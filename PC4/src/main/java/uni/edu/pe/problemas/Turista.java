package uni.edu.pe.problemas;

import java.util.Scanner;

public class Turista {
    static final int MAXV = 100;
    static final int MAXvecinos = 100;

    // aristas[v][i] = i-ésimo vecino del vértice v
    int[][] aristas;
    // peso[v][i] = peso de la arista v -> aristas[v][i]
    int[][] peso;
    // vecinos[v] = número de vecinos de v
    int[] vecinos;

    // VARIABLES AUXILIARES (USADAS EN ALGORITMOS)

    // PRIM
    boolean[] intree;      // si el nodo ya está en el MST
    int[] distance;        // menor peso conocido para conectar al MST
    int[] parent;          // padre en el MST

    // FUTURO (Dijkstra)
    int[] dist;          // distancia mínima desde el origen


    // GENERAL
    boolean[] visited;

    // DATOS DEL GRAFO
    int nvertices;
    int naristas;


    // CONSTRUCTOR


    public Turista() {

        aristas = new int[MAXV + 1][MAXvecinos];
        peso = new int[MAXV + 1][MAXvecinos];
        vecinos = new int[MAXV + 1];
        intree = new boolean[MAXV + 1];
        distance = new int[MAXV + 1];
        parent = new int[MAXV + 1];
        visited = new boolean[MAXV + 1];
        dist = new int[MAXV + 1];

    }





    // INSERTAR ARISTA CON PESO

    public void insertArista(int x, int y, int w, boolean directed) {
        aristas[x][vecinos[x]] = y;
        peso[x][vecinos[x]] = w;
        vecinos[x]++;
        if (!directed) {
            insertArista(y, x, w, true);
        } else {
            naristas++;
        }
    }

    public void dijkstra(int start){
        // Inicialización
        for(int i = 0; i < nvertices; i++){
            visited[i] = false;
            dist[i] = Integer.MIN_VALUE;
            parent[i] = -1;
        }
        dist[start] = Integer.MAX_VALUE;
        int v = start;
        while(!visited[v]){
            // Agregar el vértice al conjunto de procesados
            visited[v] = true;
            // Relajar vecinos de v
            for(int i = 0; i < vecinos[v]; i++){
                int w = aristas[v][i];
                int weight = peso[v][i];

                if(!visited[w] ){
                    int candidato = Math.min(dist[v], weight);
                    if(candidato > dist[w]){
                        dist[w] = candidato;
                        parent[w] = v;
                    }

                }
            }
            // Buscar el siguiente vértice con menor distancia
            int mejor = Integer.MIN_VALUE;
            v = -1;
            for(int i = 0; i < nvertices; i++){
                if(!visited[i] && dist[i] > mejor){
                    mejor = dist[i];
                    v = i;
                }
            }
            // Ya no quedan vértices alcanzables
            if(v == -1) break;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Turista g = new Turista();
        int N = sc.nextInt();
        int R = sc.nextInt();
        g.nvertices = N;
        g.naristas = R;
        for(int i = 0 ; i < R ; i++){
            int C1 = sc.nextInt();
            int C2 = sc.nextInt();
            int P = sc.nextInt();
            g.insertArista(C1,C2,P, false);
        }
        int S = sc.nextInt();
        int D = sc.nextInt();
        int T = sc.nextInt();

        g.dijkstra(S);

        int res =   T/(g.dist[D]-1) ; // el conductor tambien cuenta
        if(T % g.dist[D]-1  > 0){
            res++;
        }
        System.out.println(res);
    }

}

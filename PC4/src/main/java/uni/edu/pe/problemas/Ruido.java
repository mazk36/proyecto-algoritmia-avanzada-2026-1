package uni.edu.pe.problemas;

import java.util.Scanner;

public class Ruido {
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


    public Ruido() {

        aristas = new int[MAXV + 1][MAXvecinos];
        peso = new int[MAXV + 1][MAXvecinos];
        vecinos = new int[MAXV + 1];
        intree = new boolean[MAXV + 1];
        distance = new int[MAXV + 1];
        parent = new int[MAXV + 1];
        visited = new boolean[MAXV + 1];
        dist = new int[MAXV + 1];

    }

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
        for(int i = 1; i < nvertices+1; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        dist[start] = 0;
        int v = start;
        while(!visited[v]){
            // Agregar el vértice al conjunto de procesados
            visited[v] = true;
            // Relajar vecinos de v
            for(int i = 0; i < vecinos[v]; i++){
                int w = aristas[v][i];
                int weight = peso[v][i];
                // Si encuentro un camino más corto hacia w
                if(!visited[w] ){
                    int candidato = Math.max(dist[v],weight);
                    if(candidato < dist[w])
                    {
                        dist[w] = candidato;
                        parent[w] = v;
                    }

                }
            }
            // Buscar el siguiente vértice con menor distancia
            int mejor = Integer.MAX_VALUE;
            v = -1;
            for(int i = 1; i < nvertices+1; i++){
                if(!visited[i] && dist[i] < mejor){
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

        while (true) {
            Ruido g = new Ruido();
            int C = sc.nextInt();
            int S = sc.nextInt();
            int Q = sc.nextInt();
            if(C == 0 && S == 0 && Q == 0) break;
            g.naristas = S;
            g.nvertices = C;
            for(int i = 0 ; i < S ; i++){
                int c1 = sc.nextInt();
                int c2 = sc.nextInt();
                int d = sc.nextInt();
                g.insertArista(c1,c2,d,false);
            }
            for(int i = 0 ; i<Q; i++){
                int e1 = sc.nextInt();
                int e2 = sc.nextInt();
                g.dijkstra(e1);
                System.out.println(g.dist[e2]);
            }


        }


    }
}

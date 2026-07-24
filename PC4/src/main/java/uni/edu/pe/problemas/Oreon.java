package uni.edu.pe.problemas;
import java.util.*;

public class Oreon {
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


    public Oreon() {

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
    public void prim(int start) {

        // inicialización (solo lo necesario aquí)
        for (int i = 0; i <= nvertices; i++) {
            intree[i] = false;
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distance[start] = 0;

        int v = start;

        while (!intree[v]) {

            intree[v] = true;

            // actualizar vecinos del nodo v
            for (int i = 0; i < vecinos[v]; i++) {

                int w = aristas[v][i];
                int weight = peso[v][i];

                // si mejora conexión al MST
                if (!intree[w] && weight < distance[w]) {

                    distance[w] = weight;
                    parent[w] = v;

                }
            }

            // buscar siguiente nodo con menor costo
            int dist = Integer.MAX_VALUE;
            v = -1;

            for (int i = 1; i <= nvertices; i++) {

                if (!intree[i] && distance[i] < dist) {

                    dist = distance[i];
                    v = i;
                }
            }
            if (v == -1) break;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[,\\s]+");   // separa tanto por comas como por espacios/saltos de línea


        char[] letras = {'A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int n = sc.nextInt();
        Oreon g = new Oreon();
        g.nvertices = n ;
        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < n ; j++) {
                int w = sc.nextInt();
                if(i != j && w != 0){
                    g.insertArista(i,j,w,false);
                }
            }
        }
        g.prim(0);
        int[] pesoMST = new int[n-1];
        int[] desde = new int[n-1];
        int[] hasta = new int[n-1];
        int idx = 0;
        for (int i = 0 ; i< n;i++) {
            if (g.parent[i] != -1) {          // <- este filtro es el que faltaba
            int u = Math.min(i, g.parent[i]);
            int v = Math.max(i, g.parent[i]);
            desde[idx] = u;
            hasta[idx] = v;
            pesoMST[idx] = g.distance[i];
            idx++;
        }
        }
        for(int i = 0; i < n-2 ; i++) {
            for (int j = 0 ; j < n-2 ; j++){
                if(pesoMST[j] > pesoMST[j+1]){
                    int aux = pesoMST[j];
                    pesoMST[j] = pesoMST[j+1];
                    pesoMST[j+1] = aux;
                    int aux1 = desde[j];
                    desde[j] = desde[j+1];
                    desde[j+1] = aux1;
                    int aux2 = hasta[j];
                    hasta[j] = hasta[j+1];
                    hasta[j+1] = aux2;
                }
            }
        }
        for(int i = 0 ; i < idx ; i++){
            System.out.println(letras[desde[i]] + "->" + letras[hasta[i]] + " " + pesoMST[i] );
        }


    }
}

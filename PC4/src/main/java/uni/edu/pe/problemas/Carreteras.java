package uni.edu.pe.problemas;

import java.util.Scanner;

public class Carreteras {
    static int m;
    static int n;

    // Constantes
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
    // int[] dist;         // distancia mínima desde origen

    // GENERAL
    boolean[] visited;

    // DATOS DEL GRAFO
    int nvertices;
    int naristas;


    public Carreteras() {

        aristas = new int[MAXV + 1][MAXvecinos];
        peso = new int[MAXV + 1][MAXvecinos];
        vecinos = new int[MAXV + 1];
        intree = new boolean[MAXV + 1];
        distance = new int[MAXV + 1];
        parent = new int[MAXV + 1];
        visited = new boolean[MAXV + 1];
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

        int x ;
        int y ;
        int z ;
        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();
            if(m == 0 && n== 0) break;

            Carreteras g = new Carreteras();
            g.nvertices = m ;
            g.naristas = n;
            int pesoinicial=0;

            for(int i = 0 ; i < n ; i++){
                x = sc.nextInt();
                y = sc.nextInt();
                z = sc.nextInt();
                pesoinicial= pesoinicial+ z;
                g.insertArista(x,y,z,false);
            }
            g.prim(0);
            int cont = 0 ;
            for(int i = 0 ; i < m; i++){
                cont = cont + g.distance[i];
            }
            System.out.println(pesoinicial-cont);
        }

    }
}

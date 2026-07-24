package uni.edu.pe.problemas;
import java.util.*;

public class Lunares {
    // Constantes
    static final int MAXV = 100;
    static final int MAXvecinos = 100;

    // aristas[v][i] = i-ésimo vecino del vértice v
    int[][] aristas;
    // peso[v][i] = peso de la arista v -> aristas[v][i]
    double[][] peso;
    // vecinos[v] = número de vecinos de v
    int[] vecinos;

    // VARIABLES AUXILIARES (USADAS EN ALGORITMOS)

    // PRIM
    boolean[] intree;      // si el nodo ya está en el MST
    double[] distance;        // menor peso conocido para conectar al MST
    int[] parent;          // padre en el MST

    // FUTURO (Dijkstra)
    // int[] dist;         // distancia mínima desde origen

    // GENERAL
    boolean[] visited;

    // DATOS DEL GRAFO
    int nvertices;
    int naristas;


    // CONSTRUCTOR
    static double distancia(double x1, double y1, double x2, double y2){
        return (Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) ));
    }


    public Lunares() {

        aristas = new int[MAXV + 1][MAXvecinos];
        peso = new double[MAXV + 1][MAXvecinos];
        vecinos = new int[MAXV + 1];
        intree = new boolean[MAXV + 1];
        distance = new double[MAXV + 1];
        parent = new int[MAXV + 1];
        visited = new boolean[MAXV + 1];

    }
    public void insertArista(int x, int y, double w, boolean directed) {
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
                double weight = peso[v][i];

                // si mejora conexión al MST
                if (!intree[w] && weight < distance[w]) {

                    distance[w] = weight;
                    parent[w] = v;

                }
            }

            // buscar siguiente nodo con menor costo
            double dist = Integer.MAX_VALUE;
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
        int casos = sc.nextInt();


        for (int k = 0; k < casos; k++) {
            Lunares g = new Lunares();
            int lunares = sc.nextInt();
            g.nvertices = lunares;
            double[] x = new double[lunares];
            double[] y = new double[lunares];
            for(int i = 0 ; i < lunares ; i++) {
                x[i] = sc.nextDouble();
                y[i] = sc.nextDouble();
            }
            int cont = 0 ;
            for (int i = 0; i < lunares-1; i++) {
                for(int j = i+1 ; j< lunares ; j++) {
                    g.insertArista(i, j,distancia(x[i], y[i], x[j], y[j]), false);
                    cont++;
                }
            }
            g.naristas = cont;
            g.prim(0);
            double cont2=0;
            for (int i = 0 ; i < g.nvertices ; i++){
                cont2 = cont2+ g.distance[i];
            }
            System.out.println(cont2);
        }
    }
}



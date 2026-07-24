package uni.edu.pe.problemas;
import java.util.*;

public class SMPT {

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
    int[] dist;            // distancia mínima desde el origen

    // GENERAL
    boolean[] visited;

    // DATOS DEL GRAFO
    int nvertices;
    int naristas;

    // CONSTRUCTOR
    public SMPT() {

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

    public void dijkstra(int start) {

        for (int i = 0; i < nvertices; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        dist[start] = 0;
        int v = start;

        while (!visited[v]) {

            visited[v] = true;

            for (int i = 0; i < vecinos[v]; i++) {

                int w = aristas[v][i];
                int weight = peso[v][i];

                if (!visited[w] && dist[v] + weight < dist[w]) {
                    dist[w] = dist[v] + weight;
                    parent[w] = v;
                }
            }

            int mejor = Integer.MAX_VALUE;
            v = -1;

            for (int i = 0; i < nvertices; i++) {

                if (!visited[i] && dist[i] < mejor) {
                    mejor = dist[i];
                    v = i;
                }
            }

            if (v == -1) break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int k = 0; k < N; k++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int S = sc.nextInt();
            int T = sc.nextInt();

            SMPT g = new SMPT();
            g.nvertices = n;
            g.naristas = m;

            for (int i = 0; i < m; i++) {

                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();

                g.insertArista(u, v, w, false);
            }

            g.dijkstra(S);

            if (g.dist[T] == Integer.MAX_VALUE) {
                System.out.println("Case #" + k + " unreachable");
            } else {
                System.out.println("Case #" + k + " " + g.dist[T]);
            }
        }
    }
}
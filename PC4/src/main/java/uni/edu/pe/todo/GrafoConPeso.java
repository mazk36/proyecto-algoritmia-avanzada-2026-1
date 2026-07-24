package uni.edu.pe.todo;
import java.util.*;
public class GrafoConPeso {
    static class MyGraph {
        static final int MAXV = 100;
        static final int MAXvecinos = 100;
        int[][] aristas;
        int[][] peso;
        int[] vecinos;
        boolean[] intree;
        int[] distance;
        int[] parent;
        int[] dist;
        boolean[] visited;
        int nvertices;
        int naristas;
        public MyGraph() {
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
        public void printGraph() {
            for (int i = 1; i <= nvertices; i++) {
                System.out.print(i + " -> ");
                for (int j = 0; j < vecinos[i]; j++) {
                    System.out.print("(" +
                            aristas[i][j] + "," +
                            peso[i][j] + ") ");
                }
                System.out.println();
            }
        }
        //PRIM
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
                for (int i = 0; i < vecinos[v]; i++) {
                    int w = aristas[v][i];
                    int weight = peso[v][i];
                    if (!intree[w] && weight < distance[w]) {
                        distance[w] = weight;
                        parent[w] = v;
                    }
                }
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
        public void dijkstra(int start){
            for(int i = 0; i < nvertices; i++){
                visited[i] = false;
                dist[i] = Integer.MAX_VALUE;
                parent[i] = -1;
            }
            dist[start] = 0;
            int v = start;
            while(!visited[v]){
                visited[v] = true;
                for(int i = 0; i < vecinos[v]; i++){
                    int w = aristas[v][i];
                    int weight = peso[v][i];
                    if(!visited[w] && dist[v] + weight < dist[w]){
                        dist[w] = dist[v] + weight;
                        parent[w] = v;
                    }
                }
                int mejor = Integer.MAX_VALUE;
                v = -1;
                for(int i = 0; i < nvertices; i++){
                    if(!visited[i] && dist[i] < mejor){
                        mejor = dist[i];
                        v = i;
                    }
                }
                if(v == -1) break;
            }
        }
    }
}

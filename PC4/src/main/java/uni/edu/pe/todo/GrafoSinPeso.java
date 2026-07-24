package uni.edu.pe.todo;

import java.util.*;

public class GrafoSinPeso {

    static class MyGraph {
        static final int MAXV = 100;
        static final int MAXvecinos = 100;
        int[][] aristas;
        int[] vecinos;
        boolean[] descubierto;
        boolean[] existe;
        int[] parent;
        int[] distancia;
        Stack<Integer> solucion;
        public void dfs(int v) {
            descubierto[v] = true;
            System.out.print(v + " ");
            for (int i = 0; i < vecinos[v]; i++) {
                int w = aristas[v][i];
                if (!descubierto[w]) {
                    parent[w] = v;
                    dfs(w);
                }
            }
        }
        public void bfs(int inicio) {
            for (int i = 0; i <= nvertices; i++) {
                descubierto[i] = false;
                parent[i] = -1;
                distancia[i] = -1;
            }
            Queue<Integer> cola = new LinkedList<>();
            descubierto[inicio] = true;
            distancia[inicio] = 0;
            cola.offer(inicio);
            while (!cola.isEmpty()) {
                int v = cola.poll();
                System.out.print(v + " ");
                for (int i = 0; i < vecinos[v]; i++) {
                    int w = aristas[v][i];
                    if (!descubierto[w]) {
                        descubierto[w] = true;
                        parent[w] = v;
                        distancia[w] = distancia[v] + 1;
                        cola.offer(w);
                    }
                }
            }
        }
        int nvertices;
        int naristas;
        public MyGraph() {
            aristas = new int[MAXV + 1][MAXvecinos];
            vecinos = new int[MAXV + 1];
            descubierto = new boolean[MAXV + 1];
            existe = new boolean[MAXV + 1];
            parent = new int[MAXV + 1];
            distancia = new int[MAXV + 1];
            solucion = new Stack<>();
        }
        public void insertArista(int x, int y, boolean directed) {
            if (vecinos[x] >= MAXvecinos) {
                System.out.println("Warning: Se excedió el número máximo de vecinos.");
                return;
            }
            aristas[x][vecinos[x]] = y;
            vecinos[x]++;
            existe[x] = true;
            existe[y] = true;
            if (!directed) {
                insertArista(y, x, true);
            } else {
                naristas++;
            }
        }
    }
}
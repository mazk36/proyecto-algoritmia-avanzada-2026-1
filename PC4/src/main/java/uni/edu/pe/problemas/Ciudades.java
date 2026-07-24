package uni.edu.pe.problemas;

import java.util.Scanner;


public class Ciudades {
    double[] x;
    double[] y;
    // Constantes
    static final int MAXV = 100;
    static final int MAXvecinos = 100;

    // aristas[v][i] = i-ésimo vecino del vértice v
    int[][] aristas;
    // peso[v][i] = peso de la arista v -> aristas[v][i]
    double[][] peso;

    int[] vecinos;
    boolean[] intree;      // si el nodo ya está en el MST
    double[] distance;        // menor peso conocido para conectar al MST
    int[] parent;          // padre en el MST


    int[] dist;
    boolean[] visited;
    int nvertices;
    int naristas;
    double r;

    static double distancia(double x1, double y1, double x2, double y2){
        return (Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) ));
    }
    public Ciudades() {

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

    public void prim(int start){

        // inicialización (solo lo necesario aquí)
        for(int i = 0; i <= nvertices; i++){
            intree[i] = false;
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        distance[start] = 0;

        int v = start;

        while(!intree[v]){

            intree[v] = true;

            // actualizar vecinos del nodo v
            for(int i = 0; i < vecinos[v]; i++){

                int w = aristas[v][i];
                double weight = peso[v][i];

                // si mejora conexión al MST
                if(!intree[w] && weight < distance[w]){

                    distance[w] = weight;
                    parent[w] = v;
                }

            }

            // buscar siguiente nodo con menor costo
            double dist = Integer.MAX_VALUE;
            v = -1;
            for(int i = 1; i <= nvertices; i++){
                if(!intree[i] && distance[i] < dist){
                    dist = distance[i];
                    v = i;
                }
            }
            if (v == -1) break;
        }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double r = sc.nextInt();
        Ciudades g = new Ciudades();
        g.nvertices = n;

        double[] x = new double[n];
        double[] y = new double[n];
        for(int i = 0 ; i < n ; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for (int i = 0 ; i < n-1 ; i++) {
            for (int j = i+1; j<n; j++){
                g.insertArista(i,j,distancia(x[i],y[i],x[j], y[j]), false);
            }
        }
        g.prim(0);
        int estados = 0 ;
        double carreteras = 0 ;
        double ferrocarriles = 0 ;
        for (int i = 0 ; i < n ; i++){
            if(g.distance[i] <= r){
                if(estados == 0) estados++;
                carreteras+= g.distance[i];
            }
            if(g.distance[i] > r){
                estados++;
                ferrocarriles+= g.distance[i];
            }
        }
        System.out.println("Estados "+ estados +" carreteras " + carreteras + " ferrocarriles " + ferrocarriles);
    }
}

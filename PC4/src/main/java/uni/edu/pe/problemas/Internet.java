package uni.edu.pe.problemas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Internet {
    // Constantes
    static final int MAXV = 100;
    static final int MAXvecinos = 100;
    int[][] aristas;
    int[] vecinos;
    boolean[] descubierto;
    boolean[] existe;
    int[] parent;
    int[] distancia;
    int nvertices;
    int naristas;

    public Internet(){
        aristas = new int[MAXV + 1][MAXvecinos];
        vecinos = new int[MAXV + 1];
        descubierto = new boolean[MAXV + 1];
        existe = new boolean[MAXV + 1];
        parent = new int[MAXV + 1];
        distancia = new int[MAXV + 1];
        solucion = new Stack<>();

    }
    public void insertArista(int x, int y, boolean directed){
        if(vecinos[x] >= MAXvecinos){
            System.out.println("Warning: Se excedió el número máximo de vecinos.");
            return;
        }
        aristas[x][vecinos[x]] = y;
        vecinos[x]++;
        existe[x] = true;
        existe[y] = true;

        if(!directed){
            insertArista(y,x,true);
        }
        else{
            naristas++;
        }
    }


    // Topological Sort
    Stack<Integer> solucion;

    public void bfs(int inicio ){

        for(int i = 0; i <= nvertices; i++){
            descubierto[i] = false;
            parent[i] = -1;
            distancia[i] = -1;
        }
        Queue<Integer> cola = new LinkedList<>();
        descubierto[inicio] = true;
        distancia[inicio] = 0;
        cola.offer(inicio);
        while(!cola.isEmpty()){
            int v = cola.poll();

            for(int i = 0; i < vecinos[v]; i++){
                int w = aristas[v][i];
                if(!descubierto[w]){
                    descubierto[w] = true;
                    parent[w] = v;
                    distancia[w] = distancia[v] + 1;
                    cola.offer(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Internet g = new Internet();
        g.nvertices = n;
        for (int x = 0 ; x < n ; x++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            while (j!=0){
                g.insertArista(i,j,false);
                j = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        for (int x = 0 ; x < m ; x++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            g.bfs(i);
            int aux = g.parent[j];
            int tam = 0 ;
            int[] sol = new int[100];
            sol[tam] = j;
            tam++;
            while (aux != i){
                sol[tam] = aux;
                aux=g.parent[aux];
                tam++;
            }
            sol[tam] = i ;
            for(int k = tam ; k >= 0 ; k--){
                System.out.print(sol[k] + " ");
            }
        }

    }
}




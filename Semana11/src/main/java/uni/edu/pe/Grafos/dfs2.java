package uni.edu.pe.Grafos;

import java.util.*;

public class dfs2 {
    static class MyGraph {

        // constantes
        static final int MAXV = 26;
        static final int MAXvecinos = 26;

        // grafo
        int[][] aristas;
        int[] vecinos;

        //DFS
        boolean[] descubierto;

        //Existe?
        boolean[] existe ;

        //Solucion
        Stack<Integer> respuesta ;


        MyGraph() {
            this.aristas = new int[MAXV][MAXvecinos];
            this.vecinos = new int[MAXV];

            this.descubierto = new boolean[MAXV];
            existe = new boolean[MAXV];
            respuesta = new Stack<>();
        }

        public void insertarArista(int x, int y) {
            aristas[x][this.vecinos[x]] = y;
            this.vecinos[x]++;
        }



        public void dfs(int v){
            descubierto[v] = true;

            //recorremos todos sus vecinos
            for (int i = 0 ; i < vecinos[v] ; i++){
                if(!descubierto[aristas[v][i]]){
                    dfs(aristas[v][i]);
                }
            }
            respuesta.push(v);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyGraph g = new MyGraph();

        // cantidad de lineas
        int n = sc.nextInt();
        String[] palabras = new String[n];


        for (int i = 0; i < n; i++) {
            palabras[i] = sc.next();
            for (int j = 0; j < palabras[i].length(); j++) {
                char c = palabras[i].charAt(j);
                // aqui aprobecho en guardar todas las letras que aparecen
                g.existe[c - 'A'] = true;
            }
        }
        // aqui hacemos el algoritmo de comparacion

        for (int i = 0; i < n - 1; i++) {
            String a = palabras[i];
            String b = palabras[i + 1];

            int min = Math.min(a.length(), b.length());

            for (int j = 0; j < min; j++) {
                char l1 = a.charAt(j);
                char l2 = b.charAt(j);
                if (l1 != l2) {
                    g.insertarArista(l1 - 'A', l2 - 'A');
                    break;
                }
            }
        }
        for (int i = 0; i < 26; i++) {

            if (g.existe[i] && !g.descubierto[i]) {

                g.dfs(i);

            }
        }
        while (!g.respuesta.isEmpty()) {
            System.out.println((char) (g.respuesta.pop() + 'A'));
        }
        System.out.println();

    }
}

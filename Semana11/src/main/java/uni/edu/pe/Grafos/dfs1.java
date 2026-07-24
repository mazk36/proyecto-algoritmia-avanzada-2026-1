package uni.edu.pe.Grafos;
import java.util.*;

public class dfs1 {
    static class MyGraph {

        // primero ponemos los static
        static final int MAXV = 100; // MAXIMOS VERTICES
        static final int MAXvecinos = 50; // GRADO MAXIMO DE UN VERTICE

        int nvertices; // numero de vertices ACTUALES
        int naristas; // cuantas aristas se han insertado

        int aristas[][]; // en la primera casilla se pone el vertice y la segunda es sus vecinos
        int vecinos[];
        int indegree[];// la cantidad de vecinos de i es vecino[i]

        boolean directed; // si es dirigido o no
        boolean[] discovered; // ya viste el vertice i ?

        char[] vertices;
        int tamaño;
        char[] respuesta;

        // ahora si, vamos a armar el grapho y sus funciones

        MyGraph(boolean directed) {
            this.directed = directed;
            this.aristas = new int[MAXV + 1][MAXvecinos];
            this.vecinos = new int[MAXV + 1];
            this.indegree = new int[MAXV +1] ;
            this.discovered = new boolean[MAXV + 1];


            iniciarGrapho();
        }

        public void iniciarGrapho() {
            this.nvertices = 0;
            this.naristas = 0;
        }


        public void insertarArista(int x, int y, boolean directed) {
            aristas[x][this.vecinos[x]] = y;
            this.vecinos[x]++;
            this.indegree[y]++;
            this.naristas++;
        }



        public void dfs(int nivel){
            if(nivel == tamaño) {
                imprimirrespuesta();
                return;
            }
            for(int i = 0 ; i < nvertices ; i++){
                if(indegree[i] == 0 && !discovered[i] ){
                    discovered[i] = true;
                    respuesta[nivel] = vertices[i];
                    for(int j = 0 ; j < vecinos[i]; j++){
                        indegree[aristas[i][j]]--;
                    }
                    dfs(nivel+1);
                    for(int j = 0 ; j < vecinos[i]; j++){
                        indegree[aristas[i][j]]++;
                    }
                    discovered[i] = false ;
                }
            }
        }

        private void imprimirrespuesta() {
            for(int i = 0 ; i < tamaño ; i++){
                System.out.print(respuesta[i]);
            }
            System.out.println();

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyGraph g = new MyGraph(true);

        int tamaño = sc.nextInt();

        g.tamaño = tamaño;
        g.nvertices = tamaño;
        g.respuesta = new char[tamaño];
        g.vertices = new char[tamaño];

        int[] posicion = new int[26];

        for(int i = 0 ; i < tamaño ; i++){
            char c = sc.next().charAt(0);
            g.vertices[i] = c ;
            posicion[c-'A'] = i ;
        }
        int restrictions = sc.nextInt();
        for (int i = 0 ; i < restrictions;i++){
            String txt = sc.next();
            int x = posicion[txt.charAt(0) - 'A'] ;
            int y = posicion[txt.charAt(2) - 'A']  ;
            char signo = txt.charAt(1) ;
            if(signo == '<'){
                g.insertarArista(x,y,true);

            }else{
                g.insertarArista(y,x,true);
            }
        }
        g.dfs(0);
    }
}

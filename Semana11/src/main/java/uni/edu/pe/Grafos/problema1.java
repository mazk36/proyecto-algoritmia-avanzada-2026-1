package uni.edu.pe.Grafos;
import java.util.*;

public class problema1 {

    static class MyGraph {

        // primero ponemos los static
        static final int MAXV = 100 ; // MAXIMOS VERTICES
        static final int MAXvecinos = 50 ; // GRADO MAXIMO DE UN VERTICE
        int nvertices ; // numero de vertices ACTUALES
        int naristas ; // cuantas aristas se han insertado
        int aristas[][] ; // en la primera casilla se pone el vertice y la segunda es sus vecinos
        int vecinos[] ; // la cantidad de vecinos de i es vecino[i]
        boolean directed ; // si es dirigido o no

        // esto es para hacer bfs
        boolean[] discovered ; // ya viste el vertice i ?
        int[] parent ; // de que vertice vengo para llegar al vertice i
        boolean[] processed ; // es para los que ya estan procesados

        // ahora si, vamos a armar el grapho y sus funciones

        MyGraph(boolean directed) {
            this.directed = directed ;
            this.aristas = new  int[MAXV+1][MAXvecinos];
            this.vecinos = new  int[MAXV+1] ;
            this.discovered = new boolean[MAXV+1] ;
            this.processed = new boolean[MAXV+1] ;
            this.parent = new int[MAXV+1] ;

            iniciarGrapho();
        }

        public void iniciarGrapho() {
            this.nvertices = 0 ;
            this.naristas = 0 ;
            for (int i = 1 ; i <= MAXV ; i++){
                this.vecinos[i] = 0;
            }
        }


        public void insertarArista(int x, int y, boolean directed){
            aristas[x][this.vecinos[x]] = y ;
            this.vecinos[x]++;
            this.naristas++ ;
            if(!directed){
                insertarArista(y,x,true);
            }
        }




        public void bfs(int start) {
            Queue<Integer> q = new LinkedList<>() ;
            int v ; // este es el vertice que estamos revisando
            q.add(start); // ya lo agregue a la cola
            discovered[start] = true ;

            while (!q.isEmpty()){
                v = q.poll(); // saca de la cola y lo mete en v
                procesarVertice(v);
                this.processed[v] = true ;// aqui lo almaceno en los vertices que ya estan procesados
                // ahora hay que buscar su vecino
                for (int i = 0; i<this.vecinos[v]; i++){
                    int siguienteVertice = this.aristas[v][i] ;
                    //verificamos que el vertice sea valido
                    if(this.VerticeValido(siguienteVertice)){
                        //verificamos si ah sido descubierto
                        if(!this.discovered[siguienteVertice]){
                            q.add(siguienteVertice) ;
                            discovered[siguienteVertice] = true ;
                            this.parent[siguienteVertice] = v ;
                        }
                    }
                }
            }
        }
        





        private void procesarArista(int v, int siguienteVertice) {
        }

        // aqui implemento como es que se procesa, ejemplo : mostrar, contar, etc
        static void procesarVertice(int v){
        }
        static boolean VerticeValido(int v){
            return true ;
        }

        public int solver(int nvertices){
            int cont = 0 ;
            for(int i = 1; i <= nvertices ; i++){
                if(!discovered[i]){
                    bfs(i);
                    cont++;
                }
            }
            return cont;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char linea = sc.next().charAt(0);
        int tamaño = linea -'A' + 1 ;
        MyGraph g = new MyGraph(false) ;
        while (true){
            String arista = sc.next();
            if(arista.equals("finish"))
            {
                break;
            }
            int x = arista.charAt(0) - 'A' + 1 ;
            int y = arista.charAt(1) - 'A' + 1 ;
            g.insertarArista(x,y,false);
        }
        System.out.println(g.solver(tamaño));
    }

}


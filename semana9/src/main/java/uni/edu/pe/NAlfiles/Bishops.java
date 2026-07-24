package uni.edu.pe.NAlfiles;
import static java.lang.Math.abs;

public class Bishops {
    static final int MAXCANDIDATES = 64;
    static final int NMAX = 65;
    static boolean finished = false;
    int count_sol=0;

    /**
     * Método principal de backtracking
     * @param a vector solución
     * @param k posición actual (índice del último elemento añadido)
     * @param n datos de entrada del problema específico
     */
    void backtrack(int[] a, int k, int n, int bishops) {
        int[] c = new int[MAXCANDIDATES];  // candidatos para la siguiente posición
        int[] nc = new int[1];              // cantidad de candidatos (simulamos puntero)

        if (is_a_solution(a, k, bishops)) {
            count_sol++;
            process_solution(a, k, n);
        } else {
            k = k + 1;
            construct_candidates(a, k, n, c, nc);
            for (int i = 0; i < nc[0]; i++) {
                a[k] = c[i];
                backtrack(a, k, n, bishops);
                if (finished) {
                    return;  // terminar temprano
                }
            }
        }
    }

    /**
     * Determina si los primeros k elementos de a forman una solución completa
     */
    boolean is_a_solution(int[] a, int k, int bishops) {
        // Implementar según el problema específico
        return (k==bishops);
    }

    /**
     * Construye el arreglo de candidatos para la posición k
     * @param c arreglo donde se almacenan los candidatos
     * @param nc arreglo de un elemento que contiene la cantidad de candidatos
     */
    static void construct_candidates(int[] a, int k, int n, int[] c, int[] nc) {
        boolean valido = true ;
        nc[0] = 0 ;
        //no se porque se necesita pero se necesita
        int start = (k==1) ? 0 : a[k-1]+1 ;
        for(int pos = start ; pos < n*n ; pos++)
        {
            int row = pos/n;
            int col = pos%n;
            valido = true;
            //Que no se ataquen
            for(int i = 1 ; i < k ; i++)
            {
                int prev_row = a[i]/n ;
                int prev_col = a[i]%n ;
                //diagonal
                if(abs(row-prev_row) == abs(prev_col-col))
                {
                    valido = false;
                    break;
                }
            }
            if(valido)
            {
                c[nc[0]] = pos ;
                nc[0] ++;
            }

        }

    }

    /**
     * Procesa una solución completa (imprime, cuenta, etc.)
     */
    static void process_solution(int[] a, int k, int bishops) {
        // Implementar según el problema específico
        System.out.print("{");

        for(int i = 1 ; i <= bishops ; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println("}");
    }

    /**
     * Realiza acciones al hacer un movimiento (opcional)
     */
    static void make_move(int[] a, int k, int n) {
        // Implementar si es necesario para el problema
    }

    /**
     * Deshace las acciones al retroceder (opcional)
     */
    static void unmake_move(int[] a, int k, int n) {
        // Implementar si es necesario para el problema
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int n = 8; // Tamaño del conjunto
        int bishops = 6;
        Bishops solver = new Bishops();
        solver.resuelveAlfil(n, bishops);
    }

    private void resuelveAlfil(int n, int bishops) {
        count_sol=0;
        int[] a = new int[NMAX]; // Vector solución
        backtrack(a, 0, n, bishops); // Iniciar backtracking

        System.out.println("Total de soluciones:" + count_sol);
    }
}

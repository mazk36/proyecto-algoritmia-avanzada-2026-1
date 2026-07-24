package uni.edu.pe.subset;

public class Subset {
    static final int MAXCANDIDATES = 2;
    static final int MAX = 9 ;
    static boolean finished = false;

    /**
     * Método principal de backtracking
     * @param a vector solución
     * @param k posición actual (índice del último elemento añadido)
     * @param n datos de entrada del problema específico
     */
    void backtrack(int[] a, int k, int n) {
        int[] c = new int[MAXCANDIDATES];  // candidatos para la siguiente posición
        int[] nc = new int[1];              // cantidad de candidatos (simulamos puntero)

        if (is_a_solution(a, k, n)) {
            process_solution(a, k, n);
        } else {
            k = k + 1;
            construct_candidates(a, k, n, c, nc);
            for (int i = 0; i < nc[0]; i++) {
                a[k] = c[i];
                backtrack(a, k, n);
                if (finished) {
                    return;  // terminar temprano
                }
            }
        }
    }

    /**
     * Determina si los primeros k elementos de a forman una solución completa
     */
    static boolean is_a_solution(int[] a, int k, int n) {
        // Implementar según el problema específico
        if(k==n)
        {
            return true;
        }

        return false;
    }

    /**
     * Construye el arreglo de candidatos para la posición k
     * @param c arreglo donde se almacenan los candidatos
     * @param nc arreglo de un elemento que contiene la cantidad de candidatos
     */
    static void construct_candidates(int[] a, int k, int n, int[] c, int[] nc) {
        // Implementar según el problema específico
        c[0] = 0 ;
        c[1] = 1 ;
        nc[0] = 2;
    }

    /**
     * Procesa una solución completa (imprime, cuenta, etc.)
     */
    static void process_solution(int[] a, int k, int n) {
        // Implementar según el problema específico
        System.out.print("{");

        for(int i = 1 ; i <= n ; i++)
        {
            if(a[i] == 1)
            {
                System.out.print(i + " ");
            }
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
        int n = 3 ;
        int a[] = new int[MAX];
        Subset subset = new Subset();
        subset.backtrack(a,0,n);
    }
}

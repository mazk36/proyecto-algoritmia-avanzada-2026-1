package uni.edu.pe.derengagement;

public class derengagement {

    static final int MAXCANDIDATES = 8;
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

        return (k==n);
    }

    /**
     * Construye el arreglo de candidatos para la posición k
     * @param c arreglo donde se almacenan los candidatos
     * @param nc arreglo de un elemento que contiene la cantidad de candidatos
     */
    static void construct_candidates(int[] a, int k, int n, int[] c, int[] nc) {
        // Implementar según el problema específico
        boolean[] in_per = new boolean[MAXCANDIDATES] ;
        for (int i = 1 ; i<MAXCANDIDATES ; i++) {in_per[i] = false;}
        for(int i = 1 ; i < k ; i++)
        {
            in_per[a[i]] = true ;
        }
        nc[0] = 0 ;
        // esto de aqui revisa todos los numeros para saber cuales estan disponibles
        for(int i= 1 ; i <= n ; i++)
        {
            if(!in_per[i] && k != i)
            {
                c[nc[0]] = i ;
                nc[0]++;
            }
        }




    }

    /**
     * Procesa una solución completa (imprime, cuenta, etc.)
     */
    static void process_solution(int[] a, int k, int n) {
        // Implementar según el problema específico
        System.out.print("{");

        for(int i = 1 ; i <= n ; i++)
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
        derengagement Derengagement = new derengagement();
        int n = 3 ;
        int[] a = new int[MAX] ;
        Derengagement.backtrack(a, 0, n);
    }
}


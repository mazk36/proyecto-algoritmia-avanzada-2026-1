package uni.edu.pe.problemas;

import java.util.Scanner;

public class vuelos {

    static class MyGraph {
        // Constantes
        static final int MAXV = 100;
        static final int MAXvecinos = 100;
        static final int MAXPEND = 1000000;   // capacidad de la "bolsa" de rutas pendientes

        // aristas[v][i] = i-ésimo vecino del vértice v
        int[][] aristas;
        // peso[v][i] = peso de la arista v -> aristas[v][i]
        int[][] peso;
        // vecinos[v] = número de vecinos de v
        int[] vecinos;

        // DATOS DEL GRAFO
        int nvertices;
        int naristas;

        // CONSTRUCTOR
        public MyGraph() {
            aristas = new int[MAXV + 1][MAXvecinos];
            peso    = new int[MAXV + 1][MAXvecinos];
            vecinos = new int[MAXV + 1];
        }

        // INSERTAR ARISTA CON PESO (igual que en tu plantilla)
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

        /* ============================================================
         *  DIJKSTRA  (versión generalizada: k CAMINOS MÁS BARATOS)
         *
         *  Es tu mismo Dijkstra, con SOLO dos diferencias conceptuales:
         *
         *    Dijkstra normal            ->   Esta versión (k caminos)
         *    -----------------------------------------------------------
         *    dist[v]  (una distancia    ->   una BOLSA de rutas a medio
         *              por nodo)              hacer: costoPend[] y nodoPend[]
         *                                     (varias rutas vivas a la vez,
         *                                      incluso varias a un mismo nodo)
         *
         *    visited[v] (se cierra      ->   cnt[v]  (se cierra HASTA k veces;
         *                una sola vez)             cada cierre = una forma más
         *                                          de llegar a v)
         *
         *  Los dos bucles clásicos siguen presentes:
         *    - "buscar el mínimo"  -> ahora busca la ruta más barata de la bolsa
         *    - "relajar vecinos"   -> ahora extiende esa ruta por cada vecino
         * ============================================================ */
        public void dijkstra(int start, int destino, int k) {

            // --- Estructuras ---
            // cnt[v]: cuántas veces hemos CERRADO el nodo v (0..k).  (Sustituye a visited)
            int[] cnt = new int[MAXV + 1];

            // La bolsa: dos arreglos paralelos, mismo estilo que aristas[]/peso[].
            //   costoPend[i] = costo acumulado de la i-ésima ruta pendiente
            //   nodoPend[i]  = ciudad donde va parada esa ruta
            int[] costoPend = new int[MAXPEND];
            int[] nodoPend  = new int[MAXPEND];
            int nPend = 0;   // cuántas rutas hay ahora mismo en la bolsa

            // --- Inicialización ---
            // En Dijkstra normal hacías dist[start] = 0.  Aquí el equivalente es
            // meter a la bolsa la ruta inicial: "costo 0, parado en start".
            costoPend[nPend] = 0;
            nodoPend[nPend]  = start;
            nPend++;

            int encontrados = 0;  // cuántas rutas al destino llevamos impresas

            // Mientras haya rutas por explorar y aún no tengamos las k respuestas
            while (nPend > 0 && encontrados < k) {

                // 1) BUSCAR EL MÍNIMO
                //    Idéntico a tu bucle "buscar el siguiente vértice con menor
                //    distancia", pero recorriendo la bolsa en vez de los nodos.
                //    Nos da la ruta viva MÁS BARATA -> por eso las respuestas
                //    salen ordenadas de menor a mayor.
                int mejor = Integer.MAX_VALUE;
                int idx = -1;
                for (int i = 0; i < nPend; i++) {
                    if (costoPend[i] < mejor) {
                        mejor = costoPend[i];
                        idx = i;
                    }
                }

                // 2) SACAR ESA RUTA DE LA BOLSA
                //    Truco para borrar en O(1): copio la última encima de la que
                //    saco y encojo el tamaño. El orden de la bolsa da igual,
                //    porque en el paso 1 siempre la recorro entera.
                int d = costoPend[idx];   // costo de la ruta que estamos cerrando
                int v = nodoPend[idx];    // ciudad donde termina esa ruta
                nPend--;
                costoPend[idx] = costoPend[nPend];
                nodoPend[idx]  = nodoPend[nPend];

                // 3) CERRAR EL NODO (equivalente a "visited[v] = true")
                //    Pero permitimos cerrar cada nodo hasta k veces. Si ya lo
                //    cerramos k veces, esta ruta ya no puede aportar nada nuevo.
                if (cnt[v] == k) continue;
                cnt[v]++;

                // 4) ¿LLEGAMOS AL DESTINO?
                //    La cnt[destino]-ésima vez que llegamos = la cnt[destino]-ésima
                //    ruta más barata. La imprimimos.
                if (v == destino) {
                    System.out.print(d + " ");
                    encontrados++;
                }

                // 5) RELAJAR VECINOS
                //    Tu mismo bucle sobre aristas[v]/peso[v]. En Dijkstra normal
                //    aquí mejorabas dist[w]; aquí, en cambio, creamos una ruta
                //    NUEVA (costo d + peso) y la metemos a la bolsa.
                for (int i = 0; i < vecinos[v]; i++) {
                    int w = aristas[v][i];   // vecino
                    int p = peso[v][i];      // peso de v -> w
                    if (cnt[w] < k) {        // si w ya se cerró k veces, no sirve extender hacia él
                        costoPend[nPend] = d + p;
                        nodoPend[nPend]  = w;
                        nPend++;
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        MyGraph g = new MyGraph();
        g.nvertices = n;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g.insertArista(a, b, c, true);   // vuelos dirigidos
        }

        // Un solo método hace todo: los k caminos más baratos de la ciudad 1 a la n
        g.dijkstra(1, n, k);
    }
}
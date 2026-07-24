package uni.edu.pe.Grafos;
import java.util.*;


public class oildepositDFS {

    static int[] di = {1, -1, 0, 0, 1,-1, 1,-1};
    static int[] dj = {0, 0, 1, -1, -1, 1, 1, -1};
    static boolean[][] descubierto ;
    static int[][] aguilas;
    static int n ;


    static void dfs(int x, int y) {
        if (descubierto[x][y] || aguilas[x][y] == 0) return;
        descubierto[x][y] = true;
        
        for (int k = 0; k < 8; k++) {
            if (x + di[k] < 0 || x + di[k] > n-1 || y + dj[k] < 0 || y + dj[k] > n-1 || descubierto[x + di[k]][y + dj[k]] || aguilas[x + di[k]][y + dj[k]] == 0)
                continue;
            dfs(x + di[k], y + dj[k]);

        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        descubierto = new boolean[n][n];
        aguilas = new int[n][n];
        for (int fila = 0 ; fila < n; fila++){
            String linea = sc.next();
            for(int columna = 0 ; columna < n ; columna++){
                aguilas[fila][columna] =linea.charAt(columna) -'0';
            }
        }
        int cont = 0 ;

        for (int fila = 0 ; fila < n; fila++){
            for(int columna = 0 ; columna < n ; columna++){
                if(!descubierto[fila][columna] && aguilas[fila][columna] == 1){
                    cont++;
                    dfs(fila,columna);
                }
            }
        }
        System.out.print(cont);
    }
}

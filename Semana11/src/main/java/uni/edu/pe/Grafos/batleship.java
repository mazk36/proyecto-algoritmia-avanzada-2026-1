package uni.edu.pe.Grafos;

import java.util.*;

public class batleship {
    static int[] di ={1, -1, 0, 0,};
    static int[] dj ={0, 0, 1, -1 };
    static int n;
    static boolean[][] descubierto;
    static char[][] barcos;
    static boolean vivo;

    static void dfs(int x, int y){
        if(descubierto[x][y] || barcos[x][y] =='.' ) return;
        descubierto[x][y] = true;

        for (int k = 0 ; k < 4; k++){
            if(x+di[k]<0 || x+di[k] > n-1 || y+dj[k] < 0 || y+dj[k] > n-1 || descubierto[x+di[k]][y+dj[k]] || barcos[x+di[k]][y+dj[k]] == '.') continue;
            dfs(x+di[k],y+dj[k]);
        }

        if(barcos[x][y] == 'x') vivo = true ;
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        barcos = new char[n][n];
        descubierto = new boolean[n][n];
        for(int i = 0 ; i < n ; i++){
            String linea = sc.next();
            for (int j = 0 ; j < n ; j++){
                barcos[i][j] = linea.charAt(j);
            }
        }
        int cont = 0 ;
        for(int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                vivo = false;
                dfs(i,j);
                if(vivo) cont++;
            }
        }
        System.out.println(cont);
    }
}

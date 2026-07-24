package uni.edu.pe.NQueens;

import java.util.Scanner;

public class YO {
    static int n;
    static int[] reinas;
    static int cont = 0 ;


    static boolean save(int[] reinas, int fila, int columna)
    {
        for (int i = 1 ; i< columna ; i++)
        {
            if(reinas[i] == fila || Math.abs(reinas[i] - fila) == Math.abs(i - columna) )
            {
                return false;

            }
        }
        return true ;
    }

    static void solver(int pos)
    {
        if(pos > n)
        {
            cont++;
            return;
        }
        for(int i = 1 ; i <= n ; i++)
        {
            if(save(reinas,i,pos))
            {
                reinas[pos]= i;
                solver(pos+1);
                reinas[pos] = 0 ;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt();
        reinas = new int[n+1];
        cont = 0 ;
        solver(1);
        System.out.println(cont);
    }
}

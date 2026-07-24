package uni.edu.pe.Lotto;
import java.util.*;


public class Lotto {
    //a es la cantidad de nuemeros de nuestro arreglo
    static int[] a = new int[14] ;
    static int[] ans = new int[6] ;

    static void solve(int i , int cont, int n)
    {
        if(i>n) return;
        // cuando ya tengamos una solucion
        if(cont == 6)
        {
            for(int x: ans) System.out.print(x +" ");
            System.out.println();
            return;
        }
        // si no tenemos solucion aun
        // primer agregamos
        ans[cont] = a[i];
        // comprobamos si es solucion
        solve(i+1, cont+1, n);
        // hacemos backtrack
        ans[cont] = 0 ;
        solve(i+1, cont, n);
    }

    public static void main(String[] args) {
        while (true)
        {
            Scanner sc = new Scanner(System.in) ;
            int k = sc.nextInt();
            if(k==0) break;
            for(int j = 0 ; j < k ; j++) a[j]= sc.nextInt();
            solve(0,0,k);

        }


    }

}

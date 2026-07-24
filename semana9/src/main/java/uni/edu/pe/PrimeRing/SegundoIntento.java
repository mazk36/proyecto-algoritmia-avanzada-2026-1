package uni.edu.pe.PrimeRing;
import java.util.*;

public class SegundoIntento {

    static int n;
    static int[] ring;            // se dimensionan en main, ya con n leído
    static boolean[] usd;         // usd[k] = ¿ya usé el número k?

    //Funcion para verificar si algo es prime o no
    static boolean isPrime(int a)
    {
        for(int i = 2 ; i < a ; i++) if(a%i == 0) return false ;
        return true ;
    }

    static void solver(int pos)
    {
        if(pos > n) {
            if(isPrime(ring[n] + ring[1])) {
                for(int k = 1 ; k <= n; k++) System.out.print(ring[k] + " ");
                System.out.println();
            }
            return;
        }
        for(int i = 2; i <= n ; i++)
        {
            //Esto es solo para revisar que el num no haya sido usado ya
            if(!usd[i] && isPrime(ring[pos-1] + i))
            {
                ring[pos] = i ;
                usd[i] = true ;
                solver(pos+1) ;
                usd[i] = false;
                ring[pos] = 0 ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt();
        ring = new int[n+1] ;
        usd = new boolean[n+1] ;
        ring[1] = 1 ;
        usd[1] = true ;
        solver(2);

    }
}

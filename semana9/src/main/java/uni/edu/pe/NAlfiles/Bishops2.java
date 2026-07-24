package uni.edu.pe.NAlfiles;
import java.util.*;

public class Bishops2 {
    static boolean[][] bishops;
    static int n ;
    static int k ;
    static int contBishops;
    static int cont = 0 ;

    static boolean save(int fila, int columna)
    {
        for (int i = 1 ;i <= fila ; i++) {
            for (int j = 1 ; j <= n ; j++){
                if((bishops[i][j]) && Math.abs(i - fila) == Math.abs(j - columna)){
                    return false;
                }
            }
        }
        return true;
    }
    static void solver(int pos)
    {
        if(contBishops == k)
        {
            cont++;
            return;
        }

        if(pos > n*n) return;
        int fila = (pos-1) / n+1 ;
        int columna = (pos-1) % n+1 ;

        //opcion no poner nada
        solver(pos+1);
        //opcion agregar si se puede

        if(save(fila,columna)){
            bishops[fila][columna] = true ;
            contBishops++;
            solver(pos+1);
            //ahora retrocedemos
            bishops[fila][columna] = false ;
            contBishops-- ;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        k = sc.nextInt();
        n = sc.nextInt() ;
        bishops = new boolean[n+1][n+1] ;
        cont=0;
        solver(1);
        System.out.println(cont);
    }
}

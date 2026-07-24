package uni.edu.pe.problemas;

import java.util.Scanner;

public class reinask {
    static int[][] pesos ;
    static int[] reinas;
    static int sumaMin = Integer.MIN_VALUE;
    static int[] sol ;


    static void backtracking(int pos, int sum){
        if(pos == 8){
            if(sum > sumaMin){
                sumaMin = sum ;

            }
            return;
        }

        // pruebo con todos los posibles valores
        for(int j = 0 ; j < 8; j++){
            boolean posible = true ;
            //reviso si se puede meter
            for(int i = 0 ; i < pos;  i++){
                if(reinas[i] == j || Math.abs(i-pos) == Math.abs(reinas[i]-j)){
                    posible = false;
                    break;
                }
            }
            if(posible){
                reinas[pos] = j;
                sum = sum + pesos[pos][j] ;
                backtracking(pos+1, sum);
                reinas[pos] = 0 ;
                sum = sum - pesos[pos][j] ;
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        reinas = new int[8];
        sol = new int[8];
        pesos = new int[8][8] ;
        for(int x = 0 ; x < k ; x++){

            for(int i = 0 ; i < 8 ; i++){
                for (int j = 0 ; j < 8 ; j++){
                    pesos[i][j] = sc.nextInt();
                }
            }
            backtracking(0,0);
            System.out.println(sumaMin);
            sumaMin = Integer.MIN_VALUE;

        }
    }


}

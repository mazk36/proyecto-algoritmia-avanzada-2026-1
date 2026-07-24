package uni.edu.pe.problemas;

import java.util.Scanner;

public class subsetsPD {






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea1 = sc.next();
        String linea2 = sc.next();
        char[] caracteres1 = new char[linea1.length()];
        char[] caracteres2 = new char[linea2.length()];
        for(int i = 0 ; i <linea1.length() ; i++){
            caracteres1[i] = linea1.charAt(i);
        }
        for(int i = 0 ; i <linea2.length() ; i++){
            caracteres2[i] = linea2.charAt(i);
        }

        int dp[][] = new int[linea1.length()+1][linea2.length()+1];

        for(int i = 1 ; i <=linea1.length(); i++){
            for(int j = 1 ; j <=linea2.length(); j++){
                //caso base
                if(caracteres1[i-1] == caracteres2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[linea1.length()][linea2.length()]);



    }
}

package uni.edu.pe.problemas;

public class coeficientesBinario {

    static int resultado(int x, int y){
        int calculos[][] = new int[x+2][y+2];
        for(int i = 0; i <= x ; i++){
            calculos[i][0] = 1;
        }

        for(int i = 0 ; i <= x ; i++){
            for(int j = 0; j <=y ; j++){
                if(i == j){
                    calculos[i][j] = 1 ;
                }
            }
        }
        for(int i = 2 ; i <= x ; i++){
            for(int j = 1 ; j<= y ; j++){
                calculos[i][j] = calculos[i-1][j] + calculos[i-1][j-1];
            }
        }
        return calculos[x][y];
    }

    public static void main(String[] args) {
        System.out.println(resultado(7,4));
    }


}

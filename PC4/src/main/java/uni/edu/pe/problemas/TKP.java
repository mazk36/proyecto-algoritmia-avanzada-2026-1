package uni.edu.pe.problemas;
import java.util.Scanner;

public class TKP {
    static int[] di = {1, -1, 1, -1, 2, 2, -2,-2};
    static int[] dj = {2, 2, -2, -2, 1, -1, 1, -1};
    static int maxPasos = Integer.MAX_VALUE;
    static int[] pasosSol;
    static int[] pasosAux;

    static void solver(int pos , int finalx, int sum){
        if(sum >= maxPasos) return;
        // si ya llegue
        if(pos == finalx){
            if(sum < maxPasos){
                maxPasos = sum;
            }
            return;
        }
        //pos esta de la forma i+j*8 osea que i = pos%8 y j=pos/8
        int posi = pos%8;
        int posj = pos/8;
        int auxi = posi;
        int auxj = posj;
        //Aqui tengo que decidir a donde avanzar
        for(int i = 0 ; i < 8 ; i++){
            posi=auxi;
            posj=auxj;
            posi = posi + di[i];
            posj = posj + dj[i];
            // que no este fuera de los limites del tablero
            if(!(posi <0 || posj < 0 || posi > 7 || posj > 7)){
                // que no haya tocado ya este
                boolean repetido = false ;
                for(int j = 0 ; j < sum ; j++){
                    int posAnteriori = pasosAux[j] % 8;
                    int posAnteriorj = pasosAux[j] / 8;
                    if(posi == posAnteriori && posj == posAnteriorj){
                        repetido = true;
                    }
                }
                if(!repetido){
                    pos = posi + posj*8;
                    pasosAux[sum] = pos;

                    solver(pos,finalx,sum+1);

                    pasosAux[sum] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea = sc.next();
        int i = linea.charAt(0) - 'a'  ;
        int j = linea.charAt(1) - '0' -1 ;
        int inicio = i+j*8;
        linea = sc.next();
        i = linea.charAt(0) - 'a' ;
        j = linea.charAt(1) - '0' -1 ;
        int finalx = i+j*8;
        pasosSol = new int[100];
        pasosAux = new int[100];
        pasosAux[0]=inicio;
        solver(inicio, finalx, 1);
        System.out.println(maxPasos-1) ;
    }
}

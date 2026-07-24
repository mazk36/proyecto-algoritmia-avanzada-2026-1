package uni.edu.pe.cd;

import java.util.*;

public class CD {
    static int N ;              // capacidad maxima del caset
    static int cPistas;         // cantidad de pistas
    static int[] duracion;      // duracion de cada pista

    static int mejorSuma = 0 ;

    static ArrayList<Integer> actual = new ArrayList<>();
    static ArrayList<Integer> mejor = new ArrayList<>() ;



    static void solver(int pos, int sumActual)
    {
        if(pos == cPistas) {
            if(sumActual> mejorSuma) {
                mejorSuma = sumActual;
                mejor = new ArrayList<>(actual) ;
            }
            return;
        }
        // opcion 1, no añadimos nada
        solver(pos+1, sumActual);
        // opcion 2, añadimos
        if(sumActual + duracion[pos] <=N)
        {
            actual.add(duracion[pos]);
            sumActual= sumActual+duracion[pos];
            solver(pos+1,sumActual);
            // quitamos
            actual.remove(actual.size()-1);
            sumActual= sumActual-duracion[pos];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cPistas = sc.nextInt();
        duracion = new int[cPistas];
        for(int i = 0 ; i<cPistas; i++) {
            duracion[i] = sc.nextInt();
        }
        solver(0,0);

        for(int i = 0 ; i < mejor.size() ; i++){
            System.out.print(mejor.get(i) + " ");
        }
        System.out.print("sum : " + mejorSuma );

    }

}

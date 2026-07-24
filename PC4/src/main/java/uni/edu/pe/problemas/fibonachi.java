package uni.edu.pe.problemas;

public class fibonachi {

    static int fibonachi(int n){
        int temporal[] = new int[n+1];
        temporal[0] = 1;
        temporal[1] = 1 ;
        for (int i = 2 ; i <= n ; i++){
            temporal[i] = temporal[i-1] + temporal[i-2];
        }
        return temporal[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonachi(3));
    }
}

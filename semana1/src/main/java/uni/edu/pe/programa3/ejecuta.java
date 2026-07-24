package uni.edu.pe.programa3 ;
import java.sql.SQLOutput;
import java.util.Scanner ;


public class ejecuta
{
    public static void main(String[] arg)
    {
        String nombre, direccion ;
        int edad ;
        double pf ;


        // Aqui es donde creamos una manera de hacer cin >> 
        
        Scanner sc = new Scanner(System.in) ;


        System.out.println("Ingrese su nombre: ") ;
        nombre = sc.nextLine() ;

        System.out.println("Ingrese su direccion : ") ;
        direccion = sc.nextLine() ;

        System.out.println("Ingrese su edad : ") ;
        edad = sc.nextInt() ;
        sc.nextLine() ;
        
        System.out.println("Ingrese su promedio final : ") ; 
        pf = sc.nextDouble() ;
        sc.nextLine() ;

        //Aqui mostrmos todos los datos recogidos ... cout << 

        System.out.println("Nombre : " +nombre) ;
        System.out.println("Direccion : " +direccion) ;
        System.out.println("Edad : " +edad) ;
        System.out.println("Promedio final : " +pf) ;
    }
}



package uni.edu.pe.programa2 ;
public class Prueba2 {
    public static void main(String[] arg)
    {
        Auto aDeportivo = new Auto (1, "Ferrari", "ROJO") ;
        Auto aComercial = new Auto (2, "Swift", "GRIS") ;



        System.out.println(aDeportivo) ;
        System.out.println(aComercial) ;

        System.out.println("id "+aDeportivo.id+ " color "+aDeportivo.color+ " modelo "+aDeportivo.modelo);
    }
}

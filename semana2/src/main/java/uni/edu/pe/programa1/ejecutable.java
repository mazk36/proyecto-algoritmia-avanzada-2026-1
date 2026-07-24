package uni.edu.pe.programa1;

public class ejecutable {
    public static void main(String[] args) {
        iComplex c1 = new complex(2, 3);
        iComplex c2 = new complex(3, 4);
        iComplex suma = c1.sum(c2);
        System.out.println("La suma de los complejos es: "+suma);
        System.out.println("El producto de los complejos es: "+c1.times(c2));
        System.out.println("¿Los complejos son iguales? "+c1.isequals(c2));
        System.out.println("El modulo del complejo 1 es: "+c1.module());
    }
}

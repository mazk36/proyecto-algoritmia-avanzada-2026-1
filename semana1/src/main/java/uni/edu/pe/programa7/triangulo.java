package uni.edu.pe.programa7;

public class triangulo extends figura  {
    private double base ;
    private double altura ;

    //Hacemos funciones de este triangulo
    public void calcularArea()
    {
        System.out.println("Calculando el area del triangulo");
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

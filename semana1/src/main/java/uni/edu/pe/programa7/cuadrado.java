package uni.edu.pe.programa7;

public class cuadrado extends figura{
    private double lado ;

    //Hacemos las funciones de este cuadrado
    public void calcularArea()
    {
        System.out.println("Calculando el area del cuadrado");
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}

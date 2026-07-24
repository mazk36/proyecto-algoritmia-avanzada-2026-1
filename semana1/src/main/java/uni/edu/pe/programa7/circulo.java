package uni.edu.pe.programa7;

import java.util.Objects;

public class circulo extends figura {
    private double radio ;

    public void calcularArea()
    {
        System.out.println("Calculando Area del Circulo");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        circulo circulo = (circulo) o;
        return Integer.compare(getId(), circulo.getId()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}

package uni.edu.pe.programa4;

public class Estudiante {
    int cod;
    float pf;
    String nombre;

    public Estudiante(int cod, float pf, String nombre) {
        this.cod = cod;
        this.pf = pf;
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "cod=" + cod +
                ", pf=" + pf +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

package uni.edu.pe.programa7;

public class figura {
    protected double coordx ;
    protected double coordy ;
    protected int id;

    //Ahora hacemos las funciones que puede hacer una figura
    public void calcularArea()
    {
        System.out.println("Calculando area");
    }
    public void rotar()
    {
        System.out.println("Rotando la figura");
    }
    //Hacemos el get and set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCoordx() {
        return coordx;
    }

    public void setCoordx(double coordx) {
        this.coordx = coordx;
    }

    public double getCoordy() {
        return coordy;
    }

    public void setCoordy(double coordy) {
        this.coordy = coordy;
    }



}

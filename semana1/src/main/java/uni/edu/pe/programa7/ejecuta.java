package uni.edu.pe.programa7;

public class ejecuta
{
    public static void main(String[] args) {
        //Creamos nuestras figuras

        circulo cir = new circulo();
        cir.setRadio(5);
        cir.calcularArea();

        triangulo tri = new triangulo();
        tri.setAltura(5);
        tri.setBase(2);
        tri.calcularArea();

        cuadrado cua = new cuadrado();
        cua.setLado(5);
        cua.calcularArea();

        figura fig = new figura();
        fig.calcularArea();


        figura[] listadeFiguras = new figura[4] ;
        listadeFiguras[0] = new circulo();
        listadeFiguras[1] = new triangulo();
        listadeFiguras[2] = new cuadrado();
        listadeFiguras[3] = new figura();

        for(figura f : listadeFiguras)
        {
            f.calcularArea();
            f.setCoordx(2);
            f.setCoordy(2);
        }


        circulo cir2 = new circulo();
        circulo cir3 = new circulo();
        cir2.setId(2);
        cir3.setId(2);
        System.out.println(cir2.equals(cir3));



    }
}


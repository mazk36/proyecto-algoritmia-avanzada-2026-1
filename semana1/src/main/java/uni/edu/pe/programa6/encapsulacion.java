package uni.edu.pe.programa6;

class book
{
    private String code ;
    private String descripcion ;
    private int cont = 2 ;


    public book(String code, String descripcion)
    {
        this.code = code ;
        this.descripcion = descripcion ;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    @Override
    public String toString() {
        return "book{" +
                "code='" + code + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cont=" + cont +
                '}';
    }
}

class encapsulacion
{
    public static void main(String[] args) {
        book b =  new book("001", "book 1") ;
        book c =  new book("002", "book 2") ;
        System.out.println(b);
        System.out.println(c);
        book d = c ;
        System.out.println(d);
        d.setCont(d.getCont() + 1);
        System.out.println("Despues de sumar");
        System.out.println(c);
        System.out.println(d);
    }
}

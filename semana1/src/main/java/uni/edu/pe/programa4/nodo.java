package uni.edu.pe.programa4 ;

//Vamos a crear la clase nodo
public class nodo
{
    int Cod ;
    float pf ;
    nodo next ;
    //Ahora creamos el constructor

    //Hacemos el constructor si es que no ponemos argumentos
    public nodo(){} ;

    //Hacemos el constructor si es que si ponemos argumentos
    public nodo(int Cod, float pf , nodo next)
    {
        this.Cod = Cod ;
        this.pf = pf ;
        this.next = next ;
    }
}


package uni.edu.pe.programa4;

public class SStack<T> implements IStack<T> {
    SNode<T> peak = null ;
    int size = 0 ;



    //Funcion esta vacio
    @Override
    public boolean isEmpty() {
        return peak == null;
    }

    //Funcion push
    @Override
    public void push(T elem) {
        SNode<T> node = new SNode<T>(elem);
        node.next = peak ;
        peak = node ;
        size++ ;
    }

    //Funcion pop
    //OJO POP BORRA EL PRIMERO PERO TAMBIEN NOS LO DEVUELVE
    @Override
    public T pop() {
        if(isEmpty())
        {
            System.out.println("La pila esta vacia");
            return null ;
        }
        T elem = peak.elem ;
        peak = peak.next ;
        size-- ;
        return elem;
    }

    //Funcion top
    //Solo nos devuelve el top
    @Override
    public T top() {
        if(isEmpty())
        {
            System.out.println("La pila esta vacia");
            return null ;
        }
        return peak.elem;
    }


    @Override
    public int getSize() {
        return size;
    }

    public void listaElementos()
    {
        SNode actual = peak ;
        while (actual != null)
        {
            System.out.println(actual.elem);
            actual = actual.next ;
        }
    }
}

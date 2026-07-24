package uni.edu.pe.programa2;

public class SStack implements IStack {
    SNode peak = null ;
    int size = 0 ;



    //Funcion esta vacio
    @Override
    public boolean isEmpty() {
        return peak == null;
    }

    //Funcion push
    @Override
    public void push(Integer elem) {
        SNode node = new SNode(elem);
        node.next = peak ;
        peak = node ;
        size++ ;
    }

    //Funcion pop
    //OJO POP BORRA EL PRIMERO PERO TAMBIEN NOS LO DEVUELVE
    @Override
    public Integer pop() {
        if(isEmpty())
        {
            System.out.println("La pila esta vacia");
            return null ;
        }
        Integer elem = peak.elem ;
        peak = null ;
        size-- ;
        return elem;
    }

    //Funcion top
    //Solo nos devuelve el top
    @Override
    public Integer top() {
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

    public void listarElementos()
    {
        SNode actual = peak ;
        while (actual != null)
        {
            System.out.println(actual.elem);
            actual = actual.next ;
        }
    }
}

package uni.edu.pe.program3;

public class SQueue implements IQueue{
    SNode first ;
    SNode last ;
    int size ;

    //Funcion vacio
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    //Funcion enqueue
    @Override
    public void enqueue(String elem) {
        SNode node = new SNode(elem) ;
        if(isEmpty())
        {
            first = node ;
        }
        else
        {
            last.next = node ;
        }
        last = node ;
        size++ ;

    }

    //Funcion dequeue que NOS DA TAMBIEN EL DATO QUE SALE
    @Override
    public String dequeue() {
        if(isEmpty())
        {
            System.out.println("La cola esta vacia");
            return null ;
        }
        String firstElement = first.elem;
        first = first.next ;
        if(first==null)
        {
            last = null ;
        }
        size-- ;
        return firstElement;
    }

    @Override
    public String front() {
        if(isEmpty())
        {
            System.out.println("La cola esta vacia");
            return null ;
        }
        return first.elem;
    }

    @Override
    public int getSize() {
        return size;
    }
}

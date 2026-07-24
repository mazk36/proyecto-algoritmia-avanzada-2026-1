package uni.edu.pe.problema2;
// import java.util.HashSet  ;


public class DList<T> implements IList<T>{

    DNode<T> header ;
    DNode<T>  trailer ;
    int size ;

    public DList() {
        header = new DNode<>(null) ;
        trailer = new DNode<>(null) ;
        header.next = trailer ;
        trailer.prev = header ;;
    }

    @Override
    public boolean isEmpty() {
        return (header.next == trailer) ;
    }

    @Override
    public void addfirst(T element) {
        DNode<T> node = new DNode<>(element) ;

        node.next = header.next ;
        node.prev = header ;

        header.next.prev = node ;
        header.next = node ;
        size++ ;
    }



    @Override
    public void remove(T element) {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return;
        }

        DNode<T> actual = header.next ;
        while (actual != trailer)
        {
            if(actual.element.equals(element))
            {
                actual.prev.next = actual.next ;
                actual.next.prev = actual.prev ;
                size-- ;
                return;
            }
            actual = actual.next ;
        }
        System.out.println("No se encontro el elemento ");
        return;
    }

    @Override
    public void removeAll(T element) {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return;
        }
        DNode<T> actual = header.next ;
        if(actual.element.equals(element))
        {
            actual.prev.next = actual.next ;
            actual.next.prev = actual.prev ;
            size-- ;
        }

        while (actual.next != trailer)
        {
            if(actual.next.element.equals(element))
            {

                actual.next = actual.next.next ;
                actual.next.prev = actual ;
                size-- ;
            }
            else
            {
                actual = actual.next ;

            }
        }
        return;
    }
}

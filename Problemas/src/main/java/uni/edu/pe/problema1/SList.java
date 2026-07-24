package uni.edu.pe.problema1;
import java.util.HashSet;

import java.util.Objects;
//OJO A ESTE EXTENDS ES PARA PODER COMPARAR CUANDO ES UN OBJETO

public class SList<T extends Comparable<T>> implements IList<T> {
    public SNode<T> first ;
    public SNode<T> last ;
    int size ;


    //Ahora vamos a implementar



    
    @Override
    public boolean isEmpty() {
        return (first == null);
    }
    @Override
    public void addFirst(T newElem) {
        SNode<T> node = new SNode<>(newElem) ;
        if(isEmpty())
        {
            last = node ;
        }
        node.next = first ;
        first = node ;
        size++ ;
    }

    @Override
    public void addLast(T newElem) {
        if(isEmpty())
        {
            addFirst(newElem);
        }
        else
        {
            SNode<T> node = new SNode<>(newElem) ;
            last.next = node ;
            last = node ;
            size++ ;
        }

    }

    @Override
    public void removeFirst() {
        if(!isEmpty())
        {
            first = first.next ;
            if(first == null)
            {
                last = null ;
            }
            size-- ;
        }
    }

    @Override
    public void removeLast() {
        if(!isEmpty())
        {
            if(size == 1)
            {
                removeFirst();
            }
            else
            {
                SNode<T> penult = first ;
                while (penult.next != last)
                {
                    penult = penult.next ;
                }
                penult.next = null ;
                last = penult;
                size-- ;
            }
        }
    }

    @Override
    public void mostrarlista() {
        SNode<T> actual = first ;
        while (actual != null)
        {
            System.out.println(actual.element);
            actual = actual.next ;
        }
    }

    @Override
    public void remove(T element) {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return;
        }

        //Caso hay que borrar primer elemento
        if(first.element.equals(element))
        {
            removeFirst();
            return;
        }

        else {
            //aqui vamos a hacer una jugada, atento chaval
            SNode<T> actual = first.next ;
            SNode<T> prev = first ;
            //Aqui tengo 2 punteros que se van a enlazar una vez encuentre al que hay que borrar

            while (actual != null)
            {
                if(actual.element.equals(element))
                {
                    prev.next = actual.next ;
                    if(actual == last)
                    {
                        last = prev ;
                    }
                    size-- ;
                    return;
                }

                prev = actual ;
                actual = actual.next ;

            }

        }
    }

    @Override
    public void removeAll(T element) {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return;
        }

        //Caso hay que borrar primer elemento, pero y si hay varios en el primero?
        while (first != null && first.element.equals(element) ) {
            removeFirst();
        }
        //Si la lista quedo vacia hay que retornar
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return;
        }

        SNode<T> prev = first ;
        SNode<T> actual = first.next ;
        while (actual != null)
        {
            if(actual.element.equals(element))
            {
                prev.next = actual.next ;
                if(actual == last)
                {
                    last = prev ;
                }
                actual = actual.next ;
                size-- ;

            }
            else
            {
                prev = actual ;
                actual = actual.next ;
            }
        }
        return;
    }

    @Override
    public T getAtRev(int index) {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return null ;
        }
        if(index >= size || index < 0)
        {
            System.out.println("Indice fuera de lista");
            return null ;
        }
        SNode<T> node = first ;
        for(int i = 0 ; i < size- index- 1; i++ )
        {
            node = node.next ;
        }
        return node.element;
    }

    @Override
    public T getMiddle() {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return null ;
        }
        SNode<T> node = first ;
        if(size % 2 == 1)
        {
            for(int i = 0 ; i < size /2 ; i++) {
                node = node.next;
            }
        }
        else if(size % 2 == 0)
        {
            for (int i = 0 ; i < size/2-1 ; i++)
            {
                node = node.next ;
            }
        }
        return node.element;
    }

    @Override
    public int count(T element) {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return 0 ;
        }
        int contador = 0 ;
        SNode node = first ;
        while (node != null)
        {
            if(node.element.equals(element))
            {
                contador++ ;
            }
            node = node.next ;
        }
        return contador;

    }

    @Override
    public boolean isSorted() {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return false ;
        }
        if(size == 1)
        {
            return true ;
        }
        SNode<T> actual = first.next;
        SNode<T> prev = first ;
        while (actual != null)
        {
            if(actual.element.compareTo(prev.element) < 0 )
            {
                return false ;
            }
            actual = actual.next ;
            prev = prev.next;
        }
        return true ;
    }

    @Override
    public void removeDuplicateSorted() {
        if(!isSorted())
        {
            System.out.println("La lista no esta ordenada");
            return ;
        }
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return;
        }

        SNode<T> actual = first.next ;
        SNode<T> prev = first ;
        while (actual != null)
        {
            //Tengo que eliminar
            if(actual.element.compareTo(prev.element) == 0)
            {
                prev.next = actual.next ;
                //si es que el actual es el ultimo elemento, osea que lo que sigue es null, tenemos que hacer que el prev sea last porque el que se borra es el actual
                if(actual == last)
                {
                    prev = last ;
                }
                size-- ;
                actual = actual.next ;

            }
            //si no tengo que eliminar
            else
            {
                prev = actual ;
                actual = actual.next;
            }

        }
        return;
    }

    @Override
    public void removeDuplicate() {
        if(isEmpty()) {System.out.println("La lista esta vacia"); return;}
        HashSet<T> vistos = new HashSet<>() ;
        SNode<T> prev = null ;
        SNode<T> actual = first ;
        while (actual != null)
        {
            //Primer caso si es que ya salio
            if(vistos.contains(actual.element))
            {
                //aqui borramos
                prev.next = actual.next ;
                //Que pasa si es que el actual es el ultimo ?
                if(actual == last)
                {
                    last = prev ;
                }
                size-- ;
            }
            else
            {
                vistos.add(actual.element) ;
                prev = actual ;
            }
            actual = prev.next ;
        }
    }

    @Override
    public void swapPairwise() {
        if(isEmpty() || size == 1)
        {
            return ;
        }

        SNode<T> actual = first ;

        while (actual != null && actual.next != null)
        {
            T element = actual.element;
            actual.element = actual.next.element ;
            actual.next.element = element ;
            //Aqui ya hice el swap ahora hay que avanzar 2 casillas
            actual = actual.next.next ;
        }
    }

    @Override
    public void moveLast() {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia");
            return;
        }
        if(size == 1)
        {
            System.out.println("La lista solo tiene un elemento");
            return;
        }
        SNode<T> penult = first ;
        while (penult.next != last)
        {
            penult = penult.next ;
        }
        last.next = first ;
        first = last ;
        penult.next = null ;
        last = penult ;
    }

    @Override
    public void intersection(T list2) {

    }
}




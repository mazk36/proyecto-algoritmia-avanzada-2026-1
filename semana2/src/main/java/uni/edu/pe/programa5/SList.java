package uni.edu.pe.programa5;

public class SList implements IList {
    public SNode first ;
    public SNode last ;
    int size ;

    //Ahora vamos a implementar


    @Override
    public int getSize() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return (first == null);
    }
    @Override
    public void addFirst(String newElem) {
        SNode node = new SNode(newElem) ;
        if(isEmpty())
        {
            last = node ;
        }
        node.next = first ;
        first = node ;
        size++ ;
    }

    @Override
    public void addLast(String newElem) {
        if(isEmpty())
        {
            addFirst(newElem);
        }
        else
        {
            SNode node = new SNode(newElem) ;
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
                SNode penult = first ;
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
    public void insertAt(int index, String newElem) {
        if(index > size || index < 0) {System.out.println("Indice fuera de lista") ; return; }
        SNode actual = first ;
        SNode siguiente = first.next ;
        SNode node = new SNode(newElem) ;
        if(index == 0) { addFirst(newElem); return;}
        if(index == size) {addLast(newElem); return;}
        for (int i = 0 ; i < index-1 ; i++)
        {
            actual = actual.next ;
            siguiente = siguiente.next ;
        }
        actual.next = node ;
        node.next = siguiente ;
        size++ ;
    }


    @Override
    public boolean contains(String elem) {
        if(isEmpty()) {System.out.println("La lista esta vacia"); return false ;}
        SNode node = first ;
        while (node != null)
        {
            if(node.element.equals(elem))
            {
                return true ;
            }
            node = node.next ;
        }
        return false;
    }


    @Override
    public int getIndexOf(String elem) {
        if(isEmpty()) {System.out.println("la lista esta vacia"); return -1;}
        if(!contains(elem))
        {
            System.out.println("La lista no contiene el elemento");
            return -1 ;
        }
        else
        {
            SNode actual = first ;
            int index = 0 ;
            while (actual != null)
            {
                if(actual.element.equals(elem))
                {
                    return index ;
                }
                actual = actual.next ;
                index++ ;
            }
        }
        return -1;
    }

    @Override
    public String getFirst() {
        if(isEmpty()){System.out.println("la lista esta vacia"); return null ;}
        SNode node = first ;
        return node.element;
    }

    @Override
    public String getLast() {
        if(isEmpty()){System.out.println("la lista esta vacia"); return null ;}
        SNode node = last ;
        return node.element ;
    }

    @Override
    public String getAt(int index) {
        if (isEmpty()) {System.out.println("La lista esta vacia"); return null ;}
        if(index >= size || index < 0) {System.out.println("Indice fuera de lista "); return null ;}
        SNode node = first ;
        for (int i = 0 ; i < index ; i++)
        {
            node = node.next ;
        }
        return node.element;
    }



    @Override
    public void removeAll(String elem) {
        if(isEmpty()) {System.out.println("la lista esta vacia"); return  ;}
        if(!contains(elem)) {System.out.println("la lista no contiene a ese elemento"); return;}

        while (first != null && (first.element.equals(elem)) )
        {
            removeFirst();

        }
        if (first == null) return ;

        SNode node = first ;
        while (node.next != null)
        {
            if(node.next.element.equals(elem))
            {
                if(node.next == last) {
                    last = node;
                }
                node.next = node.next.next ;
                size-- ;

            }
            else
            {
                node = node.next ;
            }

        }
    }

    @Override
    public void removeAt(int index) {
        if(isEmpty()) {System.out.println("la lista esta vacia"); return ;}
        if(index >= size || index < 0) {System.out.println("indice fuera de lista"); return;}
        if(index == 0 ) { removeFirst() ; return;}
        SNode prev = first ;
        int i = 0 ;
        while (i+1 != index)
        {
            prev = prev.next;
            i++;
        }
        if(prev.next == last)
        {
            last = prev ;
        }
        prev.next = prev.next.next ;
        size-- ;
    }

    @Override
    public void mostrarLista() {
        SNode node = first ;
        while (node != null)
        {
            System.out.println(node.element);
            node = node.next ;
        }
    }
}

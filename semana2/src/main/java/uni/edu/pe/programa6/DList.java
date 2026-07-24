package uni.edu.pe.programa6;

public class DList implements IList{
    DNode header ;
    DNode trailer ;
    int size = 0 ;

    //Vamos a hacer el constructor de la DLIST
    public  DList(){
        header = new DNode(null) ;
        trailer = new DNode(null) ;
        header.next = trailer ;
        trailer.prev = header ;
    }

    // IMPLEMENTAMOOOOOOOS

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void addFirst(String newElem) {
        DNode node = new DNode(newElem) ;
        node.next = header.next ;
        node.prev = header ;

        header.next.prev = node ;
        header.next = node ;

        size++;
    }

    @Override
    public void addLast(String newElem) {
        DNode node = new DNode(newElem) ;
        node.prev = trailer.prev ;
        node.next = trailer ;

        trailer.prev.next = node ;
        trailer.prev = node ;
        size++ ;
    }
    @Override
    public void removeFirst() {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia hermano");
            return;
        }
        header.next = header.next.next ;
        header.next.prev = header ;
        size-- ;

    }

    @Override
    public void removeLast() {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia hermano");
            return;
        }
        trailer.prev = trailer.prev.prev ;
        trailer.prev.next = trailer ;
        size-- ;
    }

    @Override
    public void insertAt(int index, String newElem) {

    }



    @Override
    public boolean contains(String elem) {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getIndexOf(String elem) {
        return 0;
    }

    @Override
    public String getFirst() {
        return "";
    }

    @Override
    public String getLast() {
        return "";
    }

    @Override
    public String getAt(int index) {
        return "";
    }



    @Override
    public void removeAll(String elem) {

    }

    @Override
    public void removeAt(int index) {

    }

    
}

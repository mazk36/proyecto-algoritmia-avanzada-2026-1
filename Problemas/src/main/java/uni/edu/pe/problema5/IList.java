package uni.edu.pe.problema5;

interface IList {
    void addFirst(String newElem);
    void addLast(String newElem);
    void insertAt(int index, String newElem);
    boolean isEmpty();
    void removeFirst();
    void removeLast();

    boolean contains(String elem);
    int getSize();
    int getIndexOf(String elem);
    String getFirst();
    String getLast();
    String getAt(int index);
    String toString();

    void removeAll(String elem);
    void removeAt(int index);
    void mostrarLista() ;
}

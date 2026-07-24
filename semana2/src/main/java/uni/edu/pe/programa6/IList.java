package uni.edu.pe.programa6;

public interface IList {
    void addFirst(String newElem);
    void addLast(String newElem);
    void insertAt(int index, String newElem);
    boolean isEmpty();
    boolean contains(String elem);
    int getSize();
    int getIndexOf(String elem);
    String getFirst();
    String getLast();
    String getAt(int index);
    String toString();
    void removeFirst();
    void removeLast();
    void removeAll(String elem);
    void removeAt(int index);
}

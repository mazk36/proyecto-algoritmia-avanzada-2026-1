package uni.edu.pe.problema4;

public interface IList {
    void addFirst(Integer newElem);
    void addLast(Integer newElem);
    void insertAt(int index, Integer newElem);
    boolean isEmpty();
    boolean contains(Integer elem);
    int getSize();
    int getIndexOf(Integer elem);
    String getFirst();
    String getLast();
    String getAt(int index);
    String toString();
    void removeFirst();
    void removeLast();
    void removeAll(Integer elem);
    void removeAt(int index);
}

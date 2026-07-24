package uni.edu.pe.problema2;

public class DNode<T>{
    T element ;
    DNode<T> next  ;
    DNode<T> prev  ;


    public DNode(T element) {
        this.element = element;
    }
}

package uni.edu.pe.programa4;

public interface IStack<T> {
    boolean isEmpty();
    void push(T elem);
    T pop();
    T top();
    int getSize();
}

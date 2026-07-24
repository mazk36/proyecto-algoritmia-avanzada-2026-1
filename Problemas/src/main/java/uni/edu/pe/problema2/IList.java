package uni.edu.pe.problema2;

public interface IList<T> {

    boolean isEmpty() ;
    void addfirst(T element) ;


    /*
    remove(e): método que recibe un elemento, e, y borra la primera ocurrencia de
    e en la lista (es decir, elimina el primer nodo que contiene a e). El método
    modifica la lista y no devuelve nada. Si el elemento no existe en la lista, el
    método debe informar que no existe.
    */

    void remove(T element) ;

    /*
    removeAll(e): método que recibe un elemento, e, y borra todas las ocurrencias
    de e en la lista (es decir, elimina todos los nodos que contienen a e). El método
    modifica la lista y no devuelve nada. Si el elemento no existe en la lista, el
    método debe informar que no existe.
    */

    void removeAll(T element) ;

}

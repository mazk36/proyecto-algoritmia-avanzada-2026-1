package uni.edu.pe.problema1;

interface IList<T> {
    void addFirst(T newElem);
    void addLast(T newElem);

    boolean isEmpty();
    void removeFirst();
    void removeLast();

    void mostrarlista() ;

    //Ahora vamos a resolver el problema
    /*
    remove(e): método que recibe un elemento, e, y borra la primera ocurrencia de
    e en la lista (es decir, elimina el primer nodo que contiene el elemento e). El
    método modifica la lista y no devuelve nada. Si el elemento no existe en la lista,
    el método debe mostrar un mensaje indicando que el elemento no existe.
    */

    void remove(T element) ;

    /*removeAll(e): función que recibe un elemento, e, y borra todas las ocurrencias
    de e en la lista (es decir, elimina todos los nodos que contienen a e). El método
    modifica la lista y no devuelve nada. Si el elemento no existe en la lista, el
    método debe mostrar un mensaje indicando que el elemento no existe.
    */

    void removeAll(T element) ;

    /*
    getAtRev(index): método que recibe un índice, index, y devuelve el elemento en
    la posición index empezando por el final. Por ejemplo:
    l: 0->1->2->3->4, l.getAtRev(0)=4, l.getAtRev(1)=3, l.getAtRev(2)=2,
    l.getAtRev(3)=1, l.getAtRev(4)=0
    El método debe comprobar que el índice es correcto (es una posición de la
    lista). En caso de no ser un índice correcto, imprime un mensaje y devuelve
    None.
    */

    T getAtRev(int index) ;

    /*getMiddle(): método que devuelve el elemento que está en la mitad de la lista.
    Si la lista tiene un número par de elementos, la función devolverá el elemento
    en la posición len(l)//2. Ejemplo: 1->2->3->4->5->6, l.getMiddle()=3
    */

    T getMiddle() ;

    /*
    count(e): método que recibe un elemento, e, y devuelve el número de veces que
    ocurre en la lista. Si el elemento no existe en la lista, la función devuelve 0.
     */

    int count(T element) ;

    /*isSorted(): método que comprueba si la lista está ordenada de forma
    ascendente (en este caso devuelve true). En caso contrario, debe devolver
    False.
    */

    boolean isSorted() ;

    /*
     removeDuplicateSorted(): método que borra los elementos duplicados en una
    lista ordenada. El método modifica la lista, no devuelve nada.
    Ejemplo: l: 1->1->2->3->3->4->5->5, l: 1->2->3->4->5
    */

    void removeDuplicateSorted() ;

    /*removeDuplicates(): método que borra los elementos duplicados en una lista
    (no tiene que estar ordenada). La función modifica la lista, no devuelve nada.
    Ejemplo: l: 1->2->1->0->2->6->6->4->5->5, l: 1->2->0->6->4->5
    */

    void removeDuplicate() ;

    /*
    swapPairwise(): método que intercambia los elementos que ocupan
    posiciones contiguas. La función modifica la lista, no devuelve nada. Ejemplos:
    l: 1->2->3->4->5, l: 2->1->4->3->5
    l: 1->2->3->4->5->6, l: 2->1->4->3->6->5
    */

    void swapPairwise() ;

    /*
    moveLast(): método que mueve el último elemento al principio de la lista, sin
    usar ninguno del resto de métodos de la clase. El método modifica la lista, no
    devuelve nada.
    Ejemplo: l: 1->2->3->4->5->6, l: 6->1->2->3->4->5
    */

    void moveLast() ;

    /*
    intersection(l2): método que recibe una lista l2 y devuelve una nueva lista que
    contenga la intersección de ambas listas, la invocante y l2. Como precondición,
    se exige que ambas listas estén ordenadas de forma ascendente.
    Ejemplo: l: 1->2->3->4->5->6, l2: 0->1->2->3, output: 1->2->3
     */

    void intersection(T list2) ;


}

package uni.edu.pe.problema6;

public interface IBSTree<K extends Comparable<K>,E>{
    public void insert(K key, E elem);

    public void remove(K key);

    public E find(K key);

    public int getSize();

    public int getHeight();

    public void showPreOrder();

    public void showInOrder();

    public void showPostOrder();

    public BSTNode<K,E> search(K num);

    public void showLevelOrder();

    public K abuelo(BSTNode<K,E> node);

    public void imprimirNietosDel10();

    public void recorrido(BSTNode<K,E> node);

    public K predecesor(BSTNode<K,E> node);

    public K antecesor(BSTNode<K,E> node);

    public K clavemaspequeña();

    public K clavemasgrande();

    public int equilibrioPorTamano(BSTNode<K,E> node);

    public int equilibrioPorAltura(BSTNode<K,E> node);

    public boolean perfectamenteEquilibrado();

    public boolean perfectamenteEquilibradoAltura();

    public int profundidad(BSTNode<K,E> node);
}

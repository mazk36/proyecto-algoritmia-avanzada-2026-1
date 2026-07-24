package uni.edu.pe.problema6;

public class BSTNode<K extends Comparable<K>, E>
{
    public K key;
    public E elem;

    public BSTNode<K,E> parent;
    public BSTNode<K,E> leftChild;
    public BSTNode<K,E> rightChild;

    public BSTNode(K key, E element)
    {
        this.key = key;
        this.elem = element;
    }
}
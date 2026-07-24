package uni.edu.pe.abb;

public class BSTNode {
    public int key;
    public String elem;
    public BSTNode parent;
    public BSTNode leftChild;
    public BSTNode rightChild;

    //constructor
    public BSTNode(int key, String element) {
        this.key = key;
        this.elem = element;
    }
}

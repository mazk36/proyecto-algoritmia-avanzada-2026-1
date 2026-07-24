package uni.edu.pe.abb;

public interface IBSTree
{
    public void insert(int key, String elem);
    public void remove(int key);
    public String find(int key);

    public int getSize();
    public int getHeight();
    public void showPreOrder();
    public void showInOrder();
    public void showPostOrder();
    public void showLevelOrder();
}

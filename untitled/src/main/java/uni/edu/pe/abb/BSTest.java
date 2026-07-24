package uni.edu.pe.abb;

public class BSTest {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insert(50,"50");
        tree.insert(30,"30");
        tree.insert(20,"20");
        tree.insert(40,"40");
        tree.insert(70,"70");
        tree.insert(60,"60");
        tree.insert(80,"80");
        tree.showInOrder();

        System.out.println(tree.getSize());
        System.out.println(tree.getHeight());






    }
}

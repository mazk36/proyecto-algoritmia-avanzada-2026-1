package uni.edu.pe.problema3;

public class BSTest {
    public static void main(String[] args) {
        MyBST tree = new MyBST();
        tree.insert(25,"25");
        tree.insert(20,"20");
        tree.insert(36,"36");
        tree.insert(10,"10");
        tree.insert(22,"22");
        tree.insert(30,"30");
        tree.insert(40,"40");
        tree.insert(5,"5");
        tree.insert(12,"12");
        tree.insert(28,"28");
        tree.insert(38,"38");
        tree.insert(48,"48");


        System.out.println(tree.sonPrimos(tree.search(10), tree.search(30)));

    }


}

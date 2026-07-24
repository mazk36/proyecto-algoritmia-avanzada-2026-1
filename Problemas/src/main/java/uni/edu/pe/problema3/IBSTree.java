package uni.edu.pe.problema3;

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
    public BSTNode search(int num) ;
    public void showLevelOrder() ;
    public int abuelo (BSTNode node) ;
    public void imprimirNietosDel10();
    public void recorrido(BSTNode node);
    public int predecesor(BSTNode node) ;
    public int antecesor(BSTNode node) ;
    public int clavemaspequeña() ;
    public int clavemasgrande() ;
    public int equilibrioPorTamano(BSTNode node);
    public int equilibrioPorAltura(BSTNode node);
    public boolean perfectamenteEquilibrado() ;
    public boolean perfectamenteEquilibradoAltura();
    public int profundidad(BSTNode node) ;
}

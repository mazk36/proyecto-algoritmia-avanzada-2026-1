package uni.edu.pe.problema3;

public class BSTree implements IBSTree{
    protected BSTNode root ;

    @Override
    public void insert(int key, String elem) {
        BSTNode newNode = new BSTNode(key, elem) ;
        if (root == null)
        {
            root = newNode ;
            root.parent = null ;
        }
        else
        {
            insert(newNode, root);
        }

    }
    private void insert(BSTNode newNode, BSTNode node)
    {
        int key = newNode.key;
        if(key == node.key)
        {
            System.out.println("Duplicado!!!");
            return;
        }
        else if (key < node.key)
        {
            if(node.leftChild == null)
            {
                node.leftChild = newNode ;
                newNode.parent = node ;
            }
            else
            {
                insert(newNode, node.leftChild);
            }
        }else
        {
            if(node.rightChild == null)
            {
                node.rightChild = newNode ;
                newNode.parent = node ;
            }
            else
            {
                insert(newNode, node.rightChild);
            }
        }
    }

    //El mas dificil
    @Override
    public void remove(int key) {
        root = remove(key, root);

    }



    private BSTNode remove(Integer key, BSTNode currentNode) {
        if(currentNode==null) {
            System.out.println("No se encontro el elemento");
            return null;
        }

        if(key < currentNode.key) {
            currentNode.leftChild = remove(key, currentNode.leftChild);
            return currentNode;
        }else if(key > currentNode.key) {
            currentNode.rightChild = remove(key, currentNode.rightChild);
            return currentNode;
        }else
        {
            // Caso 1: Encontramos el nodo a eliminar
            if(currentNode.leftChild==null && currentNode.rightChild==null) {
                return null;
            }

            //Caso 2: tiene un hijo
            if(currentNode.leftChild==null) {
                currentNode.rightChild.parent = currentNode.parent;
                return currentNode.rightChild;
            }
            if(currentNode.rightChild==null) {
                currentNode.leftChild.parent = currentNode.parent;
                return currentNode.leftChild;
            }

            //Caso 3: tiene dos hijos
            BSTNode succesorNode = currentNode.rightChild;
            while(succesorNode.leftChild!=null) {
                succesorNode = succesorNode.leftChild;
            }

            currentNode.elem = succesorNode.elem;
            currentNode.key = succesorNode.key;

            currentNode.rightChild = remove(succesorNode.key, currentNode.rightChild);
            return currentNode;
        }



    }

    @Override
    public int profundidad(BSTNode node) {
        return getHeight() - getHeight(node) ;
    }

    @Override
    public String find(int key) {
        return find(root, key) ;
    }
    private String find(BSTNode actualnode , int key)
    {
        String result = null ;
        if(actualnode == null) return null;
        else
        {
            if(key == actualnode.key)
            {
                result = actualnode.elem ;
            }
            else if(key < actualnode.key)
            {
                result = find(actualnode.leftChild, key) ;
            }
            else
            {
                result = find(actualnode.rightChild, key) ;
            }
            return result ;
        }
    }

    @Override
    public int getSize() {
        return getSize(root);
    }
    private int getSize(BSTNode node)
    {
        if (node == null)
        {
            return 0 ;
        }

        return 1 + getSize(node.leftChild) + getSize(node.rightChild) ;

    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }
    public int getHeight(BSTNode node)
    {
        if(node == null)
        {
            return 0 ;
        }
        return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) ;

    }

    @Override
    public void showPreOrder() {
        showPreOrder(root);
    }
    private void showPreOrder(BSTNode node) {
        if (node == null) return ;
        System.out.println(node.elem);
        showPreOrder(node.leftChild);
        showPreOrder(node.rightChild);

    }

    @Override
    public void showInOrder() {
        showInOrder(root);
    }
    private void showInOrder(BSTNode node)
    {
        if(node == null) return ;
        showInOrder(node.leftChild);
        System.out.println(node.elem);
        showInOrder(node.rightChild);
    }

    @Override
    public void showPostOrder() {
        showPostOrder(root);
    }
    private void showPostOrder(BSTNode node) {
        if (node == null) return ;
        showPostOrder(node.leftChild);
        showPostOrder(node.rightChild);
        System.out.println(node.elem);
    }


    @Override
    public void showLevelOrder() {
        int h = getHeight() ;
        for (int level = 1 ; level < h ; level++)
        {
            showLevelOrder(root, level);
        }
    }

    private void showLevelOrder(BSTNode node, Integer level){
        if(node == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.println(node.elem);
        }
        showLevelOrder(node.leftChild, level-1);
        showLevelOrder(node.rightChild, level-1);
    }

    public int abuelo (BSTNode node)
    {
        if(node == null)
        {
            return -1 ;
        }
        else if(node.parent == null)
        {
            return -1 ;
        } else if (node.parent.parent == null)
        {
            return -1 ;
        }
        return node.parent.parent.key;
    }

    public void imprimirNietosDel10()
    {
        imprimirNietosDel10(root);
    }
    private void imprimirNietosDel10(BSTNode node)
    {
        if(node == null)
        {
            return;
        }

        if(abuelo(node) % 10 == 0)
        {
            System.out.println(node.elem);
        }
        imprimirNietosDel10(node.leftChild);
        imprimirNietosDel10(node.rightChild);
    }

    public int predecesor(BSTNode node)
    {
        if(node == null)
        {
            return -1 ;
        }
        //CASO 1 :
        if(node.leftChild == null)
        {
            BSTNode parent = node.parent ;
            while ( parent != null && node == parent.leftChild )
            {
                node = parent ;
                parent = parent.parent ;
            }
            if(parent == null)
            {
                System.out.println("No tiene susesor");
                return -1 ;
            }
            return parent.key ;
        }
        //CASO 2 :
        else
        {
            BSTNode aux = node.leftChild ;
            while (aux.rightChild != null)
            {
                aux = aux.rightChild ;
            }
            return aux.key ;
        }
    }

    @Override
    public int antecesor(BSTNode node) {
        if(node == null)
        {
            return -1 ;
        }
        //caso 1
        if(node.rightChild == null)
        {
            BSTNode parent = node.parent ;
            while (parent != null && node == parent.rightChild)
            {
                node = parent ;
                parent = parent.parent ;
            }
            if(parent == null)
            {
                System.out.println("No tiene sucesor");
                return -1 ;
            }
            return parent.key;
        }
        //caso 2
        else
        {
            BSTNode aux = node.rightChild ;
            while (aux.leftChild != null)
            {
                aux = aux.leftChild ;
            }
            return aux.key;
        }
    }

    @Override
    public int clavemaspequeña() {
        if(root == null)
        {
            return -1;
        }
        return clavemaspequeña(root) ;
    }
    private int clavemaspequeña(BSTNode node)
    {
        if(node.leftChild == null)
        {
            return node.key;
        }
        return clavemaspequeña(node.leftChild) ;
    }

    public int clavemasgrande() {
        if(root == null)
        {
            return -1;
        }
        return clavemasgrande(root) ;
    }
    private int clavemasgrande(BSTNode node)
    {
        if(node.rightChild == null)
        {
            return node.key ;
        }
        return clavemasgrande(node.rightChild) ;
    }

    public int equilibrioPorTamano(BSTNode node)
    {
        if(node == null)
        {
            return -1 ;
        }
        if(node.leftChild == null && node.rightChild == null)
        {
            return 0 ;
        }
        else if(node.leftChild == null)
        {
            return getSize(node.rightChild) ;
        }
        else if(node.rightChild == null)
        {
            return getSize(node.leftChild) ;
        }
        int aux = 0 ;
        aux = getSize(node.rightChild) - getSize(node.leftChild) ;
        if(aux < 0)
        {
            return -aux ;
        }
        else
        {
            return aux ;
        }
    }
    public int equilibrioPorAltura(BSTNode node)
    {
        if(node == null)
        {
            return -1 ;
        }
        if(node.leftChild == null && node.rightChild == null)
        {
            return 0 ;
        }
        else if(node.leftChild == null)
        {
            return getHeight(node.rightChild) ;
        }
        else if(node.rightChild == null)
        {
            return getHeight(node.leftChild) ;
        }
        int aux = 0 ;
        aux = getHeight(node.rightChild) - getHeight(node.leftChild) ;
        if(aux < 0)
        {
            return -aux ;
        }
        else
        {
            return aux ;
        }
    }


    public boolean perfectamenteEquilibrado()
    {
        return perfectamenteEquilibrado(root);
    }
    private boolean perfectamenteEquilibrado(BSTNode node)
    {
        if(node == null)
        {
            return true;
        }
        if(equilibrioPorTamano(node) > 1)
        {
            return false;
        }
        return (perfectamenteEquilibrado(node.leftChild) && perfectamenteEquilibrado(node.rightChild));
    }

    public boolean perfectamenteEquilibradoAltura()
    {
        return perfectamenteEquilibradoAltura(root);
    }
    private boolean perfectamenteEquilibradoAltura(BSTNode node)
    {
        if(node == null)
        {
            return true;
        }
        if(equilibrioPorAltura(node) > 1)
        {
            return false;
        }
        return (perfectamenteEquilibradoAltura(node.leftChild) && perfectamenteEquilibradoAltura(node.rightChild));
    }




        @Override
    public void recorrido(BSTNode node) {
        BSTNode aux = root ;
        while (aux != node)
        {
            if(aux.key < node.key)
            {
                //vamos a la izquierda
                System.out.println(aux.leftChild.elem);
                aux = aux.leftChild ;
            }
            else
            {
                //vamos a la derecha
                System.out.println(aux.leftChild.elem);
                aux = aux.leftChild ;

            }
        }
    }

    @Override
    public BSTNode search(int num) {
        return search(num, root);
    }
    private BSTNode search(int num, BSTNode node)
    {
        if(node == null)
        {
            return null ;
        }

        if(num == node.key)
        {
            return node ;
        }
        BSTNode encontrado = search(num, node.leftChild) ;
        if(encontrado != null)
        {
            return encontrado ;
        }
        encontrado = search(num, node.rightChild) ;
        if(encontrado != null)
        {
            return encontrado ;
        }
        return null ;
    }
}

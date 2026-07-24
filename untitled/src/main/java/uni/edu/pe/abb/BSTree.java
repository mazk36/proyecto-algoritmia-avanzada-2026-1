package uni.edu.pe.abb;

public class BSTree implements IBSTree{
    private BSTNode root ;

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
    private int getHeight(BSTNode node)
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

    }
}

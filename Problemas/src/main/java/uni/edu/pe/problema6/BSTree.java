package uni.edu.pe.problema6;

public class BSTree<K extends Comparable<K>, E> implements IBSTree<K,E>
{
    protected BSTNode<K,E> root;

    @Override
    public void insert(K key, E elem)
    {
        BSTNode<K,E> newNode = new BSTNode<>(key, elem);

        if(root == null)
        {
            root = newNode;
            root.parent = null;
        }
        else
        {
            insert(newNode, root);
        }
    }

    private void insert(BSTNode<K,E> newNode, BSTNode<K,E> node)
    {
        K key = newNode.key;

        if(key.compareTo(node.key) == 0)
        {
            System.out.println("Duplicado");
            return;
        }

        else if(key.compareTo(node.key) < 0)
        {
            if(node.leftChild == null)
            {
                node.leftChild = newNode;
                newNode.parent = node;
            }
            else
            {
                insert(newNode, node.leftChild);
            }
        }

        else
        {
            if(node.rightChild == null)
            {
                node.rightChild = newNode;
                newNode.parent = node;
            }
            else
            {
                insert(newNode, node.rightChild);
            }
        }
    }

    @Override
    public void remove(K key)
    {
        root = remove(key, root);
    }

    private BSTNode<K,E> remove(K key, BSTNode<K,E> currentNode)
    {
        if(currentNode == null)
        {
            System.out.println("No se encontro el elemento");
            return null;
        }

        if(key.compareTo(currentNode.key) < 0)
        {
            currentNode.leftChild =
                    remove(key, currentNode.leftChild);

            return currentNode;
        }

        else if(key.compareTo(currentNode.key) > 0)
        {
            currentNode.rightChild =
                    remove(key, currentNode.rightChild);

            return currentNode;
        }

        else
        {
            // caso hoja
            if(currentNode.leftChild == null &&
                    currentNode.rightChild == null)
            {
                return null;
            }

            // un hijo
            if(currentNode.leftChild == null)
            {
                currentNode.rightChild.parent =
                        currentNode.parent;

                return currentNode.rightChild;
            }

            if(currentNode.rightChild == null)
            {
                currentNode.leftChild.parent =
                        currentNode.parent;

                return currentNode.leftChild;
            }

            // dos hijos
            BSTNode<K,E> successorNode =
                    currentNode.rightChild;

            while(successorNode.leftChild != null)
            {
                successorNode =
                        successorNode.leftChild;
            }

            currentNode.key = successorNode.key;
            currentNode.elem = successorNode.elem;

            currentNode.rightChild =
                    remove(successorNode.key,
                            currentNode.rightChild);

            return currentNode;
        }
    }

    @Override
    public E find(K key)
    {
        return find(root, key);
    }

    private E find(BSTNode<K,E> actualNode, K key)
    {
        E result = null;

        if(actualNode == null)
        {
            return null;
        }

        if(key.compareTo(actualNode.key) == 0)
        {
            result = actualNode.elem;
        }

        else if(key.compareTo(actualNode.key) < 0)
        {
            result = find(actualNode.leftChild, key);
        }

        else
        {
            result = find(actualNode.rightChild, key);
        }

        return result;
    }

    @Override
    public BSTNode<K,E> search(K key)
    {
        return search(key, root);
    }

    private BSTNode<K,E> search(K key,
                                BSTNode<K,E> node)
    {
        if(node == null)
        {
            return null;
        }

        if(key.compareTo(node.key) == 0)
        {
            return node;
        }

        BSTNode<K,E> found =
                search(key, node.leftChild);

        if(found != null)
        {
            return found;
        }

        found = search(key, node.rightChild);

        return found;
    }

    @Override
    public int getSize()
    {
        return getSize(root);
    }

    private int getSize(BSTNode<K,E> node)
    {
        if(node == null)
        {
            return 0;
        }

        return 1
                + getSize(node.leftChild)
                + getSize(node.rightChild);
    }

    @Override
    public int getHeight()
    {
        return getHeight(root);
    }

    public int getHeight(BSTNode<K,E> node)
    {
        if(node == null)
        {
            return 0;
        }

        return 1 + Math.max(
                getHeight(node.leftChild),
                getHeight(node.rightChild)
        );
    }

    @Override
    public void showPreOrder()
    {
        showPreOrder(root);
    }

    private void showPreOrder(BSTNode<K,E> node)
    {
        if(node == null)
        {
            return;
        }

        System.out.println(node.elem);

        showPreOrder(node.leftChild);
        showPreOrder(node.rightChild);
    }

    @Override
    public void showInOrder()
    {
        showInOrder(root);
    }

    private void showInOrder(BSTNode<K,E> node)
    {
        if(node == null)
        {
            return;
        }

        showInOrder(node.leftChild);

        System.out.println(node.elem);

        showInOrder(node.rightChild);
    }

    @Override
    public void showPostOrder()
    {
        showPostOrder(root);
    }

    private void showPostOrder(BSTNode<K,E> node)
    {
        if(node == null)
        {
            return;
        }

        showPostOrder(node.leftChild);
        showPostOrder(node.rightChild);

        System.out.println(node.elem);
    }

    // LOS DEMÁS MÉTODOS
    // SOLO NECESITAN:
    // int -> K
    // String -> E
    // BSTNode -> BSTNode<K,E>
    // y reemplazar:
    // < > == por compareTo
}

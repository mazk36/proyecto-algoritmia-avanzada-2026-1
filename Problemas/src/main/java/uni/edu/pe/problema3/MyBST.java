package uni.edu.pe.problema3;

import com.sun.source.tree.ReturnTree;

public class MyBST extends BSTree{

    public boolean sonPrimos(BSTNode a, BSTNode b)
    {
        //Primero, que existan
        if(a == null || b == null || a.parent == null || a.parent.parent == null || b.parent == null || b.parent.parent == null)
        {
            return false;
        }

        //Primero misma altura
        if(!(getHeight() - getHeight(a) == getHeight() - getHeight(b)))
        {
            return false ;
        }
        return ((a.parent.parent == b.parent.parent) && a.parent != b.parent) ;
    }



    public boolean padresIguales(BSTNode a, BSTNode b)
    {
        if(a == null || b == null || a.parent == null || b.parent == null)
        {
            return false ;
        }
        return a.parent == b.parent ;


    }

    public int lwc(BSTNode a, BSTNode b)
    {
        //Primero que existan
        if(a == null || b == null) {
            return -1;
        }
        if(!(getHeight()-getHeight(a) == getHeight() - getHeight(b)))
        {
            // A ESTA ABAJO
            if(getHeight()-getHeight(a) > getHeight() - getHeight(b))
            {
                while (getHeight()-getHeight(a) != getHeight() - getHeight(b))
                {
                    a = a.parent;
                }
            }


            // B ESTA ABAJO
            if(getHeight()-getHeight(a) < getHeight() - getHeight(b))
            {
                while (getHeight()-getHeight(a) != getHeight() - getHeight(b))
                {
                    b = b.parent;
                }
            }
            // CASO ESPECIAL UNO ANCESTRO DEL OTRO
            if(a == b)
            {
                return a.key ;
            }
        }

        if(padresIguales(a,b))
        {
            return a.parent.key ;
        }
        return lwc(a.parent, b.parent) ;
    }


    public boolean zigzag()
    {
        return zigzag(root) ;
    }
    private boolean zigzag(BSTNode nodo)
    {
        //condicion solo hacia una direccion
        while (nodo != null)
        {
            if(nodo.rightChild != null && nodo.leftChild != null)
            {
                return false ;
            }
            //condicion de que no puede ir hacia 2 lugares iguales seguido
            else if(nodo.rightChild != null && nodo.rightChild.rightChild != null)
            {
                return false ;
            } else if (nodo.leftChild != null && nodo.leftChild.leftChild != null) {
                return false ;
            }
            //aqui avanzaremos una casilla o a la derecha o a la izquierda
            if(nodo.leftChild != null)
            {
                nodo = nodo.leftChild ;
            }
            else if(nodo.rightChild != null)
            {
                nodo = nodo.rightChild ;
            }
        }
        return true ;
    }


    public boolean is_left_odd_rigth_even()
    {
        return is_left_odd_rigth_even(root) ;
    }
    public boolean is_left_odd_rigth_even(BSTNode node)
    {
        if(node == null)
        {
            return true ;
        }

        if(node.leftChild != null )
        {
            if(! (node.leftChild.key % 2 == 1))
            {
                return false ;
            }
        }

        if(node.rightChild != null)
        {
            if (!(node.rightChild.key % 2 == 0))
            {
                return false ;
            }

        }
        return (is_left_odd_rigth_even(node.leftChild) && is_left_odd_rigth_even(node.rightChild)) ;
    }



    public boolean is_same_shape(MyBST arbol)
    {
        return is_same_shape(root, arbol.root) ;
    }
    private boolean is_same_shape(BSTNode n1, BSTNode n2)
    {
        if(n1 == null && n2 == null)
        {
            return true ;
        }
        else if(n1 == null || n2 == null)
        {
            return false ;
        }
        return (is_same_shape(n1.leftChild, n2.leftChild) && is_same_shape(n1.rightChild, n2.rightChild) );
    }



}

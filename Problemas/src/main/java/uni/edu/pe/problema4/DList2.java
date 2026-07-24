package uni.edu.pe.problema4;

public class DList2 extends DList{



    public void remove(int element)
    {
        DNode node = header.next ;
        while (node != trailer)
        {
            //aqui eliminamos
            if(node.element == element)
            {
                node.prev.next = node.next ;
                node.next.prev = node.prev ;
                size-- ;
                return;
            }
            //si no eliminamos seguimos
            node = node.next ;
        }
        System.out.println("no se encotro el elemento");
    }

    public void removeAll(int element)
    {
        DNode node = header.next ;
        int sizeInicial = size ;
        while (node!= trailer)
        {
            if(node.element == element)
            {
                node.prev.next = node.next ;
                node.next.prev = node.prev ;
                size-- ;
            }
            node = node.next ;
        }
        if(sizeInicial == size)
        {
            System.out.println("No se encontro elemento");
        }
    }

    public int getAtRev(int index)
    {
        if(index >= size || index < 0)
        {
            System.out.println("Indice fuera de limite");
            return -1;
        }
        DNode node = header ;
        for(int i = 0 ; i < size-index ; i++)
        {
            node = node.next ;
        }
        return node.element ;
    }


    public int getAtEff(int index)
    {
        if(index >= size || index < 0)
        {
            System.out.println("Indice fuera de limite");
            return -1;
        }
        //caso 1, el index esta mas cerca de el final
        if(index < size / 2)
        {
            DNode node = trailer.prev ;
            for(int i = 0 ; i < index ; i++)
            {
                node = node.prev ;
            }
            return node.element ;
        }
        //caso 2, el index
        else
        {
            DNode node = header ;
            for(int i = 0 ; i < size-index ; i++)
            {
                node = node.next ;
            }
            return node.element ;
        }
    }

    public void insertAtEff(int index, int element)
    {
        if(index > size || index < 0)
        {
            System.out.println("Indice fuera de limite");
            return ;
        }

        //caso 1, el index esta mas cerca de el final
        if(index < size / 2)
        {
            DNode node = trailer.prev ;
            for(int i = 0 ; i < index ; i++)
            {
                node = node.prev ;
            }

            DNode nuevo = new DNode(element) ;
            node.next.prev = nuevo ;
            nuevo.next = node.next ;
            node.next = nuevo ;
            nuevo.prev = node ;
            size++ ;
        }

        //caso 2, el index
        else
        {
            DNode node = header ;
            for(int i = 0 ; i < size-index ; i++)
            {
                node = node.next ;
            }
            node = node ;
            DNode nuevo = new DNode(element) ;
            node.next.prev = nuevo ;
            nuevo.next = node.next ;
            node.next = nuevo ;
            nuevo.prev = node ;
            size++ ;
        }
    }



}

package uni.edu.pe.programa4 ;
public class xd {

    public static void main(String[] arg)
    {
        nodo p = new nodo(111, 12.2f, null) ;
        nodo q = new nodo(222, 14.2f, null) ;
        nodo r = new nodo() ;
        r.Cod = 333 ;
        r.pf = 10.2f ;
        r.next = null ;

        p.next = q ;
        q.next = r ;

        //Ahora vamos a mostrar todo

        System.out.println("Nodo p : " +p.Cod+ " pf : " +p.pf);
        p = p.next ;
        System.out.println("Nodo p : " +p.Cod+ " pf : " +p.pf);
        p = p.next ;
        System.out.println("Nodo p : " +p.Cod+ " pf : " +p.pf);


    }
}

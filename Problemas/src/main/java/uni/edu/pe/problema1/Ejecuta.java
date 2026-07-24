package uni.edu.pe.problema1;

public class Ejecuta  {
    public static void main(String[] args) {
        IList<String> lista = new SList<>() ;
        lista.addFirst("Semen");
        /*
        lista.addFirst("the boys");
        lista.addFirst("the boys");
        lista.addFirst("Pornito");
        lista.mostrarlista();
        System.out.println("------------");
        System.out.println(lista.count("the boys"));
        */
        //Quiero probar el metodo de lista ordenada asi que creare una lista de numeros
        IList<Integer> lista2 = new SList<>();
        lista2.addFirst(6);
        lista2.addFirst(4);
        lista2.addFirst(2);
        lista2.addFirst(2);
        lista2.addFirst(8);
        lista2.mostrarlista();
        System.out.println(lista2.isSorted());
        lista2.removeDuplicate();
        lista2.swapPairwise();
        lista2.mostrarlista();
        System.out.println("-----------");
        lista2.moveLast();
        lista2.mostrarlista();
    }


}

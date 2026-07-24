package uni.edu.pe.programa5;

public class Ejecuta {
    public static void main(String[] args) {
        IList lista = new SList();
        lista.addFirst("pinga");
        lista.addFirst("pinga");
        lista.addFirst("hola");
        lista.addFirst("adios");
        lista.insertAt(2, "pinga");
        lista.insertAt(3,"pinga");
        lista.mostrarLista();
        System.out.println("-------------");
        lista.removeAll("pinga");
        lista.mostrarLista();
    }
}

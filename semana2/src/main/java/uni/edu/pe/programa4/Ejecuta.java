package uni.edu.pe.programa4;

import java.util.Scanner ;

public class Ejecuta {
    public static void main(String[] args) {
        SStack<Integer> pila = new SStack();
        System.out.println("La pila esta vacia?: "+pila.isEmpty());
        System.out.println("La pila tiene el tamanio: "+pila.size);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        /*
        pila.push("Nestor");
        pila.push(true);
        pila.push(1.2);
        */
        System.out.println("La pila esta vacia?: "+pila.isEmpty());
        System.out.println("La pila tiene el tamanio: "+pila.size);
        pila.listaElementos();
        System.out.println("\n");
        pila.pop();
        pila.listaElementos();

        SStack<String> pila2 = new SStack<>();
        pila2.push("Nestor");
        pila2.push("Juan");
        pila2.push("Pedro");
        System.out.println("La pila esta vacia?: "+pila2.isEmpty());
        System.out.println("La pila tiene el tamanio: "+pila2.size);
        pila2.listaElementos();

        System.out.println("<==== Pila de estudiantes====>");
        SStack<Estudiante> pila3 = new SStack<>();
        pila3.push(new Estudiante(1, 15.5f, "Nestor"));
        pila3.push(new Estudiante(2, 12.5f, "Juan"));
        pila3.push(new Estudiante(3, 18.5f, "Pedro"));
        pila3.listaElementos();

    }
}


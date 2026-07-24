package uni.edu.pe.programa5 ;
import java.util.Scanner ;

//Hacemos mi clase nodo y las funciones que puede correr esta clase nodo
class nodo  {
    int cod ;
    float pf ;
    nodo next ;

    //Ahora hacemos las funciones que puede hacer esta clase nodo

    public nodo(int cod, float pf)
    {
        this.cod = cod ;
        this.pf = pf ;
        this.next = null ;
    }

    public nodo() {} ;
}

public class PilaEstudiantes
{
    nodo tope ;
    public PilaEstudiantes()
    {
        tope = null ;
    }
    public void crearpila()
    {
        System.out.println("Creacion de la pila");
        tope = null ;
        Scanner sc = new Scanner(System.in) ;
        int n ;
        System.out.println("Ingrese la cantidad de alumnos a ingresar : ");
        n = sc.nextInt() ;
        for(int i = 0 ; i <n ; i++)
        {
            System.out.println("Estudiante " +(i+1)+ " : ");
            int cod ;
            float pf ;
            System.out.println("Ingrese el codigo del estudiante : ");
            cod = sc.nextInt();
            sc.nextLine() ;
            System.out.println("Ingrese el promedio final del estudiante : ");
            pf = sc.nextFloat() ;
            sc.nextLine() ;
            if(this.tope == null)
            {
                this.tope = new nodo(cod, pf) ;
            }
            else
            {
                nodo q = new nodo(cod, pf) ;
                q.next = this.tope;
                this.tope = q ;
            }
         }
    }

    public void recorre()
    {
        nodo p = this.tope ;
        while(p!=null)
        {
            System.out.println("Estudiante : " +p.cod+ " promedio final :" +p.pf);
            p = p.next ;
        }
    }

    public static void main(String[] args) {
        PilaEstudiantes p = new PilaEstudiantes();
        p.crearpila();
        p.recorre();
    }
}
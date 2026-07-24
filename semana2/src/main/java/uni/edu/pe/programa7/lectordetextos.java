package uni.edu.pe.programa7;

import java.io.*;
import java.util.Scanner ;

public class lectordetextos {
    public static void main(String[] args) throws IOException {
        //escribirenFile();
        //leerConScanner() ;
        //leerConFileReader();
    }

    private static void leerConFileReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String linea ;
        while ((linea = br.readLine()) != null)
        {
            System.out.println(linea);
        }
        br.close();
    }

    private static void escribirenFile() throws IOException {
        FileWriter fw = new FileWriter("input.txt", true) ;
        fw.write("\ncalla cachera");
        fw.close();
    }

    public static void leerConScanner() throws FileNotFoundException{
        Scanner sc = new Scanner(new File("input.txt")) ;
        while (sc.hasNext())
        {
            System.out.println(sc.nextLine());
        }
    }
}

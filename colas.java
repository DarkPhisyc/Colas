import java.util.Scanner;

public class colas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("SISTEMAS DE COLAS");
            System.out.println("\tMenu:");
            System.out.println("1. Modelo M/M/1");
            System.out.println("2. Modelo M/M/c");
            System.out.println("3. Modelo M/M/1/k");
            System.out.println("4. Salir");
            System.out.println("Opcion: ");
            opcion = sc.nextInt();
        } while (opcion != 4);
        sc.close();
    }
}
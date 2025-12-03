import java.util.Scanner;

public class colas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n\nSISTEMAS DE COLAS");
            System.out.println("\tMenu:");
            System.out.println("1. Modelo M/M/1");
            System.out.println("2. Modelo M/M/c");
            System.out.println("3. Modelo M/M/1/k");
            System.out.println("4. Salir");
            System.out.print("\nOpcion: ");
            opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("\nModelo M/M/1");
                    System.out.println("Teclea el promedio de llegadas: ");
                    double lambda = sc.nextDouble();
                    System.out.println("Teclea el promedio de servicio: ");
                    double miu = sc.nextDouble();
                    if(miu > lambda) {
                        double p = lambda / miu;
                        System.out.printf("\nUtilizacion del sistema: %.2f\n", p);
                        double lq = (Math.pow(lambda, 2)) / (miu * (miu - lambda));
                        System.out.printf("Numero promedio de clientes en la cola: %.2f\n", lq);
                        double wq = lq / lambda;
                        System.out.printf("Tiempo promedio de espera en la cola: %.2f\n", wq);
                        double l = lambda / (miu - lambda);
                        System.out.printf("Numero promedio de clientes en el sistema: %.2f\n", l);
                        double w = 1.0 / (miu - lambda);
                        System.out.printf("Tiempo total en el sistema: %.2f\n", w);
                        System.out.println("\nEl sistema es estable.");
                    } else {
                        System.out.println("El sistema no es estable.");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA");
                    break;
            }
        } while (opcion != 4);
        sc.close();
    }
}
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
                    System.out.println("\nModelo M/M/c");
                    System.out.println("Teclea el promedio de llegadas: ");
                    lambda = sc.nextDouble();
                    System.out.println("Teclea el promedio de servicio: ");
                    miu = sc.nextDouble();
                    System.out.println("Teclea el numero de servidores: ");
                    int c = sc.nextInt();
                    double p = lambda / (c * miu);
                    if(p < 1) {
                        double a = lambda / miu;
                        System.out.println("\nUtilizacion del sistema: " + p);
                        double sum = 0.0;
                        for(int n = 0; n < c; n++) {
                            sum += (Math.pow(a, n)) / factorial(n);
                        }
                        double p0 = 1.0 / (sum + (Math.pow(a, c) / (factorial(c) * (1 - p))));
                        System.out.printf("Probabilidad de que no haya clientes en el sistema: %.2f\n", p0);
                        double lq = (p0 * Math.pow(a, c) * p) / (factorial(c) * Math.pow((1 - p), 2));
                        System.out.printf("Numero promedio de clientes en la cola: %.2f\n", lq);
                        double wq = lq / lambda;
                        System.out.printf("Tiempo promedio de espera en la cola: %.2f\n", wq);
                        double l = lq + a;
                        System.out.printf("Numero promedio de clientes en el sistema: %.2f\n", l);
                        double w = wq + (1.0 / miu);
                        System.out.printf("Tiempo total en el sistema: %.2f\n", w);
                        System.out.println("\nEl sistema es estable.");
                    } else {
                        System.out.println("El sistema no es estable.");
                    }
                    break;
                case 3:
                    System.out.println("\nModelo M/M/1/k");
                    System.out.println("Teclea el promedio de llegadas: ");
                    lambda = sc.nextDouble();
                    System.out.println("Teclea el promedio de servicio: ");
                    miu = sc.nextDouble();
                    System.out.println("Teclea la capacidad del sistema: ");
                    int k = sc.nextInt();
                    p = lambda / miu;
                    System.out.println("\nUtilizacion del sistema: " + p);
                    double p0 = (1 - p) / (1 - Math.pow(p, k + 1));
                    System.out.printf("Probabilidad de que el sistema este vacio: %.2f\n", p0);
                    double pk = Math.pow(p, k) * p0;
                    System.out.printf("Probabilidad de que el sistema este lleno: %.2f\n", pk);
                    double l = (p * (1 - (k + 1) * Math.pow(p, k) + k * Math.pow(p, k + 1))) / ((1 - p) * (1 - Math.pow(p, k + 1)));
                    System.out.printf("Numero promedio de clientes en el sistema: %.2f\n", l);
                    double w = l / (lambda * (1 - pk));
                    System.out.printf("Tiempo total en el sistema: %.2f\n", w);
                    double wq = w - (1.0 / miu);
                    System.out.printf("Tiempo promedio de espera en la cola: %.2f\n", wq);
                    double lq = lambda * (1 - pk) * wq;
                    System.out.printf("Numero promedio de clientes en la cola: %.2f\n", lq);
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
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
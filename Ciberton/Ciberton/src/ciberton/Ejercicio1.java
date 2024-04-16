package ciberton;


import java.util.Scanner;

/**
 *
 * @author Hector Bustillo
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo y luego presione enter: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Ingrese un número entero positivo y luego presione enter:");
        } else {
            long resultado = calcular(n);
            System.out.println("La multiplicación de 1 a " + n + " es: " + resultado);
        }

        scanner.close();
    }

    public static long calcular(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n * calcular(n - 1);
        }
    }
}

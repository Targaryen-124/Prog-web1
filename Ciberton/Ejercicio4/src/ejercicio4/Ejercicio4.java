/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Hector Bustillo
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        
        int[] a = {100, 200, 300, 400, 500, 600, 700, 800, 1200, 3000};
        int[] b = {500, 430, 450, 360, 2000, 50, 100, 250, 100, 500};

        
        System.out.println("Arreglo A:");
        mostrarArreglo(a);

        System.out.println("\nArreglo B:");
        mostrarArreglo(b);

    
        int[] suma = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            suma[i] = a[i] + b[i];
        }

        
        System.out.println("\nSuma de los elementos en las mismas posiciones:");
        mostrarArreglo(suma);

        int maximo = encontrarMaximo(suma);
        System.out.println("\nEl valor máximo en la suma es: " + maximo);

        int minimo = encontrarMinimo(suma);
        System.out.println("\nEl valor mínimo en la suma es: " + minimo);

        int valorBuscado = 650;
        double interpolacion = encontrarMedianteInterpolacion(suma, valorBuscado);
        System.out.println("\nEl valor interpolado para " + valorBuscado + " es: " + interpolacion);

        int sumaTotal = calcularSumaTotal(suma);
        System.out.println("\nSuma total de los elementos: " + sumaTotal);

        int elementoBuscado = 600;
        int indice = busquedaBinaria(suma, elementoBuscado);

        
        if (indice != -1) {
            System.out.println("\nEl elemento " + elementoBuscado + " se encuentra en la posición " + indice);
        } else {
            System.out.println("\nEl elemento " + elementoBuscado + " no se encuentra en el arreglo.");
        }

    }

    
    private static void mostrarArreglo(int[] arreglo) {
        for (int elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    private static int encontrarMinimo(int[] arreglo) {
        int minimo = arreglo[0];
        for (int elemento : arreglo) {
            if (elemento < minimo) {
                minimo = elemento;
            }
        }
        return minimo;
    }

    private static int encontrarMaximo(int[] arreglo) {
        int maximo = arreglo[0];
        for (int elemento : arreglo) {
            if (elemento > maximo) {
                maximo = elemento;
            }
        }
        return maximo;
    }

    private static double encontrarMedianteInterpolacion(int[] arreglo, int valorBuscado) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] <= valorBuscado && arreglo[i + 1] >= valorBuscado) {
                double fraccion = (double) (valorBuscado - arreglo[i]) / (arreglo[i + 1] - arreglo[i]);
                double valorInterpolado = i + fraccion;
                return valorInterpolado;
            }
        }
        return -1; 
    }

    private static int calcularSumaTotal(int[] arreglo) {
        int sumaTotal = 0;
        for (int elemento : arreglo) {
            sumaTotal += elemento;
        }
        return sumaTotal;
    }

 private static int busquedaBinaria(int[] arreglo, int elementoBuscado) {
    int izquierda = 0;
    int derecha = arreglo.length - 1;

    while (izquierda <= derecha) {
        int medio = izquierda + (derecha - izquierda) / 2;

        if (arreglo[medio] == elementoBuscado) {
            return medio; 
        } else if (arreglo[medio] < elementoBuscado) {
            izquierda = medio + 1;
        } else {
            derecha = medio - 1;
        }
    }

    return -1; 
}
    
}

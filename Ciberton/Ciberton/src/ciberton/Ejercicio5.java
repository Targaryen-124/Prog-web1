package ciberton;

import java.sql.*;
import com.sun.jdi.connect.spi.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio5 {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cajero";
    private static final String USER = "";
    private static final String PASSWORD = "";

    private Map<String, String> usuarios;
    private Map<String, Double> saldo;
    private String usuarioActual;

    public Ejercicio5() {
        
        
        
        
        usuarios = new HashMap<>();
        saldo = new HashMap<>();
        // Agrega algunos usuarios de ejemplo
        usuarios.put("hector", "12345");
        usuarios.put("usuario2", "contrasena2");
        saldo.put("hector", 1000.0);
        saldo.put("usuario2", 1500.0);
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso.");
            usuarioActual = usuario;  // Almacena el nombre de usuario actual
            return true;
        } else {
            System.out.println("Credenciales incorrectas. Inténtelo de nuevo.");
            return false;
        }
    }

    public void mostrarMenu() {
        System.out.println("\nOperaciones disponibles:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Cambiar contraseña");
        System.out.println("5. Salir");
    }

    public void consultarSaldo(String usuario) {
        System.out.println("Saldo actual: $" + saldo.get(usuario));
    }

    public void retirarDinero(String usuario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el monto a retirar: ");
        double monto = scanner.nextDouble();

        if (monto <= saldo.get(usuario)) {
            saldo.put(usuario, saldo.get(usuario) - monto);
            System.out.println("Retiro exitoso. Saldo restante: $" + saldo.get(usuario));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositarDinero(String usuario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();

        saldo.put(usuario, saldo.get(usuario) + monto);
        System.out.println("Depósito exitoso. Saldo actual: $" + saldo.get(usuario));
    }

    public void cambiarContrasena(String usuario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nueva contraseña: ");
        String nuevaContrasena = scanner.nextLine();

        usuarios.put(usuario, nuevaContrasena);
        System.out.println("Contraseña cambiada con éxito.");
    }

    public void ejecutarCajero() {
        boolean inicioSesionExitoso = false;
        Scanner scanner = new Scanner(System.in);

        while (!inicioSesionExitoso) {
            inicioSesionExitoso = login();
        }

        String usuarioActual = this.usuarioActual;  // Almacena el nombre de usuario actual

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción (1-5): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(usuarioActual);
                    break;
                case 2:
                    retirarDinero(usuarioActual);
                    break;
                case 3:
                    depositarDinero(usuarioActual);
                    break;
                case 4:
                    cambiarContrasena(usuarioActual);
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el cajero automático. Hasta luego.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio5 cajero = new Ejercicio5();
        cajero.ejecutarCajero();
    }
    

     
}

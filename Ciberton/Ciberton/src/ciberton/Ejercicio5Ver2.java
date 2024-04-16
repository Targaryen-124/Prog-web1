package ciberton;

import java.sql.Connection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

public class Ejercicio5Ver2 {

    private Map<String, Double> saldo;
    private String usuarioActual;

    public Ejercicio5Ver2() {
        saldo = new HashMap<>();
        saldo.put("hector", 1000.0);
        saldo.put("usuario2", 1500.0);
        saldo.put("Yohana", 1200.0);
    }

        Connection conectar;
        String usuario = "root";
        String contrasena = "root";
        String cadena = "jdbc:mysql://localhost:3306/cajero";

        public Connection conectar() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ejercicio5Ver2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            } catch (SQLException ex) {
                Logger.getLogger(Ejercicio5Ver2.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conectar;
        }

    public boolean login(){
        try {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Ingrese su nombre de usuario: ");
            String usuario1 = scanner.nextLine();
            
            System.out.print("Ingrese su contraseña: ");
            String contrasena1 = scanner.nextLine();
            
           ResultSet rs = null;
           PreparedStatement ps = null;
            
            ps = conectar().prepareStatement ("SELECT * FROM usuarios where usuarios.usuario = (?) and usuarios.contrasena = (?)");
            
           ps.setString(1, usuario1);
           ps.setString(2, contrasena1);
            
           rs = ps.executeQuery();
           
            if (rs.next()) {
                System.out.println("Inicio de sesión exitoso.");
                usuarioActual = usuario1;  // Almacena el nombre de usuario actual
                return true;
            } else {
                System.out.println("Credenciales incorrectas. Inténtelo de nuevo.");
                usuarioActual = "";  // Almacena el nombre de usuario actual
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio5Ver2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void mostrarMenu() {
        System.out.println("\nOperaciones disponibles:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
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
    public void ejecutarCajero(){
        boolean inicioSesionExitoso = false;
        Scanner scanner = new Scanner(System.in);

        while (!inicioSesionExitoso) {
            inicioSesionExitoso = login();
        }

        String usuarioAct;  // Almacena el nombre de usuario actual
        usuarioAct = this.usuarioActual;

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción (1-5): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(usuarioAct);
                    break;
                case 2:
                    retirarDinero(usuarioAct);
                    break;
                case 3:
                    depositarDinero(usuarioAct);
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el cajero automático. Hasta luego.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    public static void main(String[] args){
        Ejercicio5Ver2 cajero = new Ejercicio5Ver2();
        cajero.ejecutarCajero();
    }

}


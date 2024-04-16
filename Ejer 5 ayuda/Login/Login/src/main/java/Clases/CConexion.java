
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class CConexion {
    
    Connection conectar;
    
    String usuario="root";
    String contrasena ="Viancy16";
   /* String bd = "login";
    String ip= "localhost";
    String puerto="3306";*/    
    
    String cadena = "jdbc:mysql://localhost:3306/login?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
   
    public Connection conectar(){
    
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conectar = DriverManager.getConnection(cadena,usuario,contrasena);
       // JOptionPane.showMessageDialog(null,"Conexion exitosa");
        }
    catch(Exception e){
    
        JOptionPane.showMessageDialog(null,"Error de conexion" + e.toString());    
    }
    return conectar;
    }
}
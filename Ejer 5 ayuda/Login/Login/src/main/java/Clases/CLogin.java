
package Clases;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class CLogin {
    
    public void validarUsuario(JTextField usuario,JPasswordField contrasena){
    
        try {
           ResultSet rs = null;
           PreparedStatement ps = null;
           Clases.CConexion Obconexion = new Clases.CConexion ();
           
           String consulta = "SELECT * FROM usuarios where usuarios.ingresousuario = (?) and usuarios.ingresocontrasena = (?)";
           ps=Obconexion.conectar().prepareStatement(consulta);
           
           String contra = String.valueOf(contrasena.getPassword());
           ps.setString(1, usuario.getText());
           ps.setString(2, contra);
           
           rs = ps.executeQuery();
          
           if (rs.next()){
           JOptionPane.showMessageDialog(null, "El usuario es correcto");
           }
           else{
             JOptionPane.showMessageDialog(null, "El usuario es INCORRECTO");
           }
        }
 
        catch(Exception e) {
         JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
      
    }
    
}

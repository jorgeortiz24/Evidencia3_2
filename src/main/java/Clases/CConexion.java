package Clases;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class CConexion {
    Connection conectar;
    
    String usuario="root";
    String contraseña="2426";
    String bd="Evidencia3_2";
    String ip="localhost";
    String puerto="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contraseña);
            JOptionPane.showMessageDialog(null,"SE CONECTO CORRECTAMENTE A LA BASE DE DATOS");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"PROBLEMAS EN LA CONEXION"+ e.toString());
        }
        return conectar;
    }
}

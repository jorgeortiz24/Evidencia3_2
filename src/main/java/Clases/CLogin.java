package Clases;

import com.jorge.evidencia3_2.FormMenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jorge
 */
public class CLogin {
    
    public void validaUsuario(JTextField usuario,JPasswordField contraseña){
        try {
            
            ResultSet rs=null;
            PreparedStatement ps= null;
            
            Clases.CConexion objetoConexion = new Clases.CConexion();
            
            String consulta="select * from usuario where usuario.ingresoUsuario =(?)and Usuario.ingresoContraseña= (?);";
            ps=objetoConexion.estableceConexion() .prepareStatement(consulta);
            
            String contra = String.valueOf(contraseña.getPassword());
            
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                JOptionPane.showMessageDialog(null, "EL USUARIO ES INCORRECTO, VUELVE A INTENTARLO");
                FormMenuPrincipal objetoMenu = new FormMenuPrincipal();
                objetoMenu.setVisible(true); 
            }
            else
            {
            
            JOptionPane.showMessageDialog(null, "EL USUARIO ES CORRECTO");
            }
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "ERROR:" +e.toString()); 
        } 
        
    } 
}

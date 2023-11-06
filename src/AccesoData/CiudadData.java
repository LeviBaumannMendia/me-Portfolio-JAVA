
package AccesoData;

import Entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class CiudadData {
    
     private Connection con = null;
     
     public CiudadData() {
        con = Conexion.getConexion();
    }
    
     
     
     
     public void guardarCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO ciudad (nombre, pais, provincia) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ciudad.getNombre());
            ps.setString(2, ciudad.getPais());
            ps.setString(3, ciudad.getProvincia());

            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
             ciudad.setIdCiudad(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ciudad agregada!");
                ps.close();
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad " + ex.getMessage());
        }

    }
     
     
     
     
     
     
     
     public Ciudad buscarCiudad(int idCiudad){
        Ciudad ciudad = null;
        String sql = "SELECT idCiudad, nombre, pais, provincia FROM ciudad WHERE idCiudad = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudad);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                ciudad = new Ciudad();          
                ciudad.setIdCiudad(rs.getInt("idCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setProvincia(rs.getString("provincia"));
            }
             rs.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudad");
        }
        return ciudad;

    }
     
     
     
     public boolean existeCiudad(int idCiudad) {
    String sql = "SELECT COUNT(*) FROM ciudad WHERE idCiudad = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCiudad);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count es mayor que 0, el DNI ya existe en la base de datos
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar el DNI en la base de datos: " + ex.getMessage());
    }
    return false; // Si hubo un error o no se encontró el DNI, retornamos false
}
     
     
     
     
     
     public boolean existeNombreCiudad(String nombre, String provincia) {
    String sql = "SELECT COUNT(*) FROM ciudad WHERE nombre LIKE ? AND provincia LIKE ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, provincia);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count es mayor que 0, la ciudad ya existe en la base de datos
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar la ciudad en la base de datos: " + ex.getMessage());
    }
    return false; // Si no se encontró la ciudad, retornamos false
}
     
     
     
     public ArrayList<Ciudad>  obtenerCiudades(){
        
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();
        String sql = "SELECT * FROM ciudad ORDER BY provincia";
         
       
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(rs.getInt("idCiudad"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setPais(rs.getString("pais"));
                ciudad.setProvincia(rs.getString("provincia"));
                
                listaCiudades.add(ciudad);

            }
            ps.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete");
      }
        
        return listaCiudades;
    }
     
     
     
     public void editarCiudad(int idCiudad, String nombre, String provincia){
        String sql= "UPDATE ciudad SET nombre=?, provincia=? WHERE idCiudad = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2, provincia);
            ps.setInt(3, idCiudad);
           
             int exito = ps.executeUpdate();
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            } else{
                //JOptionPane.showMessageDialog(null, "Error en la modificación de la ciudad");
            }
            ps.close();
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos de la ciudad");
           
        }
        }
     
     
     
}

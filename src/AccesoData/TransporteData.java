
package AccesoData;


import Entidades.Paquete;
import Entidades.Transporte;
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

public class TransporteData {
    
    private Connection con = null;
    
    
    
    public TransporteData() {
        con = Conexion.getConexion();
    }
    
    
    
     public Transporte buscarTransporte(int idTransporte){
        Transporte transporte = null;
        String sql = "SELECT idTransporte, tipoTransporte, servicio, empresa, precioPasaje FROM transporte WHERE idTransporte = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTransporte);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                transporte = new Transporte();          
                transporte.setIdTransporte(rs.getInt("idTransporte"));
                transporte.setTipoTransporte(rs.getString("tipoTransporte"));
                transporte.setServicio(rs.getString("servicio"));
                transporte.setEmpresa(rs.getString("empresa"));
                transporte.setPrecioPasaje(rs.getDouble("precioPasaje"));
            }
             rs.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla transporte");
        }
        return transporte;

    }
      public ArrayList<Transporte>  llenarComboTransporte(){
        
        
        ArrayList<Transporte> listaTransportes = new ArrayList<>();
        String sql = "SELECT idTransporte, tipoTransporte, servicio, empresa, precioPasaje FROM transporte ORDER BY tipoTransporte";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             
            
            while(rs.next()){
                Transporte transporte = new Transporte();
               
                transporte.setIdTransporte(rs.getInt("idTransporte"));
                transporte.setTipoTransporte(rs.getString("tipoTransporte"));
                transporte.setServicio(rs.getString("servicio"));
                transporte.setEmpresa(rs.getString("empresa"));
                transporte.setPrecioPasaje(rs.getDouble("precioPasaje"));
                
                listaTransportes.add(transporte);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla transporte" + ex.getMessage());
      }
        
        return listaTransportes;
    }
      
      
      public boolean existeTransporte(String tipoTransporte, String servicio, String empresa) {
    String sql = "SELECT COUNT(*) FROM transporte WHERE tipoTransporte LIKE ? AND servicio LIKE ? AND empresa LIKE?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipoTransporte);
        ps.setString(2, servicio);
        ps.setString(3, empresa);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count es mayor que 0, hay mas transportes
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar los transportes en la base de datos: " + ex.getMessage());
    }
    return false; // Si no se encontró el transporte, retornamos false
}
     
    public void guardarTransporte(Transporte transporte) {
        String sql = "INSERT INTO transporte (tipoTransporte, servicio, empresa, precioPasaje) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, transporte.getTipoTransporte());
            ps.setString(2, transporte.getServicio());
            ps.setString(3, transporte.getEmpresa());
            ps.setDouble(4, transporte.getPrecioPasaje());

            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
             transporte.setIdTransporte(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Transporte agregado con éxito");
                ps.close();
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Transporte " + ex.getMessage());
        }

    }
     public void editarTransporte(Transporte transporte) {
         int filasactualizadas;
        String sql = "UPDATE transporte SET tipoTransporte=?, servicio=?, empresa=?, precioPasaje=? WHERE idTransporte=?";
         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, transporte.getTipoTransporte());
            ps.setString(2, transporte.getServicio());
            ps.setString(3, transporte.getEmpresa());
            ps.setDouble(4, transporte.getPrecioPasaje());
            ps.setInt(5, transporte.getIdTransporte());
            filasactualizadas = ps.executeUpdate();
            
            if (filasactualizadas == 1) {
                JOptionPane.showMessageDialog(null, "Los cambios editados fueron realizados con exito");
                ps.close();
            } else {
                System.out.println("No se actualizó ningun dato");
}
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla transporte " + ex.getMessage());
        }

    }
     
      public void elimninarTransporte (int idTransporte){
        String sql = "DELETE FROM transporte WHERE idTransporte = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTransporte );
            int exito = ps.executeUpdate();
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Transporte eliminado");
            } 
            else 
            {
                 JOptionPane.showMessageDialog(null, "Error al intentar eliminar transporte");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar transporte");
        }
    }
     
      
      
      
      
      public boolean existePaqueteConTransporte(int idTransporte) {
    String sql = "SELECT COUNT(*) FROM paquete WHERE idTransporte = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idTransporte);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count es mayor que 0, la id ya existe en la base de datos
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar la id en la base de datos: " + ex.getMessage());
    }
    return false; // Si hubo un error o no se encontró la id, retornamos false
}
      
      
     
     
     
    
}

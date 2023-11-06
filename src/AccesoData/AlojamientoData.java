
package AccesoData;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AlojamientoData {
    
    private Connection con = null;
    private CiudadData ciuData = new CiudadData();
    
    public AlojamientoData() {
        con = Conexion.getConexion();
    }
    
    
    public Alojamiento buscarAlojamiento(int idAlojamiento){
        Alojamiento alojamiento = null;
        String sql = "SELECT idAlojamiento, idCiudad, nombreHotel, servicio, estrellas, precio, estado FROM alojamiento WHERE idAlojamiento = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlojamiento);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alojamiento = new Alojamiento();          
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                Ciudad ciu = ciuData.buscarCiudad(rs.getInt("idCiudad"));
                alojamiento.setNombreHotel(rs.getString("nombreHotel"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setEstrellas(rs.getInt("estrellas"));
                alojamiento.setPrecio(rs.getDouble("precio"));
                alojamiento.setEstado(rs.getBoolean("estado"));
            }
             rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return alojamiento;

    }
    
    
    
    
    
    public ArrayList<Alojamiento> llenarComboAlojamientos(int idCiudad){
        
        
        ArrayList<Alojamiento> listaAlojamientosC = new ArrayList<>();
        String sql = "SELECT idAlojamiento, idCiudad, nombreHotel, servicio, estrellas, precio, estado FROM alojamiento WHERE estado = 1 AND idCiudad = ?";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCiudad);
            ResultSet rs = ps.executeQuery();
            Alojamiento alojamiento;
             
            
            while(rs.next()){
                alojamiento = new Alojamiento();
               
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                
                Ciudad ciu = ciuData.buscarCiudad(rs.getInt("idCiudad"));
                alojamiento.setCiudadDestino(ciu);
                
                alojamiento.setNombreHotel(rs.getString("nombreHotel"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setEstrellas(rs.getInt("estrellas"));
                alojamiento.setPrecio(rs.getDouble("precio"));
                alojamiento.setEstado(rs.getBoolean("estado"));
                
                
                listaAlojamientosC.add(alojamiento);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento" + ex.getMessage());
      }
        
        return listaAlojamientosC;
    }
    
    
    
    public ArrayList<Alojamiento> obtenerAlojamientos(int idAlojamiento){
        
        
        ArrayList<Alojamiento> listaAlojamientos = new ArrayList<>();
        String sql = "SELECT idAlojamiento, idCiudad, nombreHotel, servicio, estrellas, precio, estado FROM alojamiento WHERE estado = 1 AND idAlojamiento = ?";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlojamiento);
            ResultSet rs = ps.executeQuery();
            Alojamiento alojamiento;
             
            
            if(rs.next()){
                alojamiento = new Alojamiento();
               
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                
                Ciudad ciu = ciuData.buscarCiudad(rs.getInt("idCiudad"));
                alojamiento.setCiudadDestino(ciu);
                
                alojamiento.setNombreHotel(rs.getString("nombreHotel"));
                alojamiento.setServicio(rs.getString("servicio"));
                alojamiento.setEstrellas(rs.getInt("estrellas"));
                alojamiento.setPrecio(rs.getDouble("precio"));
                alojamiento.setEstado(rs.getBoolean("estado"));
                
                
                listaAlojamientos.add(alojamiento);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alojamiento" + ex.getMessage());
      }
        
        return listaAlojamientos;
    }
    
    public void guardarAlojamiento(Alojamiento alojamiento) {
        String sql = "INSERT INTO alojamiento (nombreHotel, idciudad, servicio, estrellas, precio, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,alojamiento.getNombreHotel());
            ps.setInt(2, alojamiento.getCiudadDestino().getIdCiudad());
            ps.setString(3, alojamiento.getServicio());
            ps.setInt(4, alojamiento.getEstrellas());
            ps.setDouble(5, alojamiento.getPrecio());
            ps.setBoolean(6, true);

            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
            alojamiento.setIdAlojamiento(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alojamiento agregado con éxito");
                ps.close();
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla Alojamiento " + ex.getMessage());
           
        }

    }
    
    
    
    public void modificarAlojamiento(Alojamiento alojamiento){
        String sql= "UPDATE alojamiento SET nombreHotel=?, servicio=?, estrellas=?, precio=? WHERE idAlojamiento=?";
;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,alojamiento.getNombreHotel());
            ps.setString(2, alojamiento.getServicio());
            ps.setInt(3, alojamiento.getEstrellas());
            ps.setDouble(4, alojamiento.getPrecio());
            ps.setInt(5, alojamiento.getIdAlojamiento());
             int exito = ps.executeUpdate();
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            } else{
                JOptionPane.showMessageDialog(null, "El alojamiento no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos del alojamiento");
           
        }
        }
     
    
    
    public boolean existeAlojamiento(int idCiudad, String nombreHotel) {
    String sql = "SELECT COUNT(*) FROM alojamiento WHERE idCiudad = ? AND nombreHotel LIKE ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCiudad);
        ps.setString(2, nombreHotel);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count es mayor que 0, el DNI ya existe en la base de datos
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar el alojamiento en la base de datos: " + ex.getMessage());
    }
    return false; // Si hubo un error o no se encontró el DNI, retornamos false
}
    
     
    
}


package AccesoData;


import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class PaqueteData {
    
    private Connection con = null;
    private final CiudadData ciuData = new CiudadData();
    private final AlojamientoData aloData = new AlojamientoData();
    private final TransporteData traData = new TransporteData();
    
    
    public PaqueteData() {
        con = Conexion.getConexion();
        

    }
    
    
    
    
    public ArrayList<Paquete>  obtenerPaquetesEliminados(){        
        
        ArrayList<Paquete> listaPaquetes = new ArrayList<>();
        String sql = "SELECT idPaquete, nombrePaquete, idCiudad, idAlojamiento, idTransporte, cuposTotales, cuposOcupados, precioTotal FROM paquete WHERE estado = 0";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             
            
            while(rs.next()){
                Paquete paquete = new Paquete();
                Ciudad ciudad;
                Alojamiento alojamiento;
                Transporte transporte;
                
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setNombrePaquete(rs.getString("nombrePaquete"));
                ciudad = ciuData.buscarCiudad(rs.getInt("idCiudad"));
                paquete.setCiudad(ciudad);
                alojamiento = aloData.buscarAlojamiento(rs.getInt("idAlojamiento"));
                paquete.setAlojamiento(alojamiento);
                transporte = traData.buscarTransporte(rs.getInt("idTransporte"));
                paquete.setTransporte(transporte);
                paquete.setCuposTotales(rs.getInt("cuposTotales"));
                paquete.setCuposOcupados(rs.getInt("cuposOcupados"));
                paquete.setPrecioTotal(rs.getDouble("precioTotal"));
                listaPaquetes.add(paquete);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete" + ex.getMessage());
      }
        
        return listaPaquetes;
    }
    
    
    
    
    
    
    public ArrayList<Paquete>  llenarComboBoxPaquetes(){
        
        
        ArrayList<Paquete> listaPaquetes = new ArrayList<>();
        String sql = "SELECT idPaquete, nombrePaquete, idCiudad, idAlojamiento, idTransporte, fechaIda, fechaVuelta, cuposTotales, cuposOcupados, precioTotal, "
                + "excursion1, precioexcursion1, excursion2, precioexcursion2,excursion3, precioexcursion3 FROM paquete WHERE estado = 1";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             
            
            while(rs.next()){
                Paquete paquete = new Paquete();
                Ciudad ciudad;
                Alojamiento alojamiento;
                Transporte transporte;
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setNombrePaquete(rs.getString("nombrePaquete"));
                ciudad = ciuData.buscarCiudad(rs.getInt("idCiudad"));
                paquete.setCiudad(ciudad);
                alojamiento = aloData.buscarAlojamiento(rs.getInt("idAlojamiento"));
                paquete.setAlojamiento(alojamiento);
                transporte = traData.buscarTransporte(rs.getInt("idTransporte"));
                paquete.setTransporte(transporte);
                paquete.setFechaIda(rs.getDate("fechaIda").toLocalDate());
                paquete.setFechaVuelta(rs.getDate("fechaVuelta").toLocalDate());
                paquete.setCuposTotales(rs.getInt("cuposTotales"));
                paquete.setCuposOcupados(rs.getInt("cuposOcupados"));
                paquete.setPrecioTotal(rs.getDouble("precioTotal"));
                paquete.setExcursion1(rs.getString("excursion1"));
                paquete.setPrecioexcursion1(rs.getDouble("precioexcursion1"));
                paquete.setExcursion2(rs.getString("excursion2"));
                paquete.setPrecioexcursion2(rs.getDouble("precioexcursion2"));
                paquete.setExcursion3(rs.getString("excursion3"));
                paquete.setPrecioexcursion3(rs.getDouble("precioexcursion3"));
                listaPaquetes.add(paquete);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete" + ex.getMessage());
      }
        
        return listaPaquetes;
    }
    
    
    
    
    public ArrayList<Paquete>  llenarComboBoxPaquetesPorCiudad(int idCiudad){
        
        
        ArrayList<Paquete> listaPaquetesTodos = new ArrayList<>();
        String sql = "SELECT idPaquete, nombrePaquete, idCiudad FROM paquete WHERE idCiudad = ? AND estado = 1";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idCiudad);
            ResultSet rs = ps.executeQuery();
            
             
            
            while(rs.next()){
                Paquete paquete = new Paquete();
                Ciudad ciudad = new Ciudad();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setNombrePaquete(rs.getString("nombrePaquete"));
                ciudad = ciuData.buscarCiudad(rs.getInt("idCiudad"));
                paquete.setCiudad(ciudad);
                listaPaquetesTodos.add(paquete);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paquete" + ex.getMessage());
      }
        
        return listaPaquetesTodos;
    }
    
    
    
    
    
    
    
    
    public Paquete buscarPaquete(int idPaquete){
    Paquete paquete = null;
    String sql = "SELECT * FROM paquete WHERE idPaquete = ? AND estado = 1";
   
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaquete);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            paquete = new Paquete();
            
            paquete.setIdPaquete(rs.getInt("idPaquete"));
            paquete.setNombrePaquete(rs.getString("nombrePaquete"));
            
            // Aquí debes obtener las instancias de Ciudad, Alojamiento y Transporte
            int idCiudad = rs.getInt("idCiudad");
            int idAlojamiento = rs.getInt("idAlojamiento");
            int idTransporte = rs.getInt("idTransporte");
            
            // Usa tus métodos de obtención para obtener los objetos completos
            paquete.setCiudad(ciuData.buscarCiudad(idCiudad));
            paquete.setAlojamiento(aloData.buscarAlojamiento(idAlojamiento));
            paquete.setTransporte(traData.buscarTransporte(idTransporte));
            
            paquete.setFechaIda(rs.getDate("fechaIda").toLocalDate());
            paquete.setFechaVuelta(rs.getDate("fechaVuelta").toLocalDate());
            paquete.setTemporada(rs.getString("temporada"));
            paquete.setCuposTotales(rs.getInt("cuposTotales"));
            paquete.setCuposOcupados(rs.getInt("cuposOcupados"));
            
            
            paquete.setPrecioTotal(rs.getDouble("precioTotal"));
        }
        
        rs.close(); 
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla paquete");
    }
    
    return paquete;
 }
    
    
    public void crearPaquete (Paquete paquete){
          String sql = "INSERT INTO paquete (nombrePaquete, idCiudad, idAlojamiento, idTransporte, fechaIda, fechaVuelta, temporada,"
                  + " cuposTotales, cuposOcupados, precioTotal, excursion1, precioexcursion1, excursion2, precioexcursion2,excursion3, precioexcursion3,estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paquete.getNombrePaquete());
            ps.setInt(2, paquete.getCiudad().getIdCiudad());
            ps.setInt(3, paquete.getAlojamiento().getIdAlojamiento());
            ps.setInt(4, paquete.getTransporte().getIdTransporte());
            ps.setDate(5, Date.valueOf(paquete.getFechaIda()));
            ps.setDate(6, Date.valueOf(paquete.getFechaVuelta())); 
            ps.setString(7, paquete.getTemporada());
            ps.setInt(8, paquete.getCuposTotales());
            ps.setInt(9, 0);
            ps.setDouble(10, paquete.getPrecioTotal());
            ps.setString(11, paquete.getExcursion1());
            ps.setDouble(12, paquete.getPrecioexcursion1());
            ps.setString(13, paquete.getExcursion2());
            ps.setDouble(14, paquete.getPrecioexcursion2());
            ps.setString(15, paquete.getExcursion3());
            ps.setDouble(16, paquete.getPrecioexcursion3());
            ps.setBoolean(17, paquete.getEstado());
            

            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
             paquete.setIdPaquete(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paquete agregado correctamente");
                ps.close();
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al crear el paquete " + ex.getMessage());
        }

    }
 
    
    
    
    
    public void modificarPaquete(Paquete paquete){
        String sql= "UPDATE paquete SET nombrePaquete=?, idCiudad=?, idAlojamiento=?, idTransporte=?, fechaIda=?, fechaVuelta=?, temporada=?, cuposTotales=?, cuposOcupados=?, precioTotal=? WHERE idPaquete=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paquete.getNombrePaquete());
            ps.setInt(2, paquete.getCiudad().getIdCiudad());
            ps.setInt(3, paquete.getAlojamiento().getIdAlojamiento());
            ps.setInt(4, paquete.getTransporte().getIdTransporte());
            ps.setDate(5, Date.valueOf(paquete.getFechaIda()));
            ps.setDate(6, Date.valueOf(paquete.getFechaVuelta()));
            ps.setString(7, paquete.getTemporada());
            ps.setInt(8, paquete.getCuposTotales());
            ps.setInt(9, paquete.getCuposOcupados());
            ps.setDouble(10, paquete.getPrecioTotal()); 
            ps.setInt(11, paquete.getIdPaquete());
            
            int exito = ps.executeUpdate();
            
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            } else{
                JOptionPane.showMessageDialog(null, "El paquete no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos del cliente");
           
        }
    
}
    
    public void restarCupos(Paquete paquete){
        
        String sql= "UPDATE paquete SET cuposOcupados=? WHERE idPaquete=?";
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, paquete.getCuposOcupados());
            ps.setInt(2, paquete.getIdPaquete());
        
            //System.out.println("Cupos: "+paquete.getCuposOcupados());
            int exito = ps.executeUpdate();
            
            if (exito>0){
                //JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            } else{
                JOptionPane.showMessageDialog(null, "El paquete no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion del campo cuposOcupados");
           
        }
    }
    
    
    
    public void asignarClienteAPaquete (ClientePaquete clientepaquete){
          String sql = "INSERT INTO cliente_paquete(idCliente, idPaquete, precioFinal) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clientepaquete.getCliente().getIdCliente());
            ps.setInt(2, clientepaquete.getPaquete().getIdPaquete());
            ps.setDouble(3, clientepaquete.getPrecioFinal());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                clientepaquete.setIdClientePaquete(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paquete vendido con éxito");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos");
            
        }

    }
    
    
    public void eliminarPaquete(Paquete paquete){
        String sql= "UPDATE paquete SET estado=? WHERE idPaquete=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, false); 
            ps.setInt(2, paquete.getIdPaquete());
            
            int exito = ps.executeUpdate();
            
            if (exito==1){
                //JOptionPane.showMessageDialog(null, "Paquete dado de baja con éxito");
            } else{
                JOptionPane.showMessageDialog(null, "El paquete no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos del cliente");
           
        }
    
}
    
    
    public void recuperarPaquete(int idPaquete){
        String sql= "UPDATE paquete SET estado=? WHERE idPaquete=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true); 
            ps.setInt(2, idPaquete);
            
            int exito = ps.executeUpdate();
            
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Paquete recuperado con éxito");
            } else{
                JOptionPane.showMessageDialog(null, "El paquete no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos del cliente");
           
        }
    
}
    
    
    public void volverCuposACero(int idPaquete){
        
        String sql= "UPDATE paquete SET cuposOcupados=? WHERE idPaquete=?";
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, idPaquete);
        
            //System.out.println("Cupos: "+paquete.getCuposOcupados());
            int exito = ps.executeUpdate();
            
            if (exito>0){
                //JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            } else{
                JOptionPane.showMessageDialog(null, "El paquete no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion del campo cuposOcupados");
           
        }
    }
     
     
    
    public void agregarExcursiones(Paquete paquete){
        String sql= "UPDATE paquete SET excursion1=?,  excursion2=?, excursion3=? WHERE idPaquete=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paquete.getExcursion1()); 
            ps.setString(2, paquete.getExcursion2());
            ps.setString(3, paquete.getExcursion3());
            ps.setInt(4, paquete.getIdPaquete());
            
            int exito = ps.executeUpdate();
            
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Excursiones agregadas con éxito");
            } else{
                JOptionPane.showMessageDialog(null, "El paquete no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de las excursiones");
           
        }
    
}
    
    public void llenarExcursiones(Paquete paquete){
        
    }
    
    
    
    }
  
    


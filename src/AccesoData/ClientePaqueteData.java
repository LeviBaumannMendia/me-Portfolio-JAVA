
package AccesoData;

import Entidades.Cliente;
import Entidades.ClientePaquete;
import Entidades.Paquete;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientePaqueteData {
    
    private Connection con = null;
    private final PaqueteData paqData = new PaqueteData();
    private final ClienteData clieData = new ClienteData();
    private final CiudadData ciuData = new CiudadData();
    private final AlojamientoData aloData = new AlojamientoData();
    private final TransporteData traData = new TransporteData();
    //private final Cliente cliente = new Cliente();
    
     
      public ClientePaqueteData() {
        con = Conexion.getConexion();
    }
      
      
      public ArrayList<Cliente> obtenerClientePorPaquete (int idPaquete){
        ArrayList<Cliente> obtenerCliente = new ArrayList<>();
        String sql = "SELECT c.idCliente, c.dni, c.nombre, c.apellido, c.telefono, c.observaciones FROM cliente_paquete cl JOIN cliente c ON cl.idCliente = c.idCliente AND cl.idPaquete = ? ORDER BY c.nombre";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPaquete);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               Cliente cliente = new Cliente();
               cliente.setIdCliente(rs.getInt("idCliente"));
               cliente.setDni(rs.getInt("dni"));
               cliente.setNombre(rs.getString("nombre"));
               cliente.setApellido(rs.getString("apellido"));
               cliente.setTelefono(rs.getLong("telefono"));
               cliente.setObservaciones(rs.getString("observaciones"));
               obtenerCliente.add(cliente);
 
            } 
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos");
        }
        return obtenerCliente;
    }
      
      
      
      
       public ArrayList<Paquete> obtenerPaquetePorCliente (int idCliente){
        ArrayList<Paquete> obtenerPaquete = new ArrayList<>();
        String sql = "SELECT p.idPaquete, p.nombrePaquete, p.idCiudad, p.idAlojamiento, p.idTransporte, p.cuposTotales, p.cuposOcupados, p.precioTotal FROM cliente_paquete cp JOIN paquete p ON cp.idPaquete = p.idPaquete AND cp.idCliente = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               Paquete paquete = new Paquete();
               paquete.setIdPaquete(rs.getInt("idPaquete"));
               paquete.setNombrePaquete(rs.getString("nombrePaquete"));
               
               int idCiudad = rs.getInt("idCiudad");
               int idAlojamiento = rs.getInt("idAlojamiento");
               int idTransporte = rs.getInt("idTransporte");
               paquete.setCiudad(ciuData.buscarCiudad(idCiudad));
               paquete.setAlojamiento(aloData.buscarAlojamiento(idAlojamiento));
               paquete.setTransporte(traData.buscarTransporte(idTransporte));
               
               paquete.setCuposTotales(rs.getInt("cuposTotales"));
               paquete.setCuposOcupados(rs.getInt("cuposOcupados"));
               paquete.setPrecioTotal(rs.getInt("precioTotal"));
               
               obtenerPaquete.add(paquete);
 
            } 
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos");
        }
        return obtenerPaquete;
    }
      
      
      
      
      
      
      public ClientePaquete buscarClientePaquete(int idPaquete){
    ClientePaquete clientepaquete = null;
    String sql = "SELECT * FROM cliente_paquete WHERE idPaquete = ?";
   
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaquete);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            clientepaquete = new ClientePaquete();
            
            clientepaquete.setIdClientePaquete(rs.getInt("id_ClientePaquete"));
            
            // Aquí debes obtener las instancias de Ciudad, Alojamiento y Transporte
            int idCliente = rs.getInt("idCliente");
            int iddelPaquete = rs.getInt("idPaquete");
            
            // Usa tus métodos de obtención para obtener los objetos completos
            clientepaquete.setCliente(clieData.buscarCliente(idCliente));
            clientepaquete.setPaquete(paqData.buscarPaquete(iddelPaquete));
            
            clientepaquete.setPrecioFinal(rs.getDouble("precioFinal"));
            
        }
        
        rs.close(); 
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cliente_paquete");
    }
    
    return clientepaquete;
 }
      
      
      
      
      
      public ArrayList<ClientePaquete> buscarClientesPorPaquete(int idPaquete){
          
          ArrayList<ClientePaquete> obtenerClientes = new ArrayList<>();
          
    String sql = "SELECT id_ClientePaquete, idCliente, idPaquete, precioFinal FROM cliente_paquete WHERE idPaquete = ?";
   
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaquete);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            ClientePaquete clientepaquete = new ClientePaquete();
            
            clientepaquete.setIdClientePaquete(rs.getInt("id_ClientePaquete"));
            
            // Aquí debes obtener las instancias de Ciudad, Alojamiento y Transporte
            int iddelCliente = rs.getInt("idCliente");
            int iddelPaquete = rs.getInt("idPaquete");
            
            // Usa tus métodos de obtención para obtener los objetos completos
            clientepaquete.setCliente(clieData.buscarCliente(iddelCliente));
            clientepaquete.setPaquete(paqData.buscarPaquete(iddelPaquete));
            
            clientepaquete.setPrecioFinal(rs.getDouble("precioFinal"));
            
            obtenerClientes.add(clientepaquete);
            
        }
        
        rs.close(); 
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cliente_paquete");
    }
    
    return obtenerClientes;
 }
      
      
      
      
      
      
      
      public ArrayList<ClientePaquete> buscarPaquetesPorCliente(int idCliente){
          
          ArrayList<ClientePaquete> obtenerClientes = new ArrayList<>();
          
    String sql = "SELECT id_ClientePaquete, idCliente, idPaquete, precioFinal FROM cliente_paquete WHERE idCliente = ?";
   
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            ClientePaquete clientepaquete = new ClientePaquete();
            
            clientepaquete.setIdClientePaquete(rs.getInt("id_ClientePaquete"));
            
            // Aquí debes obtener las instancias de Ciudad, Alojamiento y Transporte
            int iddelCliente = rs.getInt("idCliente");
            int iddelPaquete = rs.getInt("idPaquete");
            
            // Usa tus métodos de obtención para obtener los objetos completos
            clientepaquete.setCliente(clieData.buscarCliente(iddelCliente));
            clientepaquete.setPaquete(paqData.buscarPaquete(iddelPaquete));
            
            clientepaquete.setPrecioFinal(rs.getDouble("precioFinal"));
            
            obtenerClientes.add(clientepaquete);
            
        }
        
        rs.close(); 
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cliente_paquete");
    }
    
    return obtenerClientes;
 }
      
      
      
      
      
      
      
      public boolean existenAmbos(int idPaquete, int idCliente) {
    String sql = "SELECT COUNT(*) FROM cliente_paquete WHERE idPaquete = ? AND idCliente = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaquete);
        ps.setInt(2, idCliente);
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
      
      
      
      
      
      public boolean existePaquete(int idPaquete) {
    String sql = "SELECT COUNT(*) FROM cliente_paquete WHERE idPaquete = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaquete);
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
      
      
      
      public boolean existeCliente(int idCliente) {
    String sql = "SELECT COUNT(*) FROM cliente_paquete WHERE idCliente = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCliente);
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
      
      
      
      
      
      public void eliminarClientePaquete(int idPaquete) {
    String sql = "DELETE FROM cliente_paquete WHERE idPaquete = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPaquete);
        int exito = ps.executeUpdate();
        
        if (exito == 1) {
            //JOptionPane.showMessageDialog(null, "Paquete eliminado con éxito");
        } else {
            //JOptionPane.showMessageDialog(null, "El cliente_paquete no existe");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el cliente_paquete");
    }
}
      
      
      public void eliminarClientePaquete_PorCliente(int idCliente) {
    String sql = "DELETE FROM cliente_paquete WHERE idCliente = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCliente);
        int exito = ps.executeUpdate();
        
        if (exito == 1) {
            //JOptionPane.showMessageDialog(null, "Paquete eliminado con éxito");
        } else {
            //JOptionPane.showMessageDialog(null, "El cliente_paquete no existe");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el cliente_paquete");
    }
}
      
      
  }
      
    


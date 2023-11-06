
package AccesoData;

import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteData {
    
    private Connection con = null;
    
    
    public ClienteData() {
        con = Conexion.getConexion();

    }
    
    
    
    public void guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (dni, nombre, apellido, telefono, direccion, email, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setLong(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getObservaciones());

            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
             cliente.setIdCliente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cliente registrado!");
                ps.close();
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente " + ex.getMessage());
        }

    }
    
    public boolean existeDNI(int dni) {
    String sql = "SELECT COUNT(*) FROM cliente WHERE dni = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, dni);
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
    
    
    
    
    public Cliente buscarCliente(int idCliente){
        Cliente cliente = null;
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE idCliente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idCliente);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cliente=new Cliente();        
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones"));
                
            }
             rs.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return cliente;

    }
    
    
    
    
    
    
    
    
        public Cliente buscarClientePorDni(int dni){
        Cliente cliente = null;
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,dni );
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cliente=new Cliente();          
                cliente.setDni(rs.getInt("dni"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones"));
                
            }
             rs.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return cliente;

    }
        
        
        
        
        
        
        
        
        
        
        public Cliente buscarClientePorNombre(String nombre){
        Cliente cliente = null;
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE nombre LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nombre );
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cliente=new Cliente();          
                cliente.setDni(rs.getInt("dni"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones")); 
            }
             rs.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return cliente;

    }
        
        
        
        
        
        public Cliente buscarClientePorApellido(String apellido){
        Cliente cliente = null;
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE apellido LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,apellido);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cliente=new Cliente();          
                cliente.setDni(rs.getInt("dni"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones")); 
            }
             rs.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return cliente;

    }
        
        
        
        
        
        
        
        public Cliente buscarClientePorNombreApellido(String nombre, String apellido){
        Cliente cliente = null;
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE nombre LIKE ? AND apellido LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre );
            ps.setString(2, apellido );
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                cliente=new Cliente();          
                cliente.setDni(rs.getInt("dni"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones"));
                
            }
             rs.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
        }
        return cliente;

    }
        
         public void elimninarCliente (int dni){
        String sql = "DELETE FROM cliente WHERE dni = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            int exito = ps.executeUpdate();
            if(exito == 1){
                //JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Error");  
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el cliente");
        }
        
        
    }
         
         
         public void modificarCliente(Cliente cliente){
        String sql= "UPDATE cliente SET apellido=?, nombre=?, telefono=?, direccion=?, email=?, observaciones=? WHERE dni=?";   //ACÁ ES SEGÚN POR QUÉ LO QUEREMOS BUSCAR
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setLong(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getObservaciones());
            ps.setInt(7, cliente.getDni());
            int exito = ps.executeUpdate();
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            } else{
                JOptionPane.showMessageDialog(null, "El cliente no existe");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la modificacion de los datos del cliente");
           
        }
    
}
         
         
         
         
         
         public ArrayList<Cliente>  obtenerClientes(){
        
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente ORDER BY apellido";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             
            
            while(rs.next()){
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones"));
                listaClientes.add(cliente);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente" + ex.getMessage());
      }
        
        return listaClientes;
    }
         
         
         
         
         public ArrayList<Cliente> obtenerClientesPorNombre(String nombrecliente){
        
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE nombre LIKE ? ORDER BY apellido";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrecliente);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones"));
                listaClientes.add(cliente);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente" + ex.getMessage());
      }
        
        return listaClientes;
    }
         
         
         
         
         public ArrayList<Cliente> obtenerClientesPorApellido(String apellidocliente){
        
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE apellido LIKE ? ORDER BY apellido";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, apellidocliente);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones"));
                listaClientes.add(cliente);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente" + ex.getMessage());
      }
        
        return listaClientes;
    }
         
         
         
         
         
         public ArrayList<Cliente> obtenerClientesPorNombreApellido(String nombrecliente, String apellidocliente){
        
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT idCliente, dni, nombre, apellido, telefono, direccion, email, observaciones FROM cliente WHERE nombre LIKE ? AND apellido LIKE ? ORDER BY apellido";
        
          
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrecliente);
            ps.setString(2, apellidocliente);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getInt("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservaciones(rs.getString("observaciones"));
                listaClientes.add(cliente);
            }
            
            rs.close();
            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente" + ex.getMessage());
      }
        
        return listaClientes;
    }
         
         
         
         
}

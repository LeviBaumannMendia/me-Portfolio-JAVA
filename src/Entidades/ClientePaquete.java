
package Entidades;


public class ClientePaquete {
    
    private int idClientePaquete;
    private Cliente cliente;
    private Paquete paquete;
    private Double precioFinal;

    public ClientePaquete(int idClientePaquete, Cliente cliente, Paquete paquete, Double precioFinal) {
        this.idClientePaquete = idClientePaquete;
        this.cliente = cliente;
        this.paquete = paquete;
        this.precioFinal = precioFinal;
    }

    public ClientePaquete(Cliente cliente, Paquete paquete, Double precioFinal) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.precioFinal = precioFinal;
    }
    
    
    
    public ClientePaquete(){
        
    }

    public int getIdClientePaquete() {
        return idClientePaquete;
    }

    public void setIdClientePaquete(int idClientePaquete) {
        this.idClientePaquete = idClientePaquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString() {
        return "ClientePaquete{" + "idClientePaquete=" + idClientePaquete + ", cliente=" + cliente + ", paquete=" + paquete + ", precioFinal=" + precioFinal + '}';
    }
    
    
    
}

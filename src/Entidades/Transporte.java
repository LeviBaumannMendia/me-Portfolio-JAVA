
package Entidades;


public class Transporte {
    
    private int idTransporte;
    private String tipoTransporte;
    private String servicio;
    private String empresa;
    private double precioPasaje;

    public Transporte(int idTransporte, String tipoTransporte, String servicio, String empresa, double precioPasaje) {
        this.idTransporte = idTransporte;
        this.tipoTransporte = tipoTransporte;
        this.servicio = servicio;
        this.empresa = empresa;
        this.precioPasaje = precioPasaje;
    }

    public Transporte(String tipoTransporte, String servicio, String empresa, double precioPasaje) {
        this.tipoTransporte = tipoTransporte;
        this.servicio = servicio;
        this.empresa = empresa;
        this.precioPasaje = precioPasaje;
       
    }
    
    public Transporte(){
        
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    public String getEmpresa(){
        return empresa;
    }
 public void setEmpresa(String empresa){
     this.empresa = empresa;
 }
    public double getPrecioPasaje() {
        return precioPasaje;
    }

    public void setPrecioPasaje(double precioPasaje) {
        this.precioPasaje = precioPasaje;
    }

    
    
    
    @Override
    public String toString() {
        return tipoTransporte + " "+ empresa +" "+ servicio;
    }
    
    
    
    
}

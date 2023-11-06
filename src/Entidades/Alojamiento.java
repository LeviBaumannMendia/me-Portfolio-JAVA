
package Entidades;


public class Alojamiento {
    private int idAlojamiento;
    private Ciudad ciudadDestino;
    private String nombreHotel;
    private String servicio;
    private int estrellas;
    private double precio;
    private boolean estado;

    public Alojamiento(int idAlojamiento, Ciudad ciudadDestino, String nombreHotel, String servicio, int estrellas, double precio, boolean estado) {
        this.idAlojamiento = idAlojamiento;
        this.ciudadDestino = ciudadDestino;
        this.nombreHotel = nombreHotel;
        this.servicio = servicio;
        this.estrellas = estrellas;
        this.precio = precio;
        this.estado = estado;
    }

    public Alojamiento(Ciudad ciudadDestino, String nombreHotel, String servicio,  int estrellas, double precio, boolean estado) {
        this.ciudadDestino = ciudadDestino;
        this.nombreHotel = nombreHotel;
        this.servicio = servicio;
        this.estrellas = estrellas;
        this.precio = precio;
        this.estado = estado;
    }
    
    public Alojamiento() {
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return nombreHotel;
    } 
    
 
}

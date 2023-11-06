
package Entidades;

import java.time.LocalDate;


public class Paquete {
     private int idPaquete;
     private String nombrePaquete;
     private Ciudad ciudad;
     private Alojamiento alojamiento;
     private Transporte transporte;
     private LocalDate fechaIda;
     private LocalDate fechaVuelta;
     private String temporada;
     private int cuposTotales;
     private int cuposOcupados;
     private double precioTotal;
     private String excursion1;
     private String excursion2;
     private String excursion3;
     private double precioexcursion1;
     private double precioexcursion2;
     private double precioexcursion3;
     private boolean estado;

     
     
    public Paquete(int idPaquete, String nombrePaquete, Ciudad ciudad, Alojamiento alojamiento, Transporte transporte, LocalDate fechaIda, LocalDate fechaVuelta, String temporada, int cuposTotales, 
            int cuposOcupados, double precioTotal, String excursion1, String excursion2, String excursion3, double precioexcursion1, double precioexcursion2, double precioexcursion3, boolean estado) {

        this.idPaquete = idPaquete;
        this.nombrePaquete = nombrePaquete;
        this.ciudad = ciudad;
        this.alojamiento = alojamiento;
        this.transporte = transporte;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.temporada = temporada;
        this.cuposTotales = cuposTotales;
        this.cuposOcupados = cuposOcupados;
        this.precioTotal = precioTotal;
        this.excursion1 = excursion1;
        this.excursion2 = excursion2;
        this.excursion3 = excursion3;
        this.precioexcursion1 = precioexcursion1;
        this.precioexcursion2 = precioexcursion2;
        this.precioexcursion3 = precioexcursion3;
        this.estado = estado;
    }

    public Paquete(String nombrePaquete, Ciudad ciudad, Alojamiento alojamiento, Transporte transporte, LocalDate fechaIda, LocalDate fechaVuelta, String temporada, int cuposTotales, int cuposOcupados, 
                            double precioTotal, String excursion1, String excursion2, String excursion3, double precioexcursion1, double precioexcursion2, double precioexcursion3, boolean estado) {
        this.nombrePaquete = nombrePaquete;
        this.ciudad = ciudad;
        this.alojamiento = alojamiento;
        this.transporte = transporte;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.temporada = temporada;
        this.cuposTotales = cuposTotales;
        this.cuposOcupados = cuposOcupados;
        this.precioTotal = precioTotal;
        this.excursion1 = excursion1;
        this.excursion2 = excursion2;
        this.excursion3 = excursion3;
        this.precioexcursion1 = precioexcursion1;
        this.precioexcursion2 = precioexcursion2;
        this.precioexcursion3 = precioexcursion3;
        this.estado = estado;
    }

     
     public Paquete(){
         
     }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public LocalDate getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(LocalDate fechaIda) {
        this.fechaIda = fechaIda;
    }

    public LocalDate getFechaVuelta() {
        return fechaVuelta;
    }

    public void setFechaVuelta(LocalDate fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public int getCuposTotales() {
        return cuposTotales;
    }

    public void setCuposTotales(int cuposTotales) {
        this.cuposTotales = cuposTotales;
    }

    public int getCuposOcupados() {
        return cuposOcupados;
    }

    public void setCuposOcupados(int cuposOcupados) {
        this.cuposOcupados = cuposOcupados;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getExcursion1() {
        return excursion1;
    }

    public void setExcursion1(String excursion1) {
        this.excursion1 = excursion1;
    }

    public String getExcursion2() {
        return excursion2;
    }

    public void setExcursion2(String excursion2) {
        this.excursion2 = excursion2;
    }

    public String getExcursion3() {
        return excursion3;
    }

    public void setExcursion3(String excursion3) {
        this.excursion3 = excursion3;
    }
    
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecioexcursion1() {
        return precioexcursion1;
    }

    public void setPrecioexcursion1(double precioexcursion1) {
        this.precioexcursion1 = precioexcursion1;
    }

    public double getPrecioexcursion2() {
        return precioexcursion2;
    }

    public void setPrecioexcursion2(double precioexcursion2) {
        this.precioexcursion2 = precioexcursion2;
    }

    public double getPrecioexcursion3() {
        return precioexcursion3;
    }

    public void setPrecioexcursion3(double precioexcursion3) {
        this.precioexcursion3 = precioexcursion3;
    }
 
    
    
    @Override
    public String toString() {
        return nombrePaquete +", "+ ciudad.getProvincia();
    }
     
     
}

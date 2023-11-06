package Entidades;


public class Ciudad {
    private int idCiudad;
    private String nombre;
    private String pais;
    private String provincia;
    
    public Ciudad(int idCiudad, String nombre, String pais, String provincia){
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.pais = pais;
        this.provincia = provincia;
 
    }
    
    public Ciudad(String nombre, String pais, String provincia){
        //this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.pais = pais;
        this.provincia = provincia;
    }
    
    public Ciudad(){
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    @Override
    public String toString() {
        return nombre+", "+provincia;
    }
    
    
    
    
}
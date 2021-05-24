
package domain;

public class Prestamo {

   
    private int idPrestamo;
    private String idPrestamista;
    private String nombrePrestamista;
    private String fecha;
    private String motivo;
    private String lugar;
    private String hora;

    public Prestamo(String idPrestamista, String nombrePrestamista, String fecha, String motivo, String lugar, String hora) {
        this.idPrestamista = idPrestamista;
        this.nombrePrestamista = nombrePrestamista;
        this.fecha = fecha;
        this.motivo = motivo;
        this.lugar = lugar;
        this.hora = hora;
    }
    
     public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    
    public String getIdPrestamista() {
        return idPrestamista;
    }

    public void setIdPrestamista(String idPrestamista) {
        this.idPrestamista = idPrestamista;
    }

    public String getNombrePrestamista() {
        return nombrePrestamista;
    }

    public void setNombrePrestamista(String nombrePrestamista) {
        this.nombrePrestamista = nombrePrestamista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    

    public String toString(){   
        return "Prestamo "+ fecha + " "+ hora;
    }



}

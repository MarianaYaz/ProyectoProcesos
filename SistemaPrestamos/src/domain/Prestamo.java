
package domain;

import java.util.ArrayList;

public class Prestamo {

    
    private int idPrestamo;
    private String idPrestamista;
    private String nombrePrestamista;
    private String fecha;
    private String motivo;
    private String lugar;
    private String hora;
    private ArrayList<Dispositivo> dispositivos;
    private Dispositivo dispositivo;

   
    
    public Prestamo(String idPrestamista, String nombrePrestamista, String fecha, String motivo, String lugar, String hora) {
        this.idPrestamista = idPrestamista;
        this.nombrePrestamista = nombrePrestamista;
        this.fecha = fecha;
        this.motivo = motivo;
        this.lugar = lugar;
        this.hora = hora;
        dispositivos= new ArrayList<Dispositivo> ();
    }
    
     public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    
    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

   public void addDispositivo(Dispositivo dispositivo){    
       dispositivos.add(dispositivo);
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
    
     public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    

    public String toString(){   
        return "Prestamo "+ fecha + " "+ hora;
    }



}

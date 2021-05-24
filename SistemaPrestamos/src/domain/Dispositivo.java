
package domain;

/**
 *
 * @author kari
 */
public class Dispositivo {
    private String clave;
    private String descripcion;
    private String fechaRegistro;
    private String estado;

    public Dispositivo(String clave, String descripcion, String fechaRegistro, String estado) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }
    
    
    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }
    

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

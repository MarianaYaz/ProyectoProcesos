
package domain;

/**
 *
 * @author kari
 */
public class Dispositivo {
    private String clave;
    private String descripcion;
    private String fechaRegistro;

    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
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
    
    
}

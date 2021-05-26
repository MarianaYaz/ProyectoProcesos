
package domain;

/**
 *
 * @author david
 */
public class Devolucion {
    private String comentario;
    private String fechaDevolucion;
    private String horaDevolucion;
    private Prestamo prestamo;

    public Devolucion(String comentario, String fechaDevolucion, String horaDevolucion) {
        this.comentario = comentario;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
    }

    public String getComentario() {
        return comentario;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getHoraDevolucion() {
        return horaDevolucion;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setHoraDevolucion(String horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
}

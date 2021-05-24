
package domain;

/**
 *
 * @author david
 */
public class ControlProyector extends Dispositivo{
    private String marca;
    private String salaAsignada;
    
    public ControlProyector(String marca, String salaAsignada, String clave, String descripcion, String fechaRegistro, String estado){
        super(clave, descripcion, fechaRegistro, estado);
        this.marca = marca;
        this.salaAsignada = salaAsignada;
    }

    public String getMarca() {
        return marca;
    }

    public String getSalaAsignada() {
        return salaAsignada;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setSalaAsignada(String salaAsignada) {
        this.salaAsignada = salaAsignada;
    }

}

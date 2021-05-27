
package domain;

/**
 *
 * @author david
 */
public class ControlProyector extends Dispositivo{
    private String marca;
    private String salaAsignada;

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


package domain;

/**
 *
 * @author david
 */
public class Laptop extends Dispositivo{
    private String marca;
    private String modelo;
    
    public Laptop(String marca, String modelo, String clave, String descripcion, String fechaRegistro, String estado){
        super(clave, descripcion, fechaRegistro, estado);
        this.marca = marca;
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}

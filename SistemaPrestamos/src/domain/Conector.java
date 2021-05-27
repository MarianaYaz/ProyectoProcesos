
package domain;

/**
 *
 * @author david
 */
public class Conector extends Dispositivo{
    private String tipo;
    
    public Conector(String tipo, String clave, String descripcion, String fechaRegistro, String estado){
        super(clave, descripcion, fechaRegistro, estado);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

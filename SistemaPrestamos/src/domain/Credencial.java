
package domain;

import java.sql.Blob;

public class Credencial {
    private String correo;
    private Blob contrasenia;
    private String tipo;
    
    public Credencial(String correo, Blob contrasenia, String tipo){
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public Credencial(String correo, Blob contraseniaBlob) {
       this.correo = correo;
       this.contrasenia = contrasenia;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setContrasenia(Blob contrasenia){
        this.contrasenia = contrasenia;
    }
    
    public Blob getContrasenia(){
        return contrasenia;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}

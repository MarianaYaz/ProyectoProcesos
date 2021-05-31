
package domain;

import java.sql.Blob;

public class Credencial {
    private String correo;
    private String contrasenia;
    private String tipo;
    
    public Credencial(String correo, String contrasenia, String tipo){
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public Credencial(String correo, String contrasenia) {
       this.correo = correo;
       this.contrasenia = contrasenia;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}

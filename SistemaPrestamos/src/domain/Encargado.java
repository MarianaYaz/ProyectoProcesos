package domain;

public class Encargado {
    private String curp;
    private String nombre;
    private String numeroPersonal;
    private String turno;
    
    public Encargado(String curp, String nombre, String numeroPersonal, String turno){
        this.curp = curp;
        this.nombre = nombre;
        this.numeroPersonal = numeroPersonal;
        this.turno = turno;
    }
    
    public void setCurp(String curp){
        this.curp = curp;
    }
    
    public String getCurp(){
        return curp;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNumeroPersonal(String numeroPersonal){
        this.numeroPersonal = numeroPersonal;
    }
    
    public String getNumeroPersonal(){
        return numeroPersonal;
    }

    public void setTurno(String turno){
        this.turno = turno;
    }
    
    public String getTurno(){
        return turno;
    }   
}

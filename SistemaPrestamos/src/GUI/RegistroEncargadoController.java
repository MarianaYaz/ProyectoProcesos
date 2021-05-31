package GUI;

import businessLogic.CredencialDAO;
import domain.Encargado;
import businessLogic.EncargadoDAO;
import domain.Credencial;
import java.net.URL;
import java.sql.Blob;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroEncargadoController implements Initializable {
    private ObservableList<String> turnos;
    @FXML private ComboBox<String> cbTurnos;
    @FXML private ComboBox<Integer> cbYears;
    @FXML private TextField tfCurp;
    @FXML private TextField tfNombre;
    @FXML private TextField tfNumeroPersonal;
    @FXML private TextField tfCorreo;
    @FXML private TextField tfContrasenia;
    @FXML private Button btCerrar;
    @FXML private Button btGuardar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     turnos = FXCollections.observableArrayList();
     turnos.add("Matutino");
     turnos.add("Vespertino");
     cbTurnos.setItems(turnos);
     cbTurnos.getSelectionModel().selectFirst();
    }    

    @FXML 
    public void save(){
       String curp = "";
       String nombre = "";
       String numPersonal = "";
       String correo = "";
       String contrasenia = "";
       String turno = "";
       String tipo = "Encargado";
       curp = tfCurp.getText();
       nombre = tfNombre.getText();
       numPersonal = tfNumeroPersonal.getText();
       correo = tfCorreo.getText();
       contrasenia = tfContrasenia.getText();
       turno = cbTurnos.getSelectionModel().getSelectedItem();
       correo = tfCorreo.getText();
       contrasenia = tfContrasenia.getText();
       Credencial credencial = new Credencial(correo,contrasenia, tipo);
       Encargado encargado = new Encargado(curp,nombre,numPersonal,turno);
       if(validar(encargado)&&validar(credencial)){
            CredencialDAO credencialDAO = new CredencialDAO();
            credencialDAO.registrarCredencial(credencial);
            EncargadoDAO encargadoDAO = new EncargadoDAO();
            encargadoDAO.registrarEncargado(encargado);  
            MensajeAlerta mensajeAlerta = new MensajeAlerta();
            mensajeAlerta.mostrarMensajeGuardadoExito("Encargado");
            Stage stage = (Stage)btGuardar.getScene().getWindow();
            stage.close();
       }
    }
    
    @FXML
    public void close() {
        Stage stage = (Stage)btCerrar.getScene().getWindow();
        stage.close();
    }

    
    public boolean validar(Encargado encargado){
        boolean value = true;
        MensajeAlerta mensajeAlerta = new MensajeAlerta();
        if(camposVacios(encargado)){
            value = false;
            mensajeAlerta.mostrarMensajeCamposInvalidos("Campos vacios");
        }
        if(estaRegistrado(encargado)){
            value = false;
            mensajeAlerta.mostrarMensajeCamposInvalidos("El encargado ya se encuentra registrado");
        }
            
        return value;
    }
    
    public boolean validar(Credencial credencial){
        boolean value = true;
        MensajeAlerta mensajeAlerta = new MensajeAlerta();
        if(camposVacios(credencial)){
            value = false;
            mensajeAlerta.mostrarMensajeCamposInvalidos("Campos vacios");
        }
        if(camposInvalidos(credencial)){
            value = false;
            mensajeAlerta.mostrarMensajeCamposInvalidos("Correo invalido");
        }  
        if(estaRegistrado(credencial)){
            value = false;
            mensajeAlerta.mostrarMensajeCamposInvalidos("El correo ya se encuentra registrado");
        }
        return value;
    }
    
    public boolean camposVacios(Encargado encargado){
        boolean emptyFields = false;
        if((encargado.getCurp().isEmpty()||encargado.getNombre().isEmpty()||encargado.getNumeroPersonal().isEmpty()||encargado.getTurno().isEmpty())){
            emptyFields = true;
        }
        return emptyFields;
    }
    
    public boolean estaRegistrado(Encargado encargado){
        boolean value = false;
        EncargadoDAO encargadoDAO = new EncargadoDAO();
        String curp = encargadoDAO.buscarCurp(encargado);
        if(!curp.isEmpty()){
            value = true;
        }
        return value;
    }
    
    public boolean estaRegistrado(Credencial credencial){
        boolean value = false;
        CredencialDAO credencialDAO = new CredencialDAO();
        Credencial credencialRecuperada = credencialDAO.buscarCredencial(credencial);
        if(credencialRecuperada != null){
            value = true;
        }
        return value;
    }
    
    public boolean camposVacios(Credencial credencial){
        boolean emptyFields = false;
        if(credencial.getContrasenia() == null || credencial.getCorreo().isEmpty()||credencial.getTipo().isEmpty()){
            emptyFields = true;
        }
        return emptyFields;
    }
    
    public boolean camposInvalidos(Credencial credencial){
        boolean value = true;
        Validacion validar = new Validacion();
        if(validar.validarCorreo(credencial.getCorreo())){
            value = false;
        }
        return value;
    }
}

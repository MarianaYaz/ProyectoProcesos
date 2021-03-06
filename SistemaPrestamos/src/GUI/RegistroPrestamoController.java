package GUI;

import businessLogic.DispositivoDAO;
import businessLogic.PrestamoDAO;
import domain.Cable;
import domain.Conector;
import domain.ControlProyector;
import domain.Dispositivo;
import domain.Laptop;
import domain.Prestamo;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author kari
 */
public class RegistroPrestamoController implements Initializable {
   private ObservableList<Dispositivo> dispositivos;

    @FXML TextField tfIdPrestamista;
    @FXML TextField tfNombrePrestamista;
    @FXML TextField tfHora;
    @FXML TextField tfLugar;
     @FXML TextArea taMotivo;
    @FXML DatePicker dpFecha;
    @FXML ComboBox cbDispositivos;
    @FXML Button btGuardar;
    @FXML Button btSalir;
    private String opcionDispositivo;
    private String correo;
    
    
     @FXML 
    private void actionGuardar(ActionEvent actionEvent){   
        if(!validarCamposVacios()){
            if(validarInformacion()){
                int idPrestamo;
                String idPrestamista=tfIdPrestamista.getText();
                String nombrePrestamista=tfNombrePrestamista.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha=dpFecha.getValue().format(formatter);
                String motivo=taMotivo.getText();
                String lugar=tfLugar.getText();
                String hora=tfHora.getText();
                if(validarHora(hora)){
                    Prestamo prestamo = new Prestamo(idPrestamista,nombrePrestamista,fecha,motivo,lugar,hora);          
                    if(!buscarRepetido(prestamo)){  
                        guardar(prestamo);
                    }else{  
                        enviarAlerta("El prestamo ya esta registrado");
                    }
                }else{  
                  enviarAlerta("El formato de hora debe ser HH:MM");

                }
            }
        }else{  
            enviarAlerta("Por favor llena todos los campos");
        }
    }
    
    private void guardar(Prestamo prestamo){    
        PrestamoDAO prestamoDAO = new PrestamoDAO();    
        if(prestamoDAO.guardadoExitoso(prestamo)){  
            prestamo.setIdPrestamo(prestamoDAO.getId(prestamo));
            Dispositivo dispositivo= (Dispositivo) cbDispositivos.getSelectionModel().getSelectedItem();
            prestamo.setDispositivo(dispositivo);
            DispositivoDAO dispositivoDAO = new DispositivoDAO();
            if(prestamoDAO.guardadoDispositivo(prestamo, opcionDispositivo) 
            && dispositivoDAO.actualizarEstado(dispositivo.getClave(), opcionDispositivo, "Prestado") 
            && prestamoDAO.agregarEncargadoPrestamo(prestamo.getIdPrestamo(), correo)){
                enviarAlertaGuardado();
            }
        }
    
    };
    
    private void enviarAlertaGuardado(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informaci??n guardada");
        alert.setContentText("El prestamo ha sido guardado con exito");
        alert.showAndWait();
    }
    
    private void enviarAlerta(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private boolean buscarRepetido(Prestamo prestamo){
        boolean value=true;
        PrestamoDAO prestamoDAO = new PrestamoDAO();   
        if(prestamoDAO.getId(prestamo) == 0 ){  
            value=false;
            
        }
        return value;
    }
    
    @FXML 
    private void actionSalir(ActionEvent actionEvent){   
        Stage stage = (Stage) btSalir.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dpFecha.setConverter(new LocalDateStringConverter(formatter, null));
        dpFecha.setValue(LocalDate.now());
        dispositivos = FXCollections.observableArrayList();
        
    }    
    
    
    public void initializeDispositivos(String option){   
            opcionDispositivo=option;
            DispositivoDAO dispositivoDAO = new DispositivoDAO();
            switch(option){ 
            case "Cable": ;
                ArrayList <Cable> dispositivosLista = new ArrayList<Cable>();
                dispositivosLista = dispositivoDAO.getCables();
                for( int i = 0; i<dispositivosLista.size(); i++) {
                  dispositivos.add(dispositivosLista.get(i));
                 }
            break;
            
            case "Conector":;
                ArrayList <Conector> dispositivosList = new ArrayList<Conector>();
                dispositivosList = dispositivoDAO.getConectores();
                for( int i = 0; i<dispositivosList.size(); i++) {
                  dispositivos.add(dispositivosList.get(i));
                 }
            break;
            
            case "Control de proyector":;
                ArrayList <ControlProyector> dispositivosListaC = new ArrayList<ControlProyector>();
                dispositivosListaC = dispositivoDAO.getControlesProyectores();
                for( int i = 0; i<dispositivosListaC.size(); i++) {
                  dispositivos.add(dispositivosListaC.get(i));
                 }
            break;
            
            case "Laptop":;
                ArrayList <Laptop> dispositivosListaL = new ArrayList<Laptop>();
                dispositivosListaL = dispositivoDAO.getLaptops();
                for( int i = 0; i<dispositivosListaL.size(); i++) {
                  dispositivos.add(dispositivosListaL.get(i));
                 }
            break;
            
         }
       cbDispositivos.setItems(dispositivos);
       cbDispositivos.getSelectionModel().selectFirst();
    }
    
    private boolean validarCamposVacios(){  
        boolean value=false;
          if(tfIdPrestamista.getText().isEmpty() || tfNombrePrestamista.getText().isEmpty() 
           || tfHora.getText().isEmpty()  || taMotivo.getText().isEmpty() || tfLugar.getText().isEmpty() ){
              value=true;
          }
          return value;
    
    }
    
    private boolean validarInformacion(){  
        boolean value=true;
        if( findInvalidField(tfIdPrestamista.getText())) {   
            enviarAlerta("Id Prestamo tiene caracteres inv??lidos ");
            value=false;
        }
           
        if(findInvalidField(tfNombrePrestamista.getText())){
            enviarAlerta("Nombre de prestamista tiene caracteres inv??lidos ");
            value=false;
        }
        
        if(findInvalidField(taMotivo.getText())){
            enviarAlerta("Motivo tiene caracteres inv??lidos ");
            value= false;

        }
        
        if(findInvalidField(tfLugar.getText())){
            enviarAlerta("Lugar tiene caracteres inv??lidos ");
            value= false;       
        }
        
        
           
        return value;
    }
    
    private boolean validarHora(String hora){ 
        boolean value=false;
        Pattern pattern = Pattern.compile("[0-2][0-3]:[0-5][0-9]");
        Matcher mather = pattern.matcher(hora);
        if(mather.find()){  
            value=true;
        }   
        return value; 
        
    }
    
    private boolean findInvalidField(String field){ 
        boolean value=false;
        Pattern pattern = Pattern.compile("[!#$%&'*+/=?^_`{|}~]");
        Matcher mather = pattern.matcher(field);
        if(mather.find()){  
            value=true;
        }   
        return value;  
    }
    
    public void setCorreo(String correo){  
        this.correo=correo;
    }
    
    
    
}

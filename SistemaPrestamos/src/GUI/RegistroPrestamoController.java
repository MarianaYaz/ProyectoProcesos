/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    
     @FXML 
    private void actionGuardar(ActionEvent actionEvent){   
        if(!validarCamposVacios()){
            int idPrestamo;
            String idPrestamista=tfIdPrestamista.getText();
            String nombrePrestamista=tfNombrePrestamista.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha=dpFecha.getValue().format(formatter);
            String motivo=taMotivo.getText();
            String lugar=tfLugar.getText();
            String hora=tfHora.getText();
            //String idPrestamista, String nombrePrestamista, String fecha, String motivo, String lugar, String hora
            Prestamo prestamo = new Prestamo(idPrestamista,nombrePrestamista,fecha,motivo,lugar,hora);
            if(!buscarRepetido(prestamo)){  
                guardar(prestamo);
            }
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
            && dispositivoDAO.actualizarEstado(dispositivo.getClave(), opcionDispositivo, "Prestado") ){
                enviarAlertaGuardado();
            }
        }
    
    };
    
    private void enviarAlertaGuardado(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información guardada");
        alert.setContentText("El prestamo ha sido guardado con exito");
        alert.showAndWait();
    }
    
    private boolean buscarRepetido(Prestamo prestamo){
        boolean value=true;
        PrestamoDAO prestamoDAO = new PrestamoDAO();    
        if(prestamoDAO.getId(prestamo) != 0 ){  
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
           || tfHora.getText().isEmpty()  || taMotivo.getText().isEmpty() || tfLugar.getText().isEmpty() 
           || dpFecha.getValue()== null){
              value=true;
          }
          return value;
    
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import businessLogic.DispositivoDAO;
import domain.Cable;
import domain.Conector;
import domain.ControlProyector;
import domain.Dispositivo;
import domain.Laptop;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    
    
     @FXML 
    private void actionGuardar(ActionEvent actionEvent){   
        
    }
    
    @FXML 
    private void actionSalir(ActionEvent actionEvent){   
        Stage stage = (Stage) btSalir.getScene().getWindow();
        stage.close();
    }

    private String opcionDispositivo;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dpFecha.setConverter(new LocalDateStringConverter(formatter, null));
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

        
    }
    
    
}

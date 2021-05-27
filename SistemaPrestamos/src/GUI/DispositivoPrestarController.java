/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Dispositivo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class DispositivoPrestarController implements Initializable {
   private ObservableList<String> dispositivos;

    @FXML Button btOk;
    @FXML Button btCancelar;
    @FXML ComboBox cbDispositivos;
    
    
    @FXML 
    private void actionPrestamo(ActionEvent actionEvent){  
        FXMLLoader loader;
        Stage primaryStage = (Stage) btOk.getScene().getWindow();
        primaryStage.close();
        try {
                String opcion = (String) cbDispositivos.getSelectionModel().getSelectedItem();
                       
               loader = new FXMLLoader(getClass().getResource("RegistroPrestamo.fxml"));
               Parent root = loader.load();
               RegistroPrestamoController registroPrestamoController = loader.getController();
               registroPrestamoController.initializeDispositivos(opcion);
               Scene scene = new Scene(root);
               Stage stage = new Stage();
               stage.setScene(scene);
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.showAndWait();
               
               } catch (IOException ex) {
                 Logger.getLogger(DispositivoPrestarController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML 
    private void actionSalir(ActionEvent actionEvent){   
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dispositivos = FXCollections.observableArrayList();
        dispositivos.add("Cable");
        dispositivos.add("Conector");
        dispositivos.add("Control de proyector");
        dispositivos.add("Laptop");
        cbDispositivos.setItems(dispositivos);
        cbDispositivos.getSelectionModel().selectFirst();
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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

/**
 * FXML Controller class
 *
 * @author david
 */
public class DispositivoDevolverController implements Initializable {
    private ObservableList<String> dispositivos;
    
    @FXML
    private ComboBox cbDispositivos;
    @FXML
    private Button btSiguiente;
    @FXML
    private Button btCancelar;

    /**
     * Initializes the controller class.
     */
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

    @FXML
    private void actionSiguiente(ActionEvent event){
        FXMLLoader loader;
        Stage primaryStage = (Stage) btSiguiente.getScene().getWindow();
        primaryStage.close();
        try {
               String opcion = (String) cbDispositivos.getSelectionModel().getSelectedItem();
               loader = new FXMLLoader(getClass().getResource("RegistroDevolucion.fxml"));
               Parent root = loader.load();
               RegistroDevolucionController registroDevolucionController = loader.getController();
               registroDevolucionController.initializeDispositivos(opcion);
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
    private void actionCancelar(ActionEvent event){
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        stage.close();
    }
    
}

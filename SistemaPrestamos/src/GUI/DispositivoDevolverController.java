/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private void actionSiguiente(ActionEvent event) {
    }

    @FXML
    private void actionCancelar(ActionEvent event){
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        stage.close();
    }
    
}

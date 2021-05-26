/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author david
 */
public class RegistroDevolucionController implements Initializable {

    @FXML
    private ComboBox<?> cbDispositivo;
    @FXML
    private DatePicker dpFechaDevolucion;
    @FXML
    private ComboBox<?> cbPresentaProblema;
    @FXML
    private TextArea textAreaComentarios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardarPrestamo(ActionEvent event) {
    }

    @FXML
    private void cancelarDevolucion(ActionEvent event) {
    }
    
}

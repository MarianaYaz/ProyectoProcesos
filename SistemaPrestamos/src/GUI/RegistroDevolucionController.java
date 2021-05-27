/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Devolucion;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
 * @author david
 */
public class RegistroDevolucionController implements Initializable {

    @FXML
    private ComboBox cbDispositivo;
    @FXML
    private DatePicker dpFechaDevolucion;
    @FXML
    private ComboBox<?> cbPresentaProblema;
    @FXML
    private TextArea textAreaComentarios;
    @FXML
    private Button btCancelar;
    @FXML
    private TextField tfHoraDevolucion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dpFechaDevolucion.setConverter(new LocalDateStringConverter(formatter, null));
        
    }    

    @FXML
    private void guardarDevolucion(ActionEvent event){
        if(!validarCamposVacios()){
            String comentarios = textAreaComentarios.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaDevolucion = dpFechaDevolucion.getValue().format(formatter);
            String horaDevolucion = tfHoraDevolucion.getText();
            Devolucion devolucion = new Devolucion(comentarios, fechaDevolucion, horaDevolucion);

        }
    }
    
    @FXML
    private void cancelarDevolucion(ActionEvent event){
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        stage.close();
    }
    
    private boolean validarCamposVacios(){  
        boolean value=false;
          if(textAreaComentarios.getText().isEmpty() || cbPresentaProblema.getSelectionModel().getSelectedIndex() < 0
             || dpFechaDevolucion.getValue()== null || tfHoraDevolucion.getText().isEmpty()){
              value=true;
          }
          return value;
    }
    
    private void enviarAlertaGuardado(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información guardada");
        alert.setContentText("El prestamo ha sido guardado con exito");
        alert.showAndWait();
    }

    
}

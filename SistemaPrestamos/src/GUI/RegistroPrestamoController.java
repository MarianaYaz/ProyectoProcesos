/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author kari
 */
public class RegistroPrestamoController implements Initializable {

    @FXML TextField tfIdPrestamista;
    @FXML TextField tfNombrePrestamista;
    @FXML TextField tfHora;
    @FXML TextField tfLugar;
    @FXML TextArea taMotivo;
    @FXML DatePicker dpFecha;
    @FXML ComboBox cbDispositivos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dpFecha.setConverter(new LocalDateStringConverter(formatter, null));
    }    
    
}

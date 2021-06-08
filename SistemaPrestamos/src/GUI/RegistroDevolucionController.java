
package GUI;

import businessLogic.DevolucionDAO;
import businessLogic.DispositivoDAO;
import businessLogic.PrestamoDAO;
import domain.Cable;
import domain.Conector;
import domain.ControlProyector;
import domain.Devolucion;
import domain.Dispositivo;
import domain.Laptop;
import domain.Prestamo;
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
import javafx.scene.control.Label;
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
    private ComboBox cbDispositivos;
    @FXML
    private DatePicker dpFechaDevolucion;
    @FXML
    private ComboBox<String> cbPresentaProblema;
    @FXML
    private TextArea textAreaComentarios;
    @FXML
    private Button btCancelar;
    @FXML
    private TextField tfHoraDevolucion;
    @FXML
    private Label lbNombrePrestamista;
    @FXML
    private Label lbFechaPrestamo;
    @FXML
    private Label lbHoraPrestamo;
    @FXML
    private Label lbMotivo;
    
    private String opcionDispositivo;
    private ObservableList<Dispositivo> dispositivos;
    private int idPrestamo;
    private Dispositivo dispositivo;
    @FXML
    private Label lbLugar;
   
    @Override
    public void initialize(URL url, ResourceBundle rb){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dpFechaDevolucion.setConverter(new LocalDateStringConverter(formatter, null));
        dpFechaDevolucion.setValue(LocalDate.now());
        dispositivos = FXCollections.observableArrayList();
        fillComboBoxPresentaProblema();
        mostrarInformacionPrestamo();
    }    

    private void fillComboBoxPresentaProblema(){
        ObservableList<String> listOpciones = FXCollections.observableArrayList("SI","NO");
        cbPresentaProblema.setItems(listOpciones);
    }
    
    @FXML
    private void guardarDevolucion(ActionEvent event){
        if(!validarCamposVacios()){
            String comentarios = textAreaComentarios.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaDevolucion = dpFechaDevolucion.getValue().format(formatter);
            String horaDevolucion = tfHoraDevolucion.getText();
            Devolucion devolucion = new Devolucion(comentarios, fechaDevolucion, horaDevolucion);
            DevolucionDAO devolucionDAO = new DevolucionDAO();
            DispositivoDAO dispositivoDAO = new DispositivoDAO();
            if(cbPresentaProblema.getSelectionModel().getSelectedItem().equals("NO")){ 
                if (devolucionDAO.guardadoDevolucion(devolucion, idPrestamo) && dispositivoDAO.actualizarEstado(dispositivo.getClave(), opcionDispositivo, "Disponible")) {
                    enviarAlertaGuardado();
                    cancelarDevolucion(event);
                }
            }else{
                if (devolucionDAO.guardadoDevolucion(devolucion, idPrestamo) && dispositivoDAO.actualizarEstado(dispositivo.getClave(), opcionDispositivo, "Mantenimiento")) {
                    enviarAlertaGuardado();
                    cancelarDevolucion(event);
                }
            }
        }
    }
    
    private void mostrarInformacionPrestamo(){
        cbDispositivos.setOnAction(e -> {
            dispositivo = (Dispositivo) cbDispositivos.getSelectionModel().getSelectedItem();
            PrestamoDAO prestamoDAO = new PrestamoDAO();
            idPrestamo = prestamoDAO.getIdPrestamoPorClaveDispositivo(dispositivo.getClave(), opcionDispositivo);
            Prestamo prestamo = prestamoDAO.getPrestamoPorId(idPrestamo);
            lbNombrePrestamista.setText(" "+ prestamo.getNombrePrestamista());
            lbFechaPrestamo.setText(" "+prestamo.getFecha());
            lbHoraPrestamo.setText(" "+prestamo.getHora());
            lbMotivo.setText(prestamo.getMotivo());
            lbLugar.setText(" "+prestamo.getLugar());
        });
    }
 
    @FXML
    private void cancelarDevolucion(ActionEvent event){
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        stage.close();
    }
    
    public void initializeDispositivos(String option){   
            opcionDispositivo = option;
            DispositivoDAO dispositivoDAO = new DispositivoDAO();
            switch(option){ 
            case "Cable": ;
                ArrayList <Cable> dispositivosLista = new ArrayList<>();
                dispositivosLista = dispositivoDAO.getCablesPrestados();
                for( int i = 0; i<dispositivosLista.size(); i++){
                  dispositivos.add(dispositivosLista.get(i));
                }
            break;
            
            case "Conector":;
                ArrayList <Conector> dispositivosList = new ArrayList<>();
                dispositivosList = dispositivoDAO.getConectoresPrestados();
                for( int i = 0; i<dispositivosList.size(); i++){
                  dispositivos.add(dispositivosList.get(i));
                }
            break;
            
            case "Control de proyector":;
                ArrayList <ControlProyector> dispositivosListaC = new ArrayList<>();
                dispositivosListaC = dispositivoDAO.getControlesProyectoresPrestados();
                for( int i = 0; i<dispositivosListaC.size(); i++){
                  dispositivos.add(dispositivosListaC.get(i));
                }
            break;
            
            case "Laptop":;
                ArrayList <Laptop> dispositivosListaL = new ArrayList<>();
                dispositivosListaL = dispositivoDAO.getLaptopsPrestadas();
                for( int i = 0; i<dispositivosListaL.size(); i++) {
                  dispositivos.add(dispositivosListaL.get(i));
                }
            break;
            
        }
       cbDispositivos.setItems(dispositivos);
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
        alert.setContentText("La devolución ha sido guardado con exito");
        alert.showAndWait();
    }
 
    
}

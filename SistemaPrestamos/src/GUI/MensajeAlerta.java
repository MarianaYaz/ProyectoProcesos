
package GUI;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MensajeAlerta {
    @FXML
    public  void mostrarMensajeCamposInvalidos(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información invalida");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
     public  void mostrarMensajeGuardadoExito(String message){    
    
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información guardada");
        alert.setContentText(message + " ha sido guardado con exito");
        alert.showAndWait();
    }
    


}

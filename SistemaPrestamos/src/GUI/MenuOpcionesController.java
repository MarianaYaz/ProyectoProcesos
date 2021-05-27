
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuOpcionesController implements Initializable {

    @FXML Button btRegistrarEncargado;
    @FXML Button btRegistrarPrestamo;
    @FXML Button btRegistrarDevolucion;
    @FXML Button btSalir;
    String tipo;

    @FXML  
    private void registrarEncargado(ActionEvent actionEvent){
        try{ 
            Stage primaryStage= new Stage();
            URL url = new File("src/GUI/RegistroEncargado.fxml").toURI().toURL();
           try{
              FXMLLoader loader = new FXMLLoader(url);
              loader.setLocation(url);
              loader.load();
              RegistroEncargadoController RegistroEncargadoController =loader.getController();      
              Parent root = loader.getRoot();
              Scene scene = new Scene(root);
              primaryStage.setScene(scene);       
            } catch (IOException ex) {
              Logger.getLogger(MenuOpcionesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            primaryStage.show();
       } catch (MalformedURLException ex) {
           Logger.getLogger(MenuOpcionesController.class.getName()).log(Level.SEVERE, null, ex);
       }       
    }
    
     @FXML  
    private void registrarPrestamo(ActionEvent actionEvent){
         try{ 
            Stage primaryStage= new Stage();
            URL url = new File("src/GUI/DispositivoPrestar.fxml").toURI().toURL();
           try{
              FXMLLoader loader = new FXMLLoader(url);
              loader.setLocation(url);
              loader.load();
              DispositivoPrestarController dispositivoPrestarController =loader.getController();      
              Parent root = loader.getRoot();
              Scene scene = new Scene(root);
              primaryStage.setScene(scene);       
            } catch (IOException ex) {
              Logger.getLogger(MenuOpcionesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            primaryStage.show();
       } catch (MalformedURLException ex) {
           Logger.getLogger(MenuOpcionesController.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    
     @FXML  
    private void registrarDevolucion(ActionEvent actionEvent){}
    
     @FXML  
    private void salir(ActionEvent actionEvent){
        Stage stage = (Stage) btSalir.getScene().getWindow();
        stage.close();
    }
    
    public void inicializarTipo(String tipo){
        this.tipo = tipo;
        if(tipo.equals("Encargado")){
             btRegistrarEncargado.setDisable(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import businessLogic.CredencialDAO;
import businessLogic.EncargadoDAO;
import domain.Credencial;
import domain.Encargado;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mariana
 */
public class InicioSesionController implements Initializable {
    @FXML PasswordField pfContrasenia;
    @FXML TextField tfCorreo;
    @FXML Button btIniciar;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
    
    @FXML 
    public void iniciar(){
       String contrasenia = "";
       String correo = "";
       Blob contraseniaBlob = null;
       correo = tfCorreo.getText();
       contrasenia = pfContrasenia.getText();
       correo = tfCorreo.getText();
       Validacion validacion = new Validacion();
       contraseniaBlob = validacion.convertirContrasenia(contrasenia);
       Credencial credencial = new Credencial(correo,contraseniaBlob);
       CredencialDAO credencialDAO = new CredencialDAO();
       Credencial credencialRecuperada = credencialDAO.buscarCredencial(credencial);
       if(verificarCredenciales(credencialRecuperada,credencial)){
                Stage primaryStage= new Stage();
            try{
            URL url = new File("src/GUI/MenuOpciones.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            loader.setLocation(url);
            loader.load();
            MenuOpcionesController menuPrincipal = loader.getController();
            menuPrincipal.inicializarTipo(credencialRecuperada.getTipo());
            Parent root = loader.getRoot();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            Stage stage = (Stage) btIniciar.getScene().getWindow();
            stage.close();
            primaryStage.show();
            }catch (IOException ex) {
            Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    
     public boolean verificarCredenciales(Credencial credencialRecuperada, Credencial credencial){
         boolean value = true;
         if(credencialRecuperada == null){
             value = false;
         }else
         if(!credencialRecuperada.getContrasenia().equals(credencial.getContrasenia())
                 &&!credencialRecuperada.getCorreo().equals(credencial.getCorreo())){
             value = false;
         }     
         return value;
     }  
    
}

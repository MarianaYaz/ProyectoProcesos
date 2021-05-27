/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaprestamos;

import GUI.RegistroDevolucionController;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mariana
 */
public class SistemaPrestamos extends Application {
    
    @Override
   public void start(Stage primaryStage) {
        
        try{
            
            URL url = new File("src/GUI/RegistroDevolucion.fxml").toURI().toURL();
            try{
                FXMLLoader loader = new FXMLLoader(url);
                loader.setLocation(url);
                loader.load();
                RegistroDevolucionController registroDevolucionController =loader.getController();
                Parent root = loader.getRoot();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                
            } catch (IOException ex) {
               Logger.getLogger(SistemaPrestamos.class.getName()).log(Level.SEVERE, null, ex);

            }
            primaryStage.show();
            
        } catch (MalformedURLException ex) {
               Logger.getLogger(SistemaPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

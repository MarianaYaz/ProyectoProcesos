package sistemaprestamos;


import GUI.MenuOpcionesController;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SistemaPrestamos extends Application {
    
    
    public void start(Stage primaryStage) {
        
        try{
            
            URL url = new File("src/GUI/MenuOpciones.fxml").toURI().toURL();
            try{
                FXMLLoader loader = new FXMLLoader(url);
                loader.setLocation(url);
                loader.load();
                MenuOpcionesController menuOpcionesController =loader.getController();
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
        
    public static void main(String[] args){
        launch(args);
    }

    
}

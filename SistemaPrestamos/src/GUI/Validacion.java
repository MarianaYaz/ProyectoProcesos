
package GUI;

import dataAccess.ConnectorDB;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
     public boolean validarCorreo(String email){      
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
     
    public Blob convertirContrasenia(String contrasenia){
         Blob blobData = null;
         try {
             ConnectorDB db = new ConnectorDB();
             Connection dbConnection = db.getConnection();
             byte[] byteData = contrasenia.getBytes("UTF-8");
             blobData = dbConnection.createBlob();
             blobData.setBytes(1, byteData);
         } catch (SQLException ex) {
             Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
         } catch (UnsupportedEncodingException ex) {
             Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
         }
    return blobData;
  }
}   

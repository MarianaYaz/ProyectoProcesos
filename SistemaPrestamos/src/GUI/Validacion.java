
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
    public boolean validarCurp(String curp){
        Pattern pattern = Pattern.compile("^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$");
        Matcher mather = pattern.matcher(curp);
        return mather.find();
    }
    
    public boolean validarCampo(String name){ 
        Pattern pattern = Pattern.compile("[0-9!#$%&'*+/=?^_`{|}~-]");
        Matcher mather = pattern.matcher(name);
        return !mather.find();
    }
     
}   

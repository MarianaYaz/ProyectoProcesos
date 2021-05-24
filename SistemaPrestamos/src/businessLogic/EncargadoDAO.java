
package businessLogic;

import dataAccess.ConnectorDB;
import domain.Encargado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncargadoDAO implements IEncargado {
    @Override
    public boolean registrarEncargado(Encargado encargado) {
        boolean saveSuccess = false;
        try {  
            try { 
            ConnectorDB connectorDataBase = new ConnectorDB();
            Connection connectionDataBase;
           
                connectionDataBase = connectorDataBase.getConnection();
           
            
            
            PreparedStatement insertStatment;
            insertStatment = connectionDataBase.prepareStatement("INSERT INTO Encargado(curp,nombre,numPersonal,turno) VALUES(?,?,?,?) ");
            insertStatment.setString(1, encargado.getCurp());
            insertStatment.setString(2,  encargado.getNombre());
            insertStatment.setString(3, encargado.getNumeroPersonal());
            insertStatment.setString(4, encargado.getTurno());
            
            insertStatment.executeUpdate();
            
            connectorDataBase.disconnect();
            saveSuccess = true;
             } catch (SQLException ex) {
            Logger.getLogger(EncargadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return saveSuccess;
             } catch (ClassNotFoundException ex) {
                Logger.getLogger(EncargadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        return saveSuccess;
    } 
}

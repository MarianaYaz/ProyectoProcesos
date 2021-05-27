/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.ConnectorDB;
import domain.Credencial;
import domain.Encargado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariana
 */
public class CredencialDAO {
       public boolean registrarCredencial(Credencial credencial) {
        boolean saveSuccess = false;
        try {  
            try { 
            ConnectorDB connectorDataBase = new ConnectorDB();
            Connection connectionDataBase;
            connectionDataBase = connectorDataBase.getConnection();   
            PreparedStatement insertStatment;
            insertStatment = connectionDataBase.prepareStatement("INSERT INTO Credenciales(correoElectronico,contrasenia,tipo) VALUES(?,?,?) ");
            insertStatment.setString(1, credencial.getCorreo());
            insertStatment.setBlob(2, credencial.getContrasenia());
            insertStatment.setString(3, credencial.getTipo());
            
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
    
   public String buscarCorreo(Credencial credencial) {
        String curp = "";
        try{
            ConnectorDB connectorDataBase=new ConnectorDB();
            Connection connectionDataBase = connectorDataBase.getConnection();
            ResultSet resultSet;
            PreparedStatement preparedStatement = connectionDataBase.prepareStatement("SELECT correoElectronico from Credenciales where correoElectronico=? ");
            preparedStatement.setString(1, credencial.getCorreo());          
            
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                curp = resultSet.getString("correoElectronico");
            }
                connectorDataBase.disconnect();
                
        }catch(SQLException exe) {
            Logger.getLogger(EncargadoDAO.class.getName()).log(Level.SEVERE, null, exe);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EncargadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return curp;
    } 
}

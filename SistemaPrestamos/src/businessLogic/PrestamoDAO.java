/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.ConnectorDB;
import domain.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kari
 */
public class PrestamoDAO {
    
    
    
    /* CREATE TABLE IF NOT EXISTS Prestamo (idPrestamo int NOT NULL auto_increment, idPrestamista varchar(10) not null,
 nombrePrestamista varchar(80) not null, fechaPrestamo varchar(15) not null, motivo varchar( 100) not null, horaPrestamo varchar(5) not null,
 lugarPrestamo varchar(50), idDevolucion int not null, primary key (idPrestamo),
 foreign key (idDevolucion) REFERENCES Devolucion (idDevolucion));*/
    public boolean guardadoExitoso(Prestamo prestamo)  {
        boolean value=false;
            try {
                ConnectorDB connectorDataBase=new ConnectorDB();
                Connection connectionDataBase = connectorDataBase.getConnection();
                String insertGroupAcademic = "INSERT INTO CuerpoAcademico(clave,nombre, objetivo, mision , vision , gradoConsolidacion) VALUES (?,?,?,?,?,?)";
            
                PreparedStatement preparedStatement = connectionDataBase.prepareStatement(insertGroupAcademic);
                
               /* preparedStatement.setString(1,);
                preparedStatement.setString(2,);
                preparedStatement.setString(3);
                preparedStatement.setString(4);
                preparedStatement.setString(5);
                preparedStatement.setString(6);*/
                
                
                preparedStatement.executeUpdate();
                connectorDataBase.disconnect();
                value=true;
            } catch (SQLException sqlException) {
               // throw new BusinessException("DataBase connection failed ", sqlException);
            } catch (ClassNotFoundException ex) {
              // Log.logException(ex);
            }
        return value;
    }
}

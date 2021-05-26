
package businessLogic;

import dataAccess.ConnectorDB;
import domain.Cable;
import domain.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PrestamoDAO {
    
    

    public int recuperarId(Prestamo prestamo)  {
        boolean value=false;
        int id=0;
         try {   
                ConnectorDB connectorDataBase=new ConnectorDB();
                Connection connectionDataBase;
                connectionDataBase = connectorDataBase.getConnection();
        
                String insertGroupAcademic = "Select * from  Prestamo where idPrestamista=? and nombrePrestamista=? and fechaPrestamo=? and motivo=? horaPrestamo=? and lugarPrestamo=?";
            
                PreparedStatement preparedStatement;
        
             preparedStatement = connectionDataBase.prepareStatement(insertGroupAcademic);
                
                preparedStatement.setString(1,prestamo.getIdPrestamista());
                preparedStatement.setString(2,prestamo.getNombrePrestamista());
                preparedStatement.setString(3,prestamo.getFecha());
                preparedStatement.setString(4,prestamo.getMotivo());
                preparedStatement.setString(5,prestamo.getHora());
                preparedStatement.setString(6,prestamo.getLugar());
                
                
                preparedStatement.executeUpdate();
                connectorDataBase.disconnect();
                value=true;
                } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return id;
    }
    


    
     public int  getId(Prestamo prestamo){
        int id = 0;
        try{
            ConnectorDB connectorDataBase = new ConnectorDB();
            Connection connectionDataBase = connectorDataBase.getConnection();
            String query="SELECT idPrestamo FROM Prestamo where idPrestamista=? and nombrePrestamista=? and horaPrestamo=? and fechaPrestamo=? and lugarPrestamo=?";

               PreparedStatement preparedStatement;
               preparedStatement = connectionDataBase.prepareStatement(query);
               ResultSet resultSet;
               preparedStatement.setString(1,prestamo.getIdPrestamista());
                preparedStatement.setString(2,prestamo.getNombrePrestamista());
                preparedStatement.setString(3,prestamo.getHora());
                preparedStatement.setString(6,prestamo.getLugar());
                resultSet = preparedStatement.executeQuery();
                               
               while(resultSet.next()){
                     id=resultSet.getInt(1);
                }
                connectorDataBase.disconnect();
            }catch(SQLException sqlException) {
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, sqlException);

            }catch(ClassNotFoundException ex) {
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return id;
        }
     public boolean guardadoExitoso(Prestamo prestamo)  {
        boolean value=false;
         try {   
                ConnectorDB connectorDataBase=new ConnectorDB();
                Connection connectionDataBase;
                connectionDataBase = connectorDataBase.getConnection();
        
                String insert = "INSERT INTO Prestamo(idPrestamista,nombrePrestamista, fechaPrestamo, motivo, horaPrestamo,lugarPrestamo) VALUES (?,?,?,?,?,?)";
            
                PreparedStatement preparedStatement;
        
             preparedStatement = connectionDataBase.prepareStatement(insert);
                
                preparedStatement.setString(1,prestamo.getIdPrestamista());
                preparedStatement.setString(2,prestamo.getNombrePrestamista());
                preparedStatement.setString(3,prestamo.getFecha());
                preparedStatement.setString(4,prestamo.getMotivo());
                preparedStatement.setString(5,prestamo.getHora());
                preparedStatement.setString(6,prestamo.getLugar());
                
                
                preparedStatement.executeUpdate();
                connectorDataBase.disconnect();
                value=true;
                } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return value;
    }
    
   
    
     public boolean guardadoDispositivo(Prestamo prestamo, String option)  {
        boolean value=false;
         try {   
                ConnectorDB connectorDataBase=new ConnectorDB();
                Connection connectionDataBase;
                connectionDataBase = connectorDataBase.getConnection();
                String insert;
                
                    insert = "INSERT INTO PrestamoCable(idPrestamo,claveDispositivo)";
            
                PreparedStatement preparedStatement;
        
             preparedStatement = connectionDataBase.prepareStatement(insert);
                
                preparedStatement.setInt(1,prestamo.getIdPrestamo());
                preparedStatement.setString(2, prestamo.getDispositivo().getClave());
                
                
                preparedStatement.executeUpdate();
                connectorDataBase.disconnect();
                value=true;
                } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return value;
    }
     
    public ArrayList<Prestamo>  getPrestamos(){
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
        try{
            ConnectorDB connectorDataBase = new ConnectorDB();
            Connection connectionDataBase = connectorDataBase.getConnection();
            String query="SELECT * FROM Prestamo";

               PreparedStatement preparedStatement;
               preparedStatement = connectionDataBase.prepareStatement(query);
               ResultSet resultSet;
               resultSet = preparedStatement.executeQuery();
                               
               while(resultSet.next()){
                    int clave=resultSet.getInt(1);
                    String idPrestamista = resultSet.getString("idPrestamista");
                    String nombrePrestamista = resultSet.getString("nombrePrestamista");
                    String fechaPrestamo= resultSet.getString("fechaPrestamo");
                    String motivo= resultSet.getString("motivo");
                    String horaPrestamo=resultSet.getString("horaPrestamo");
                    String lugarPrestamo = resultSet.getString("lugarPrestamo");
                    Prestamo prestamo = new Prestamo(idPrestamista,nombrePrestamista, fechaPrestamo, motivo,lugarPrestamo, horaPrestamo);

                    prestamos.add(prestamo);
                }
                connectorDataBase.disconnect();
            }catch(SQLException sqlException) {
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, sqlException);

            }catch(ClassNotFoundException ex) {
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return prestamos;
        }
}

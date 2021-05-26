
package businessLogic;

import dataAccess.ConnectorDB;
import domain.Cable;
import domain.Conector;
import domain.ControlProyector;
import domain.Laptop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DispositivoDAO {
    
    
    public boolean actualizarEstado(String clave, String tipo, String estado){
        boolean value=false;
         try {   
                ConnectorDB connectorDataBase=new ConnectorDB();
                Connection connectionDataBase;
                connectionDataBase = connectorDataBase.getConnection();
                String insert="";
            switch(tipo){ 
                case "Cable": ;
                    insert = "UPDATE Cable set estado=?, where clave=?";   
                break;

                case "Conector":;
                  insert = "UPDATE Conector set estado=?, where clave=?";   

                break;

                case "Control de proyector":;
                    insert = "UPDATE ControlProyector set estado=?, where clave=?";   

                break;

                case "Laptop":;
                    insert = "UPDATE Laptop set estado=?, where clave=?";   

                break;
            
         }           
         PreparedStatement preparedStatement;
         preparedStatement = connectionDataBase.prepareStatement(insert);               
         preparedStatement.setString(1,estado);
         preparedStatement.setString(2, clave);               
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
    
    public ArrayList<Cable> getCables(){
        ConnectorDB connectorDataBase=new ConnectorDB();
        String sql = "SELECT * FROM Cable";
        ArrayList<Cable> cables = new ArrayList<>();
        try {
            Connection connectionDataBase = connectorDataBase.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connectionDataBase.prepareStatement(sql);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                String estado = resultSet.getString("estado");
                if(estado.equals("Disponible")){
                    String clave = resultSet.getString("clave");
                    String fechaRegistro = resultSet.getString("fechaRegistro");
                    String descripcion = resultSet.getString("descripcion");
                    String tipo = resultSet.getString("tipo");
                    Cable cable = new Cable(tipo, clave, descripcion, fechaRegistro, estado);
                    cables.add(cable);
                }
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cables;
    } 
    
    public ArrayList<Conector> getConectores(){
        ConnectorDB connectorDataBase=new ConnectorDB();
        String sql = "SELECT * FROM Conector";
        ArrayList<Conector> conectores = new ArrayList<>();
        try {
            Connection connectionDataBase = connectorDataBase.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connectionDataBase.prepareStatement(sql);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                String estado = resultSet.getString("estado");
                if(estado.equals("Disponible")){
                    String clave = resultSet.getString("clave");
                    String fechaRegistro = resultSet.getString("fechaRegistro");
                    String descripcion = resultSet.getString("descripcion");
                    String tipo = resultSet.getString("tipo");
                    Conector conector = new Conector(tipo, clave, descripcion, fechaRegistro, estado);
                    conectores.add(conector);
                }
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conectores;
    }
    
    public ArrayList<ControlProyector> getControlesProyectores(){
        ConnectorDB connectorDataBase=new ConnectorDB();
        String sql = "SELECT * FROM ControlProyector";
        ArrayList<ControlProyector> controlesProyectores = new ArrayList<>();
        try {
            Connection connectionDataBase = connectorDataBase.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connectionDataBase.prepareStatement(sql);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                String estado = resultSet.getString("estado");
                if(estado.equals("Disponible")){
                    String clave = resultSet.getString("clave");
                    String fechaRegistro = resultSet.getString("fechaRegistro");
                    String descripcion = resultSet.getString("descripcion");
                    String marca = resultSet.getString("marca");
                    String salaAsignada = resultSet.getString("salaAsignada");
                    ControlProyector controlProyector = new ControlProyector(marca, salaAsignada, clave, descripcion, fechaRegistro, estado);
                    controlesProyectores.add(controlProyector);
                }
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controlesProyectores;
    }
    
    public ArrayList<Laptop> getLaptops(){
        ConnectorDB connectorDataBase=new ConnectorDB();
        String sql = "SELECT * FROM Conector";
        ArrayList<Laptop> laptops = new ArrayList<>();
        try {
            Connection connectionDataBase = connectorDataBase.getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connectionDataBase.prepareStatement(sql);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                String estado = resultSet.getString("estado");
                if(estado.equals("Disponible")){
                    String clave = resultSet.getString("clave");
                    String fechaRegistro = resultSet.getString("fechaRegistro");
                    String descripcion = resultSet.getString("descripcion");
                    String marca = resultSet.getString("marca");
                    String modelo = resultSet.getString("modelo");
                    Laptop laptop = new Laptop(marca, modelo, clave, descripcion, fechaRegistro, estado);
                    laptops.add(laptop);
                }
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laptops;
    }
   
}

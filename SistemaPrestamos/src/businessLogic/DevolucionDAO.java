
package businessLogic;

import dataAccess.ConnectorDB;
import domain.Devolucion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class DevolucionDAO implements IDevolucionDAO{

    @Override
    public boolean guardadoDevolucion(Devolucion devolucion) {
        boolean resultadoGuardado = false;
        try {
            ConnectorDB connectorDataBase=new ConnectorDB();
            Connection connectionDataBase = connectorDataBase.getConnection();
            String sql = "INSERT INTO devolucion(horaDevolucion, fechaDevolucion, comentario, idPrestamo) VALUE (?,?,?,?)";
            PreparedStatement preparedStatement = connectionDataBase.prepareStatement(sql);
            preparedStatement.setString(1, devolucion.getHoraDevolucion());
            preparedStatement.setString(2, devolucion.getFechaDevolucion());
            preparedStatement.setString(3, devolucion.getComentario());
            //preparedStatement.setInt(4, devolucion.getPrestamo().getIdPrestamo());
            preparedStatement.executeUpdate();
            connectorDataBase.disconnect();
            resultadoGuardado = true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DevolucionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoGuardado;
    }
    
}


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
public class DevolucionDAO {
    
    public boolean guardadoDevolucion(Devolucion devolucion, int idPrestamo){
        boolean value=false;
        try {
            ConnectorDB connectorDataBase = new ConnectorDB();
            Connection connectionDataBase;
            connectionDataBase = connectorDataBase.getConnection();

            String insert = "INSERT INTO Devolucion(horaDevolucion,fechaDevolucion,comentario,idPrestamo) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement;
            preparedStatement = connectionDataBase.prepareStatement(insert);
            preparedStatement.setString(1, devolucion.getHoraDevolucion());
            preparedStatement.setString(2, devolucion.getFechaDevolucion());
            preparedStatement.setString(3, devolucion.getComentario());
            preparedStatement.setInt(4, idPrestamo);
            preparedStatement.executeUpdate();
            connectorDataBase.disconnect();
            value = true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }
}

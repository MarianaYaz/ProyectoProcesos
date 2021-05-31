
package dataAccess;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectorDB {
    private Connection connection;
        private String url;
        private String userName;
        private String userPassword;

        private void inicializar(){ 
            Properties properties = new Properties();
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream("./Datos.properties");
                properties.load(fileInputStream);
            } catch (IOException ex) {
                 Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);

            }
            url = properties.getProperty("url");
            userName = properties.getProperty("user");
            userPassword = properties.getProperty("password");
        }

        public void connect() throws ClassNotFoundException {

                connection = null;  
                inicializar();
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                try { 
                      this.connection = DriverManager.getConnection(url, userName, userPassword);
                 } catch (SQLException ex) {
                    Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
                 }
        } 

        public Connection getConnection() throws ClassNotFoundException {
                connect();
                return connection;
        }

        public void disconnect() {
                if(connection != null) {
                    try {
                        if (!connection.isClosed()) {
                            connection.close(); 
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
        }
}

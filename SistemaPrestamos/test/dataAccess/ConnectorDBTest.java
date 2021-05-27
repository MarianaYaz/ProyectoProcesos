
package dataAccess;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectorDBTest {
    
    public ConnectorDBTest() {
    }

    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        ConnectorDB instance = new ConnectorDB();
        instance.connect();
        assertNotNull(instance.getConnection());

    }

    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        ConnectorDB instance = new ConnectorDB();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testDisconnect() {
        System.out.println("disconnect");
        ConnectorDB instance = new ConnectorDB();
        instance.disconnect();
    }
}

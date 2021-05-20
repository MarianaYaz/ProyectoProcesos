
package dataAccess;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectorDBTest {

    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        ConnectorDB instance;
        instance = new ConnectorDB();
        assertNotNull(instance.getConnection());
    }

    @Test
    public void testDisconnect() throws Exception {
        System.out.println("disconnect");
        ConnectorDB instance = new ConnectorDB();
        instance.disconnect();
    }
}



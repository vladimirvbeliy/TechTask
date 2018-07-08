package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

@Deprecated
public class JDBCTest {

    public static void main(String...arg){
        // Avoid WARN: disable SSL by setting useSSL=false
        String jdbcUrl = "jdbc:mysql://localhost:3307/tech_task?useSSL=false";
        String user = "test";
        String pass = "test";

		try {
        System.out.println("Connecting to database: " + jdbcUrl);

        Connection myConn =
                DriverManager.getConnection(jdbcUrl, user, pass);

        System.out.println("Connection successful");

    }catch (Exception exc) {
        exc.printStackTrace();
    }
    }

}

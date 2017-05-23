
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnectorMysql {

    private static String id = "root";						
    private static String pw = "root";
 
    public Connection getConnection() {
        Connection con = null;
        try {
            System.out.println("Mysql DBconnector - 1");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testtest", id, pw);
            System.out.println("Mysql DBconnector - 2");

        } catch (Exception e) {
            System.out.println("error in Mysql DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
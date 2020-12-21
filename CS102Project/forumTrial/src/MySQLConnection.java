import java.sql.*;
import com.mysql.jdbc.Driver;


public class MySQLConnection {
    Connection myConn;
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/forum?serverTimezone=UTC";

        String user = "root";
        String pass = "18273645";

        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection myConn = (Connection) DriverManager.getConnection(url, user, pass);

        return myConn;
    }
}

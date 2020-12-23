package forum;

import java.sql.*;
//import com.mysql.jdbc.Driver;


public class MySQLConnection {
    Connection myConn;
    public static Connection getConnection() throws Exception {
    	Class.forName("com.mysql.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost:3306/user_info?characterEncoding=utf8";

        String user = "root";
        String pass = "271099";

        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection myConn = (Connection) DriverManager.getConnection(url, user, pass);

        return myConn;
    }
}

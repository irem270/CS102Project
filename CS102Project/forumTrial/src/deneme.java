import java.sql.*;

public class deneme {

    public static void main(String[] args){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/forum?serverTimezone=UTC";

        String user = "root";
        String pass = "18273645";



        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement st = conn.createStatement();
            st.executeUpdate("Insert into users " + "(id,username,password)" + "values(555,'seyfi',12345)");
            System.out.println("All good...");
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

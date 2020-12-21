/***import java.sql.*;

public class forum1 {

    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/forum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static final String user = "root";
    static final String pass = "12345678";


    public static void main(String[] args){

        Connection conn = null;
        Statement st = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url,user,pass);

            System.out.println("Creating a database...");
            st = conn.createStatement();
            String sql = "CREATE DATABASE REGISTRATION";
            st.executeUpdate(sql);
            System.out.println("Database crated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(st != null)
                    st.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        //while()
        //System.out.println("Goodbye...");
    }
}
 */
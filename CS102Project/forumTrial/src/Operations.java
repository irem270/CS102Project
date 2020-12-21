import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operations {
    public static boolean IsLogIn(String username, String pass,JFrame frame) {
        try{
            Connection myConn = MySQLConnection.getConnection();
            String MySQLQuerry = "SELECT * from users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = myConn.prepareStatement(MySQLQuerry);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,pass);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Done");

            while(rs.next()){
                LogIn.ID = rs.getInt("id");
                LogIn.username = rs.getString("username");

                return true;
            }

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(frame,"Database errors: " + ex.getMessage() );
        }
        return false;
    }

}

package forum;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operations {
    public  boolean IsLogIn(String username, String pass) {
        try{
            Connection myConn = MySQLConnection.getConnection();
            String MySQLQuerry = "SELECT * from users WHERE name = ? AND password = ?";
            PreparedStatement preparedStatement = myConn.prepareStatement(MySQLQuerry);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,pass);
            ResultSet rs = preparedStatement.executeQuery();
      

            while(rs.next()){
                LogIn.ID = rs.getInt("id");
                LogIn.name = rs.getString("name");
     
                return true;
            }

        }
        catch(Exception ex){
//            JOptionPane.showMessageDialog(panel,"Database errors: " + ex.getMessage() );
        }
        return false;
    }

}

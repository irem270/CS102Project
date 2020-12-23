package forum;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operations {
	public boolean IsLogIn(String username, String pass) {
		try {
			Connection myConn = MySQLConnection.getConnection();
			String MySQLQuerry = "SELECT * from user_info WHERE name = ? AND id = ?";
			PreparedStatement preparedStatement = myConn.prepareStatement(MySQLQuerry);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				LogIn.mail = rs.getString("mail");
				LogIn.name = rs.getString("name");

				return true;
			}

		} catch (Exception ex) {
//            JOptionPane.showMessageDialog(panel,"Database errors: " + ex.getMessage() );
		}
		return false;
	}

	public static int getPassword(String email) {
		try {
			Connection myConn = MySQLConnection.getConnection();
			String MySQLQuerry = "SELECT * from user_info WHERE mail = ?";
			PreparedStatement preparedStatement = myConn.prepareStatement(MySQLQuerry);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				LogIn.mail = rs.getString("mail");
				LogIn.password = rs.getInt("id");

			}

		} catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"Database errors: " + ex.getMessage() );
		}
		return LogIn.password;
	}

}

package forum;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			JOptionPane.showMessageDialog(null, "Database errors: " + ex.getMessage());
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
				return LogIn.password;
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Database errors: " + ex.getMessage());
		}
		return -1;
	}

	public static boolean changePassword(int password) {
		Connection con;
		try {
			con = (Connection) MySQLConnection.getConnection();
			String query = "update user_info set id = " + password + " where name = '" + UserInfo.getName() + "'";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// execute the java preparedstatement
			preparedStmt.executeUpdate();

			con.close();
			JOptionPane.showMessageDialog(null, "Password updated successfully.");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// create the java mysql update preparedstatement

	}

	public static boolean isUnique(String name) {
		try {
			Connection myConn = MySQLConnection.getConnection();
			String MySQLQuerry = "SELECT * from user_info WHERE name = ?";
			PreparedStatement preparedStatement = myConn.prepareStatement(MySQLQuerry);
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				if (rs.getString("name").equals(name))
					return false;
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Database errors: " + ex.getMessage());
		}
		return true;
	}

	public static void createTable() {
		int count = 1;
		String str = "forum_page";
		StringBuilder builder = new StringBuilder();
		builder.append(count);
		builder.append(str);
		try {
			Connection myConn = MySQLConnection.getConnection();
			// String MySQLQuerry = "CREATE TABLE IF NOT EXISTS " + Integer.toString(count)
			// + ".forumpage (newmessage varchar(140), date varchar(140))";
			PreparedStatement create = myConn.prepareStatement("CREATE TABLE IF NOT EXISTS " + builder
					+ " (newmessage VARCHAR(140) NOT NULL, date VARCHAR(140) NOT NULL)");
			create.executeUpdate();
			count++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

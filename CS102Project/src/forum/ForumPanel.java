package forum;

import javax.swing.JPanel;

import emptyData.Style;
import forum.Operations;
import forum.UserInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForumPanel extends JPanel {

	int count = 1;
	int pageCount = 1;
	JButton send;
	private static JTextArea mess;
	public static JTextField entry;
	private Style style;
	Connection conn = null;
	Statement st = null;
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/forum?characterEncoding=utf8";

	static final String user = "root";
	static final String pass = "271099";

	public ForumPanel(Style style) {

		this.style = style;
		this.setName("forumPanel");

		send = new JButton("Send");
		send.setBounds(166, 127, 149, 51);
		send.addActionListener(new senderActionListener());

		entry = new JTextField();
		entry.setEditable(true);
		entry.setPreferredSize(new Dimension(200, 100));

		mess = new JTextArea();
		mess.setEditable(false);
		mess.setPreferredSize(new Dimension(620, 320));
		Operations.createTable();
		messages();

		add(entry);
		add(send);
		add(mess);
	}

	public class senderActionListener implements ActionListener {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String MySQLDate = date.toString();
		java.util.Date date2 = new java.util.Date();

		java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(date2.getTime());

		@Override
		public void actionPerformed(ActionEvent e) {
			if(entry.getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Please write something.." , "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			String message = "from : " + UserInfo.getName() + "\n" + entry.getText().toString();
			entry.setText("");
			if (messages() > 6) {
				Operations.createTable();
				pageCount++;
				count = 1;
			}

			try {
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement st = conn.createStatement();
				st.executeUpdate("Insert into " + Integer.toString(pageCount) + "forum_page (newmessage,date)"
						+ "values('" + message + "','" + sqlDate + "')");
				mess.append(sqlDate + "\n" + message);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
		}
	}

	public int messages() {
		String str = "forum_page";
		StringBuilder builder1 = new StringBuilder();
		builder1.append(pageCount);
		builder1.append(str);
		try {
			Connection myConn = DriverManager.getConnection(url, user, pass);
			String MySQLQuerry = "SELECT * from " + builder1;
			PreparedStatement preparedStatement = myConn.prepareStatement(MySQLQuerry);
			ResultSet rs = preparedStatement.executeQuery(MySQLQuerry);
			StringBuilder builder = new StringBuilder();
			while (rs.next()) {
//				builder.append(UserInfo.getName());
//				builder.append("\t");
				builder.append(rs.getString("date"));
				builder.append("\n");
				builder.append(rs.getString("newmessage"));
				builder.append("\n");
				builder.append("\n");
			}
			mess.setText(builder.toString());
			count++;

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Database errors: " + ex.getMessage());
		}
		return count;
	}
}

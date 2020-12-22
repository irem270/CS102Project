package forum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.*;
import java.sql.*;

public class RegisterPanel extends JPanel {

	JButton register;
	JLabel nameLabel, passLabel, idLabel;
	JTextField userName, Id;
	JPasswordField password;
	Connection conn = null;
	Statement st = null;
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/users?characterEncoding=utf8";

	static final String user = "root";
	static final String pass = "271099";

	public RegisterPanel() {
		this.setName("registerPanel");

		register = new JButton("Register");
		register.setBounds(166, 127, 149, 51);
		register.addActionListener(new registerActionListener());

		nameLabel = new JLabel();
		nameLabel.setText("name");

		idLabel = new JLabel();
		idLabel.setText("id");

		passLabel = new JLabel();
		passLabel.setText("password");

		userName = new JTextField("");
		userName.setPreferredSize(new Dimension(100, 30));

		password = new JPasswordField("");
		password.setPreferredSize(new Dimension(100, 30));

		Id = new JTextField("");
		Id.setPreferredSize(new Dimension(100, 30));

		add(nameLabel);
		add(userName);
		add(idLabel);
		add(Id);
		add(passLabel);
		add(password);
		add(register);
	}

	public boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	public class registerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = userName.getText();
			String ID = Id.getText();
			String pass1 = password.getText();

			userName.setText("");
			password.setText("");
			Id.setText("");

			if (!isInteger(ID)) {
				JOptionPane.showMessageDialog(null, "ID and Password must be integer");
			} else if (!isInteger(pass1)) {
				JOptionPane.showMessageDialog(null, "ID and Password must be integer");
			} else {

				int id = Integer.parseInt(ID);
				int pss = Integer.parseInt(pass1);

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, user, pass);
					Statement st = conn.createStatement();
					st.executeUpdate("Insert into users " + "(id,name,password)" + "values(" + id + ",'" + name + "',"
							+ pass1 + ")");
					JPanel cardLayoutPanel = (JPanel) getParent();
					CardLayout layout = (CardLayout) cardLayoutPanel.getLayout();
					layout.show(cardLayoutPanel, "menu");
					JOptionPane.showMessageDialog(null, "Successfully Registered");
				} catch (SQLException | ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}

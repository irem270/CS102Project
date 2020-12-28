package forum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class RegisterPanel extends JPanel {

	JButton register;
	JLabel nameLabel, passLabel, idLabel;
	JTextField userName, Id;
	JPasswordField password;
	Connection conn = null;
	Statement st = null;
	JPanel nameP, idP, passP;
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/user_info?characterEncoding=utf8";

	static final String user = "root";
	static final String pass = "271099";

	public RegisterPanel() {
		this.setName("registerPanel");
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(255, 165, 0));
		
		nameP = new JPanel();
		nameP.setBackground(new Color(255, 165, 0));
		
		nameLabel = new JLabel();
		nameLabel.setText("Name:");
		nameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		
		userName = new JTextField("");
		userName.setPreferredSize(new Dimension(150, 30));
		
		nameP.add(nameLabel);
		nameP.add(userName);
		nameP.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		idP = new JPanel();
		idP.setBackground(new Color(255, 165, 0));
		
		idLabel = new JLabel();
		idLabel.setText("e-Mail:");
		idLabel.setFont(new Font("Serif", Font.BOLD, 30));
		
		Id = new JTextField("");
		Id.setPreferredSize(new Dimension(150, 30));
		
		idP.add(idLabel);
		idP.add(Id);
		idP.setAlignmentX(Component.CENTER_ALIGNMENT);

		passP = new JPanel();
		passP.setBackground(new Color(255, 165, 0));
		
		passLabel = new JLabel();
		passLabel.setText("Password:");
		passLabel.setFont(new Font("Serif", Font.BOLD, 30));

		password = new JPasswordField("");
		password.setPreferredSize(new Dimension(150, 30));
		
		passP.add(passLabel);
		passP.add(password);
		passP.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		register = new JButton("Register");
		register.setBounds(166, 127, 149, 51);
		register.setFont(new Font("Serif", Font.BOLD, 15));
		register.setAlignmentX(Component.CENTER_ALIGNMENT);
		register.addActionListener(new registerActionListener());
		
		add(Box.createRigidArea(new Dimension(100, 50)));
		add(nameP);
		add(Box.createRigidArea(new Dimension(100, 10)));
		add(idP);
		add(Box.createRigidArea(new Dimension(100, 10)));
		add(passP);
		add(Box.createRigidArea(new Dimension(100, 20)));
		add(register);
		add(Box.createRigidArea(new Dimension(100, 100)));
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
			String mail = Id.getText();
			String pass1 = password.getText();

			userName.setText("");
			password.setText("");
			Id.setText("");

			 if (!isInteger(pass1)) {
				JOptionPane.showMessageDialog(null, "ID and Password must be integer", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (pass1.length() < 6) {
				JOptionPane.showMessageDialog(null, "Password is too short", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int pss = Integer.parseInt(pass1);
				
				UserInfo.setName(name);
				UserInfo.setPassword(pss);

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, user, pass);
					Statement st = conn.createStatement();
					st.executeUpdate("Insert into user_info " + "(name,mail,id)" + "values('" + name + "','" + mail + "',"
							+ pss + ")");
					JPanel cardLayoutPanel = (JPanel) getParent();
					CardLayout layout = (CardLayout) cardLayoutPanel.getLayout();
					layout.show(cardLayoutPanel, "menu");
					JOptionPane.showMessageDialog(null, "Successfully Registered. Welcome " + name);
				} catch (SQLException | ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}

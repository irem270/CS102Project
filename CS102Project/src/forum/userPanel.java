package forum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.*;

public class userPanel extends JPanel implements ActionListener {

	JButton logIn, register;
	JLabel inLabel, regLabel;
	JTextField userName;
	JPasswordField password;
	registerPanel1 r;

	public userPanel() {
		setName("userPanel");

		inLabel = new JLabel();
		inLabel.setText("username");

		regLabel = new JLabel();
		regLabel.setText("Password");

		userName = new JTextField("");
		userName.setPreferredSize(new Dimension(100, 30));

		password = new JPasswordField("");
		password.setPreferredSize(new Dimension(100, 30));

		logIn = new JButton("Log In");
		logIn.setBounds(166, 127, 149, 51);

		register = new JButton("Register");
		register.setBounds(166, 127, 149, 51);

		logIn.addActionListener(this);

		add(inLabel);
		add(userName);
		add(regLabel);
		add(password);
		add(logIn);
		add(register);

		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel cardLayoutPanel = (JPanel) getParent();
				CardLayout layout = (CardLayout) cardLayoutPanel.getLayout();
				layout.show(cardLayoutPanel, "registerPanel");
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Operations operation = new Operations();
		try {
			String usernameStr = userName.getText();
			String passwordStr = password.getText();
			userName.setText("");
			password.setText("");

			if (operation.IsLogIn(usernameStr, passwordStr)) {
				JPanel cardLayoutPanel = (JPanel) getParent();
				CardLayout layout = (CardLayout) cardLayoutPanel.getLayout();
				layout.show(cardLayoutPanel, "menu");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Your username or password is invalid" , "Inane error",
					    JOptionPane.ERROR_MESSAGE);
				
			}
			

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}
	}
}

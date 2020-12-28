package forum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class userPanel extends JPanel implements ActionListener {

	JButton logIn, register, forgot;
	JLabel inLabel, regLabel;
	JTextField userName;
	JPasswordField password;
	JPanel inputPanel;

	public userPanel() {
		setName("userPanel");
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBackground(new Color(0, 128, 255));
		this.setPreferredSize(new Dimension(500, 250));
		
		inputPanel = new JPanel();
		inputPanel.setBackground(new Color(0, 128, 255));

		inLabel = new JLabel();
		inLabel.setFont(new Font("Serif", Font.BOLD, 25));
		inLabel.setText("Username :");
		inLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		regLabel = new JLabel();
		regLabel.setFont(new Font("Serif", Font.BOLD, 25));
		regLabel.setText("Password:");
		regLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		userName = new JTextField("");
		userName.setPreferredSize(new Dimension(150, 30));

		password = new JPasswordField("");
		password.setPreferredSize(new Dimension(150, 30));

		logIn = new JButton("Log In");
		logIn.setFont(new Font("Serif", Font.BOLD, 15));
		logIn.setBounds(166, 127, 149, 51);
		logIn.setAlignmentX(Component.CENTER_ALIGNMENT);

		register = new JButton("Register");
		register.setFont(new Font("Serif", Font.BOLD, 15));
		register.setBounds(166, 127, 149, 51);
		register.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		forgot = new JButton("Forgot password? ");
		forgot.setFont(new Font("Serif", Font.BOLD, 15));
		forgot.setBounds(166, 127, 149, 51);
		forgot.setAlignmentX(Component.CENTER_ALIGNMENT);

		logIn.addActionListener(this);
		
		inputPanel.add(inLabel);
		inputPanel.add(Box.createHorizontalGlue());
		inputPanel.add(userName);
		inputPanel.add(Box.createRigidArea(new Dimension(70, 10)));
		inputPanel.add(regLabel);
		inputPanel.add(Box.createHorizontalGlue());
		inputPanel.add(password);
		
		add(Box.createRigidArea(new Dimension(100, 60)));
		add(inputPanel);
		
		add(Box.createRigidArea(new Dimension(100, 30)));
		add(logIn);
		add(Box.createRigidArea(new Dimension(100, 10)));
		add(register);
		add(Box.createRigidArea(new Dimension(100, 10)));
		add(forgot);
		add(Box.createRigidArea(new Dimension(100, 150)));
		
		
		forgot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel cardLayoutPanel = (JPanel) getParent();
				CardLayout layout = (CardLayout) cardLayoutPanel.getLayout();
				layout.show(cardLayoutPanel, "forgotPanel");
			}
		});

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
				UserInfo.setName(usernameStr);
				UserInfo.setPassword(Integer.parseInt(passwordStr));
			}
			else {
				JOptionPane.showMessageDialog(null, "Your username or password is invalid" , "An error",
					    JOptionPane.ERROR_MESSAGE);
				
			}
			

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());

		}
	}
}

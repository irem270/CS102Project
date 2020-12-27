package forum;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ForgotPanel extends JPanel {
	private JTextField enter;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ForgotPanel() {
		this.setName("forgotPanel");
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(new Color(0, 128, 255));

		add(Box.createRigidArea(new Dimension(100, 70)));

		enter = new JTextField();
		enter.setText(" Enter your email adress");
		enter.setEditable(false);
		enter.setBounds(66, 26, 295, 50);
		enter.setMaximumSize(new Dimension(500, 100));
		enter.setMinimumSize(new Dimension(200, 30));
		enter.setFont(new Font("Serif", Font.BOLD, 25));
		enter.setBackground(new Color(0, 128, 255).brighter());
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(enter);
		enter.setColumns(10);

		add(Box.createRigidArea(new Dimension(100, 10)));

		textField = new JTextField();
		textField.setBounds(66, 57, 295, 30);
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField.setMaximumSize(new Dimension(300, 30));
		textField.setMinimumSize(new Dimension(200, 30));
		add(textField);
		textField.setColumns(10);

		add(Box.createRigidArea(new Dimension(100, 10)));

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(160, 88, 89, 23);
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 15));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnNewButton);

		add(Box.createRigidArea(new Dimension(100, 100)));

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mail = textField.getText().toString();
				if (isValidEmailAddress(mail)) {

					if (ForgetPassword.sendMail(mail)) {
						JOptionPane.showMessageDialog(null, "Please check your mails.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid email!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
}

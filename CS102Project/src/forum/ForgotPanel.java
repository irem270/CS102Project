package forum;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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
		setLayout(null);
		
		enter = new JTextField();
		enter.setText("enter your email adress");
		enter.setEditable(false);
		enter.setBounds(66, 26, 295, 23);
		add(enter);
		enter.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(66, 57, 295, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(160, 88, 89, 23);
		add(btnNewButton);
		
		
		btnNewButton.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mail = textField.getText().toString();
				textField.setText("");
				if(isValidEmailAddress(mail)) {
					
				if(ForgetPassword.sendMail(mail)) {
					JOptionPane.showMessageDialog(null, "Please check your mail box.");
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid email!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	public  boolean isValidEmailAddress(String email) {
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

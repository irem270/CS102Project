package emptyData;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;

public class NavigationPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public NavigationPanel(Style style, String message) {
		setLayout(null);
		
		textField = new JTextField(message);
		textField.setForeground(new Color(204, 204, 255));
		textField.setBounds(127, 11, 174, 32);
		add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setBackground(style.getBckColor().darker());
		textField.setFont(style.getFont());	
		
		JButton back = new JButton("back");
		back.setBounds(329, 16, 68, 23);
		add(back);
		this.setBackground(style.getBckColor().darker());

	}
	
	public void setText(String text) {
		textField.setText(text);
	}
}

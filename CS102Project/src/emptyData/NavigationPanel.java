package emptyData;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class NavigationPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPanel panel;
	private JButton back, out;

	/**
	 * Create the panel.
	 */
	public NavigationPanel(Style style, String message, JPanel panel) {
		setLayout(null);
		this.panel = panel;
		textField = new JTextField(message);
		textField.setForeground(new Color(204, 204, 255));
		textField.setBounds(127, 11, 174, 32);
		add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setBackground(style.getBckColor().darker());
		textField.setFont(style.getFont());

		back = new JButton("back");
		back.setBounds(329, 16, 68, 23);
		add(back);
		this.setBackground(style.getBckColor().darker());
		back.addActionListener(this);

		out = new JButton("Log Out");
		out.setBounds(22, 16, 89, 23);
		add(out);

		out.addActionListener(this);

	}

	public void setText(String text) {
		textField.setText(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TopicInfo info = new TopicInfo();
		String topicNames = "";

		for (int i = 0; i < info.getTopics().size(); i++) {
			topicNames = topicNames + info.getTopics().get(i).getName();
		}

		CardLayout cardLayout = (CardLayout) panel.getLayout();
		Component current = new JPanel();
		current.setName("");

		if (e.getSource() == back) {
			for (Component p : panel.getComponents()) {
				if (p.isVisible())
					current = p;
			}
			if (!current.getName().equals("")) {
				if (topicNames.contains(current.getName()))
					cardLayout.show(panel, "topicPanel");
				else if (current.getName().equals("topicPanel")) {
					cardLayout.show(panel, "menu");
				} else if (current.getName().equals("infoPanel")) {
					cardLayout.show(panel, "menu");
				}
			}
		} else if (e.getSource() == out) {
			cardLayout.show(panel, "userPanel");
		}

	}
}

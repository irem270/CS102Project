package emptyData;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import forum.Operations;

public class MenuPanel extends JPanel implements ActionListener {
	private JButton topics;
	private JButton infoButton;
	private JButton pass;

	/**
	 * @wbp.nonvisual location=186,299
	 */

	/**
	 * Create the panel.
	 */
	public MenuPanel(Style style) {

		setName("menu");
		setBackground(style.getBckColor());
		setLayout(null);

		topics = new JButton("Topics");
		topics.setBounds(166, 127, 149, 51);
		topics.setFont(style.getFont());
		add(topics);

		infoButton = new JButton("Info");
		infoButton.setFont(style.getFont());
		infoButton.setBounds(166, 215, 149, 51);
		add(infoButton);
		infoButton.addActionListener(this);

		pass = new JButton("Change Password");
		pass.setBounds(166, 291, 149, 51);
		add(pass);
		pass.addActionListener(this);

	}

	public void initialize() {

		topics.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JPanel cardLayoutPanel = (JPanel) getParent();
		CardLayout layout = (CardLayout) cardLayoutPanel.getLayout();
		if (e.getSource() == topics) {

			layout.show(cardLayoutPanel, "topicPanel");
		} else if (e.getSource() == infoButton) {
			layout.show(cardLayoutPanel, "infoPanel");

		} else if (e.getSource() == pass) {
			String str = JOptionPane.showInputDialog("Enter Your New Password : ");

			if (!isInteger(str)) {
				JOptionPane.showMessageDialog(null, "Password must be an integer", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (str.length() < 6)
				JOptionPane.showMessageDialog(null, "Password is too short", "Error", JOptionPane.ERROR_MESSAGE);
			else
				Operations.changePassword(Integer.parseInt(str));
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image wp = new ImageIcon(MenuPanel.class.getResource("wall_1.jpg")).getImage();
		g.drawImage(wp, 0, 0, getWidth(), getHeight(), null);

	}

	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}
}

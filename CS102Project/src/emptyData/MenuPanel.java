package emptyData;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener {
	Style style;
	JButton topics;
	JButton infoButton;

	/**
	 * Create the panel.
	 */
	public MenuPanel(Style style) {
		this.style = style;
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

		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image wp = new ImageIcon(MenuPanel.class.getResource("wall_1.jpg")).getImage();
		g.drawImage(wp, 0, 0, 1500, 700, null);
				
	}
}

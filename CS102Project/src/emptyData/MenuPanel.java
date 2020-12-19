package emptyData;

import java.awt.CardLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import info.Update;

import com.jgoodies.forms.layout.FormSpecs;

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
}

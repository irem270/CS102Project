package emptyData;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;

public class SlidesPanel extends JScrollPane {
	private Topic topic;
	private JTextField textField;
	private Style style;

	/**
	 * Create the panel.
	 */
	public SlidesPanel(Topic topic, Style style) {
		this.topic = topic;
		this.style = style;
		
		this.setName(topic.getName());

		textField = new JTextField(topic.getName());
		textField.setFont(new Font("Serif", Font.BOLD, 30));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(style.getBckColor());
		textField.setHorizontalAlignment(JTextField.CENTER);


		this.setColumnHeaderView(textField);

		Scroll scrollPane = new Scroll();
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setViewportView(scrollPane);
		setBackground(style.getBckColor());
		this.getViewport().setBackground(style.getBckColor());

	}

	class Scroll extends JScrollPane {
		@Override
		public void paint(Graphics g) {
			for (int i = 0; i < topic.getImg().size(); i++) {
				g.drawImage((topic.getImg().get(i)), i * 850 + 50, 50, 800, 400, null);

			}

		}

		public Scroll() {

			setMinimumSize(new Dimension(160, 200));
			setPreferredSize(new Dimension(topic.getImg().size() * 860, 800));
		}
	}
}

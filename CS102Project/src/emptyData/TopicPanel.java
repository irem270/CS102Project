package emptyData;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TopicPanel extends JPanel {
	private JTextField textField;
	private Style style;
	private String name;
	JButton Slides;
	JFrame f;

	/**
	 * Create the panel.
	 */
	public TopicPanel(String name, Style style) {
		setLayout(null);

		this.name = name;
		this.style = style;
		setBackground(style.getBckColor().brighter());

		textField = new JTextField();
		textField.setBounds(178, 37, 110, 36);
		add(textField);
		textField.setColumns(10);
		textField.setFont(style.getFont());
		textField.setText(name);
		textField.setEditable(false);

		Slides = new JButton("Slides");
		Slides.setBounds(185, 84, 89, 23);
		add(Slides);

		JButton exercise = new JButton("Exercise");
		exercise.setBounds(185, 127, 89, 23);
		add(exercise);
		f = (JFrame) SwingUtilities.getRoot(this);

	}

	public void initialize() {
		Slides.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}
}

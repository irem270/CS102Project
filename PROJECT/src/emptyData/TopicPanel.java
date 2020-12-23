package emptyData;

import javax.swing.JPanel;

import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;

public class TopicPanel extends JPanel {
	private JTextField textField;
	private Style style;
	private String name;
	JButton Slides, exercise;

	/**
	 * Create the panel.
	 */
	public TopicPanel(String name, Style style) {
		setLayout(null);

		this.name = name;
		this.style = style;

		setBackground(style.getBckColor().brighter());

		textField = new JTextField();
		textField.setBackground(new Color(255, 165, 0));
		textField.setBounds(120, 29, 232, 52);
		add(textField);
		textField.setColumns(20);
		textField.setFont(style.getFont());
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setText(name);
		textField.setEditable(false);

		Slides = new JButton("Slides");
		Slides.setBounds(185, 92, 89, 23);
		add(Slides);

		exercise = new JButton("Exercise");
		exercise.setBounds(185, 127, 89, 23);
		add(exercise);

	}

	public void initialize() {
		Slides.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel cardLayoutPanel = (JPanel) getParent();
				JPanel cardLayoutPanel2 = (JPanel) cardLayoutPanel.getParent();
				CardLayout layout = (CardLayout) cardLayoutPanel2.getLayout();
				layout.show(cardLayoutPanel2, name);
			}
		});
		exercise.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ExerciseFrame f = new ExerciseFrame();
				f.setVisible(true);
			}
		});

	}

}

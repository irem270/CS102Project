package emptyData;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StudentTopicsFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<TopicPanel> panels;
	private ArrayList<JButton> buttons;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTopicsFrame frame = new StudentTopicsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentTopicsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		initialize();
	}
	private void initialize() {
		panels = new ArrayList<>();
		buttons = new ArrayList<>();
		
		for(TopicPanel tp : panels) {
			buttons.add(new JButton(tp.getTopicName()));
		}
		
	}

}

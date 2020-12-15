package emptyData;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
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
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { StudentTopicsFrame frame = new
	 * StudentTopicsFrame(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public StudentTopicsFrame(Style style) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setBackground(style.getBckColor());
		initialize( style);
	}
	private void initialize(Style style) {
		panels = new ArrayList<>();
		buttons = new ArrayList<>();
		panels.add(new TopicPanel("hello", style));
		panels.add(new TopicPanel("Topic2", style));
		panels.add(new TopicPanel("Topic3", style));
		panels.add(new TopicPanel("Topic4", style));
		setLayout(new GridLayout((int)(Math.sqrt(panels.size())),(int) Math.sqrt(panels.size())));
		for(TopicPanel p: panels) {
			add(p);
			p.initialize();
		}
			
		
		
	}

}

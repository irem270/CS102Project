package emptyData;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;

public class MainFrame {

	private JFrame frame;
	private Style style;
	private MenuPanel menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	//	frame.setBounds(100, 100, 450, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setTitle("Empty Data");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color bck = new Color(163, 26, 255); 
		style  = new Style(bck, Color.black, new Font("Serif", Font.BOLD, 30) ); 
		MenuPanel menu = new MenuPanel(style);
		frame.add(menu, BorderLayout.CENTER);
		menu.initialize();
		
	
	}

}

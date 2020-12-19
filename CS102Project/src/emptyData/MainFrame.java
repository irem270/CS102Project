package emptyData;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class MainFrame {

	private JFrame frame;
	private Style style;
	private MenuPanel menu;
	private NavigationPanel nav;
	private JPanel center;
	private TopicInfo info;

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
	 * @throws IOException 
	 */
	public MainFrame() throws IOException {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException  {
		int y = 70;
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Empty Data");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Color bck = new Color(0, 128, 255);
		style = new Style(bck, Color.black, new Font("Serif", Font.BOLD, 30));

		center = new JPanel(new CardLayout());
		nav = new NavigationPanel(style, "WELCOME", center);
		menu = new MenuPanel(style);
		info = new TopicInfo();
	
		InfoPanel ip = new InfoPanel(style);
	

		nav.setBounds(400, 0, 600, y);
		center.setBounds(0, y, 1300, 560);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(style.getBckColor().darker());

		center.add(menu, "menu");
		center.add(topicPanel(), "topicPanel");
		center.add(ip,"infoPanel");

		frame.getContentPane().add(nav);
		frame.getContentPane().add(center);
		menu.initialize();

		for (int i = 0; i < info.getTopics().size(); i++) {
			SlidesPanel s = new SlidesPanel(info.getTopics().get(i), style);
			center.add(s, info.getTopics().get(i).getName());

		}

	}

	private JPanel topicPanel() {
		JPanel all = new JPanel();
		all.setName("topicPanel");
		ArrayList<TopicPanel> panels = new ArrayList<>();

		for (int i = 0; i < info.getTopics().size(); i++) {
			panels.add(new TopicPanel(info.getTopics().get(i).name, style));
		}
		all.setLayout(new GridLayout((int) (Math.sqrt(panels.size())), (int) Math.sqrt(panels.size())));
		for (TopicPanel p : panels) {
			all.add(p);
			p.initialize();
		}
		return all;
	}

}

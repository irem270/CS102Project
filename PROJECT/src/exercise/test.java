package exercise;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class test { 

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(new SortPanel("Correct mistakes"), BorderLayout.NORTH);

		frame.add(new CorrectMistakes(), BorderLayout.CENTER);
        frame.setVisible(true);
	}

}

package company;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Main extends JFrame {

	public Main(String subject) throws FileNotFoundException {
		ExercisesCollection collection = new ExercisesCollection();
		int num = 3;
//		String subject = "Recurson";
		Exercise smth = collection.getExercise(subject, num);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		add(new SortPanel(subject), BorderLayout.NORTH);

		add(smth, BorderLayout.CENTER);
		setVisible(true);
	}

}

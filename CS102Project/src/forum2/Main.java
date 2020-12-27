package forum2;



import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        JFrame frame = new JFrame();
        ExercisesCollection collection = new ExercisesCollection();
        int num = 1;
        Exercise smth = new Exercise();
        smth = collection.getExercise(num);

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(new SortPanel("Correct mistakes"), BorderLayout.NORTH);

        frame.add(smth, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}

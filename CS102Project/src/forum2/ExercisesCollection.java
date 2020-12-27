package forum2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class ExercisesCollection {
    String str;
    File file;
    Scanner scan;
    String question;
    Exercise exercise;


    public ExercisesCollection() throws FileNotFoundException {
        str = "C:\\Users\\virem\\git\\CS102Project\\CS102Project\\src\\ExerciseExamples\\ExerciseExamples\\Exercise";

    }

    public Exercise getExercise(int num) throws FileNotFoundException {
        str = str + num + ".txt";
        file = new File(str);
        scan = new Scanner(file);

        if(scan.nextLine().equals("CorrectMistakes")) {
            String question = "";
            while(scan.nextLine().equals("Answer:")) {
                question = question.concat(scan.nextLine() + "\n");

            }
            String rightAns = "";
            while(scan.nextLine().equals("Output:")) {
                rightAns = rightAns.concat(scan.nextLine() + "\n");
            }
            String output = "";
            while(scan.hasNextLine()) {
                output = output.concat(scan.nextLine() + "\n");
            }

            exercise = new CorrectMistakes(question, rightAns, output);

        }
        else if(scan.nextLine().equals("TrueFalse")){
            String question = "";
            while(scan.nextLine().equals("Answer:")) {
                question = question.concat(scan.nextLine() + "\n");

            }
            String ans = "";
            while(scan.nextLine().equals("Output:")) {
                ans = ans.concat(scan.nextLine() + "\n");
            }
            boolean rightAns = true;
            if(scan.nextLine().equals("false")) {
                rightAns = false;
            }

            exercise = new TrueFalse(question, ans, rightAns);
        }
        else if(scan.nextLine().equals("MultipleChoice")){

            String question = "";
            while(scan.nextLine().equals("Answer:")) {
                question = question.concat(scan.nextLine() + "\n");

            }
            String ans = "";
            while(scan.nextLine().equals("Output:")) {
                ans = ans.concat(scan.nextLine() + "\n");
            }
            boolean rightAns = true;
            if(scan.nextLine().equals("false")) {
                rightAns = false;
            }

            exercise = new TrueFalse(question, ans, rightAns);

        }

        return exercise;
    }
}

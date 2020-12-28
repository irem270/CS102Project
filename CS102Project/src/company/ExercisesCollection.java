package company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class ExercisesCollection {
    String str;
    File file;
    Scanner scan;
    Exercise exercise;


    public ExercisesCollection() throws FileNotFoundException {
        str = "C:\\Users\\virem\\OneDrive\\Masaüstü\\all\\";
        exercise = new Exercise();

    }

    public Exercise getExercise(String topic,int num) throws FileNotFoundException {
        str = str + topic + "\\Exercise" + num + ".txt";
        file = new File(str);
        scan = new Scanner(file);
        
        if(file.length()==0) {
        	
        }

        else if(scan.nextLine().equals("Correct mistakes")) {
            String question = "";
            while(!scan.nextLine().equals("Answer:")) {
                question = question.concat(scan.nextLine() + "\n");

            }
            String rightAns = "";
            while(!scan.nextLine().equals("Output:")) {
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
            while(!scan.nextLine().equals("Output:")) {
                question = question.concat(scan.nextLine() + "\n");

            }
            String ans = "";
            while(!scan.nextLine().equals("Answer:")) {
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
            while(!scan.nextLine().equals("Answer:")) {
                question = question.concat(scan.nextLine() + "\n");

            }
            String ans = "";
            ans = scan.nextLine();
            String aa = "";
                aa = scan.nextLine();
            String ab = "";
                ab = scan.nextLine();
            String ac = "";
                ac = scan.nextLine();
            String ad = "";
                ad = scan.nextLine();
            String ae = "";
                ae = scan.nextLine();

            exercise = new MultipleChoice(question, ans, aa, ab, ac, ad, ae);

        }

        return exercise;
    }
}

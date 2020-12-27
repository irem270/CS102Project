package forum2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class CorrectMistakes extends Exercise implements ActionListener {



    JPanel panel;
    JTextArea textArea;
    JLabel neededOutput;
    JButton submit;
    JTextField result;
    int numOfTries;
    String rightAns;
    String question;
    String output;

    public CorrectMistakes(String question, String rightAns, String output) {
        numOfTries = 0;
        this.rightAns = rightAns;
        this.question = question;
        this.output = output;

        setLayout( null );
        setBackground(new Color(255, 165, 0));

        textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.BOLD, 20));
        textArea.setBounds(30, 30, 450, 375);
        textArea.setText(question);
        add(textArea);



        submit = new JButton("Submit");
        submit.setBounds(510, 232, 112, 45);
        submit.addActionListener(this);
        add(submit);




        neededOutput = new JLabel();
        neededOutput.setBounds(652, 30, 450, 375);
        neededOutput.setBackground(Color.WHITE);
        neededOutput.setFont(new Font("Serif", Font.BOLD, 15));
        neededOutput.setText(output);
        neededOutput.setOpaque(true);
        add(neededOutput);

        result = new JTextField();
        result.setText("Answer is: ***** " + "|| Number of Tries:" + numOfTries );
        result.setOpaque(true);
        result.setBounds(412, 450, 300, 75);
        result.setFont(new Font("Serif", Font.BOLD, 25));
        result.setBackground(Color.white);
        add(result);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit) {
            if(textArea.getText().equals(rightAns)) {
                result.setBackground(Color.green);
                result.setText("Answer is: Right " + "|| Number of Tries:" + numOfTries);
            }
            else {
                numOfTries++;

                result.setBackground(Color.red);
                result.setText("Answer is: Wrong " + "Number of Tries:" + numOfTries);
            }

        }

    }

}

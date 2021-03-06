package company;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TrueFalse extends Exercise implements ActionListener {


    JPanel panel;
    JTextArea textArea;
    JLabel neededOutput;
    JButton submit;
    JTextField result;
    int numOfTries;
    boolean rightAns;
    JRadioButton t, f;
    boolean choose;
    String question;
    String answer;
    JScrollPane scroll1;
    JScrollPane scroll2;

    public TrueFalse(String question, String answer, boolean rightAns) {

        numOfTries = 0;
        this.rightAns = rightAns;
        this.question = question;
        this.answer = answer;

        setLayout( null );
        setBackground(new Color(255, 165, 0));

        textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.BOLD, 17));
        textArea.setEditable(false);
        textArea.setText(this.question);
        scroll1 = new JScrollPane(textArea);
        scroll1.setBounds(30, 30, 450, 375);
        add(scroll1);

        submit = new JButton("Submit");
        submit.setFont(new Font("Serif", Font.BOLD, 20));
        submit.setBounds(510, 232, 112, 45);
        submit.addActionListener(this);
        add(submit);

        t = new JRadioButton("TRUE");
        f = new JRadioButton("FALSE");
        t.setFont(new Font("Serif", Font.BOLD, 17));
        f.setFont(new Font("Serif", Font.BOLD, 17));
        t.setBounds(510, 183, 112, 45);
        f.setBounds(510, 135, 112, 45);
        t.addActionListener( new RadioButtonListener() );
        f.addActionListener( new RadioButtonListener() );
        add(t);
        add(f);


        neededOutput = new JLabel();
        neededOutput.setBackground(Color.WHITE);
        neededOutput.setFont(new Font("Serif", Font.BOLD, 17));
        neededOutput.setText(this.answer);
        neededOutput.setOpaque(true);
        scroll2 = new JScrollPane(neededOutput);
        scroll2.setBounds(652, 30, 450, 375);
        add(scroll2);

        result = new JTextField();
        result.setText("Answer is: ***** " + "|| Number of Tries:" + numOfTries );
        result.setOpaque(true);
        result.setBounds(412, 450, 300, 75);
        result.setFont(new Font("Serif", Font.BOLD, 17));
        result.setBackground(Color.white);
        add(result);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            if(choose == rightAns) {
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

    class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == f ) {
                t.setSelected(false);
                choose = false;
            }
            else {
                f.setSelected(false);
                choose = true;
            }
        }

    }
}
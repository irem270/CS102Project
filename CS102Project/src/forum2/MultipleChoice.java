package forum2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class MultipleChoice extends Exercise implements ActionListener{

    JLabel question;
    JRadioButton a, b, c, d, e;
    JButton submit;
    JLabel table;
    boolean choice;
    String rightAns;


    public MultipleChoice(String question, String answer, String choices){
        choice = false;

        setLayout( null );
        setBackground(new Color(255, 165, 0));


        this.question = new JLabel();
        this.question.setBounds(187, 30, 450, 225);
        this.question.setBackground(Color.WHITE);
        this.question.setFont(new Font("Serif", Font.BOLD, 30));
        this.question.setText("<html>" +  "********** *********** ********* <html> ********* **********" + "</html>");
        this.question.setOpaque(true);
        add(this.question);




        a = new JRadioButton("<html>" + "A - " + "******************************************" + "</html>");
        b = new JRadioButton("<html>" + "B - " + "******************************************" + "</html>");
        c = new JRadioButton("<html>" + "C - " + "******************************************" + "</html>");
        d = new JRadioButton("<html>" + "D - " + "******************************************" + "</html>");
        e = new JRadioButton("<html>" + "E - " + "******************************************" + "</html>");
        a.setFont(new Font("Serif", Font.BOLD, 20));
        b.setFont(new Font("Serif", Font.BOLD, 20));
        c.setFont(new Font("Serif", Font.BOLD, 20));
        d.setFont(new Font("Serif", Font.BOLD, 20));
        e.setFont(new Font("Serif", Font.BOLD, 20));
        a.addActionListener( new RadioButtonListener() );
        b.addActionListener( new RadioButtonListener() );
        c.addActionListener( new RadioButtonListener() );
        d.addActionListener( new RadioButtonListener() );
        e.addActionListener( new RadioButtonListener() );
        a.setBounds(187, 28, 450, 45);
        b.setBounds(187, 333, 450, 45);
        c.setBounds(187, 382, 450, 45);
        d.setBounds(187, 431, 450, 45);
        e.setBounds(187, 480, 450, 45);
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Serif", Font.BOLD, 20));
        submit.addActionListener(this);
        submit.setBounds(750, 187, 112, 45);
        add(submit);

        table = new JLabel();
        table.setFont(new Font("Serif", Font.BOLD, 20));
        table.setBounds(750, 300, 112, 112);
        table.setBackground(Color.WHITE);
        table.setOpaque(true);
        add(table);







    }


    class RadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            if(ev.getSource() == a ) {
                b.setSelected(false);
                c.setSelected(false);
                d.setSelected(false);
                e.setSelected(false);
                choice = true;
            }

            else if(ev.getSource() == b ) {
                a.setSelected(false);
                c.setSelected(false);
                d.setSelected(false);
                e.setSelected(false);
                choice = false;
            }
            else if(ev.getSource() == c ) {
                a.setSelected(false);
                b.setSelected(false);
                d.setSelected(false);
                e.setSelected(false);
                choice = false;
            }
            else if(ev.getSource() == d ) {
                b.setSelected(false);
                c.setSelected(false);
                a.setSelected(false);
                e.setSelected(false);
                choice = false;
            }
            else {
                b.setSelected(false);
                c.setSelected(false);
                d.setSelected(false);
                a.setSelected(false);
                choice = false;
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == submit) {
            if(choice == true) {
                table.setBackground(Color.green);
            }
            else {
                table.setBackground(Color.red);
            }
        }

    }

}

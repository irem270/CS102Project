package company;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MultipleChoice extends Exercise implements ActionListener{

    JTextArea question;
    JRadioButton a, b, c, d, e;
    JButton submit;
    JLabel table;
    boolean choice;
    JScrollPane scroll;
    String answer;


    public MultipleChoice(String question, String answer, String aa,String ab,String ac, String ad, String ae){
        choice = false;
        this.answer = answer;

        setLayout( null );
        setBackground(new Color(255, 165, 0));


        this.question = new JTextArea();
        this.question.setBackground(Color.WHITE);
        this.question.setFont(new Font("Serif", Font.BOLD, 10));
        this.question.setText(question);
        this.question.setOpaque(true);
        scroll = new JScrollPane(this.question);
        scroll.setBounds(187, 30, 450, 225);
        add(scroll);




        this.a = new JRadioButton("<html>"  + aa + "</html>");
        this.b = new JRadioButton("<html>"  + ab + "</html>");
        this.c = new JRadioButton("<html>"  + ac + "</html>");
        this.d = new JRadioButton("<html>"  + ad + "</html>");
        this.e = new JRadioButton("<html>"  + ae + "</html>");
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
        a.setBounds(187, 284, 450, 45);
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
                if(answer.equals("A"))
                    choice = true;
                else
                    choice = false;
            }

            else if(ev.getSource() == b ) {
                a.setSelected(false);
                c.setSelected(false);
                d.setSelected(false);
                e.setSelected(false);
                if(answer.equals("B"))
                    choice = true;
                else
                    choice = false;
            }
            else if(ev.getSource() == c ) {
                a.setSelected(false);
                b.setSelected(false);
                d.setSelected(false);
                e.setSelected(false);
                if(answer.equals("C"))
                    choice = true;
                else
                    choice = false;
            }
            else if(ev.getSource() == d ) {
                b.setSelected(false);
                c.setSelected(false);
                a.setSelected(false);
                e.setSelected(false);
                if(answer.equals("D"))
                    choice = true;
                else
                    choice = false;
            }
            else {
                b.setSelected(false);
                c.setSelected(false);
                d.setSelected(false);
                a.setSelected(false);
                if(answer.equals("E"))
                    choice = true;
                else
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

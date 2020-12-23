package exercise;
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
	
	
	public MultipleChoice(){
		choice = false;
		
		setLayout( null );
		setBackground(new Color(255, 165, 0));
		
		
		question = new JLabel();
		question.setBounds(250, 40, 600, 300);
		question.setBackground(Color.WHITE);
		question.setFont(new Font("Serif", Font.BOLD, 30));
		question.setText("<html>" +  "********** *********** ********* <html> ********* **********" + "</html>"); 
		question.setOpaque(true);
		add(question);
		
		
		
		
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
		a.setBounds(250, 380, 600, 60);
		b.setBounds(250, 445, 600, 60);
		c.setBounds(250, 510, 600, 60);
		d.setBounds(250, 575, 600, 60);
		e.setBounds(250, 640, 600, 60);
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
		
		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Serif", Font.BOLD, 20));
		submit.addActionListener(this);
		submit.setBounds(1000, 250, 150, 60);
		add(submit);
		
		table = new JLabel();
		table.setFont(new Font("Serif", Font.BOLD, 20));
		table.setBounds(1000, 400, 150, 150);
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

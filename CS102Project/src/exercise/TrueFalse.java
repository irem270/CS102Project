package exercise;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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
	
	
	public TrueFalse() { 
		
		numOfTries = 0;
		rightAns = true;
		

		setLayout( null );
		setBackground(new Color(255, 165, 0));
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Serif", Font.BOLD, 20));
		textArea.setBounds(40, 40, 600, 500);
		textArea.setText("class HelloWorld {\r\n"
				+ "    public static void main(String[] args) {\r\n"
				+ "        System.out.println(\"Hello, World!\"); \r\n"
				+ "    }\r\n"
				+ "}");
		textArea.setEditable(false);
		add(textArea);

		submit = new JButton("Submit");
		submit.setFont(new Font("Serif", Font.BOLD, 20));
		submit.setBounds(680, 310, 150, 60);
		submit.addActionListener(this);
		add(submit);
		
		t = new JRadioButton("TRUE");
		f = new JRadioButton("FALSE");
		t.setFont(new Font("Serif", Font.BOLD, 20)); 
		f.setFont(new Font("Serif", Font.BOLD, 20));
		t.setBounds(680, 245, 150, 60);
		f.setBounds(680, 180, 150, 60);
		t.addActionListener( new RadioButtonListener() );
		f.addActionListener( new RadioButtonListener() );
		add(t);
		add(f);
		

		neededOutput = new JLabel();
		neededOutput.setBounds(870, 40, 600, 500); 
		neededOutput.setBackground(Color.WHITE);
		neededOutput.setFont(new Font("Serif", Font.BOLD, 15));
		neededOutput.setText("<html>" +  "Hello, World!" + "</html>"); 
		neededOutput.setOpaque(true);
		add(neededOutput); 
		
		result = new JTextField();
		result.setText("Answer is: ***** " + "|| Number of Tries:" + numOfTries );
		result.setOpaque(true);
		result.setBounds(550, 600, 400, 100);
		result.setFont(new Font("Serif", Font.BOLD, 25));
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
package forum;

import javax.swing.*;

public class discussionPage extends JFrame{

    public static void main(String[] args){

        JFrame frame = new JFrame("Discussion Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new discussionPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

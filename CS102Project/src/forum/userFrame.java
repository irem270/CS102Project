package forum;

import javax.swing.*;

public class userFrame extends JFrame {

    public static void main(String[] args){

        JFrame frame = new JFrame("user Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new userPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

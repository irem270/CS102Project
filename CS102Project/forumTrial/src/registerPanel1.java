import javax.swing.*;

public class registerPanel1 extends JFrame{

    public static void main(String[] args){

        JFrame frame = new JFrame("Register Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new registerPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

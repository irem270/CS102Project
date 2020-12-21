import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.*;
import java.awt.CardLayout;
import java.sql.Connection;


public class userPanel extends JPanel {


    JButton logIn,register;
    JLabel inLabel,regLabel;
    JTextField userName,password;
    registerPanel1 r;

    public userPanel(){

        inLabel = new JLabel();
        inLabel.setText("username");

        regLabel = new JLabel();
        regLabel.setText("Password");

        userName = new JTextField("");
        userName.setPreferredSize(new Dimension(100,30));

        password = new JTextField("");
        password.setPreferredSize(new Dimension(100,30));

        logIn = new JButton("Log In");
        logIn.setBounds(166, 127, 149, 51);


        register = new JButton("Register");
        register.setBounds(166, 127, 149, 51);

        logIn.addActionListener(new loginActionListener());

        add(inLabel);
        add(userName);
        add(regLabel);
        add(password);
        add(logIn);
        add(register);

    }
    public class loginActionListener extends Component implements ActionListener{
        Operations operation = new Operations();
        JFrame f = new discussionPage();
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String usernameStr = userName.getText();
                String passwordStr = password.getText();

                if(operation.IsLogIn(usernameStr,passwordStr,f)) {
                    f.setVisible(true);
                    System.out.println("All good...");
                }


            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(this,"Please type correct infos...");
            }
        }
    }
}
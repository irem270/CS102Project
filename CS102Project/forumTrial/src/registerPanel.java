import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.*;
import java.sql.*;

public class registerPanel extends JPanel{

    JButton register;
    JLabel nameLabel,passLabel,idLabel;
    JTextField userName,password,Id;
    Connection conn = null;
    Statement st = null;
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/forum?serverTimezone=UTC";

    static final String user = "root";
    static final String pass = "18273645";


    public registerPanel(){

        register = new JButton("Register");
        register.setBounds(166, 127, 149, 51);
        register.addActionListener(new registerActionListener());

        nameLabel = new JLabel();
        nameLabel.setText("name");

        idLabel = new JLabel();
        idLabel.setText("id");

        passLabel = new JLabel();
        passLabel.setText("password");


        userName = new JTextField("");
        userName.setPreferredSize(new Dimension(100,30));

        password = new JTextField("");
        password.setPreferredSize(new Dimension(100,30));

        Id = new JTextField("");
        Id.setPreferredSize(new Dimension(100,30));

        add(nameLabel);
        add(userName);
        add(idLabel);
        add(Id);
        add(passLabel);
        add(password);
        add(register);
    }
    public class registerActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name =  userName.getText() ;
            String ID = Id.getText();
            String pass1 = password.getText();

            int id = Integer.parseInt(ID);
            int pss = Integer.parseInt(pass1);

            try{
                Connection conn = DriverManager.getConnection(url,user,pass);
                Statement st = conn.createStatement();
                st.executeUpdate("Insert into users " + "(id,username,password)" + "values("+ id + ",'" + name+ "'," + pass1 +")");
                System.out.println("All good...");
            }
            catch (SQLException ex){
                    ex.printStackTrace();
            }
        }
    }
}

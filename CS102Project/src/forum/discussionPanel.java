package forum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class discussionPanel extends JPanel {
    JTextField entry;
    JLabel message;
    JButton send;

    public discussionPanel(){

        message = new JLabel();

        entry = new JTextField();
        entry.setEditable(true);
        entry.setPreferredSize(new Dimension(200,100));

        send = new JButton("send");
        send.addActionListener(new sendActionListener());


        add(entry);
        add(send);
        add(message);


    }
    public class sendActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            message.setText(entry.getText());
        }
    }
}

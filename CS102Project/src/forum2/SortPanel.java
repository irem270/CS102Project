package forum2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortPanel extends JPanel {


    JLabel top;

    public SortPanel(String str) {

        top = new JLabel();
        top.setFont(new Font("Serif", Font.BOLD, 30));
        top.setText( str + " question");
        top.setHorizontalTextPosition(JLabel.CENTER);
        top.setForeground((new Color(204, 204, 255)));
        top.setBackground(new Color(0, 128, 255).darker());
        top.setOpaque(true);
        add(top);
        setBackground(new Color(0, 128, 255).darker());
    }

}


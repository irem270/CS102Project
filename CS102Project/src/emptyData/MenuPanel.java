package emptyData;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class MenuPanel extends JPanel {
	Style style;
	JButton topics;

	/**
	 * Create the panel.
	 */
	public MenuPanel(Style style) {
		this.style = style;
		setBackground(style.getBckColor());
				 		 setLayout(null);
				 
				 		 topics = new JButton("Topics");
				 		 topics.setBounds(166, 127, 149, 51);
				 		 topics.setFont(style.getFont());
				 		 add(topics);
		
	}
	
	public void initialize() {
		JFrame f =   (JFrame) SwingUtilities.getRoot(this);

		topics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				new StudentTopicsFrame().setVisible(true);
				
				f.dispose();;
			}
		});

	}

}

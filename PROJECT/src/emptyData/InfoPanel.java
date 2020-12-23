package emptyData;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class InfoPanel extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 */
	public InfoPanel(Style style) throws IOException {
		this.setName("infoPanel");
		File myObj = new File("src/emptyData/Info");
		FileReader myWriter = new FileReader(myObj);
		JTextArea area = new JTextArea();
		area.setForeground(Color.BLACK);
		area.setEditable(false);
		area.setOpaque(false);
		area.setFont( new Font("Serif", Font.BOLD, 20));
		int i;
		while ((i = myWriter.read()) != -1)
			area.append((char) i + "");
		myWriter.close();
		this.setBackground(style.getBckColor().brighter());
		add(area);
	}
	
	

}

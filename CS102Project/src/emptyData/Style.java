package emptyData;

import java.awt.*;

public class Style {
	private Color bckColor;
	private Color textColor;
	private Font font;
	private int size;

	public Style(Color bckColor, Color textColor, Font font, int size) {
		this.bckColor = bckColor;
		this.textColor = textColor;
		this.font = font;
		this.size = size;
	}

	public Color getBckColor() {
		return bckColor;
	}

	public Color getTextColor() {
		return textColor;
	}

	public Font getFont() {
		return font;
	}

	public int getSize() {
		return size;
	}

}

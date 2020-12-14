package emptyData;

import java.awt.*;

public class Style {
	private Color bckColor;
	private Color textColor;
	private Font font;

	public Style(Color bckColor, Color textColor, Font font) {
		this.bckColor = bckColor;
		this.textColor = textColor;
		this.font = font;

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

}

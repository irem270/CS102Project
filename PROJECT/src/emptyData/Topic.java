package emptyData;

import java.awt.Image;
import java.util.ArrayList;

public class Topic {
	String name;
	ArrayList<Image> images;
	public Topic(String name ) {
		this.name = name;
	images = new ArrayList<Image>();	
	}
	public ArrayList<Image> getImg() {
		return images;
	}
	
	public void addImage(Image img) {
		images.add(img);	
	}
	public String getName() {
		return name;
	}
	
}

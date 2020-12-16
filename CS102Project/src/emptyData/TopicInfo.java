package emptyData;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TopicInfo {
	private ArrayList<Topic> topics;


	public TopicInfo() {
		topics = new ArrayList<Topic>();
		
	
		Image img = new  ImageIcon(TopicInfo.class.getResource("a.jpg")).getImage();
		
		
		Topic t1 = new Topic("Inheritence");
		t1.addImage(img);
		topics.add(t1);
		
		Topic t2 = new Topic("Interfaces");
		t1.addImage(img);
		topics.add(t2);
		
		Topic t3 = new Topic("Overriding");
		t1.addImage(img);
		topics.add(t3);
		
		Topic t4 = new Topic("Polymorphism");
		t1.addImage(img);
		topics.add(t4);

	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}


	


}

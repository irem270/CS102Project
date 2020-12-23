package emptyData;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TopicInfo {
	private ArrayList<Topic> topics;

	public TopicInfo() {
		topics = new ArrayList<Topic>();

		inheritence();
		recursion();
		gui();

	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public void inheritence() {

		Image img2 = new ImageIcon(
				TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs1_0.jpg")).getImage();

		Topic t1 = new Topic("Inheritence");
		t1.addImage(img2);
		t1.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs1_1.jpg"))
				.getImage());
		t1.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs1_2.jpg"))
				.getImage());
		t1.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs1_3.jpg"))
				.getImage());

		topics.add(t1);

		Topic t2 = new Topic("Interfaces");
		t2.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs5_1.jpg"))
				.getImage());
		t2.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs5_2.jpg"))
				.getImage());
		t2.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs5_3.jpg"))
				.getImage());
		t2.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs5_4.jpg"))
				.getImage());
		topics.add(t2);

		Topic t3 = new Topic("Overriding");
		t3.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs3_1.jpg"))
				.getImage());
		t3.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs3_2.jpg"))
				.getImage());
		t3.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs3_3.jpg"))
				.getImage());
		topics.add(t3);

		Topic t4 = new Topic("Polymorphism");
		t4.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs4_1.jpg"))
				.getImage());
		t4.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs4_2.jpg"))
				.getImage());
		t4.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/10-Inheritance&interfaces/Cs4_3.jpg"))
				.getImage());
		topics.add(t4);

	}

	public void recursion() {
		Topic r = new Topic("Recursion");
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/12-Recursion/Cs9_0.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/12-Recursion/Cs9_1.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/12-Recursion/Cs9_2.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/12-Recursion/Cs9_3.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/12-Recursion/Cs9_4.jpg")).getImage());
		topics.add(r);
	}

	public void gui() {
		Topic r = new Topic("GUI");
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/11-GUI/Cs6_0.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/11-GUI/Cs6_1.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/11-GUI/Cs6_2.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/11-GUI/Cs6_3.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/11-GUI/Cs6_4.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/11-GUI/Cs6_5.jpg")).getImage());
		r.addImage(new ImageIcon(TopicInfo.class.getResource("/CS project slides/11-GUI/Cs6_6.jpg")).getImage());
		topics.add(r);
	}

}

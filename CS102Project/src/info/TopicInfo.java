package info;

import javax.swing.JButton;

public class TopicInfo {
	private String topicName;
	private JButton exercise;
	private JButton slide;

	public TopicInfo(String topicName, JButton exercise, JButton slide) {
		this.exercise = exercise;
		this.slide = slide;
		this.topicName = topicName;
	}

	public String getTopicName() {
		return topicName;
	}

	public JButton getExercise() {
		return exercise;
	}

	public JButton getSlide() {
		return slide;
	}

}

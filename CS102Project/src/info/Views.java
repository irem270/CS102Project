package info;

import java.util.ArrayList;

import javax.swing.JPanel;

public class Views extends JPanel {
	private ArrayList<Update> views;
	public void addView( Update view)
	{
		views.add( view);
		// notifyViews();
		if ( view != null)
			view.update(this);
	}

	public void notifyViews()
	{
		if ( views != null)
			for (Update view : views)
				 view.update(this);
	}
}

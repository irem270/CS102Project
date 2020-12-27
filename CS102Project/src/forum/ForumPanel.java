package forum;

import emptyData.Style;
import forum.Operations;
import forum.UserInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ForumPanel extends JPanel {

	int count = 1;
	int pageCount = 1;
	JButton send;
	private ArrayList<JTextArea> messages;
	private static JTextArea mess;
	public static JTextField entry;
	private Style style;
	Connection conn = null;
	Statement st = null;
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/forum?characterEncoding=utf8";

	static final String user = "root";
	static final String pass = "271099";
	Messages m;

	public ForumPanel(Style style) {

		this.style = style;
		this.setName("forumPanel");
		this.setBackground(style.getBckColor());

		messages = new ArrayList<>();

		send = new JButton("Send");
		send.setBounds(166, 127, 149, 51);
		send.addActionListener(new senderActionListener());

		entry = new HintTextField("enter you message...");
		entry.setEditable(true);
		entry.setPreferredSize(new Dimension(200, 100));
		entry.setBackground(Color.white);

		mess = new JTextArea();
		mess.setEditable(false);
		mess.setPreferredSize(new Dimension(620, 320));
		Operations.createTable();
		messages();

		add(entry);
		add(send);
//		add(mess);

		m = new Messages();
		add(m);
	}

	public class senderActionListener implements ActionListener {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String MySQLDate = date.toString();
		java.util.Date date2 = new java.util.Date();

		java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(date2.getTime());

		@Override
		public void actionPerformed(ActionEvent e) {
			if (entry.getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Please write something..", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String message = "from : " + UserInfo.getName() + "\n" + entry.getText().toString();
				entry.setText("");
				if (messages() > 6) {

				}

				try {
					Connection conn = DriverManager.getConnection(url, user, pass);
					Statement st = conn.createStatement();
					st.executeUpdate("Insert into " + "1forum_page (newmessage,date)" + "values('" + message + "','"
							+ sqlDate + "')");
					mess.append(sqlDate + "\n" + message);
					m.update(message);

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		}
	}

	public int messages() {
		String str = "forum_page";
		StringBuilder builder1 = new StringBuilder();
		builder1.append(pageCount);
		builder1.append(str);
		try {
			Connection myConn = DriverManager.getConnection(url, user, pass);
			String MySQLQuerry = "SELECT * from " + builder1;
			PreparedStatement preparedStatement = myConn.prepareStatement(MySQLQuerry);
			ResultSet rs = preparedStatement.executeQuery(MySQLQuerry);
			StringBuilder builder = new StringBuilder();
			while (rs.next()) {
//				builder.append(UserInfo.getName());
//				builder.append("\t");
				builder.append(rs.getString("date"));
				builder.append("\n");
				builder.append(rs.getString("newmessage"));
				builder.append("\n");
				builder.append("\n");
				JTextArea t = new JTextArea(rs.getString("date") + " \n" + rs.getString("newmessage") );
				t.setEditable(false);
				t.setBackground(Color.cyan);
				t.setSize(300, 30);
				messages.add(t);
			}
			mess.setText(builder.toString());
			count++;

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Database errors: " + ex.getMessage());
		}
		return count;
	}

	class Messages extends JScrollPane {

		/**
		 * Create the panel.
		 */
		JPanel view;

		public Messages() {
			GridLayout g = new GridLayout(2*messages.size(), 1);
			g.setVgap(5);
			JPanel p = new JPanel(g);
			p.setBackground(style.getBckColor());
			this.setViewportView(p);
			this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			setPreferredSize(new Dimension(620, 620));
//			this.getViewport().setLayout(new GridLayout(1,20));

			view = ((JPanel) this.getViewport().getView());

			for (int i = 0; i < messages.size(); i++) {
//				getViewport().add(messages.get(i));
				view.add(messages.get(i));
			}
		}

		public void update(String message) {
			JTextArea i = new JTextArea(message);
			i.setSize(300, 30);
			i.setEditable(false);
			i.setBackground(Color.yellow);
			view.add(i);
			view.validate();

		}

	}
	class HintTextField extends JTextField implements FocusListener {

		  private final String hint;
		  private boolean showingHint;

		  public HintTextField(final String hint) {
		    super(hint);
		    this.hint = hint;
		    this.showingHint = true;
		    super.addFocusListener(this);
		  }

		  @Override
		  public void focusGained(FocusEvent e) {
		    if(this.getText().isEmpty()) {
		      super.setText("");
		      showingHint = false;
		    }
		  }
		  @Override
		  public void focusLost(FocusEvent e) {
		    if(this.getText().isEmpty()) {
		      super.setText(hint);
		      showingHint = true;
		    }
		  }

		  @Override
		  public String getText() {
		    return showingHint ? "" : super.getText();
		  }
		}
}

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import java.awt.Font;

public class Test extends JFrame{
	private static final int CHAT_WIDTH = 860;
	private static final int CHAT_HEIGHT = 640;
	private static final int CHAT_SCREEN_WIDTH = 844;
	private static final int CHAT_SCREEN_HEIGHT = 601;
	private JTextField send_tf;
	
	public Test() {
		setSize(CHAT_WIDTH, CHAT_HEIGHT);
		getContentPane().setLayout(null);
		
		JPanel chat_panel = new JPanel();
		chat_panel.setBounds(0, 0, CHAT_SCREEN_WIDTH, CHAT_SCREEN_HEIGHT);
		getContentPane().add(chat_panel);
		chat_panel.setLayout(null);
		
		JTextArea list_textarea = new JTextArea();
		list_textarea.setBounds(286, 142, 450, 370);
		chat_panel.add(list_textarea);
		
		send_tf = new JTextField();
		send_tf.setBounds(286, 522, 255, 21);
		chat_panel.add(send_tf);
		send_tf.setColumns(10);
		
		JButton send_button = new JButton("send");
		send_button.setBounds(553, 522, 85, 23);
		chat_panel.add(send_button);
		
		JButton file_button = new JButton("\uD30C\uC77C\uCCA8\uBD80");
		file_button.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		file_button.setBounds(651, 521, 85, 23);
		chat_panel.add(file_button);
		
		JButton grouplist_button = new JButton("GROUP LIST");
		grouplist_button.setBounds(95, 493, 135, 50);
		chat_panel.add(grouplist_button);
		
		JButton sms_button = new JButton("SMS service");
		sms_button.setBounds(95, 433, 135, 50);
		chat_panel.add(sms_button);
		
		JTextPane userlist_textpane = new JTextPane();
		userlist_textpane.setBounds(95, 142, 135, 281);
		chat_panel.add(userlist_textpane);
		
		JLabel chatbackground_label = new JLabel();
		chatbackground_label.setBounds(0, 0, CHAT_SCREEN_WIDTH, CHAT_SCREEN_HEIGHT);
		chat_panel.add(chatbackground_label);
	}
}

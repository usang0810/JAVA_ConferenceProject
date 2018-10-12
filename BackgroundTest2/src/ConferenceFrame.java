import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ConferenceFrame extends JFrame implements MouseListener{
	private static final int GROUP_WIDTH = 500;
	private static final int GROUP_HEIGHT = 600;
	private static final int GROUP_SCREEN_WIDTH = 484;
	private static final int GROUP_SCREEN_HEIGHT = 561;
	private static final int CHAT_WIDTH = 860;
	private static final int CHAT_HEIGHT = 640;
	private static final int CHAT_SCREEN_WIDTH = 844;
	private static final int CHAT_SCREEN_HEIGHT = 601;
	
	private JPanel selectgroup_panel, chat_panel;
	private JButton group1_button, group2_button, group3_button, group4_button, group5_button,
		send_button, file_button, grouplist_button, sms_button;
	private JTextArea list_textarea;
	private JTextField send_tf;
	private JTextPane userlist_textpane;
			
	public ConferenceFrame() {
		
		setTitle("conferencesystem/group list");
		setSize(GROUP_WIDTH, GROUP_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//그룹목록패널 생성
		selectgroup_panel = new JPanel();
		selectgroup_panel.setBounds(0, 0, 484, 561);
		getContentPane().add(selectgroup_panel);
		selectgroup_panel.setLayout(null);
		
		group1_button = new JButton("1");
		group1_button.setBounds(51, 168, 378, 42);
		selectgroup_panel.add(group1_button);
		group1_button.addMouseListener(this);
		
		group2_button = new JButton("2");
		group2_button.setBounds(51, 240, 378, 42);
		selectgroup_panel.add(group2_button);
		group2_button.addMouseListener(this);
		
		group3_button = new JButton("3");
		group3_button.setBounds(51, 314, 378, 42);
		selectgroup_panel.add(group3_button);
		group3_button.addMouseListener(this);
		
		group4_button = new JButton("4");
		group4_button.setBounds(51, 389, 378, 42);
		selectgroup_panel.add(group4_button);
		group4_button.addMouseListener(this);
		
		group5_button = new JButton("5");
		group5_button.setBounds(51, 464, 378, 42);
		selectgroup_panel.add(group5_button);
		group5_button.addMouseListener(this);
		
		JLabel groupbackground_label = new JLabel();
		groupbackground_label.setBounds(0, 0, GROUP_SCREEN_WIDTH, GROUP_SCREEN_HEIGHT);
		selectgroup_panel.add(groupbackground_label);
		
		
		
		
		//채팅 패널 생성
		chat_panel = new JPanel();
		chat_panel.setBounds(0, 0, CHAT_SCREEN_WIDTH, CHAT_SCREEN_HEIGHT);
		getContentPane().add(chat_panel);
		chat_panel.setLayout(null);
		
		list_textarea = new JTextArea();
		list_textarea.setBounds(286, 142, 450, 370);
		chat_panel.add(list_textarea);
		
		send_tf = new JTextField();
		send_tf.setBounds(286, 522, 255, 21);
		chat_panel.add(send_tf);
		send_tf.setColumns(10);
		
		send_button = new JButton("send");
		send_button.setBounds(553, 522, 85, 23);
		chat_panel.add(send_button);
		
		file_button = new JButton("\uD30C\uC77C\uCCA8\uBD80");
		file_button.setFont(new Font("굴림", Font.PLAIN, 10));
		file_button.setBounds(651, 521, 85, 23);
		chat_panel.add(file_button);
		
		grouplist_button = new JButton("GROUP LIST");
		grouplist_button.setBounds(95, 493, 135, 50);
		chat_panel.add(grouplist_button);
		
		sms_button = new JButton("SMS service");
		sms_button.setBounds(95, 433, 135, 50);
		chat_panel.add(sms_button);
		
		userlist_textpane = new JTextPane();
		userlist_textpane.setBounds(95, 142, 135, 281);
		chat_panel.add(userlist_textpane);
		
		JLabel chatbackground_label = new JLabel();
		chatbackground_label.setBounds(0, 0, CHAT_SCREEN_WIDTH, CHAT_SCREEN_HEIGHT);
		chat_panel.add(chatbackground_label);
		
		setVisible(true);
		chat_panel.setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		selectgroup_panel.setVisible(false);
		setTitle("conferencesystem/chatt");
		setSize(CHAT_WIDTH, CHAT_HEIGHT);
		chat_panel.setVisible(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

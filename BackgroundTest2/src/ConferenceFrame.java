//GUI test class
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ConferenceFrame extends JFrame implements MouseListener, ActionListener{
	//그룹선택창 사이즈
	private static final int GROUP_WIDTH = 500;
	private static final int GROUP_HEIGHT = 600;
	private static final int GROUP_SCREEN_WIDTH = 484;
	private static final int GROUP_SCREEN_HEIGHT = 561;
	//채팅창 사이즈
	private static final int CHAT_WIDTH = 860;
	private static final int CHAT_HEIGHT = 640;
	private static final int CHAT_SCREEN_WIDTH = 844;
	private static final int CHAT_SCREEN_HEIGHT = 601;
	//image icon
	public ImageIcon groupbackground_image = new ImageIcon(ConferenceFrame.class.getResource("/images/group_background.png"));
	public ImageIcon grouplistbefore_image = new ImageIcon(ConferenceFrame.class.getResource("/images/grouplist_before.png"));
	public ImageIcon grouplistafter_image = new ImageIcon(ConferenceFrame.class.getResource("/images/grouplist_after.png"));
	public ImageIcon chatbackground_image = new ImageIcon(ConferenceFrame.class.getResource("/images/chatting_background.jpg"));

	private JPanel selectgroup_panel, chat_panel;
	private JButton group1_button, group2_button, group3_button, group4_button, group5_button,
		send_button, file_button, grouplist_button, sms_button;
	private JTextArea list_textarea;
	private JTextField send_tf;
	private JTextPane userlist_textpane;
	private JLabel userlist_label;
			
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
		group1_button.setBounds(57, 168, 371, 43);
		group1_button.setIcon(grouplistbefore_image);
		group1_button.setBorderPainted(false);
		group1_button.setContentAreaFilled(false);
		group1_button.setFocusPainted(false);
		selectgroup_panel.add(group1_button);
		group1_button.addMouseListener(this);
		
		group2_button = new JButton("2");
		group2_button.setBounds(57, 240, 371, 43);
		group2_button.setIcon(grouplistbefore_image);
		group2_button.setBorderPainted(false);
		group2_button.setContentAreaFilled(false);
		group2_button.setFocusPainted(false);
		selectgroup_panel.add(group2_button);
		group2_button.addMouseListener(this);
		
		group3_button = new JButton("3");
		group3_button.setBounds(57, 314, 371, 43);
		group3_button.setIcon(grouplistbefore_image);
		group3_button.setBorderPainted(false);
		group3_button.setContentAreaFilled(false);
		group3_button.setFocusPainted(false);
		selectgroup_panel.add(group3_button);
		group3_button.addMouseListener(this);
		
		group4_button = new JButton("4");
		group4_button.setBounds(57, 389, 371, 43);
		group4_button.setIcon(grouplistbefore_image);
		group4_button.setBorderPainted(false);
		group4_button.setContentAreaFilled(false);
		group4_button.setFocusPainted(false);
		selectgroup_panel.add(group4_button);
		group4_button.addMouseListener(this);
		
		group5_button = new JButton("5");
		group5_button.setBounds(57, 464, 371, 43);
		group5_button.setIcon(grouplistbefore_image);
		group5_button.setBorderPainted(false);
		group5_button.setContentAreaFilled(false);
		group5_button.setFocusPainted(false);
		selectgroup_panel.add(group5_button);
		group5_button.addMouseListener(this);
		
		JLabel groupbackground_label = new JLabel();
		groupbackground_label.setBounds(0, 0, GROUP_SCREEN_WIDTH, GROUP_SCREEN_HEIGHT);
		groupbackground_label.setIcon(groupbackground_image);
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
		send_tf.setBorder(null);
		chat_panel.add(send_tf);
		send_tf.setColumns(10);
		
		send_button = new JButton("send");
		send_button.setBounds(553, 522, 85, 23);
		send_button.setBackground(new Color(100,200,200));
		send_button.addActionListener(this);
		chat_panel.add(send_button);
		
		file_button = new JButton("\uD30C\uC77C\uCCA8\uBD80");
		file_button.setFont(new Font("굴림", Font.PLAIN, 10));
		file_button.setBounds(651, 521, 85, 23);
		file_button.setBackground(new Color(100,200,200));
		file_button.addActionListener(this);
		chat_panel.add(file_button);
		
		grouplist_button = new JButton("GROUP LIST");
		grouplist_button.setBounds(95, 493, 135, 50);
		grouplist_button.setBackground(new Color(100,200,200));
		grouplist_button.addActionListener(this);
		chat_panel.add(grouplist_button);
		
		sms_button = new JButton("SMS service");
		sms_button.setBounds(95, 433, 135, 50);
		sms_button.setBackground(new Color(100,200,200));
		sms_button.addActionListener(this);
		chat_panel.add(sms_button);
		
		userlist_textpane = new JTextPane();
		userlist_textpane.setBounds(95, 172, 135, 251);
		chat_panel.add(userlist_textpane);
		
		userlist_label = new JLabel("USER LIST");
		userlist_label.setForeground(Color.WHITE);
		userlist_label.setFont(new Font("굴림", Font.BOLD, 14));
		userlist_label.setHorizontalAlignment(SwingConstants.CENTER);
		userlist_label.setBounds(95, 142, 135, 21);
		chat_panel.add(userlist_label);
		
		JLabel chatbackground_label = new JLabel();
		chatbackground_label.setBounds(0, 0, CHAT_SCREEN_WIDTH, CHAT_SCREEN_HEIGHT);
		chatbackground_label.setIcon(chatbackground_image);
		chat_panel.add(chatbackground_label);
		
		setVisible(true);
		chat_panel.setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {//그룹 클릭 시 그룹선택창 숨기고 프레임사이즈 재조정 후 채팅창 보여줌
		// TODO Auto-generated method stub
		selectgroup_panel.setVisible(false);
		setTitle("conferencesystem/chat");
		setSize(CHAT_WIDTH, CHAT_HEIGHT);
		chat_panel.setVisible(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {//버튼에 마우스가 들어올 시 이미지 변환
		// TODO Auto-generated method stub
		if(e.getSource() == (group1_button)) {
			group1_button.setIcon(grouplistafter_image);
		}else if(e.getSource() == (group2_button)) {
			group2_button.setIcon(grouplistafter_image);
		}else if(e.getSource() == (group3_button)) {
			group3_button.setIcon(grouplistafter_image);
		}else if(e.getSource() == (group4_button)) {
			group4_button.setIcon(grouplistafter_image);
		}else if(e.getSource() == (group5_button)) {
			group5_button.setIcon(grouplistafter_image);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {//버튼에서 마우스 나갈 시 이미지 변환
		// TODO Auto-generated method stub
		if(e.getSource() == (group1_button)) {
			group1_button.setIcon(grouplistbefore_image);
		}else if(e.getSource() == (group2_button)) {
			group2_button.setIcon(grouplistbefore_image);
		}else if(e.getSource() == (group3_button)) {
			group3_button.setIcon(grouplistbefore_image);
		}else if(e.getSource() == (group4_button)) {
			group4_button.setIcon(grouplistbefore_image);
		}else if(e.getSource() == (group5_button)) {
			group5_button.setIcon(grouplistbefore_image);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == sms_button) {
			SMSFrame smsfrmae = new SMSFrame();
		}else if(e.getSource() == grouplist_button) {
			chat_panel.setVisible(false);
			setTitle("conferencesystem/chat");
			setSize(GROUP_WIDTH, GROUP_HEIGHT);
			selectgroup_panel.setVisible(true);
		}
	}
}

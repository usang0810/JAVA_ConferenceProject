//GUI test frame
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Test extends JFrame implements ActionListener{
	JPanel chat_panel;
	JTextArea list_textarea;
	JTextField send_tf;
	JButton send_button, file_button, grouplist_button, sms_button;
	JTextPane userlist_textpane;
	private JLabel lblNewLabel;
	
	Test(){
		setSize(860,640);
		getContentPane().setLayout(null);
		
		chat_panel = new JPanel();
		chat_panel.setBounds(0, 0, 844, 601);
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
		send_button.setBackground(new Color(100,200,200));
		send_button.addActionListener(this);
		chat_panel.add(send_button);
		
		file_button = new JButton("\uD30C\uC77C\uCCA8\uBD80");
		file_button.setFont(new Font("±¼¸²", Font.PLAIN, 10));
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
		
		lblNewLabel = new JLabel("USER LIST");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 142, 135, 21);
		chat_panel.add(lblNewLabel);
		
		JLabel chatbackground_label = new JLabel();
		chatbackground_label.setBounds(0, 0, 844, 601);
		chat_panel.add(chatbackground_label);
		
		setVisible(true);
		chat_panel.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

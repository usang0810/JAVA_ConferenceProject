import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class SMSFrame extends JFrame implements ActionListener{
	//image icon
	public ImageIcon smsbackground_image= new ImageIcon(SMSFrame.class.getResource("/images/sms_background.jpg"));

	private static final int SMS_WIDTH = 300;
	private static final int SMS_HEIGHT = 500;
	private static final int SMS_SCREEN_WIDTH = 294;
	private static final int SMS_SCREEN_HEIGHT = 461;
	
	JPanel main_panel;
	JButton send_button;
	
	public SMSFrame() {
		setTitle("conferencesystem/SMS");
		setSize(SMS_WIDTH, SMS_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		main_panel = new JPanel();
		main_panel.setBounds(0, 0, SMS_SCREEN_WIDTH, SMS_SCREEN_HEIGHT);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(93, 29, 120, 30);
		main_panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"010-1234-5678", "010-9876-5432"}));
		
		JTextArea sms_textarea = new JTextArea();
		sms_textarea.setBounds(12, 78, 260, 162);
		main_panel.add(sms_textarea);
		
		send_button = new JButton("SEND");
		send_button.setBackground(new Color(100,200,200));
		send_button.setFont(new Font("±¼¸²", Font.BOLD, 12));
		send_button.setBounds(175, 250, 97, 23);
		send_button.addActionListener(this);
		main_panel.add(send_button);
		
		JLabel background_label = new JLabel();
		background_label.setBounds(0, 0, SMS_SCREEN_WIDTH, SMS_SCREEN_HEIGHT);
		background_label.setIcon(smsbackground_image);
		main_panel.add(background_label);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
	}
}

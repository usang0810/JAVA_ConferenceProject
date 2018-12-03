package frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.json.simple.JSONObject;

import http.Coin;
import http.Tellist;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SMSFrame extends JFrame implements ActionListener{
	private int groupnum;
	//image icon
	public ImageIcon smsbackground_image= new ImageIcon(SMSFrame.class.getResource("/images/sms_background.jpg"));

	private static final int SMS_WIDTH = 300;
	private static final int SMS_HEIGHT = 500;
	private static final int SMS_SCREEN_WIDTH = 294;
	private static final int SMS_SCREEN_HEIGHT = 461;
	
	private JPanel main_panel;
	private JButton send_button;
	private JTextArea sms_textarea;
	private JComboBox tel_combobox;
	
	private ArrayList<String> tellist = new ArrayList<String>();
	
	public SMSFrame(int groupnum) {
		this.groupnum = groupnum;
		
		setTitle("conferencesystem/SMS");
		setSize(SMS_WIDTH, SMS_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		main_panel = new JPanel();
		main_panel.setBounds(0, 0, SMS_SCREEN_WIDTH, SMS_SCREEN_HEIGHT);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		tel_combobox = new JComboBox();
		tel_combobox.setBounds(93, 29, 120, 30);
		main_panel.add(tel_combobox);
		Tellist tellist = new Tellist(this.groupnum);
		try {
			this.tellist = tellist.getTelConnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<this.tellist.size(); i++) {
			tel_combobox.addItem(this.tellist.get(i));
		}
		
		sms_textarea = new JTextArea();
		sms_textarea.setBounds(12, 78, 260, 162);
		main_panel.add(sms_textarea);
		
		send_button = new JButton("SEND");
		send_button.setBackground(new Color(100,200,200));
		send_button.setFont(new Font("굴림", Font.BOLD, 12));
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
		// TODO sned_button event
		if(e.getSource() == send_button) {
			if(MenuFrame.user.getCoin()>=25) {
				//TODO 메세지전송 주석처리부분
				//SendMessage(sms_textarea.getText(), tel_combobox.getSelectedItem().toString());//실제 메세지 전송
				Coin coin = new Coin();
				coin.setUser_id(MenuFrame.user.getUser_id());
				try {
					int result = coin.cutcoinConnect();
					if(result == 0) {
						System.out.println("error!");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "메세지가 전송되었습니다");
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "코인을 충전해주세요");
			}
		}
	}
	
	public void SendMessage(String text, String tel) {
		//TODO 메세지 전송 메소드/훈희계정
		String api_key = "NCS2GTD8TN3E6G5S";
		String api_secret = "EA5GCB32L5ZGGDOUUFFZWLAV49J1GB4E";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", tel); // 수신번호
		params.put("from", "01025455627"); // 발신번호
		params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
		params.put("text", text); // 문자내용
		params.put("app_version", "JAVA SDK v1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}

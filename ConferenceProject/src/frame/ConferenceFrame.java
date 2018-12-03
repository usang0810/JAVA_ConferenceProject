package frame;
//GUI test class
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import http.Nicklist;
import model.User;

public class ConferenceFrame extends JFrame implements ActionListener, KeyListener{
	private static final int PORT = 8081;
	private static final String HTTP= "182.209.99.31";
	private User user = null;
	public static int groupnum;
	
	List list = new List();
	public static Socket socket;
	DataOutputStream out;
	
	//채팅창 사이즈
	private static final int CHAT_WIDTH = 860;
	private static final int CHAT_HEIGHT = 640;
	private static final int CHAT_SCREEN_WIDTH = 844;
	private static final int CHAT_SCREEN_HEIGHT = 601;
	//image icon
	public ImageIcon chatbackground_image = new ImageIcon(ConferenceFrame.class.getResource("/images/chatting_background.jpg"));

	private JPanel selectgroup_panel, chat_panel;
	private JButton send_button, file_button, exit_button, sms_button;
	private JTextArea chatlist_textarea, userlist_textarea;
	private JTextField send_tf;
	private JLabel userlist_label;
	public ArrayList<String> nicknamelist = null;
			
	public ConferenceFrame(User user, int groupnum) {
		this.user = user;
		this.groupnum = groupnum;
		init(user.getNickname());
		
		setTitle("conferencesystem/"+Main.GROUP_NAME[groupnum-1]+"/chatting");
		setSize(CHAT_WIDTH, CHAT_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//채팅 패널 생성
		chat_panel = new JPanel();
		chat_panel.setBounds(0, 0, CHAT_SCREEN_WIDTH, CHAT_SCREEN_HEIGHT);
		getContentPane().add(chat_panel);
		chat_panel.setLayout(null);
		
		
		chatlist_textarea = new JTextArea();
		chatlist_textarea.setLineWrap(true); // 자동 개행
		chatlist_textarea.setWrapStyleWord(true); // 행을 넘길 때 행의 마지막 단어가 두행에 걸쳐 나뉘지 않도록 하기
		chatlist_textarea.setEditable(false);
		JScrollPane chatlist_scrollpane= new JScrollPane(chatlist_textarea);
		chatlist_scrollpane.setBounds(286, 142, 450, 370);
		chatlist_scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 수직 스크롤바 표시 정책 : 항상 보여주기
		chat_panel.add(chatlist_scrollpane);
		
		send_tf = new JTextField();
		send_tf.setBounds(286, 522, 255, 21);
		send_tf.setBorder(null);
		chat_panel.add(send_tf);
		send_tf.setColumns(10);
		send_tf.addKeyListener(this);
		
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
		
		exit_button = new JButton("EXIT");
		exit_button.setBounds(95, 493, 135, 50);
		exit_button.setBackground(new Color(100,200,200));
		exit_button.addActionListener(this);
		chat_panel.add(exit_button);
		
		sms_button = new JButton("SMS service");
		sms_button.setBounds(95, 433, 135, 50);
		sms_button.setBackground(new Color(100,200,200));
		sms_button.addActionListener(this);
		chat_panel.add(sms_button);
		
		userlist_textarea = new JTextArea();
		userlist_textarea.setLineWrap(true); // 자동 개행
		userlist_textarea.setWrapStyleWord(true); // 행을 넘길 때 행의 마지막 단어가 두행에 걸쳐 나뉘지 않도록 하기
		userlist_textarea.setEditable(false);
		JScrollPane userlist_scrollpane= new JScrollPane(userlist_textarea);
		userlist_scrollpane.setBounds(95, 172, 135, 251);
		userlist_scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 수직 스크롤바 표시 정책 : 항상 보여주기
		userlist_scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);// 수평 스크롤바 표시 정책 : 항상
		chat_panel.add(userlist_scrollpane);
		
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
		
		Nicklist nicklist = new Nicklist(this.groupnum);
		
		try {
			nicknamelist = nicklist.getNickConnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//TODO nicknamelist 구하는 코드
		for(int j=0; j<nicknamelist.size(); j++) {
			userlist_textarea.append(nicknamelist.get(j)+"\n");
		}
		
		this.addWindowListener(new WindowAdapter() {
			//TODO 제목표시줄의 x버튼 눌렀을때의 이벤트
			public void windowClosing(WindowEvent e) {
				try {
					Thread.sleep(500);
				}catch(InterruptedException e2) {
					
				}
				Thread.interrupted();
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == sms_button) {
			SMSFrame smsfrmae = new SMSFrame(this.groupnum);
		}else if(e.getSource() == send_button) {
			try {
				out.writeUTF("[" + user.getNickname() + "] : " +"$"+Integer.toString(this.groupnum)+"$"+send_tf.getText());
				}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			send_tf.setText("");
		}else if(e.getSource() == exit_button) {
			//TODO Thread에 interrupted로 종료
			try {
				Thread.sleep(500);
			}catch(InterruptedException e2) {
				
			}
			Thread.interrupted();
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				out.writeUTF("[" + user.getNickname() + "] : " +"$"+Integer.toString(this.groupnum)+"$"+send_tf.getText());
				}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			send_tf.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void init(String uid) {
		try {
			// 소켓을 생성하여 연결을 요청한다.
			socket = new Socket(HTTP, PORT);
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("서버에 연결되었습니다.");
			// 접속자 이름전송
			out.writeUTF(uid+"$"+Integer.toString(this.groupnum)+"$");

			// Thread sender = new Thread(new ClientSender(socket, uid));
			Thread receiver = new Thread(new ClientReceiver(socket));

			// sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
		}
	}

	class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
			}
		}

		public void run() {
			while (in != null) {
				try {
					String re = in.readUTF();
					//System.out.println(re);
					String[] text = re.split("\\$");
					//for(int i=0; i<text.length; i++) {System.out.println(i+" = "+text[i]);}
					int num = Integer.parseInt(text[1]);
					re = "";
					for(int i=0; i<text.length; i++) {
						if(i==1) {
							continue;
						}
						re = re.concat(text[i]);
						//System.out.println(re);
					}
					if(num == ConferenceFrame.groupnum) {
						chatlist_textarea.append(re+"\n");
						chatlist_textarea.setCaretPosition(chatlist_textarea.getDocument().getLength());
					}
					//System.out.println(re);
					list.add(re);
					if(Thread.interrupted()) {
						break;
					}
				} catch (IOException e) {
				}
			}
			//System.out.println("Thread exit");
		} // run
	}// end class ClientReceiver
}

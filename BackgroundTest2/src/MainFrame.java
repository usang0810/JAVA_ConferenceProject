//로그인 패널, 회원가입 패널, 메뉴 패널, 회원정보 수정 패널
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener, MouseListener{
	
	public ImageIcon loginbackground_image= new ImageIcon(MainFrame.class.getResource("/images/login_background.png"));
	public ImageIcon loginbefore_image= new ImageIcon(MainFrame.class.getResource("/images/login_before.png"));
	public ImageIcon loginafter_image= new ImageIcon(MainFrame.class.getResource("/images/login_after.png"));
	public ImageIcon signupbackground_image = new ImageIcon(MainFrame.class.getResource("/images/signup_background.png"));
	public ImageIcon signupbefore_image = new ImageIcon(MainFrame.class.getResource("/images/signup_before.png"));
	public ImageIcon signupafter_image = new ImageIcon(MainFrame.class.getResource("/images/signup_after.png"));
	public ImageIcon menubackground_image = new ImageIcon(MainFrame.class.getResource("/images/menu_background.png"));
	public ImageIcon calendarbefore_image = new ImageIcon(MainFrame.class.getResource("/images/calendar_before.png"));
	public ImageIcon calendarafter_image = new ImageIcon(MainFrame.class.getResource("/images/calendar_after.png"));
	public ImageIcon chatbefore_image = new ImageIcon(MainFrame.class.getResource("/images/chat_before.png"));
	public ImageIcon chatafter_image = new ImageIcon(MainFrame.class.getResource("/images/chat_after.png"));
	public ImageIcon coinbefore_image = new ImageIcon(MainFrame.class.getResource("/images/coin_before.png"));
	public ImageIcon coinafter_image = new ImageIcon(MainFrame.class.getResource("/images/coin_after.png"));
	public ImageIcon setbefore_image = new ImageIcon(MainFrame.class.getResource("/images/set_before.png"));
	public ImageIcon setafter_image = new ImageIcon(MainFrame.class.getResource("/images/set_after.png"));
	
	public JPanel login_panel, signup_panel, menu_panel;
	private JButton login_button, login_signup_button, signup_signup_button, calendar_button, chat_button, set_button, coin_button;
	private JTextField login_id_tf, signup_id_tf, nickname_tf, tel1_tf, tel2_tf;
	private JPasswordField login_pw_tf, signup_pw_tf, pwck_tf;
	private JOptionPane signupmessage;
	
	public MainFrame() {
		setTitle("conferencesystem/login");
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//로그인 패널 생성
		login_panel = new JPanel();
		login_panel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		getContentPane().add(login_panel);
		login_panel.setLayout(null);
				
		login_button = new JButton();
		login_button.setBounds(462, 286, 287, 55);
		login_button.setIcon(loginbefore_image);
		login_button.setBorderPainted(false);//테두리 없음
		login_button.setContentAreaFilled(false);//배경 없음
		login_button.setFocusPainted(false);//포커스 없음
		login_button.addMouseListener(this);
		login_panel.add(login_button);
		
		login_id_tf = new JTextField("ID");
		login_id_tf.setFont(new Font("굴림", Font.BOLD, 15));
		login_id_tf.setForeground(Color.WHITE);
		login_id_tf.setBounds(507, 129, 242, 38);
		login_id_tf.setColumns(10);
		login_id_tf.setOpaque(false);//배경 없음
		login_id_tf.setBorder(null);//테두리 없음
		login_id_tf.addMouseListener(this);
		login_panel.add(login_id_tf);
		
		login_pw_tf = new JPasswordField("password");
		login_pw_tf.setFont(new Font("굴림", Font.BOLD, 15));
		login_pw_tf.setForeground(Color.WHITE);
		login_pw_tf.setBounds(507, 186, 242, 38);
		login_pw_tf.setOpaque(false);
		login_pw_tf.setBorder(null);
		login_pw_tf.addMouseListener(this);
		login_panel.add(login_pw_tf);
		
		login_signup_button = new JButton();
		login_signup_button.setBounds(462, 353, 63, 23);
		login_signup_button.setBorderPainted(false);
		login_signup_button.setContentAreaFilled(false);
		login_signup_button.setFocusPainted(false);
		login_panel.add(login_signup_button);
		login_signup_button.addMouseListener(this);
		
		JLabel loginbackground_label = new JLabel();
		loginbackground_label.setIcon(loginbackground_image);
		loginbackground_label.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		login_panel.add(loginbackground_label);
		
		
		//회원가입 패널 생성
		signup_panel = new JPanel();
		signup_panel.setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		getContentPane().add(signup_panel);
		signup_panel.setLayout(null);
		
		signup_signup_button = new JButton("New button");
		signup_signup_button.setIcon(signupbefore_image);
		signup_signup_button.setBounds(298, 382, 287, 55);
		signup_signup_button.setBorderPainted(false);
		signup_signup_button.setContentAreaFilled(false);
		signup_signup_button.setFocusPainted(false);
		signup_signup_button.addMouseListener(this);
		signup_panel.add(signup_signup_button);
		
		signup_id_tf = new JTextField();
		signup_id_tf.setBounds(230, 185, 188, 20);
		signup_id_tf.setBorder(null);
		signup_panel.add(signup_id_tf);
		signup_id_tf.setColumns(10);
		signup_id_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length()>=12) {//글자수 최대 12자
					ke.consume();
				}
			}
		});
		
		signup_pw_tf = new JPasswordField();
		signup_pw_tf.setBounds(230, 212, 188, 20);
		signup_pw_tf.setBorder(null);
		signup_panel.add(signup_pw_tf);
		signup_pw_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length()>=15) {//글자수 최대 15자
					ke.consume();
				}
			}
		});
		
		pwck_tf = new JPasswordField();
		pwck_tf.setBounds(230, 238, 188, 20);
		pwck_tf.setBorder(null);
		signup_panel.add(pwck_tf);
		pwck_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length()>=15) {//글자수 최대 15자
					ke.consume();
				}
			}
		});
		
		nickname_tf = new JTextField();
		nickname_tf.setColumns(10);
		nickname_tf.setBounds(230, 264, 188, 20);
		nickname_tf.setBorder(null);
		signup_panel.add(nickname_tf);
		nickname_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length()>=12) {//글자수 최대 12자
					ke.consume();
				}
			}
		});
		
		JComboBox tel_combobox = new JComboBox();
		tel_combobox.setFont(new Font("굴림", Font.PLAIN, 10));
		tel_combobox.setModel(new DefaultComboBoxModel(new String[] {"010", "019", "011"}));
		tel_combobox.setMaximumRowCount(3);
		tel_combobox.setBounds(230, 291, 43, 20);
		signup_panel.add(tel_combobox);
		
		JLabel tel1_label = new JLabel("-");
		tel1_label.setForeground(Color.WHITE);
		tel1_label.setBounds(285, 293, 13, 15);
		signup_panel.add(tel1_label);
		
		tel1_tf = new JTextField();
		tel1_tf.setBounds(305, 291, 40, 21);
		tel1_tf.setBorder(null);
		signup_panel.add(tel1_tf);
		tel1_tf.setColumns(4);
		tel1_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				
				if(!Character.isDigit(c)) {//문자 입력 시 컨슘
					ke.consume();
				}
				if(((JTextField)ke.getSource()).getText().length()>=4) {//글자수 최대 4자
					ke.consume();
				}
			}
		});
		
		JLabel tel2_label = new JLabel("-");
		tel2_label.setForeground(Color.WHITE);
		tel2_label.setBounds(358, 293, 13, 15);
		signup_panel.add(tel2_label);
		
		tel2_tf = new JTextField();
		tel2_tf.setColumns(4);
		tel2_tf.setBounds(378, 291, 40, 21);
		tel2_tf.setBorder(null);
		signup_panel.add(tel2_tf);
		tel2_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				
				if(!Character.isDigit(c)) {//문자 입력 시 컨슘
					ke.consume();
				}
				if(((JTextField)ke.getSource()).getText().length()>=4) {//글자수 최대 4자
					ke.consume();
				}
			}
		});
		
		JCheckBox basicproject_checkbox = new JCheckBox("Basic Project");
		basicproject_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		basicproject_checkbox.setForeground(Color.WHITE);
		basicproject_checkbox.setBounds(538, 185, 127, 23);
		basicproject_checkbox.setOpaque(false);
		signup_panel.add(basicproject_checkbox);
		
		JCheckBox expertproject_checkbox = new JCheckBox("Expert Project");
		expertproject_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		expertproject_checkbox.setForeground(Color.WHITE);
		expertproject_checkbox.setBounds(538, 215, 141, 23);
		expertproject_checkbox.setOpaque(false);
		signup_panel.add(expertproject_checkbox);
		
		JCheckBox lolgroup_checkbox = new JCheckBox("LOL GROUP");
		lolgroup_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		lolgroup_checkbox.setForeground(Color.WHITE);
		lolgroup_checkbox.setBounds(538, 245, 115, 23);
		lolgroup_checkbox.setOpaque(false);
		signup_panel.add(lolgroup_checkbox);
		
		JCheckBox battlegroundgroup_checkbox = new JCheckBox("Battleground GROUP");
		battlegroundgroup_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		battlegroundgroup_checkbox.setForeground(Color.WHITE);
		battlegroundgroup_checkbox.setBounds(538, 275, 176, 23);
		battlegroundgroup_checkbox.setOpaque(false);
		signup_panel.add(battlegroundgroup_checkbox);
		
		JCheckBox etc_checkbox = new JCheckBox("ETC");
		etc_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		etc_checkbox.setForeground(Color.WHITE);
		etc_checkbox.setBounds(538, 305, 141, 23);
		etc_checkbox.setOpaque(false);
		signup_panel.add(etc_checkbox);
		
		JLabel signupbackground_label = new JLabel();
		signupbackground_label.setIcon(signupbackground_image);
		signupbackground_label.setBounds(0, 0, Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		signup_panel.add(signupbackground_label);
		
		
		//메뉴 패널 생성
		menu_panel = new JPanel();
		menu_panel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		getContentPane().add(menu_panel);
		getContentPane().setLayout(null);
		menu_panel.setLayout(null);
		
		calendar_button = new JButton();
		calendar_button.setBounds(85, 259, 160, 160);
		calendar_button.setIcon(calendarbefore_image);
		calendar_button.setBorderPainted(false);
		calendar_button.setContentAreaFilled(false);
		calendar_button.setFocusPainted(false);
		menu_panel.add(calendar_button);
		calendar_button.addMouseListener(this);
		
		chat_button = new JButton();
		chat_button.setBounds(271, 259, 160, 160);
		chat_button.setIcon(chatbefore_image);
		chat_button.setBorderPainted(false);
		chat_button.setContentAreaFilled(false);
		chat_button.setFocusPainted(false);
		menu_panel.add(chat_button);
		chat_button.addMouseListener(this);
		
		coin_button = new JButton();
		coin_button.setBounds(457, 259, 160, 160);
		coin_button.setIcon(coinbefore_image);
		coin_button.setBorderPainted(false);
		coin_button.setContentAreaFilled(false);
		coin_button.setFocusPainted(false);
		menu_panel.add(coin_button);
		coin_button.addMouseListener(this);
		
		set_button = new JButton();
		set_button.setBounds(641, 259, 160, 160);
		set_button.setIcon(setbefore_image);
		set_button.setBorderPainted(false);
		set_button.setContentAreaFilled(false);
		set_button.setFocusPainted(false);
		menu_panel.add(set_button);
		set_button.addMouseListener(this);

		JLabel menubackground_label = new JLabel();
		menubackground_label.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		menubackground_label.setIcon(menubackground_image);
		menu_panel.add(menubackground_label);
		
		setVisible(true);
		signup_panel.setVisible(false);
		menu_panel.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login_button) {//로그인 화면의 로그인 버튼
			login_panel.setVisible(false);
			setTitle("conferencesystem/menu");
			menu_panel.setVisible(true);
		}else if(e.getSource() == login_signup_button) {//로그인 화면의 회원가입 버튼
			login_panel.setVisible(false);
			setTitle("conferencesystem/signup");
			signup_panel.setVisible(true);
		}else if(e.getSource() == signup_signup_button) {//회원가입화면의 회원가입 버튼
			signup_panel.setVisible(false);
			setTitle("conferencesystem/login");
			login_panel.setVisible(true);
			signupmessage.showMessageDialog(null, "Welcome to Conference System");
		}else if(e.getSource() == login_id_tf) {
			login_id_tf.setText(null);
		}else if(e.getSource() == login_pw_tf) {
			login_pw_tf.setText(null);
		}else if(e.getSource() == calendar_button) {
			CalendarFrame calendarframe = new CalendarFrame();
		}else if(e.getSource() == chat_button) {
			ConferenceFrame conferenceframe = new ConferenceFrame();
		}else if(e.getSource() == coin_button) {
			CoinFrame coinframe = new CoinFrame();
		}else if(e.getSource() == set_button) {
			SetFrame setframe = new SetFrame();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login_button) {
			login_button.setIcon(loginafter_image);
		}else if(e.getSource() == signup_signup_button) {
			signup_signup_button.setIcon(signupafter_image);
		}else if(e.getSource() == calendar_button) {
			calendar_button.setIcon(calendarafter_image);
		}else if(e.getSource() == chat_button) {
			chat_button.setIcon(chatafter_image);
		}else if(e.getSource() == coin_button) {
			coin_button.setIcon(coinafter_image);
		}else if(e.getSource() == set_button) {
			set_button.setIcon(setafter_image);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login_button) {
			login_button.setIcon(loginbefore_image);
		}else if(e.getSource() == signup_signup_button) {
			signup_signup_button.setIcon(signupbefore_image);
		}else if(e.getSource() == calendar_button) {
			calendar_button.setIcon(calendarbefore_image);
		}else if(e.getSource() == chat_button) {
			chat_button.setIcon(chatbefore_image);
		}else if(e.getSource() == coin_button) {
			coin_button.setIcon(coinbefore_image);
		}else if(e.getSource() == set_button) {
			set_button.setIcon(setbefore_image);
		}
	}
}

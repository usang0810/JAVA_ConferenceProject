package frame;
//�α��� �г�, ȸ������ �г�, �޴� �г�, ȸ������ ���� �г�
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

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

import http.Login;
import http.Signup;
import model.User;

public class MainFrame extends JFrame implements MouseListener, KeyListener{
	User user = null;
	
	public ImageIcon loginbackground_image= new ImageIcon(MainFrame.class.getResource("/images/login_background.png"));
	public ImageIcon loginbefore_image= new ImageIcon(MainFrame.class.getResource("/images/login_before.png"));
	public ImageIcon loginafter_image= new ImageIcon(MainFrame.class.getResource("/images/login_after.png"));
	public ImageIcon signupbackground_image = new ImageIcon(MainFrame.class.getResource("/images/signup_background.png"));
	public ImageIcon signupbefore_image = new ImageIcon(MainFrame.class.getResource("/images/signup_before.png"));
	public ImageIcon signupafter_image = new ImageIcon(MainFrame.class.getResource("/images/signup_after.png"));
	public ImageIcon backbefore_image = new ImageIcon(MainFrame.class.getResource("/images/back_before.jpg"));
	public ImageIcon backafter_image = new ImageIcon(MainFrame.class.getResource("/images/back_after.jpg"));
	//
	public JPanel login_panel, signup_panel;
	private JButton login_button, login_signup_button, signup_signup_button, back_button;
	private JTextField login_id_tf, signup_id_tf, nickname_tf, tel1_tf, tel2_tf, login_pw_tf, signup_pw_tf, pwck_tf;
	private JOptionPane signupmessage;
	private JComboBox tel_combobox;
	private JCheckBox[] signup_checkbox = new JCheckBox[5];
	
	public MainFrame() {//������ �α��� �г�
		setTitle("conferencesystem/login");
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		setResizable(false);//âũ������ �Ұ�
		setLocationRelativeTo(null);//ȭ���߾ӿ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�α��� �г� ����
		login_panel = new JPanel();
		login_panel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		getContentPane().add(login_panel);
		login_panel.setLayout(null);
				
		login_button = new JButton();
		login_button.setBounds(462, 286, 287, 55);
		login_button.setIcon(loginbefore_image);
		login_button.setBorderPainted(false);//�׵θ� ����
		login_button.setContentAreaFilled(false);//��� ����
		login_button.setFocusPainted(false);//��Ŀ�� ����
		login_button.addMouseListener(this);
		login_panel.add(login_button);
		
		login_id_tf = new JTextField("ID");
		login_id_tf.setFont(new Font("����", Font.BOLD, 15));
		login_id_tf.setForeground(Color.WHITE);
		login_id_tf.setBounds(507, 129, 242, 38);
		login_id_tf.setColumns(10);
		login_id_tf.setOpaque(false);//��� ����
		login_id_tf.setBorder(null);//�׵θ� ����
		login_id_tf.addMouseListener(this);
		login_id_tf.addKeyListener(this);
		login_panel.add(login_id_tf);
		
		login_pw_tf = new JPasswordField("password");
		login_pw_tf.setFont(new Font("����", Font.BOLD, 15));
		login_pw_tf.setForeground(Color.WHITE);
		login_pw_tf.setBounds(507, 186, 242, 38);
		login_pw_tf.setOpaque(false);
		login_pw_tf.setBorder(null);
		login_pw_tf.addMouseListener(this);
		login_pw_tf.addKeyListener(this);
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
		
		
		//ȸ������ �г� ����
		signup_panel = new JPanel();
		signup_panel.setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		getContentPane().add(signup_panel);
		signup_panel.setLayout(null);
		
		back_button = new JButton();
		back_button.setIcon(backbefore_image);
		back_button.setBounds(0, 0, 50, 50);
		back_button.setBorderPainted(false);
		back_button.setContentAreaFilled(false);
		back_button.setFocusPainted(false);
		back_button.addMouseListener(this);
		signup_panel.add(back_button);
		
		signup_signup_button = new JButton();
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
				if(((JTextField)ke.getSource()).getText().length()>=12) {//���ڼ� �ִ� 12��
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
				if(((JTextField)ke.getSource()).getText().length()>=15) {//���ڼ� �ִ� 15��
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
				if(((JTextField)ke.getSource()).getText().length()>=15) {//���ڼ� �ִ� 15��
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
				if(((JTextField)ke.getSource()).getText().length()>=12) {//���ڼ� �ִ� 12��
					ke.consume();
				}
			}
		});
		
		tel_combobox = new JComboBox();
		tel_combobox.setFont(new Font("����", Font.PLAIN, 10));
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
				
				if(!Character.isDigit(c)) {//���� �Է� �� ����
					ke.consume();
				}
				if(((JTextField)ke.getSource()).getText().length()>=4) {//���ڼ� �ִ� 4��
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
				
				if(!Character.isDigit(c)) {//���� �Է� �� ����
					ke.consume();
				}
				if(((JTextField)ke.getSource()).getText().length()>=4) {//���ڼ� �ִ� 4��
					ke.consume();
				}
			}
		});
		
		for(int i=0; i<5; i++) {
			signup_checkbox[i] = new JCheckBox(Main.GROUP_NAME[i]);
			signup_checkbox[i].setFont(new Font("����", Font.BOLD, 12));
			signup_checkbox[i].setForeground(Color.WHITE);
			signup_checkbox[i].setOpaque(false);
			signup_panel.add(signup_checkbox[i]);
		}
		signup_checkbox[0].setBounds(538, 185, 127, 23);
		signup_checkbox[1].setBounds(538, 215, 141, 23);
		signup_checkbox[2].setBounds(538, 245, 115, 23);
		signup_checkbox[3].setBounds(538, 275, 176, 23);
		signup_checkbox[4].setBounds(538, 305, 141, 23);

		
		JLabel signupbackground_label = new JLabel();
		signupbackground_label.setIcon(signupbackground_image);
		signupbackground_label.setBounds(0, 0, Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		signup_panel.add(signupbackground_label);
		
		setVisible(true);
		signup_panel.setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login_button) {
			//TODO �α��� ȭ���� �α��� ��ư
			Login login = new Login();
			login.setIdPw(login_id_tf.getText(), login_pw_tf.getText());
			try {
				user = login.loginConnect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(user==null) {
				signupmessage.showMessageDialog(null, "������ ��ġ���� �ʽ��ϴ�!");
				return;
			}else {
				System.out.println("login success");
				this.setVisible(false);
				SelectGroupFrame selectgroupframe = new SelectGroupFrame(user);
			}
			
		}else if(e.getSource() == login_signup_button) {//�α��� ȭ���� ȸ������ ��ư
			login_panel.setVisible(false);
			setTitle("conferencesystem/signup");
			signup_panel.setVisible(true);
		}else if(e.getSource() == signup_signup_button) {//ȸ������ȭ���� ȸ������ ��ư
			if(signup_id_tf.getText().equals("")) {
				signupmessage.showMessageDialog(null, "ID�� �Է����ּ���!");
				return;
			}
			if(signup_pw_tf.getText().equals("")) {
				signupmessage.showMessageDialog(null, "PW�� �Է����ּ���!");
				return;
			}
			if(!signup_pw_tf.getText().equals(pwck_tf.getText())) {//pw�� pwck�� ���� �ʴٸ� �����޼���
				signupmessage.showMessageDialog(null, "PW�� Ȯ�����ּ���!");
				return;
			}
			if(nickname_tf.getText().equals("")) {
				signupmessage.showMessageDialog(null, "NICKNAME�� �Է����ּ���!");
				return;
			}
			if(tel1_tf.getText().equals("")||tel2_tf.getText().equals("")) {
				signupmessage.showMessageDialog(null, "��ȭ��ȣ�� �Է����ּ���!");
				return;
			}
			int cnt=0;
			for(int i=0; i<5; i++) {
				if(signup_checkbox[i].isSelected() == true) {
					cnt++;
				}
			}
			if(cnt<=0) {
				signupmessage.showMessageDialog(null, "1���̻��� �׷��� ������ �ּ���!");
				return;
			}
			String user_tel = tel_combobox.getSelectedItem().toString() + tel1_tf.getText() + tel2_tf.getText();//��ȭ��ȣ ��ġ��
			int[] g = new int[5];//�׷��� �� ������ ������ / isSelected()=üũ���ִٸ� true��ȯ
			for(int i=0; i<5; i++) {
				if(signup_checkbox[i].isSelected() == true) {
					g[i] = 1;
				}else {
					g[i] = 0;
				}
			}
			Signup signup = new Signup();
			signup.setUserinfo(signup_id_tf.getText(), signup_pw_tf.getText(), nickname_tf.getText(), user_tel, 
					Integer.toString(g[0]), Integer.toString(g[1]), Integer.toString(g[2]), Integer.toString(g[3]), Integer.toString(g[4]));
			try {
				if(signup.signupConnect()==0) {
					signupmessage.showMessageDialog(null, "error");
					return;
				}else {
					signup_panel.setVisible(false);
					setTitle("conferencesystem/login");
					login_panel.setVisible(true);
					signupmessage.showMessageDialog(null, "Welcome to Conference System");//ȸ������ ȯ�� ���̾�α� ����
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == login_id_tf) {//id_tf Ŭ���� �ʱ�ȭ
			login_id_tf.setText(null);
		}else if(e.getSource() == login_pw_tf) {//pw_tf Ŭ���� �ʱ�ȭ
			login_pw_tf.setText(null);
		}else if(e.getSource() == back_button) {
			signup_panel.setVisible(false);
			login_panel.setVisible(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {//��ư���� ���콺 ���� �� �̹��� ��ȯ
		// TODO Auto-generated method stub
		if(e.getSource() == login_button) {
			login_button.setIcon(loginafter_image);
		}else if(e.getSource() == signup_signup_button) {
			signup_signup_button.setIcon(signupafter_image);
		}else if(e.getSource() == back_button) {
			back_button.setIcon(backafter_image);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {//��ư���� ���콺 ���� �� �̹��� ��ȯ
		// TODO Auto-generated method stub
		if(e.getSource() == login_button) {
			login_button.setIcon(loginbefore_image);
		}else if(e.getSource() == signup_signup_button) {
			signup_signup_button.setIcon(signupbefore_image);
		}else if(e.getSource() == back_button) {
			back_button.setIcon(backbefore_image);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			Login login = new Login();
			login.setIdPw(login_id_tf.getText(), login_pw_tf.getText());
			try {
				user = login.loginConnect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(user==null) {
				signupmessage.showMessageDialog(null, "������ ��ġ���� �ʽ��ϴ�!");
				return;
			}else {
				System.out.println("login success");
				this.setVisible(false);
				SelectGroupFrame selectgroupframe = new SelectGroupFrame(user);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

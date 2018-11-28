package frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import http.Set;
import model.User;

public class SetFrame extends JFrame implements MouseListener{
	private User user = null;
	//image icon
	public ImageIcon setbackground_image = new ImageIcon(MainFrame.class.getResource("/images/set_background.jpg"));
	public ImageIcon completebefore_image = new ImageIcon(SetFrame.class.getResource("/images/complete_before.jpg"));
	public ImageIcon completeafter_image = new ImageIcon(SetFrame.class.getResource("/images/complete_after.jpg"));
	
	private JPanel main_panel;
	private JButton set_button;
	private JTextField nickname_tf, tel1_tf, tel2_tf, pw_tf, pwck_tf;
	private JComboBox tel_combobox;
	private JCheckBox[] add_checkbox = new JCheckBox[5];
	private JCheckBox[] delete_checkbox = new JCheckBox[5];
	
	public SetFrame(User user) {
		this.user = user;
		
		setTitle("conferencesystem/set");
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		main_panel = new JPanel();
		main_panel.setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		JLabel id_label = new JLabel(user.getUser_id());//ID label MainFrame의 login_id값을 가져옴
		id_label.setForeground(Color.WHITE);
		id_label.setBounds(230, 186, 188, 20);
		main_panel.add(id_label);
		
		set_button = new JButton("Complete");
		set_button.setBounds(298, 382, 287, 55);
		set_button.setIcon(completebefore_image);
		set_button.setBorderPainted(false);
		set_button.setContentAreaFilled(false);
		set_button.setFocusPainted(false);
		set_button.addMouseListener(this);
		main_panel.add(set_button);
		
		pw_tf = new JPasswordField();
		pw_tf.setBounds(230, 212, 188, 20);
		pw_tf.setBorder(null);
		main_panel.add(pw_tf);
		pw_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length()>=15) {//글자수 최대 15자
					ke.consume();
				}
			}
		});
		
		pwck_tf = new JPasswordField();
		pwck_tf.setBounds(230, 238, 188, 20);
		pwck_tf.setBorder(null);
		main_panel.add(pwck_tf);
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
		main_panel.add(nickname_tf);
		nickname_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if(((JTextField)ke.getSource()).getText().length()>=12) {//글자수 최대 12자
					ke.consume();
				}
			}
		});
		
		tel_combobox = new JComboBox();
		tel_combobox.setFont(new Font("굴림", Font.PLAIN, 10));
		tel_combobox.setModel(new DefaultComboBoxModel(new String[] {"010", "019", "011"}));
		tel_combobox.setMaximumRowCount(3);
		tel_combobox.setBounds(230, 291, 43, 20);
		main_panel.add(tel_combobox);
		
		JLabel tel1_label = new JLabel("-");
		tel1_label.setForeground(Color.WHITE);
		tel1_label.setBounds(285, 293, 13, 15);
		main_panel.add(tel1_label);
		
		tel1_tf = new JTextField();
		tel1_tf.setBounds(305, 291, 40, 21);
		tel1_tf.setBorder(null);
		main_panel.add(tel1_tf);
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
		main_panel.add(tel2_label);
		
		tel2_tf = new JTextField();
		tel2_tf.setColumns(4);
		tel2_tf.setBounds(378, 291, 40, 21);
		tel2_tf.setBorder(null);
		main_panel.add(tel2_tf);
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
		
		for(int i=0; i<5; i++) {
			add_checkbox[i] = new JCheckBox(Main.GROUP_NAME[i]);
			add_checkbox[i].setFont(new Font("굴림", Font.BOLD, 12));
			add_checkbox[i].setForeground(Color.WHITE);
			add_checkbox[i].setOpaque(false);
			main_panel.add(add_checkbox[i]);
		}
		add_checkbox[0].setBounds(471, 186, 127, 23);
		add_checkbox[1].setBounds(471, 216, 141, 23);
		add_checkbox[2].setBounds(471, 246, 115, 23);
		add_checkbox[3].setBounds(471, 276, 176, 23);
		add_checkbox[4].setBounds(471, 306, 141, 23);
		
		
		for(int i=0; i<5; i++) {
			delete_checkbox[i] = new JCheckBox(Main.GROUP_NAME[i]);
			delete_checkbox[i].setFont(new Font("굴림", Font.BOLD, 12));
			delete_checkbox[i].setForeground(Color.WHITE);
			delete_checkbox[i].setOpaque(false);
			main_panel.add(delete_checkbox[i]);
		}
		delete_checkbox[0].setBounds(645, 186, 127, 23);
		delete_checkbox[1].setBounds(645, 216, 141, 23);
		delete_checkbox[2].setBounds(645, 246, 115, 23);
		delete_checkbox[3].setBounds(645, 276, 176, 23);
		delete_checkbox[4].setBounds(645, 306, 141, 23);
		
		JLabel setbackground_label = new JLabel();
		setbackground_label.setBounds(0, 0, Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setbackground_label.setIcon(setbackground_image);
		main_panel.add(setbackground_label);
		
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==set_button) {
			if(pw_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "PW를 입력해주세요!");//messagedialog
				return;
			}
			if(!pw_tf.getText().equals(pwck_tf.getText())) {
				JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다!");//messagedialog
				return;
			}
			if(nickname_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "NICKNAME을 입력해주세요!");//messagedialog
				return;
			}
			Set set = new Set();
			set.setNick(nickname_tf.getText());
			int nickname_check = -2;
			try {
				nickname_check = set.setConnect();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(nickname_check==-1) {
				JOptionPane.showMessageDialog(null, "NICKNAME이 중복입니다!");
				return;
			}
			if(tel1_tf.getText().equals("")||tel2_tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요!");//messagedialog
				return;
			}
			String user_tel = tel_combobox.getSelectedItem().toString() + tel1_tf.getText() + tel2_tf.getText();//전화번호 합치기
			int[] g = new int[5];//그룹의 값 저장할 변수들 / isSelected()=체크되있다면 true반환
			g[0] = user.getG1();
			g[1] = user.getG2();
			g[2] = user.getG3();
			g[3] = user.getG4();
			g[4] = user.getG5();
			
			for(int i=0; i<5; i++) {
				if(add_checkbox[i].isSelected() == true && delete_checkbox[i].isSelected() ==true) {
					JOptionPane.showMessageDialog(null, "같은 그룹의 중복체크는 안됩니다");//messagedialog
					return;
				}else if(add_checkbox[i].isSelected() == true) {
					g[i] = 1;
				}else if(delete_checkbox[i].isSelected() == true) {
					g[i] = 0;
				}
			}
			
			set.setUserinfo(user.getUser_id(), pw_tf.getText(), nickname_tf.getText(), user_tel, 
					Integer.toString(g[0]), Integer.toString(g[1]), Integer.toString(g[2]), Integer.toString(g[3]), Integer.toString(g[4]));
			int update_check = 0;
			try {
				update_check = set.setConnect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(update_check ==0) {
				JOptionPane.showMessageDialog(null, "ERROR!");//messagedialog
				return;
			}else {
				user.setUserinfo(user.getUser_id(), pw_tf.getText(), nickname_tf.getText(), user_tel,
					g[0], g[1], g[2], g[3], g[4]);
				MenuFrame.user = this.user;
				setVisible(false);
				JOptionPane.showMessageDialog(null, "수정 완료!");//messagedialog
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == set_button) {
			set_button.setIcon(completeafter_image);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == set_button) {
			set_button.setIcon(completebefore_image);
		}
	}

}

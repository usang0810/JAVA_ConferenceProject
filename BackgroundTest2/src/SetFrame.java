import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.SwingConstants;

public class SetFrame extends JFrame{
	DBConnection connection = new DBConnection();
	//image icon
	public ImageIcon setbackground_image = new ImageIcon(MainFrame.class.getResource("/images/set_background.jpg"));
	public ImageIcon completebefore_image = new ImageIcon(SetFrame.class.getResource("/images/complete_before.jpg"));
	public ImageIcon completeafter_image = new ImageIcon(SetFrame.class.getResource("/images/complete_after.jpg"));
	
	private JPanel main_panel;
	private JButton set_button;
	private JTextField nickname_tf, tel1_tf, tel2_tf;
	private JPasswordField pw_tf, pwck_tf; 
	
	public SetFrame() {
		setTitle("conferencesystem/set");
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		main_panel = new JPanel();
		main_panel.setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		JLabel id_label = new JLabel(MainFrame.login_id);//ID label MainFrame의 login_id값을 가져옴
		id_label.setForeground(Color.WHITE);
		id_label.setBounds(230, 186, 188, 20);
		main_panel.add(id_label);
		
		set_button = new JButton("Complete");
		set_button.setBounds(298, 382, 287, 55);
		set_button.setIcon(completebefore_image);
		set_button.setBorderPainted(false);
		set_button.setContentAreaFilled(false);
		set_button.setFocusPainted(false);
		set_button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "수정 완료!");//messagedialog
			}
			public void mouseEntered(MouseEvent e) {
				set_button.setIcon(completeafter_image);
			}
			public void mouseExited(MouseEvent e) {
				set_button.setIcon(completebefore_image);
			}
		});
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
		
		JComboBox tel_combobox = new JComboBox();
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
		
		JCheckBox basicproject_checkbox = new JCheckBox("Basic Project");
		basicproject_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		basicproject_checkbox.setForeground(Color.WHITE);
		basicproject_checkbox.setBounds(471, 186, 127, 23);
		basicproject_checkbox.setOpaque(false);
		main_panel.add(basicproject_checkbox);
		
		JCheckBox expertproject_checkbox = new JCheckBox("Expert Project");
		expertproject_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		expertproject_checkbox.setForeground(Color.WHITE);
		expertproject_checkbox.setBounds(471, 216, 141, 23);
		expertproject_checkbox.setOpaque(false);
		main_panel.add(expertproject_checkbox);
		
		JCheckBox lolgroup_checkbox = new JCheckBox("LOL GROUP");
		lolgroup_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		lolgroup_checkbox.setForeground(Color.WHITE);
		lolgroup_checkbox.setBounds(471, 246, 115, 23);
		lolgroup_checkbox.setOpaque(false);
		main_panel.add(lolgroup_checkbox);
		
		JCheckBox battlegroundgroup_checkbox = new JCheckBox("Battleground GROUP");
		battlegroundgroup_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		battlegroundgroup_checkbox.setForeground(Color.WHITE);
		battlegroundgroup_checkbox.setBounds(471, 276, 176, 23);
		battlegroundgroup_checkbox.setOpaque(false);
		main_panel.add(battlegroundgroup_checkbox);
		
		JCheckBox etc_checkbox = new JCheckBox("ETC");
		etc_checkbox.setFont(new Font("굴림", Font.BOLD, 12));
		etc_checkbox.setForeground(Color.WHITE);
		etc_checkbox.setBounds(471, 306, 141, 23);
		etc_checkbox.setOpaque(false);
		main_panel.add(etc_checkbox);
		
		JCheckBox checkBox = new JCheckBox("Basic Project");
		checkBox.setOpaque(false);
		checkBox.setForeground(Color.WHITE);
		checkBox.setFont(new Font("굴림", Font.BOLD, 12));
		checkBox.setBounds(645, 186, 127, 23);
		main_panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Expert Project");
		checkBox_1.setOpaque(false);
		checkBox_1.setForeground(Color.WHITE);
		checkBox_1.setFont(new Font("굴림", Font.BOLD, 12));
		checkBox_1.setBounds(645, 216, 141, 23);
		main_panel.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("LOL GROUP");
		checkBox_2.setOpaque(false);
		checkBox_2.setForeground(Color.WHITE);
		checkBox_2.setFont(new Font("굴림", Font.BOLD, 12));
		checkBox_2.setBounds(645, 246, 115, 23);
		main_panel.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Battleground GROUP");
		checkBox_3.setOpaque(false);
		checkBox_3.setForeground(Color.WHITE);
		checkBox_3.setFont(new Font("굴림", Font.BOLD, 12));
		checkBox_3.setBounds(645, 276, 176, 23);
		main_panel.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("ETC");
		checkBox_4.setOpaque(false);
		checkBox_4.setForeground(Color.WHITE);
		checkBox_4.setFont(new Font("굴림", Font.BOLD, 12));
		checkBox_4.setBounds(645, 306, 141, 23);
		main_panel.add(checkBox_4);
		
		JLabel setbackground_label = new JLabel();
		setbackground_label.setBounds(0, 0, Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setbackground_label.setIcon(setbackground_image);
		main_panel.add(setbackground_label);
		
		setVisible(true);
	}
}

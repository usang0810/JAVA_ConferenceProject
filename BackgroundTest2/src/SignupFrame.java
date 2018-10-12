import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignupFrame extends JPanel{
	
	public ImageIcon background_image = new ImageIcon(SignupFrame.class.getResource("/images/signup_background.png"));
	public ImageIcon signupbefore_image = new ImageIcon(SignupFrame.class.getResource("/images/signup_before.png"));
	public ImageIcon signupafter_image = new ImageIcon(SignupFrame.class.getResource("/images/signup_after.png"));
	
	private JButton signup_button;
	private JTextField id_tf;
	private JTextField nickname_tf;
	private JTextField tel1_tf;
	private JTextField tel2_tf;
	private JPasswordField pw_tf;
	private JPasswordField pwck_tf;
	
	public SignupFrame() {
		setLayout(null);
		setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		
		signup_button = new JButton("New button");
		signup_button.setIcon(signupbefore_image);
		signup_button.setBounds(298, 382, 287, 55);
		signup_button.setBorderPainted(false);
		signup_button.setContentAreaFilled(false);
		signup_button.setFocusPainted(false);
		signup_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				LoginFrame login = new LoginFrame();
				login.getContentPane().add(login.login_panel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				signup_button.setIcon(signupafter_image);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				signup_button.setIcon(signupbefore_image);
			}
		});
		add(signup_button);
		
		id_tf = new JTextField();
		id_tf.setBounds(230, 185, 188, 20);
		id_tf.setBorder(null);
		add(id_tf);
		id_tf.setColumns(10);
		
		pw_tf = new JPasswordField();
		pw_tf.setBounds(230, 212, 188, 20);
		pw_tf.setBorder(null);
		add(pw_tf);
		
		pwck_tf = new JPasswordField();
		pwck_tf.setBounds(230, 238, 188, 20);
		pwck_tf.setBorder(null);
		add(pwck_tf);
		
		nickname_tf = new JTextField();
		nickname_tf.setColumns(10);
		nickname_tf.setBounds(230, 264, 188, 20);
		nickname_tf.setBorder(null);
		add(nickname_tf);
		
		JComboBox tel_combobox = new JComboBox();
		tel_combobox.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		tel_combobox.setModel(new DefaultComboBoxModel(new String[] {"010", "019", "011"}));
		tel_combobox.setMaximumRowCount(3);
		tel_combobox.setBounds(230, 291, 43, 20);
		add(tel_combobox);
		
		JLabel tel1_label = new JLabel("-");
		tel1_label.setForeground(Color.WHITE);
		tel1_label.setBounds(285, 293, 13, 15);
		add(tel1_label);
		
		tel1_tf = new JTextField();
		tel1_tf.setBounds(305, 291, 40, 21);
		//tel1_tf.setDocument(new JTextFieldLimit(4));
		tel1_tf.setBorder(null);
		add(tel1_tf);
		tel1_tf.setColumns(10);
		
		JLabel tel2_label = new JLabel("-");
		tel2_label.setForeground(Color.WHITE);
		tel2_label.setBounds(358, 293, 13, 15);
		add(tel2_label);
		
		tel2_tf = new JTextField();
		tel2_tf.setColumns(10);
		tel2_tf.setBounds(378, 291, 40, 21);
		tel2_tf.setBorder(null);
		add(tel2_tf);
		
		JCheckBox basicproject_checkbox = new JCheckBox("Basic Project");
		basicproject_checkbox.setFont(new Font("±¼¸²", Font.BOLD, 12));
		basicproject_checkbox.setForeground(Color.WHITE);
		basicproject_checkbox.setBounds(538, 185, 127, 23);
		basicproject_checkbox.setOpaque(false);
		add(basicproject_checkbox);
		
		JCheckBox expertproject_checkbox = new JCheckBox("Expert Project");
		expertproject_checkbox.setFont(new Font("±¼¸²", Font.BOLD, 12));
		expertproject_checkbox.setForeground(Color.WHITE);
		expertproject_checkbox.setBounds(538, 215, 141, 23);
		expertproject_checkbox.setOpaque(false);

		add(expertproject_checkbox);
		
		JCheckBox lolgroup_checkbox = new JCheckBox("LOL GROUP");
		lolgroup_checkbox.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lolgroup_checkbox.setForeground(Color.WHITE);
		lolgroup_checkbox.setBounds(538, 245, 115, 23);
		lolgroup_checkbox.setOpaque(false);

		add(lolgroup_checkbox);
		
		JCheckBox battlegroundgroup_checkbox = new JCheckBox("Battleground GROUP");
		battlegroundgroup_checkbox.setFont(new Font("±¼¸²", Font.BOLD, 12));
		battlegroundgroup_checkbox.setForeground(Color.WHITE);
		battlegroundgroup_checkbox.setBounds(538, 275, 176, 23);
		battlegroundgroup_checkbox.setOpaque(false);

		add(battlegroundgroup_checkbox);
		
		JCheckBox etc_checkbox = new JCheckBox("ETC");
		etc_checkbox.setFont(new Font("±¼¸²", Font.BOLD, 12));
		etc_checkbox.setForeground(Color.WHITE);
		etc_checkbox.setBounds(538, 305, 141, 23);
		etc_checkbox.setOpaque(false);

		add(etc_checkbox);
		
		JLabel background_label = new JLabel();
		background_label.setIcon(background_image);
		background_label.setBounds(0, 0, Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		add(background_label);
		
	}
}

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	
	public ImageIcon background_image= new ImageIcon(LoginFrame.class.getResource("/images/login_background.png"));
	public ImageIcon loginbefore_image= new ImageIcon(LoginFrame.class.getResource("/images/login_before.png"));
	public ImageIcon loginafter_image= new ImageIcon(LoginFrame.class.getResource("/images/login_after.png"));
	
	public JPanel login_panel;
	private JButton login_button, signup_button;
	private JTextField id_tf;
	private JPasswordField pw_tf;

	public LoginFrame() {
		setTitle("conferencesystem/login");
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login_panel = new JPanel();
		login_panel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		getContentPane().add(login_panel);
		login_panel.setLayout(null);
				
		login_button = new JButton();
		login_button.setBounds(462, 286, 287, 55);
		login_button.setIcon(loginbefore_image);
		login_button.setBorderPainted(false);
		login_button.setContentAreaFilled(false);
		login_button.setFocusPainted(false);
		login_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				login_button.setIcon(loginafter_image);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				login_button.setIcon(loginbefore_image);
			}
		});
		login_panel.add(login_button);
		
		id_tf = new JTextField("ID");
		id_tf.setFont(new Font("±¼¸²", Font.BOLD, 15));
		id_tf.setForeground(Color.WHITE);
		id_tf.setBounds(507, 129, 242, 38);
		id_tf.setColumns(10);
		id_tf.setOpaque(false);
		id_tf.setBorder(null);
		login_panel.add(id_tf);
		
		pw_tf = new JPasswordField("password");
		pw_tf.setFont(new Font("±¼¸²", Font.BOLD, 15));
		pw_tf.setForeground(Color.WHITE);
		pw_tf.setBounds(507, 186, 242, 38);
		pw_tf.setOpaque(false);
		pw_tf.setBorder(null);
		login_panel.add(pw_tf);
		
		signup_button = new JButton();
		signup_button.setBounds(462, 353, 63, 23);
		signup_button.setBorderPainted(false);
		signup_button.setContentAreaFilled(false);
		signup_button.setFocusPainted(false);
		login_panel.add(signup_button);
		signup_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				login_panel.setVisible(false);
				SignupFrame signuppanel = new SignupFrame();
				getContentPane().add(signuppanel);
				//login_panel.setVisible(true);
			}
		});
		
		JLabel background_label = new JLabel();
		background_label.setIcon(background_image);
		background_label.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		login_panel.add(background_label);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

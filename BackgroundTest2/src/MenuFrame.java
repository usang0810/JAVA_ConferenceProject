import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrame extends JFrame{
	
	//public ImageIcon menubackground = new ImageCon();
	
	JPanel menu_panel;
	
	JButton calendar_button, chat_button, coin_button, set_button;
	
	public MenuFrame() {
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//로그인 패널 생성
		menu_panel = new JPanel();
		menu_panel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		getContentPane().add(menu_panel);
		getContentPane().setLayout(null);
		menu_panel.setLayout(null);
		
		calendar_button = new JButton();
		calendar_button.setBounds(85, 259, 160, 160);
		calendar_button.setBorderPainted(false);
		calendar_button.setContentAreaFilled(false);
		calendar_button.setFocusPainted(false);
		menu_panel.add(calendar_button);
		
		chat_button = new JButton();
		chat_button.setBounds(271, 259, 160, 160);
		chat_button.setBorderPainted(false);
		chat_button.setContentAreaFilled(false);
		chat_button.setFocusPainted(false);
		menu_panel.add(chat_button);
		
		coin_button = new JButton();
		coin_button.setBounds(457, 259, 160, 160);
		coin_button.setBorderPainted(false);
		coin_button.setContentAreaFilled(false);
		coin_button.setFocusPainted(false);
		menu_panel.add(coin_button);
		
		set_button = new JButton();
		set_button.setBounds(641, 259, 160, 160);
		set_button.setBorderPainted(false);
		set_button.setContentAreaFilled(false);
		set_button.setFocusPainted(false);
		menu_panel.add(set_button);
		
		JLabel menubackground_label = new JLabel();
		menubackground_label.setIcon(new ImageIcon(MenuFrame.class.getResource("/images/menu_background.png")));
		menubackground_label.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		menu_panel.add(menubackground_label);
		
		setVisible(true);
	}
}

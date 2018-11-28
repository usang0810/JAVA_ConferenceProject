package frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.User;

public class MenuFrame extends JFrame implements MouseListener{
	public static User user = null;
	public int groupnum;
	
	public ImageIcon menubackground_image = new ImageIcon(MainFrame.class.getResource("/images/menu_background.png"));
	public ImageIcon calendarbefore_image = new ImageIcon(MainFrame.class.getResource("/images/calendar_before.png"));
	public ImageIcon calendarafter_image = new ImageIcon(MainFrame.class.getResource("/images/calendar_after.png"));
	public ImageIcon chatbefore_image = new ImageIcon(MainFrame.class.getResource("/images/chat_before.png"));
	public ImageIcon chatafter_image = new ImageIcon(MainFrame.class.getResource("/images/chat_after.png"));
	public ImageIcon coinbefore_image = new ImageIcon(MainFrame.class.getResource("/images/coin_before.png"));
	public ImageIcon coinafter_image = new ImageIcon(MainFrame.class.getResource("/images/coin_after.png"));
	public ImageIcon setbefore_image = new ImageIcon(MainFrame.class.getResource("/images/set_before.png"));
	public ImageIcon setafter_image = new ImageIcon(MainFrame.class.getResource("/images/set_after.png"));
	public ImageIcon backbefore_image = new ImageIcon(MainFrame.class.getResource("/images/back_before.jpg"));
	public ImageIcon backafter_image = new ImageIcon(MainFrame.class.getResource("/images/back_after.jpg"));
	
	private JButton calendar_button, chat_button, set_button, coin_button, back_button;
	private JPanel menu_panel;

	public MenuFrame(User user, int groupnum){
		this.user = user;
		this.groupnum = groupnum;
		
		//System.out.println(groupnum);
		
		setTitle("conferencesystem/menu");
		setSize(Main.MAIN_WIDTH, Main.MAIN_HEIGHT);
		setResizable(false);//芒农扁炼例 阂啊
		setLocationRelativeTo(null);//拳搁吝居俊 积己
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		back_button = new JButton();
		back_button.setIcon(backbefore_image);
		back_button.setBounds(0, 0, 50, 50);
		back_button.setBorderPainted(false);
		back_button.setContentAreaFilled(false);
		back_button.setFocusPainted(false);
		back_button.addMouseListener(this);
		menu_panel.add(back_button);

		JLabel menubackground_label = new JLabel();
		menubackground_label.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		menubackground_label.setIcon(menubackground_image);
		menu_panel.add(menubackground_label);
		
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Mouse Pressed Event
		if(e.getSource() == calendar_button) {//calendarfrmae 积己
			CalendarFrame calendarframe = new CalendarFrame(groupnum);
		}else if(e.getSource() == chat_button) {//conferenceframe 积己
			//ConferenceFrame conferenceframe = new ConferenceFrame();
		}else if(e.getSource() == coin_button) {//coinframe 积己
			System.out.println(this.user.getNickname());
			CoinFrame coinframe = new CoinFrame(this.user);
		}else if(e.getSource() == set_button) {//setframe 积己
			SetFrame setframe = new SetFrame(this.user);
		}else if(e.getSource() == back_button) {
			this.setVisible(false);
			new SelectGroupFrame(user);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Mouse Enter Event
		if(e.getSource() == calendar_button) {
			calendar_button.setIcon(calendarafter_image);
		}else if(e.getSource() == chat_button) {
			chat_button.setIcon(chatafter_image);
		}else if(e.getSource() == coin_button) {
			coin_button.setIcon(coinafter_image);
		}else if(e.getSource() == set_button) {
			set_button.setIcon(setafter_image);
		}else if(e.getSource() == back_button) {
			back_button.setIcon(backafter_image);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Mouse Exit Event
		if(e.getSource() == calendar_button) {
			calendar_button.setIcon(calendarbefore_image);
		}else if(e.getSource() == chat_button) {
			chat_button.setIcon(chatbefore_image);
		}else if(e.getSource() == coin_button) {
			coin_button.setIcon(coinbefore_image);
		}else if(e.getSource() == set_button) {
			set_button.setIcon(setbefore_image);
		}else if(e.getSource() == back_button) {
			back_button.setIcon(backbefore_image);
		}
	}
}

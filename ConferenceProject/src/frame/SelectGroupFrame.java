package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.User;

public class SelectGroupFrame extends JFrame implements MouseListener{
	User user = null;
	//창 사이즈
	private static final int GROUP_WIDTH = 500;
	private static final int GROUP_HEIGHT = 600;
	private static final int GROUP_SCREEN_WIDTH = 484;
	private static final int GROUP_SCREEN_HEIGHT = 561;
	
	public ImageIcon groupbackground_image = new ImageIcon(SelectGroupFrame.class.getResource("/images/group_background.png"));
	public ImageIcon backbefore_image = new ImageIcon(SelectGroupFrame.class.getResource("/images/back_before.jpg"));
	public ImageIcon backafter_image = new ImageIcon(SelectGroupFrame.class.getResource("/images/back_after.jpg"));
	
	private JButton[] group_button = new JButton[5];
	private JButton back_button;
	private JPanel selectgroup_panel;
	
	public String user_id;
	public int groupnum;
	
	public SelectGroupFrame(User user) {
		this.user = user;
		
		setTitle("conferencesystem/group list");
		setSize(GROUP_WIDTH, GROUP_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//그룹목록패널 생성
		selectgroup_panel = new JPanel();
		selectgroup_panel.setBounds(0, 0, GROUP_SCREEN_WIDTH, GROUP_SCREEN_HEIGHT);
		getContentPane().add(selectgroup_panel);
		selectgroup_panel.setLayout(null);
		
		int[] g = new int[5];
		//for(int i=0; i<5; i++) {
			//g[i] = connection.getGroup(user_id, String.valueOf(i+1));
		//}
		g[0] = user.getG1();
		g[1] = user.getG2();
		g[2] = user.getG3();
		g[3] = user.getG4();
		g[4] = user.getG5();
		
		int check = 168;
		for(int i=0; i<5; i++) {
			if(g[i]==1) {
				group_button[i] = new JButton(Main.GROUP_NAME[i]);
				group_button[i].setBackground(new Color(100,200,200));
				group_button[i].setFont(new Font("굴림", Font.PLAIN, 18));
				group_button[i].addMouseListener(this);
				group_button[i].setForeground(Color.white);
				selectgroup_panel.add(group_button[i]);
				group_button[i].setBounds(57, check, 371, 43);
				check = check+73;
			}
		}
		
		back_button = new JButton();
		back_button.setIcon(backbefore_image);
		back_button.setBounds(0, 0, 50, 50);
		back_button.setBorderPainted(false);
		back_button.setContentAreaFilled(false);
		back_button.setFocusPainted(false);
		back_button.addMouseListener(this);
		selectgroup_panel.add(back_button);

		JLabel groupbackground_label = new JLabel();
		groupbackground_label.setBounds(0, 0, GROUP_SCREEN_WIDTH, GROUP_SCREEN_HEIGHT);
		groupbackground_label.setIcon(groupbackground_image);
		selectgroup_panel.add(groupbackground_label);
		
		this.setVisible(true);
		
		if(g[0]==0 && g[1]==0 && g[2]==0 && g[3]==0 && g[4]==0) {
			setVisible(false);
			JOptionPane.showMessageDialog(null, "등록된 그룹이 없습니다!");//messagedialog
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++) {
			if(e.getSource() == group_button[i]) {//그룹 선택시
				groupnum = i+1;

				setVisible(false);
				MenuFrame menuframe = new MenuFrame(user, groupnum);
			}
		}
		if(e.getSource() == back_button) {
			setVisible(false);
			new MainFrame();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back_button) {
			back_button.setIcon(backafter_image);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back_button) {
			back_button.setIcon(backbefore_image);
		}
	}
	

}

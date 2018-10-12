import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuFrame extends JFrame{
	
	JPanel menu_panel;
	
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(467, 58, 150, 150);
		menu_panel.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(680, 58, 150, 150);
		menu_panel.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(467, 259, 150, 150);
		menu_panel.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(680, 259, 150, 150);
		menu_panel.add(button_2);
		
		JLabel menubackground_label = new JLabel();
		menubackground_label.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		menu_panel.add(menubackground_label);
		
		setVisible(true);
	}
}

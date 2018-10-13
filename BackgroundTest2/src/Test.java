import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Test extends JFrame implements ActionListener{
	private static final int CALENDAR_WIDTH = 780;
	private static final int CALENDAR_HEIGHT = 580;
	private static final int CALENDAR_SCREEN_WIDTH = 764;
	private static final int CALENDAR_SCREEN_HEIGHT = 541;
	
	public JPanel main_panel, calendar_panel, memo_panel;
	
	public Test() {
		setSize(CALENDAR_WIDTH, CALENDAR_HEIGHT);
		getContentPane().setLayout(null);
		
		main_panel = new JPanel();
		main_panel.setBounds(0, 0, CALENDAR_SCREEN_WIDTH, CALENDAR_SCREEN_HEIGHT);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, CALENDAR_SCREEN_WIDTH, CALENDAR_SCREEN_HEIGHT);
		main_panel.add(lblNewLabel);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CoinFrame extends JFrame{
	private static final int COIN_WIDTH = 400;
	private static final int COIN_HEIGHT = 300;
	private static final int COIN_SCREEN_WIDTH = 394;
	private static final int COIN_SCREEN_HEIGHT = 271;
	
	private JPanel main_panel, before_panel, after_panel;
	private JTextField chargecoin_tf;
	private JButton charge_button;
	
	public CoinFrame() {
		setTitle("conferencesystem/Coin");
		setSize(COIN_WIDTH, COIN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		main_panel = new JPanel();
		main_panel.setBackground(Color.LIGHT_GRAY);
		main_panel.setBounds(0, 0, COIN_SCREEN_WIDTH, COIN_SCREEN_HEIGHT);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		JLabel nickname_label = new JLabel("\uC870\uC720\uC0C1\uB2D8");
		nickname_label.setForeground(Color.WHITE);
		nickname_label.setFont(new Font("±¼¸²", Font.BOLD, 15));
		nickname_label.setBounds(12, 97, 85, 38);
		main_panel.add(nickname_label);
		
		JLabel servername_label = new JLabel("\uC608\uAE08\uC8FC : \uD64D\uAE38\uB3D9");
		servername_label.setForeground(Color.WHITE);
		servername_label.setBounds(12, 225, 110, 15);
		main_panel.add(servername_label);
		
		JLabel servernum_label = new JLabel("\uB18D\uD611 352-0123-4567-89");
		servernum_label.setForeground(Color.WHITE);
		servernum_label.setBounds(12, 246, 165, 15);
		main_panel.add(servernum_label);
		
		before_panel = new JPanel();
		before_panel.setBackground(Color.WHITE);
		before_panel.setBounds(12, 145, 165, 70);
		main_panel.add(before_panel);
		before_panel.setLayout(null);
		
		JLabel posses_label = new JLabel("\uBCF4\uC720\r\n\uCF54\uC778");
		posses_label.setHorizontalAlignment(SwingConstants.CENTER);
		posses_label.setBounds(0, 0, 62, 70);
		before_panel.add(posses_label);
		
		JLabel beforecoin_label = new JLabel("500");
		beforecoin_label.setHorizontalAlignment(SwingConstants.CENTER);
		beforecoin_label.setBounds(62, 0, 103, 70);
		before_panel.add(beforecoin_label);
		
		after_panel = new JPanel();
		after_panel.setBackground(Color.WHITE);
		after_panel.setLayout(null);
		after_panel.setBounds(217, 145, 165, 70);
		main_panel.add(after_panel);
		
		JLabel charge_label = new JLabel("\uCDA9\uC804\uCF54\uC778");
		charge_label.setHorizontalAlignment(SwingConstants.CENTER);
		charge_label.setBounds(0, 0, 62, 70);
		after_panel.add(charge_label);
		
		chargecoin_tf = new JTextField();
		chargecoin_tf.setBounds(62, 0, 103, 70);
		chargecoin_tf.setBorder(null);
		after_panel.add(chargecoin_tf);
		chargecoin_tf.setColumns(10);
		
		charge_button = new JButton("\uCDA9\uC804");
		charge_button.setFont(new Font("±¼¸²", Font.BOLD, 15));
		charge_button.setBounds(297, 225, 85, 36);
		charge_button.setBackground(new Color(100,200,200));
		main_panel.add(charge_button);
		
		JLabel background_label = new JLabel();
		background_label.setBounds(0, 0, COIN_SCREEN_WIDTH, COIN_SCREEN_HEIGHT);
		main_panel.add(background_label);
		
		setVisible(true);
	}
}

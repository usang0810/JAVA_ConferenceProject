import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CoinFrame extends JFrame implements ActionListener{
	DBConnection connection = new DBConnection();
	//image icon
	public ImageIcon coinbackground_image= new ImageIcon(CoinFrame.class.getResource("/images/coin_background.jpg"));

	private static final int COIN_WIDTH = 400;
	private static final int COIN_HEIGHT = 300;
	private static final int COIN_SCREEN_WIDTH = 394;
	private static final int COIN_SCREEN_HEIGHT = 271;
	
	private JPanel main_panel, before_panel, after_panel;
	private JTextField chargecoin_tf;
	private JButton charge_button;
	private JLabel nickname_label, servername_label, servernum_label, posses_label, beforecoin_label, charge_label;
	
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
		
		nickname_label = new JLabel(MainFrame.login_nickname+"님");//로그인한 id의 nickname
		nickname_label.setForeground(Color.WHITE);
		nickname_label.setFont(new Font("굴림", Font.BOLD, 15));
		nickname_label.setBounds(12, 97, 200, 38);
		main_panel.add(nickname_label);
		
		servername_label = new JLabel("\uC608\uAE08\uC8FC : \uD64D\uAE38\uB3D9");//text = 예금주 : 홍길동
		servername_label.setForeground(Color.WHITE);
		servername_label.setBounds(12, 225, 110, 15);
		main_panel.add(servername_label);
		
		servernum_label = new JLabel("\uB18D\uD611 352-0123-4567-89");//text = 농협
		servernum_label.setForeground(Color.WHITE);
		servernum_label.setBounds(12, 246, 165, 15);
		main_panel.add(servernum_label);
		
		before_panel = new JPanel();
		before_panel.setBackground(Color.WHITE);
		before_panel.setBounds(12, 145, 165, 70);
		main_panel.add(before_panel);
		before_panel.setLayout(null);
		
		posses_label = new JLabel("\uBCF4\uC720\r\n\uCF54\uC778");//text = 보유코인
		posses_label.setHorizontalAlignment(SwingConstants.CENTER);
		posses_label.setBounds(0, 0, 62, 70);
		before_panel.add(posses_label);
		
		beforecoin_label = new JLabel(Integer.toString(MainFrame.login_coin));//int형 coin을 string으로 변환
		beforecoin_label.setHorizontalAlignment(SwingConstants.CENTER);
		beforecoin_label.setBounds(62, 0, 103, 70);
		before_panel.add(beforecoin_label);
		
		after_panel = new JPanel();
		after_panel.setBackground(Color.WHITE);
		after_panel.setLayout(null);
		after_panel.setBounds(217, 145, 165, 70);
		main_panel.add(after_panel);
		
		charge_label = new JLabel("\uCDA9\uC804\uCF54\uC778");//text = 충전코인
		charge_label.setHorizontalAlignment(SwingConstants.CENTER);
		charge_label.setBounds(0, 0, 62, 70);
		after_panel.add(charge_label);
		
		chargecoin_tf = new JTextField();
		chargecoin_tf.setBounds(62, 0, 103, 70);
		chargecoin_tf.setBorder(null);
		after_panel.add(chargecoin_tf);
		chargecoin_tf.setColumns(10);
		chargecoin_tf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();
				
				if(!Character.isDigit(c)) {//문자 입력 시 컨슘
					ke.consume();
				}
				if(((JTextField)ke.getSource()).getText().length()>=5) {//글자수 최대 5자
					ke.consume();
				}
			}
		});
		
		charge_button = new JButton("\uCDA9\uC804");//text = 충전
		charge_button.setFont(new Font("굴림", Font.BOLD, 15));
		charge_button.setBounds(312, 219, 70, 27);
		charge_button.setBackground(new Color(100,200,200));
		charge_button.addActionListener(this);
		main_panel.add(charge_button);
		
		JLabel background_label = new JLabel();
		background_label.setBounds(0, 0, COIN_SCREEN_WIDTH, COIN_SCREEN_HEIGHT);
		background_label.setIcon(coinbackground_image);
		main_panel.add(background_label);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == charge_button) {//charge_button 클릭 시
			if(connection.updateApplyCoin(MainFrame.login_id, Integer.parseInt(chargecoin_tf.getText()))==false){
				return;
			}
			setVisible(false);
			JOptionPane.showMessageDialog(null, chargecoin_tf.getText()+"원 입금 확인 후 충전됩니다!");//messagedialog
		}
	}
}

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.GridLayout;

public class CalendarFrame extends JFrame implements ActionListener{
	//image icon
	public ImageIcon calendarbackground_image= new ImageIcon(CalendarFrame.class.getResource("/images/calendar_background.jpg"));

	private static final int CALENDAR_WIDTH = 780;
	private static final int CALENDAR_HEIGHT = 580;
	private static final int CALENDAR_SCREEN_WIDTH = 764;
	private static final int CALENDAR_SCREEN_HEIGHT = 541;
	
	public JPanel main_panel, calendar_panel, memo_panel;
	public JPanel top_panel = new JPanel();
	public JPanel center_panel = new JPanel(new BorderLayout());
	public JPanel title_panel = new JPanel(new GridLayout(1, 7));//요일 출력 할 패널 - 7칸
	public JPanel data_panel = new JPanel(new GridLayout(0, 7));//날짜 출력 할 패널 - 7칸
	private JButton left_button = new JButton("◀");
	private JLabel year_label = new JLabel("년");
	private JLabel month_label = new JLabel("월");
	private JButton right_button = new JButton("▶");
	private JButton day_button[] = new JButton[31];//최대 31일
	
	private JButton save_button, clear_button;
	JComboBox<Integer> year_combobox = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> year_model = new DefaultComboBoxModel<Integer>();
	JComboBox<Integer> month_combobox = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> month_model = new DefaultComboBoxModel<Integer>();
	
	String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };
	Calendar now;
	int year, month, date;
	private final JPanel memotitle_panel = new JPanel();
	private final JLabel memotitle_label = new JLabel("*MEMO*");
	private JTextArea memo_textarea;
	
	public CalendarFrame() {
		setTitle("conferencesystem/Calendar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 자원 해제 후 종료
		setSize(CALENDAR_WIDTH, CALENDAR_HEIGHT);
		main_panel = new JPanel();
		main_panel.setBounds(0, 0, CALENDAR_SCREEN_WIDTH, CALENDAR_SCREEN_HEIGHT);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		getContentPane().setLayout(null);
		
		calendar_panel = new JPanel();
		calendar_panel.setBounds(25, 146, 441, 370);
		main_panel.add(calendar_panel);
		calendar_panel.setLayout(new BorderLayout(0, 0));
		
		left_button.setBackground(Color.WHITE);
		right_button.setBackground(Color.WHITE);
		data_panel.setBackground(Color.WHITE);
		
		now = Calendar.getInstance(); // 현재 날짜
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		date = now.get(Calendar.DATE);
		top_panel.add(left_button);
		
		for (int i = year - 100; i <= year + 50; i++) {
			year_model.addElement(i);
		}
		
		year_combobox.setModel(year_model);
		year_combobox.setSelectedItem(year); // 현재 년도 선택
		top_panel.add(year_combobox);
		top_panel.add(year_label);
		
		for (int i = 1; i <= 12; i++) {
			month_model.addElement(i);
		}
		
		month_combobox.setModel(month_model);
		month_combobox.setSelectedItem(month); // 현재 월 선택
		top_panel.add(month_combobox);
		top_panel.add(month_label);
		top_panel.add(right_button);
		top_panel.setBackground(new Color(100, 200, 200));
		calendar_panel.add(top_panel, "North");

		// Center
		title_panel.setBackground(Color.white);
		for (int i = 0; i < titleStr.length; i++) {//요일의 길이만큼 반복(7)해서 라벨생성
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);
			if (i == 0) {//일요일 red
				lbl.setForeground(Color.red);
			} else if (i == 6) {//토요일 blue
				lbl.setForeground(Color.blue);
			}
			title_panel.add(lbl);
		}
		center_panel.add(title_panel, "North");

		// 날짜 출력
		dayPrint(year, month);
		center_panel.add(data_panel, "Center");
		calendar_panel.add(center_panel, "Center");
		left_button.addActionListener(this);
		right_button.addActionListener(this);
		year_combobox.addActionListener(this);
		month_combobox.addActionListener(this);
		
		
		//메모 패널 생성
		memo_panel = new JPanel();
		memo_panel.setBackground(Color.WHITE);
		memo_panel.setBounds(504, 146, 230, 370);
		main_panel.add(memo_panel);
		memo_panel.setLayout(null);
		memotitle_panel.setBounds(0, 0, 230, 37);
		
		memo_panel.add(memotitle_panel);
		memotitle_panel.setLayout(null);
		memotitle_panel.setBackground(new Color(100, 200, 200));
		memotitle_label.setFont(new Font("굴림", Font.BOLD, 12));
		memotitle_label.setBounds(87, 10, 65, 25);
		
		memotitle_panel.add(memotitle_label);
		
		save_button = new JButton("SAVE");
		save_button.setBackground(new Color(100, 200, 200));
		save_button.setFont(new Font("굴림", Font.BOLD, 12));
		save_button.setBounds(12, 337, 100, 23);
		save_button.addActionListener(this);
		memo_panel.add(save_button);
		
		clear_button = new JButton("CLEAR");
		clear_button.setBackground(new Color(100, 200, 200));
		clear_button.setFont(new Font("굴림", Font.BOLD, 12));
		clear_button.setBounds(118, 337, 100, 23);
		clear_button.addActionListener(this);
		memo_panel.add(clear_button);
		
		memo_textarea = new JTextArea();
		memo_textarea.setBounds(10, 47, 208, 280);
		memo_panel.add(memo_textarea);
		
		JLabel background_label = new JLabel();
		background_label.setBounds(0, 0, CALENDAR_SCREEN_WIDTH, CALENDAR_SCREEN_HEIGHT);
		background_label.setIcon(calendarbackground_image);
		main_panel.add(background_label);
		
		setVisible(true);
		
	}
	
	public void dayPrint(int y, int m) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m - 1, 1); // 출력할 첫날의 객체 만든다.
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1일에 대한 요일 일요일 : 0
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 그 달의 마지막 날
		for (int i = 1; i < week; i++) { // 날짜 출력 전까지의 공백 출력
			data_panel.add(new JLabel(" "));
		}
		
		for (int i = 1; i <= lastDate; i++) {
			day_button[i-1] = new JButton(String.valueOf(i));
			day_button[i-1].setBorderPainted(false);
			day_button[i-1].setContentAreaFilled(false);
			//day_button[i-1].setFocusPainted(false);
			day_button[i-1].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(e.getSource() == day_button[10]) {
						//JOptionPane.showMessageDialog(null, "hello world!");//messagedialog test
					}
				}
				
			});
			cal.set(y, m - 1, i);

			int outWeek = cal.get(Calendar.DAY_OF_WEEK);
			if (outWeek == 1) {
				day_button[i-1].setForeground(Color.red);
			} else if (outWeek == 7) {
				day_button[i-1].setForeground(Color.BLUE);
			}

			data_panel.add(day_button[i-1]);
		}
	}
	
	public void createDayStart() {
		data_panel.setVisible(false); // 패널 숨기기
		data_panel.removeAll(); // 날짜 출력한 라벨 지우기
		dayPrint((Integer) year_combobox.getSelectedItem(), (Integer) month_combobox.getSelectedItem());
		data_panel.setVisible(true); // 패널 재출력
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj instanceof JButton) {
			JButton eventBtn = (JButton) obj;
			int yy = (Integer) year_combobox.getSelectedItem();
			int mm = (Integer) month_combobox.getSelectedItem();
			if (eventBtn.equals(left_button)) { // 전달
				if (mm == 1) {
					yy--;
					mm = 12;
				} else {
					mm--;
				}
			} else if (eventBtn.equals(right_button)) { // 다음달
				if (mm == 12) {
					yy++;
					mm = 1;
				} else {
					mm++;
				}
			}

			year_combobox.setSelectedItem(yy);
			month_combobox.setSelectedItem(mm);
		} else if (obj instanceof JComboBox) { // 콤보박스 이벤트 발생시
			createDayStart();
		}
	}
}

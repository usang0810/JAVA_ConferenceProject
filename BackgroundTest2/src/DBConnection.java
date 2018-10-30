

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	private Connection con;
	private Statement st;//DB�� ������ ���� ��ü
	private ResultSet rs;//���� ����� �޾ƿ��� ���� ��ü
	
	public DBConnection() {//DB����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/conference","root","316425");//localhost:3306��� �ּҰ���
			st = con.createStatement();
			
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� : "+e.getMessage());
		}
	}
	
	public boolean isAdmin(String adminID, String adminPassword) {//������� ID�� PW�� �˻��ϴ� �޼ҵ�
		try {
			String SQL = "SELECT*FROM USER WHERE user_id = '"+adminID+"' and password = '"+adminPassword+"'";
			rs = st.executeQuery(SQL);
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� �˻� ���� : "+e.getMessage());
		}
		return false;
	}
	
	public boolean insertData(String userID, String userPassword) {//DB�� ID�� PW�����ϴ� �޼ҵ�
		try {
			String SQL = "INSERT INTO USER (user_id, password) VALUES ('"+userID+"', '"+userPassword+"');";
			int cnt = st.executeUpdate(SQL);//cnt�� ��ȯ�� ����
			if(cnt>0) {//true��� 0���� ŭ
				System.out.println("insert : success");
				return true;
			}
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� : "+e.getMessage());
		}
		System.out.println("insert : fail");
		return false;
	}
	
	public boolean showID(String userID) {//idüũ �޼ҵ�
		try {
			String SQL = "SELECT*FROM user";
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				String user_id = rs.getString("user_id");//user_id ���� �� ���� �� ����
				if(user_id.equals(userID)) {//�Ű����� ���� ���ٸ� ��ȯ
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
		}
		return false;
	}
	
	public boolean showNickname(String user_nickname) {//nicknameüũ �޼ҵ�
		try {
			String SQL = "SELECT*FROM user";
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				String nickname = rs.getString("nickname");//nickname ���� �� ���� �� ����
				if(nickname.equals(user_nickname)) {//�Ű����� ���� ���ٸ� ��ȯ
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
		}
		return false;
	}
	
	public String getNickname(String user_id) {//id�� �������� nickname�� ã�� ��ȯ�ϴ� �޼ҵ�
		String nickname = null;
		try {
			String SQL = "SELECT nickname FROM user where user_id='"+user_id+"';";
			rs = st.executeQuery(SQL);
			rs.next();
			nickname = rs.getString("nickname");//nickname�� ����
		}catch(Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
		}
		return nickname;
	}
	
	public int getCoin(String user_id) {//id�� �������� coin�� ã�� ��ȯ�ϴ� �޼ҵ�
		int coin = 0;
		try {
			String SQL = "SELECT coin FROM user where user_id='"+user_id+"';";
			rs = st.executeQuery(SQL);
			rs.next();
			coin = rs.getInt("coin");//coin�� ����
		}catch(Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
		}
		return coin;
	}
	
	public boolean findPassword(String userID, String userPassword) {//ID�� �������� pwüũ �޼ҵ�
		try {
			String SQL = "SELECT*FROM user WHERE user_id='"+userID+"'";//ID�� �˻�
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				String user_pw = rs.getString("password");//password ���� �� ���� �� ����
				if(user_pw.equals(userPassword)) {//�Ű����� ���� ���ٸ� ��ȯ
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
		}
		return false;
	}
	
	public boolean insertUserdata(String userID, String userPassword, String nickname, String tel, 
			int g1, int g2, int g3, int g4, int g5) {//user���̺� ������ ����
		try {
			String SQL = "INSERT INTO USER (user_id, password, nickname, tel, g1, g2, g3, g4, g5) VALUES ('"
		+userID+"', '"+userPassword+"', '"+nickname+"', '"+tel+"', "+g1+", "+g2+", "+g3+", "+g4+", "+g5+");";
			int cnt = st.executeUpdate(SQL);//cnt�� ��ȯ�� ����
			if(cnt>0) {//true��� 0���� ŭ
				//System.out.println("insert : success");
				return true;
			}
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� : "+e.getMessage());
		}
		//System.out.println("insert : fail");
		return false;
	}
	
	public boolean updateApplyCoin(String user_id, int user_coin) {
		try {
			String SQL = "UPDATE user SET applycoin="+user_coin+" where user_id='"+user_id+"';";
			int cnt = st.executeUpdate(SQL);
			if(cnt>0) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("�˻� ����"+e.getMessage());
		}
		return false;
	}
}



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	private Connection con;
	private Statement st;//DB에 실행을 위한 객체
	private ResultSet rs;//실행 결과를 받아오기 위한 객체
	
	public DBConnection() {//DB연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/conference","root","316425");//localhost:3306대신 주소가능
			st = con.createStatement();
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 오류 : "+e.getMessage());
		}
	}
	
	public boolean isAdmin(String adminID, String adminPassword) {//사용자의 ID와 PW를 검색하는 메소드
		try {
			String SQL = "SELECT*FROM USER WHERE user_id = '"+adminID+"' and password = '"+adminPassword+"'";
			rs = st.executeQuery(SQL);
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 검색 오류 : "+e.getMessage());
		}
		return false;
	}
	
	public boolean insertData(String userID, String userPassword) {//DB에 ID와 PW삽입하는 메소드
		try {
			String SQL = "INSERT INTO USER (user_id, password) VALUES ('"+userID+"', '"+userPassword+"');";
			int cnt = st.executeUpdate(SQL);//cnt에 반환값 저장
			if(cnt>0) {//true라면 0보다 큼
				System.out.println("insert : success");
				return true;
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 삽입 오류 : "+e.getMessage());
		}
		System.out.println("insert : fail");
		return false;
	}
	
	public boolean showID(String userID) {//id체크 메소드
		try {
			String SQL = "SELECT*FROM user";
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				String user_id = rs.getString("user_id");//user_id 열의 값 한줄 씩 저장
				if(user_id.equals(userID)) {//매개변수 값과 같다면 반환
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println("검색 오류"+e.getMessage());
		}
		return false;
	}
	
	public boolean showNickname(String user_nickname) {//nickname체크 메소드
		try {
			String SQL = "SELECT*FROM user";
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				String nickname = rs.getString("nickname");//nickname 열의 값 한줄 씩 저장
				if(nickname.equals(user_nickname)) {//매개변수 값과 같다면 반환
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println("검색 오류"+e.getMessage());
		}
		return false;
	}
	
	public String getNickname(String user_id) {//id를 기준으로 nickname을 찾아 반환하는 메소드
		String nickname = null;
		try {
			String SQL = "SELECT nickname FROM user where user_id='"+user_id+"';";
			rs = st.executeQuery(SQL);
			rs.next();
			nickname = rs.getString("nickname");//nickname값 저장
		}catch(Exception e) {
			System.out.println("검색 오류"+e.getMessage());
		}
		return nickname;
	}
	
	public int getCoin(String user_id) {//id를 기준으로 coin을 찾아 반환하는 메소드
		int coin = 0;
		try {
			String SQL = "SELECT coin FROM user where user_id='"+user_id+"';";
			rs = st.executeQuery(SQL);
			rs.next();
			coin = rs.getInt("coin");//coin값 저장
		}catch(Exception e) {
			System.out.println("검색 오류"+e.getMessage());
		}
		return coin;
	}
	
	public boolean findPassword(String userID, String userPassword) {//ID를 기준으로 pw체크 메소드
		try {
			String SQL = "SELECT*FROM user WHERE user_id='"+userID+"'";//ID만 검색
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				String user_pw = rs.getString("password");//password 열의 값 한줄 씩 저장
				if(user_pw.equals(userPassword)) {//매개변수 값과 같다면 반환
					return true;
				}
			}
		}catch(Exception e) {
			System.out.println("검색 오류"+e.getMessage());
		}
		return false;
	}
	
	public boolean insertUserdata(String userID, String userPassword, String nickname, String tel, 
			int g1, int g2, int g3, int g4, int g5) {//user테이블에 데이터 삽입
		try {
			String SQL = "INSERT INTO USER (user_id, password, nickname, tel, g1, g2, g3, g4, g5) VALUES ('"
		+userID+"', '"+userPassword+"', '"+nickname+"', '"+tel+"', "+g1+", "+g2+", "+g3+", "+g4+", "+g5+");";
			int cnt = st.executeUpdate(SQL);//cnt에 반환값 저장
			if(cnt>0) {//true라면 0보다 큼
				//System.out.println("insert : success");
				return true;
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 삽입 오류 : "+e.getMessage());
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
			System.out.println("검색 오류"+e.getMessage());
		}
		return false;
	}
}

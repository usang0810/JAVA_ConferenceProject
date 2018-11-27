package http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import frame.Main;
import model.User;

public class Login {
	private String user_id;
	private String user_pw;
	
	public void setIdPw(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	public User loginConnect() throws IOException{
		
		URL url = new URL(Main.http+"/login");

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "user_id="+user_id+"&user_pw="+user_pw;
		// 리퀘스트 메소드를 POST로 설정
		conn.setRequestMethod("POST");
		// 연결된 connection 에서 출력도 하도록 설정
		conn.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close(); 

		int responseCode = conn.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine; StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		} in.close();
		// print result 
		System.out.println("HTTP 응답 코드 : " + responseCode);
		//System.out.println("HTTP body : " + response.toString().trim());
		String[] data = response.toString().split(",");
		User user = null;
		
		if(data.length==1) {
			System.out.println("error!");
			
			return null;
		}else {
			user = new User();
			user.setUser_id(data[0]);
			user.setPassword(data[1]);
			user.setNickname(data[2]);
			user.setTel(data[3]);
			user.setG1(Integer.parseInt(data[4]));
			user.setG2(Integer.parseInt(data[5]));
			user.setG3(Integer.parseInt(data[6]));
			user.setG4(Integer.parseInt(data[7]));
			user.setG5(Integer.parseInt(data[8]));
			user.setCoin(Integer.parseInt(data[9]));
			user.setApplycoin(Integer.parseInt(data[10]));
			
			user.printUserinfo();
			
			return user;
		}
		
		
	}
}


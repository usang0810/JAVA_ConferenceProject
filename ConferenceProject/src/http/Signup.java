package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import frame.Main;

public class Signup {
	private String user_id;
	private String user_pw;
	private String user_nick;
	private String user_tel;
	private String user_g1;
	private String user_g2;
	private String user_g3;
	private String user_g4;
	private String user_g5;
	
	public void setUserinfo(String user_id, String user_pw, String user_nick, String user_tel,
			String user_g1, String user_g2, String user_g3, String user_g4, String user_g5) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nick = user_nick;
		this.user_tel = user_tel;
		this.user_g1 = user_g1;
		this.user_g2 = user_g2;
		this.user_g3 = user_g3;
		this.user_g4 = user_g4;
		this.user_g5 = user_g5;
	}
	
	public int signupConnect() throws IOException{
		URL url = new URL(Main.http+"/signup");

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "user_id="+user_id+"&user_pw="+user_pw+"&user_nick="+user_nick+"&user_tel="+user_tel
				+"&user_g1="+user_g1+"&user_g2="+user_g2+"&user_g3="+user_g3+"&user_g4="+user_g4+"&user_g5="+user_g5;
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
		//System.out.println("HTTP 응답 코드 : " + responseCode);
		//System.out.println("HTTP body : " + response.toString().trim());
		String data = response.toString();
		System.out.println(data);
		if(!data.equals("0")) {
			System.out.println("error!");
			return 0;
		}else {
			System.out.println("success");
			return 1;
		}
	}

}

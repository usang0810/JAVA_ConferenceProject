package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import frame.Main;
import model.User;

public class Coin {
	private String user_id;
	private String user_coin;

	public void setIdCoin(String user_id, String user_coin) {
		this.user_id = user_id;
		this.user_coin = user_coin;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_coin() {
		return user_coin;
	}

	public void setUser_coin(String user_coin) {
		this.user_coin = user_coin;
	}

	public int updatecoinConnect() throws IOException {

		URL url = new URL(Main.http + "/updatecoin");

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "user_id=" + user_id + "&user_coin=" + user_coin;
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
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String data = response.toString();

		if(data.equals("1")) {
			System.out.println(data);
			return 1;
		}else {
			System.out.println(data);
			return 0;
		}
	}
	
	public int cutcoinConnect() throws IOException {

		URL url = new URL(Main.http + "/cutcoin");

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "user_id=" + user_id;
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
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String data = response.toString();

		if(data.equals("1")) {
			System.out.println(data);
			return 1;
		}else {
			System.out.println(data);
			return 0;
		}
	}
}

package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import frame.Main;

public class Tellist {
	private int groupnum;

	public Tellist(int groupnum) {
		this.groupnum = groupnum;
	}

	public ArrayList<String> getTelConnect() throws IOException {
		URL url = new URL(Main.http + "/gettellist");

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "groupnum=" + Integer.toString(groupnum + 1);
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
		// print result
		// System.out.println("HTTP 응답 코드 : " + responseCode);
		// System.out.println("HTTP body : " + response.toString().trim());
		String[] data = response.toString().split(",");

		// System.out.println(data);

		ArrayList<String> tellist = new ArrayList<String>();
		for (int i = 0; i < data.length; i++) {
			tellist.add(data[i]);
		}

		return tellist;
	}
}

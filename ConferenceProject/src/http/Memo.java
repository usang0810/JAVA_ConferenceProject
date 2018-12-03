package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import frame.Main;

public class Memo {
	private int groupnum;
	private String date;
	private String memo;
	
	public void setDate(int groupnum , String date) {
		this.groupnum = groupnum;
		this.date = date;
	}
	
	public void setMemo(int groupnum, String date, String memo) {
		this.groupnum = groupnum;
		this.date = date;
		this.memo = memo;
	}
	
	public int checkdateConnect() throws Exception{
		URL url = new URL(Main.http+"/checkdate");

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "groupnum="+groupnum+"&date="+date;
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
		
		String data = response.toString();
		
		if(data.equals("0")) {
			//System.out.println("error!");
			return 0;
		}else {
			//System.out.println("success");
			return 1;
		}
	}
	
	public String getmemoConnect() throws Exception{
		URL url = new URL(Main.http+"/getmemo");
		String charset = "UTF-8";
		String groupnum = URLEncoder.encode(Integer.toString(this.groupnum), charset);
		String date = URLEncoder.encode(this.date, charset);

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "groupnum="+groupnum+"&date="+date;
		// 리퀘스트 메소드를 POST로 설정
		conn.setRequestMethod("POST");
		// 연결된 connection 에서 출력도 하도록 설정
		conn.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close(); 

		int responseCode = conn.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String inputLine; StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		} in.close();
		
		String data = response.toString();
		
		if(data.equals("")) {
			//System.out.println("error!");
			return null;
		}else {
			//System.out.println("success");
			return data;
		}
	}
	
	public String editmemoConnect() throws Exception{
		URL url = new URL(Main.http+"/editmemo");
		String charset = "UTF-8";
		String groupnum = URLEncoder.encode(Integer.toString(this.groupnum), charset);
		String date = URLEncoder.encode(this.date, charset);
		String memo = URLEncoder.encode(this.memo, charset);

		// HTTP 접속 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "groupnum="+groupnum+"&date="+date+"&memo="+memo;
		// 리퀘스트 메소드를 POST로 설정
		conn.setRequestMethod("POST");
		// 연결된 connection 에서 출력도 하도록 설정
		conn.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close(); 

		int responseCode = conn.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String inputLine; StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		} in.close();
		
		String data = response.toString();
		
		System.out.println(data);
		
		return data;
	}
}

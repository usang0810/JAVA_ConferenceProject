package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import frame.Main;

public class Nicklist {
	private int groupnum;
	
	public Nicklist(int groupnum) {
		this.groupnum = groupnum;
	}
	
	public ArrayList<String> getNickConnect() throws IOException{
		URL url = new URL(Main.http+"/getnicklist");

		// HTTP ���� ���ϱ�
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		String urlParameters = "groupnum="+Integer.toString(groupnum+1);
		// ������Ʈ �޼ҵ带 POST�� ����
		conn.setRequestMethod("POST");
		// ����� connection ���� ��µ� �ϵ��� ����
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
		//System.out.println("HTTP ���� �ڵ� : " + responseCode);
		//System.out.println("HTTP body : " + response.toString().trim());
		String[] data = response.toString().split(",");
		
		//System.out.println(data);
		
		ArrayList<String> nicklist = new ArrayList<String>();
		for(int i=0; i<data.length; i++) {
			nicklist.add(data[i]);
		}
		
		return nicklist;
	}
}

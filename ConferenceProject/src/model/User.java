package model;

public class User {
	private String user_id;
	private String password;
	private String nickname;
	private String tel;
	private int g1;
	private int g2;
	private int g3;
	private int g4;
	private int g5;
	private int coin;
	private int applycoin;
	
	public void setUserinfo(String user_id, String user_pw, String user_nick, String user_tel,
			int user_g1, int user_g2, int user_g3, int user_g4, int user_g5) {
		this.user_id = user_id;
		this.password = user_pw;
		this.nickname = user_nick;
		this.tel = user_tel;
		this.g1 = user_g1;
		this.g2 = user_g2;
		this.g3 = user_g3;
		this.g4 = user_g4;
		this.g5 = user_g5;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getG1() {
		return g1;
	}
	public void setG1(int g1) {
		this.g1 = g1;
	}
	public int getG2() {
		return g2;
	}
	public void setG2(int g2) {
		this.g2 = g2;
	}
	public int getG3() {
		return g3;
	}
	public void setG3(int g3) {
		this.g3 = g3;
	}
	public int getG4() {
		return g4;
	}
	public void setG4(int g4) {
		this.g4 = g4;
	}
	public int getG5() {
		return g5;
	}
	public void setG5(int g5) {
		this.g5 = g5;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public int getApplycoin() {
		return applycoin;
	}
	public void setApplycoin(int applycoin) {
		this.applycoin = applycoin;
	}
	public void printUserinfo() {
		System.out.println(this.getUser_id());
		System.out.println(this.getPassword());
		System.out.println(this.getNickname());
		System.out.println(this.getTel());
		System.out.println(this.getG1());
		System.out.println(this.getG2());
		System.out.println(this.getG3());
		System.out.println(this.getG4());
		System.out.println(this.getG5());
		System.out.println(this.getCoin());
		System.out.println(this.getApplycoin());
	}
	
}

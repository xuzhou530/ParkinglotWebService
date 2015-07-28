package main.com.wswenyue.db.domain;

public class User {
	
	private Integer uid;
	private String uname;
	private String password;
	private String email;
	private String phone;

	@Override
	public String toString() {
		return "User{" +
				"uid=" + uid +
				", uname='" + uname + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", balance=" + balance +
				", uesrflag=" + userflag +
				'}';
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	private Integer userflag;
	private Integer balance;

	public Integer getUserflag() {
		return userflag;
	}

	public void setUserflag(Integer userflag) {
		this.userflag = userflag;
	}


}

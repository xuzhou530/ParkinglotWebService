package main.com.wswenyue.db.domain;

public class Account {
	private Integer aid;
	private Integer uid;
	private String aname;
	private Integer astatus;
	private String startTime;

	@Override
	public String toString() {
		return "Account{" +
				"aid=" + aid +
				", uid=" + uid +
				", aname='" + aname + '\'' +
				", astatus=" + astatus +
				", startTime='" + startTime + '\'' +
				'}';
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getAstatus() {
		return astatus;
	}

	public void setAstatus(Integer astatus) {
		this.astatus = astatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}

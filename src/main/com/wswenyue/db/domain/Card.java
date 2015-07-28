package main.com.wswenyue.db.domain;

/**
 * Created by wswenyue on 2015/6/4.
 */
public class Card {
    private Integer cid;
    private Integer uid;
    private String cname;
    private Integer ccount;
    private String startTime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCcount() {
        return ccount;
    }

    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}

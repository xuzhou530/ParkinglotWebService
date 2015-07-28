package main.com.wswenyue.db.domain;
import main.com.wswenyue.Tools.DateCompute;

/**
 * Created by wswenyue on 2015/6/30.
 */
public class SHT {
    private Integer eid;
    private String S;
    private String H;
    private String T;
    private String time;

    public SHT(String s, String h, String t) {
        S = s;
        H = h;
        T = t;
        time = DateCompute.GetDate();
    }

    public SHT(String s, String h, String t, String time) {
        S = s;
        H = h;
        T = t;
        this.time = time;
    }

    public SHT() {
        super();
    }

    @Override
    public String toString() {
        return "SHT{" +
                "eid=" + eid +
                ", S='" + S + '\'' +
                ", H='" + H + '\'' +
                ", T='" + T + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getT() {
        return T;
    }

    public void setT(String t) {
        T = t;
    }

    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}

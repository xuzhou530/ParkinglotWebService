package main.com.wswenyue.db.domain;

/**
 * Created by wswenyue on 2015/6/6.
 */
public class Price {
    private Integer pid;
    private String pname;
    private Integer unitprice;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }
}

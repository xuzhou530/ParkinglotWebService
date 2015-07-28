package main.com.wswenyue.db.domain;

/**
 * Created by wswenyue on 2015/7/1.
 */
public class Place {
    private Integer id;
    private String uname;
    private String placeNum;
    private String isUsing;
    private String grade;
    private Integer usedCount;

    public Place() {
    }


    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", placeNum='" + placeNum + '\'' +
                ", isUsing='" + isUsing + '\'' +
                ", grade='" + grade + '\'' +
                ", usedCount=" + usedCount +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(String placeNum) {
        this.placeNum = placeNum;
    }

    public String getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(String isUsing) {
        this.isUsing = isUsing;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }
}

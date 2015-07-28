package main.com.wswenyue.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wswenyue on 2015/6/4.
 */
public class DateCompute {

    private DateCompute(){}

    private static final DateCompute instance = new DateCompute();

    public static DateCompute getInstance(){
        return instance;
    }

    public String Count(String begin){
        String result;
        Date beginDate = null;
        Date endDate = null;
        SimpleDateFormat df = DateFormat();
        try {
            beginDate = df.parse(begin);
            endDate = new Date(System.currentTimeMillis());
        } catch (ParseException e) {
            System.out.println("日期计算失败");
            throw new RuntimeException(e);
        }
        long l=endDate.getTime()-beginDate.getTime();
        long day=l/(24*60*60*1000);
        long hour=(l/(60*60*1000)-day*24);
        long min=((l/(60*1000))-day*24*60-hour*60);
        long s=(l/1000-day*24*60*60-hour*60*60-min*60);

        if(day<0 || hour<0 || min<0 || s<0){
            day = 0;
            hour = 0;
            min = 0;
            s = 0;
        }
        //================下面的调整就是为了输出05:01这种类型的格式=====================
        String temps="";
        String tempm="";
        String temph="";
        if(hour<10){
            temph = "0"+hour;
        }
        if(hour>10){
            temph = ""+hour;
        }
        if(min<10){
            tempm = "0"+min;
        }
        if(min>10){
            tempm = ""+min;
        }
        if(s<10){
            temps = "0"+s;
        }
        if(s>10){
            temps = ""+s;
        }
//==========================================================
//        result = ""+day+"天"+hour+"小时"+min+"分"+s+"秒";
        result = temph+":"+tempm+":"+temps;
        return result;
    }

    /**
     * 时长计算
     * @param startTime
     * @return 正确执行返回值为秒，错误返回NULL
     *
     * */
public static Integer Duration(String startTime){
    Integer duration = null;
    if(startTime != null && !"".equals(startTime.trim())){
        Date beginDate;
        Date endDate;
        SimpleDateFormat df = DateFormat();
        try {
            beginDate = df.parse(startTime);
            endDate = new Date(System.currentTimeMillis());
            long s = (endDate.getTime()-beginDate.getTime()) / 1000;
            duration = (int) s;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    return duration;
}

    /**
     * 获取当前时间并返回规定格式的字符串
     * */
    public static String GetDate(){
        String result = "";
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat df = DateFormat();
        result = df.format(now);
        return result;
    }

    /**
     * 格式化时间
     * */
    public static  String FormatTime(Integer second){
        String result = "";
        if(second != null){
            long day= second/(24*60*60);
            long hour= (second/(60*60)-day*24);
            long min=((second/(60))-day*24*60-hour*60);
            long s = (second-day*24*60*60-hour*60*60-min*60);


            if(day<0 || hour<0 || min<0 || s<0){
                day = 0;
                hour = 0;
                min = 0;
                s = 0;
            }
            String temph="";
            String temps="";
            String tempm="";
            if(hour<10){
                temph = "0"+hour;
            }
            if(hour>10){
                temph = ""+hour;
            }
            if(min<10){
                tempm = "0"+min;
            }
            if(min>10){
                tempm = ""+min;
            }
            if(s<10){
                temps = "0"+s;
            }
            if(s>10){
                temps = ""+s;
            }
            result = temph+":"+tempm+":"+temps;
        }
        return result;
    }


    /**
     * 日期格式化
     * */
    public static SimpleDateFormat DateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}

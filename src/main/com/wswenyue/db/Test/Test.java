package main.com.wswenyue.db.Test;

import main.com.wswenyue.db.service.SHTManage;

/**
 * Created by wswenyue on 2015/7/6.
 */
public class Test {
    @org.junit.Test
    public void test(){
        System.out.println("查询数据如下：");
        System.out.println(SHTManage.GetDatas(3));
    }

}

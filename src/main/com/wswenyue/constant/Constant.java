package main.com.wswenyue.constant;

/**
 * Created by wswenyue on 2015/5/24.
 */
public class Constant {
    /** 服务器的端口号*/
    public static final int SERVER_PORT = 8989;
    /**
     * 以下是ARMserver配置
     * */
    public static final String OPEN_IDENTIFER = "OPEN";	//打开
    public static final String OPEN02_IDENTIFER = "OPEN2";	//打开
    public static final String OPEN03_IDENTIFER = "OPEN3";	//打开
    public static final String ARM_IP = "192.168.3.199";
    public static final int ARM_PORT = 8080;//TODO
    /**
     * 价格控制类型
     * */
    public static final String PHONE_TYPE = "phone";
    public static final String CARD_TYPE = "card";
    /**
     * 手机端发送过来的命令定义
     * */
    public static final String Client_Login = "LOGIN";
    public static final String Client_Register = "REGISTER";
    public static final String Client_Reset = "RESET";
    public static final String Client_Pay = "PAY";
    public static final String Client_CMD = "CMD";
    /**
     * 回送给手机端的指令
     * */
    public static final String Server_Login_Succeed = "LOGIN_SUCCEED";
    public static final String Server_Login_Fail  = "LOGIN_FAIL";

    public static final String Server_Register_Succeed = "REGISTER_SUCCEED";
    public static final String Server_Register_Fail = "REGISTER_FAIL";

    public static final String Server_Rsset_Succeed = "RESET_SUCCEED";
    public static final String Server_Rsset_Fail = "RESET_FAIL";

    public static final String Server_Pay_Succeed = "PAY_SUCCEED";
    public static final String Server_Pay_Fail = "PAY_FAIL";

    //异常指令
    public static final String Server_Unknown = "UNKNOWN_CODE";
    public static final String Server_CMD_Execution_Succeed = "CMD_EXECUTION_SUCCEED";

    /**
     * 权限管理
     *
     * */
    public static final String Authority_Permission_denied= "PERMISSION_DENIED";//权限不够
    public static final String Authority_Not_Allowed= "NOT_ALLOWED";//权限不够

}

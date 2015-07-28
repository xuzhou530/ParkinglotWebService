package ws.parkingLotService.servlet;

import main.com.wswenyue.db.service.BasicUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wswenyue on 2015/6/17.
 */
@WebServlet(name = "PayServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("name");
        String phone = request.getParameter("phone");
        String moneystr = request.getParameter("money");
        String passwd = request.getParameter("passwd");
        System.out.println(uname+":"+phone+":"+moneystr+":"+passwd);
        if(passwd.equals("admin") && BasicUserService.FindUser(uname,phone)){
            int money = Integer.parseInt(moneystr);
            if(BasicUserService.Prepaid(phone,money)){
               request.setAttribute("message","用户"+uname+"充值成功");
            }
        }else {
            request.setAttribute("message","用户"+uname+"充值失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}

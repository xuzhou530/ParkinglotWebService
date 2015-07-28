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
@WebServlet(name = "ListUserServlet")
public class ListUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tag = request.getParameter("tag");
        if(tag.equals("online")){
            request.setAttribute("users",BasicUserService.GetOnlineUsers());
        }else {
            request.setAttribute("users",BasicUserService.GetUsers());
        }
        request.getRequestDispatcher("/userList.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

package ws.parkingLotService.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by wswenyue on 2015/6/17.
 */
@WebServlet(name = "indexServlet")
public class indexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        Long second = (Long) session.getAttribute("second");
        if(second==null){
            second = new Date(System.currentTimeMillis()).getTime()/1000;
            session.setAttribute("second",second);
        }
        Long nowtime= new Date(System.currentTimeMillis()).getTime()/1000;
        Long time = nowtime - second;

        request.setAttribute("time",time);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}

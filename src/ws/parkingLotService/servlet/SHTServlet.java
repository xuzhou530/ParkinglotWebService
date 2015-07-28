package ws.parkingLotService.servlet;

import main.com.wswenyue.db.service.SHTManage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wswenyue on 2015/7/6.
 */
@WebServlet(name = "SHTServlet")
public class SHTServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] strs = SHTManage.GetDatas(SHTManage.DataNum).split("#");
        request.setAttribute("Time",strs[0]);
        request.setAttribute("T",strs[1]);
        request.setAttribute("H",strs[2]);
        request.getRequestDispatcher("/chart.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}

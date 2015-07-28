package ws.parkingLotService.servlet;

import java.io.IOException;

/**
 * Created by wswenyue on 2015/6/15.
 */
public class ServiceServlet extends javax.servlet.http.HttpServlet {
    private  boolean tag = true;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/service.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("get");
        doPost(request,response);
    }
}

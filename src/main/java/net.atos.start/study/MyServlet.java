package net.atos.start.study;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Created by jaroslaw on 15.07.16.
 */
public class MyServlet extends HttpServlet{

    private String msg;

    public void init() throws ServletException
    {
        msg = "";
    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
           throws ServletException, IOException
    {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        Enumeration arrtibuteNames = request.getHeaderNames();

        while(arrtibuteNames.hasMoreElements()){
            String name = (String) arrtibuteNames.nextElement();
            msg += name + "<br>";
        }

        arrtibuteNames = request.getParameterNames();
        msg += "Atrybuty: <br>";

        while (arrtibuteNames.hasMoreElements()){
            String name = (String) arrtibuteNames.nextElement();
            String value = request.getParameter(name);
            msg += name + " = " + value + "<br>";
        }

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h5>" + msg + "</h5>");
    }


    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
           throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("Wczytano 1 parametrow z poprzednie formatki :");
        out.println(request.getParameter("param1"));
    }

    public void destroy()
    {
        // do nothing.
    }

}

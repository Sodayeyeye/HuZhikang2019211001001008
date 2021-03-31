package com.HuZhiKang.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name",value = "HuZhiKang"),
                @WebInitParam(name = "studentId",value = "2019211001001008"),
        }
)

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name =  config.getInitParameter("name");
        String studentId =  config.getInitParameter("studentId");

        // print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br>Name:  "+name);
        writer.println("<br>StudentId:  "+studentId);
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.HuZhiKang.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt=request.getParameter("txt");
        String[] search=request.getParameterValues("search");
        System.out.println(search);
        System.out.println(txt);

        if (txt.equals("")){
            response.sendRedirect("index.jsp");
        }else{

            if (search[0].equals("baidu")){
                //redirect to baidu
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
                System.out.println("i am in baidu");
            }else if (search[0].equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            }else if(search[0].equals("google")){
                response.sendRedirect("https://www.google.com/search?q="+txt);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

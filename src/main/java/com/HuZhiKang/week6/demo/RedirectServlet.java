package com.HuZhiKang.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. start without /
        System.out.println("before redirect ");
//        response.sendRedirect("index.jsp");//url
        //url 会从 redirect --> index.jsp
        System.out.println("after redirect ");
        //2. start with /
        //response.sendRedirect("/HuZhikang2019211001001008_war_exploded/index.jsp");
        //redirect - another server - Absolute URL
        //http://localhost:8080/HuZhikang2019211001001008_war_exploded/redirect
        //http://localhost:8080/index.jsp
        //url change after 8080
        //add /HuZhikang2019211001001008_war_exploded/
        response.sendRedirect("http://www.baidu.com");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }
}

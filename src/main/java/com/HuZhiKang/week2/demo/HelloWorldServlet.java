package com.HuZhiKang.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




public class HelloWorldServlet extends HttpServlet {
    String name="HuZhiKang";
    String ID="2019211001001008";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Hello Client !!!");
        writer.println("Name: "+name+"<br/>");
        writer.println("ID: "+ID+"<br/>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}

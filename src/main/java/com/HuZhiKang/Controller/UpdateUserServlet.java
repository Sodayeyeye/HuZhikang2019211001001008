package com.HuZhiKang.Controller;

import com.HuZhiKang.dao.UserDao;
import com.HuZhiKang.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

@WebServlet(name = "UpdateUserServlet",value="/updateUser")//url
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //write code
        //TODO 1: forward to WEB-INF/views/updateUser.jsp
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
        //TODO 2: create one jsp page - update User
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //write code to update user info- can update password,email,gender,birthDate
        //TODO 1: get all (6) request parameter
        Connection con = null;
        String id =request.getParameter("id");
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        String email =request.getParameter("email");
        String gender =request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        System.out.println(birthdate);
        //TODO 2: create an project of User Model
        User user=new User();
        //TODO 3: set all 6 request parameter values into User model - setXXX()

        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(Date.valueOf(birthdate));
       // System.out.println(user.getBirthDate());
        //TODO 4: create an object of UserDao
        UserDao userdao = new UserDao();
        //TODO 5: call updateUser() in UserDao
        con = (Connection) getServletContext().getAttribute("con");
        try {
            int i = userdao.updateUser(con,user);
            HttpSession session= request.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("user",user);
            if(i==1){
                //TODO 6: forward to WEB-INF/views/userinfo.jsp
                request.getRequestDispatcher("accountDetails").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

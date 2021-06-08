package com.HuZhiKang.Controller;

import com.HuZhiKang.dao.OrderDao;
import com.HuZhiKang.dao.UserDao;
import com.HuZhiKang.model.Order;
import com.HuZhiKang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccountDetailsServlet", value = "/accountDetails")//url
public class AccountDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null){
    //users has logged in
            User user=(User) session.getAttribute("user");
            int userId=user.getId();

                request.setAttribute("user",user);
                OrderDao orderDao=new OrderDao();
                List<Order> orderList=orderDao.findByUserId(con,userId);
                request.setAttribute("orderList",orderList);
                String path="WEB-INF/views/accountDetails.jsp";
                request.getRequestDispatcher(path).forward(request,response);

        }else {
            //ask for login
            response.sendRedirect("login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}

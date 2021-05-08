//package com.HuZhiKang.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "/admin/*")
//public class AdminAuthenticationFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        HttpSession session = httpRequest.getSession(false);
//
//        boolean isLoggedIn = (session != null && session.getAttribute("userList") != null);
//        String loginURI = httpRequest.getContextPath() + "/admin/login";
//        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
//        boolean isLoginPage =httpRequest.getRequestURI().endsWith("login");
//        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
//            //the admin is already logged in and he's trying to login again
//            //then forwards to the admin's homepage
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home");
//            dispatcher.forward(request, response);
//        } else if (isLoggedIn || isLoginRequest) {
//            //continues the filter chain
//            //allows the request to reach the destination
//            chain.doFilter(request, response);
//        } else {
//            //the admin is not logged in,so authentication is required
//            //forward to the Login page
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin/login");
//        }
//
//    }
//    public void destroy() {
//    }
//}

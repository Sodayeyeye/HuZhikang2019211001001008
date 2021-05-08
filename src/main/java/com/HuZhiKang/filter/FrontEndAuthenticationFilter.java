//package com.HuZhiKang.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "FrontEndAuthenticationFilter")
//public class FrontEndAuthenticationFilter implements Filter {
//    private HttpServletRequest httpRequest;
//    private static final String[] loginRequireURLs = {
//            "/updateUser","/logout","myCart"
//    };
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//       httpRequest = (HttpServletRequest) request;
//       String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//
//       if(path.startsWith("/admin/")){
//           chain.doFilter(request,response);
//           return;
//       }
//        HttpSession session = httpRequest.getSession(false);
//       boolean isLoggedIn =(session !=null && session.getAttribute("userList")!=null);
//       String loginURI = httpRequest.getContextPath() + "/login";
//       boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
//       boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
//
//       if(isLoggedIn && (isLoginRequest|| isLoginPage)){
//           //the user is already logged in and he's trying to login again
//           //then forwards to the homepage
//           httpRequest.getRequestDispatcher("/").forward(request,response);
//       }else if (!isLoggedIn || isLoginRequired) {
//           //continues the filter chain
//           //allows the request to reach the destination
//           chain.doFilter(request, response);
//       } else {
//           //the admin is not logged in,so authentication is required
//           //forward to the Login page
//           httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin/login");
//       }
//    }
//}

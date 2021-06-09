package com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HuZhiKangFilter")
public class HuZhiKangFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("HuZhiKangFilter-->before chain");
        chain.doFilter(request, response);

        System.out.println("HuZhiKangFilter-->after chain");
    }
}

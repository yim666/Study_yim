package com.example.study_yim.ServletFiliter;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//@WebFilter("/*")
@WebFilter(filterName = "AccessLogFilter", urlPatterns = "/*" )
public class AFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       if(true){
           HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
           ServletOutputStream writer = servletResponse1.getOutputStream();
           writer.println("dddSuccess");
           writer.close();
           return;
       }

//        writer.flush();
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

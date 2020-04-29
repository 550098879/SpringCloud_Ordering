package org.zyx.filter;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.stereotype.Component;
import org.zyx.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by SunShine on 2020/4/28.
 */
@Component
@WebFilter(filterName = "userFilter",urlPatterns = {"/index.html"})
public class UserFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.html");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}

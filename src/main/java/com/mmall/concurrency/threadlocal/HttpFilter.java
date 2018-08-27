package com.mmall.concurrency.threadlocal;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: yliao
 * @Date: Created in 2018/8/27
 */
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequsetHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

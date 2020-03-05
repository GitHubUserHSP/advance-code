package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
* 快速入门 及执行流程*/
@WebFilter(value="/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})//访问所有资源前 都会执行该Filter（过滤器）
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //此时response对象为空 对request对象的请求消息增强
        System.out.println("FilterDemo被执行了");

        filterChain.doFilter(servletRequest,servletResponse);//放行
        //回来是从放行下面执行 不是从过滤器上面执行
        //对response的响应消息增强
        System.out.println("Filter Demo回来了");
    }

    @Override
    public void destroy() {

    }

}

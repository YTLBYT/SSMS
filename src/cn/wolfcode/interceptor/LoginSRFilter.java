package cn.wolfcode.interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 未登录不能访问静态文件(.jsp)
 * 可以放问(login login.jsp .css .js .png)
 */
@WebFilter("/*")
public class LoginSRFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //System.out.println("进入到过滤器-未登录不能访问静态文件的过滤器"+request.getRequestURI());
        //不用登陆-都可以访问--以后缀的方式判定
        String[] sr =new String[] {"/login","login.jsp",".css",".js",".png",".jpg"};
        //判定这个请求是否以上述的资源结尾
        //定义一个标志-是否是以上后缀结尾
        boolean flag=false;
        for(String url_suffix:sr){
            if(request.getRequestURI().endsWith(url_suffix)){
                flag=true;
            }
        }
        //判定是否允许放行
        if(flag){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //判定登陆
            Object userInfo = request.getSession().getAttribute("userInfo");
            if(userInfo==null){
                //说明没有登陆过
                //进行网页跳转
                request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
            }else{
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}


package cn.wolfcode.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 未登录不能访问静态文件(.jsp)
 * 可以放问(login login.jsp .css .js .png)
 */
/*
public class LoginStaticResInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入到拦截器"+request.getRequestURI());
        return false;
    }
}
*/

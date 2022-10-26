package cn.wolfcode.aop;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_priviage;
import cn.wolfcode.service.LogService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
@Aspect
public class PrivilegeAop {
    @Autowired
    LogService logServiceImpl;

    @Pointcut("execution(* cn.wolfcode.controller.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() throws ServletException, IOException {
        //从HttpServletRequest获取
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        String requestURI = request.getRequestURI();
        ModelAndView modelAndView = new ModelAndView();
        if (!requestURI.endsWith("/login")) {
            //判断当前用户是否登陆
            Object userInfo = request.getSession().getAttribute("userInfo");
            if (userInfo == null) {
                //跳转到登陆界面
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                //已登陆，则获取session中的用户信息
                T_User user = (T_User) userInfo;
                List<T_priviage> priviageList = user.getT_priviageList();
                //模块级权限
                Boolean flag=false;
                for (T_priviage priviage : priviageList) {
                    for (T_priviage son : priviage.getT_priviageList()) {
                        if (!requestURI.endsWith(son.getPurl())) {
                            //不包含就跳转
                            flag=true;
                        }
                    }
                }
                if(!flag){
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        }
    }
}

package cn.wolfcode.aop;

import cn.wolfcode.entity.T_Log;
import cn.wolfcode.entity.T_User;
import cn.wolfcode.service.LogService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Component
@Aspect
public class RecordLogAop {
    @Autowired
    LogService logServiceImpl;
    //先定义一个方法--表示我们的切点（多个连接点）
    @Pointcut("execution(* cn.wolfcode.controller.*.*(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void before(){
        RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        //ip
        String ip= request.getRemoteAddr();
        //用户操作
        String requestURI = request.getRequestURI();
        String uid =null;
        if(requestURI.endsWith("/login")){
            //uid---用户标志--用户在登陆时的参数
             uid = request.getParameter("username");
        }else{
            Object userInfo = request.getSession().getAttribute("userInfo");
            uid = userInfo != null ? ((T_User) userInfo).getUcode() : "null";
        }

        //调用service层
        T_Log t_log = new T_Log();
        t_log.setIp(ip);
        t_log.setOperation(requestURI);
        t_log.setOptime(new Timestamp(System.currentTimeMillis()));
        t_log.setUid(uid);
        logServiceImpl.addLog(t_log);
    }
}

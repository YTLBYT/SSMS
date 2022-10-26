package cn.wolfcode.controller;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_Video;
import cn.wolfcode.entity.T_priviage;
import cn.wolfcode.service.UserService;
import cn.wolfcode.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserService userServiceImpl;
    @Autowired
    VideoService videoServiceImpl;
    @RequestMapping("/test")
    public ModelAndView test(){
        //查询操作
        int userCount = userServiceImpl.getUserCount();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index.jsp");
        modelAndView.addObject("number",userCount);
        return modelAndView;
    }
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(name = "username",required = true) String acount,
                              @RequestParam(name="password",required = true) String pwd,
                              HttpServletRequest request){

        //先申明一个返回值
        ModelAndView modelAndView=new ModelAndView();
        //调用service层（账号以及密码）
        T_User user= userServiceImpl.getUser(acount);
        //判定
        if (user==null){
            //账户不存在
            //返回跳转到登陆界面-且提示账户不存在
            modelAndView.setViewName("login.jsp");
            modelAndView.addObject("acount_msg","账户不存在");
            return modelAndView;
        }
        //判定账户是否锁定
        if (user.getStatus()==0){
            //跳转到登陆页面
            //提示账户锁定
            modelAndView.setViewName("login.jsp");
            modelAndView.addObject("acount_asg","账号已锁定");
            return modelAndView;
        }
        //执行账号存在的逻辑
        //判断账号与密码是否匹配
        if(!user.getPwd().equals(pwd)){
            //密码不匹配????
            ServletContext servletContext = request.getServletContext();
            //剩余次数判定?????
            Object obj_limit=servletContext.getAttribute("limit_"+user.getUcode());
            //如果只是第一次/第二次错误---提醒剩余次数
            //设置用户一个有N次机会
            int n = 5;
            if(obj_limit==null){
                //提醒剩余次数
                modelAndView.setViewName("login.jsp");
                modelAndView.addObject("acount_msg","剩余登陆次数为"+(n-1)+"次");
                //设置session中用户的剩余次数
                servletContext.setAttribute("limit_"+user.getUcode(),n-1);
                return modelAndView;
            }
            //obj_limit不为null
            //目前剩余次数
            int limit=(int) obj_limit;
            //如果减一等于0 说明剩余次数用完了
            if(limit-1==0){
                //说明这是最后一次机会
                //如果账号是第三次错误--除了提示-该用户的状态-改为零--锁定
                //锁定账号
                userServiceImpl.updateUsers(user.getUcode(),(short)0);
                //设置页面提示信息
                modelAndView.addObject("acount_msg","次数用完,账号锁定");
                //清理session的限制
                servletContext.removeAttribute("limit_"+user.getUcode());
                }else{
                //limit-1>0说明还有机会
                modelAndView.addObject("acount_msg","密码错误-剩余"+(limit-1)+"次数");
                //更新session
                servletContext.setAttribute("limit_"+user.getUcode(),limit-1);
            }
            //密码不对
            modelAndView.setViewName("login.jsp");
            return modelAndView;
        }
        //在跳转到主页（操作页面）首先先查询该用户对应的权限
        List<T_priviage> userPri = userServiceImpl.getUserPri(user.getId());
        user.setT_priviageList(userPri);
        //跳转（到主页/登陆）
        //modelAndView.addObject("userinfo",user);
        //session中设置用户信息
        request.getSession().setAttribute("userInfo",user);
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
}

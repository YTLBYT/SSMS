package cn.wolfcode.controller;


import cn.wolfcode.entity.T_User;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserService userServiceImpl;

    @ResponseBody
    @RequestMapping("/userAdd")
    public ModelAndView userAdd(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        ModelAndView modelAndView = new ModelAndView();
        //设置日期格式，用作字符串转化为日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String userpassword = request.getParameter("userpassword");
        String userRemi = request.getParameter("userRemi");
        String uSex = request.getParameter("uSex");
        Date birthday = sdf.parse(request.getParameter("data"));
        String userphone = request.getParameter("userphone");
        String userAddress = request.getParameter("userAddress");
        String userlei = request.getParameter("userlei");
        //System.out.println(userId + userName + userpassword + uSex + birthday + userphone + userAddress + userlei);
        if(userpassword.equals(userRemi)){
            T_User user = new T_User();
            user.setUcode(userId);
            user.setUname(userName);
            user.setAddress(userAddress);
            user.setBirthday(birthday);
            user.setPwd(userpassword);
            user.setPhone(userphone);
            user.setStatus((short) 1);
            switch (uSex){
                case "man":
                    user.setSex((short) 1);
                    break;
                case "woman":
                    user.setSex((short) 2);
                    break;
            }
            switch (userlei){
                case "1":
                    user.setStatus((short) 1);
                    user.setType("超级管理员");
                    user.setId(1);
                    break;
                case "2":
                    user.setStatus((short) 1);
                    user.setType("管理员");
                    user.setId(2);
                    break;
            }
            userServiceImpl.insertUser(user);
            modelAndView.setViewName("userList.jsp");
        }
        else {
            modelAndView.addObject("password_msg","两次输入密码不一样");
            modelAndView.setViewName("userAdd.jsp");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/userUpdate")
    public ModelAndView userUpdate(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        ModelAndView modelAndView = new ModelAndView();
        //设置日期格式，用作字符串转化为日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String userId = request.getParameter("uid");
        String userName = request.getParameter("userName");
        String uSex = request.getParameter("userSex");
        Date birthday = format.parse(request.getParameter("data"));
        String userphone = request.getParameter("userphone");
        String userAddress = request.getParameter("userAddress");
        String userlei = request.getParameter("userlei");
        String userStatus = request.getParameter("userStatus");
        T_User user = new T_User();
        user.setUcode(userId);
        user.setUname(userName);
        user.setAddress(userAddress);
        user.setBirthday(birthday);
        user.setPhone(userphone);
        switch (uSex){
            case "man":
                user.setSex((short) 1);
                break;
            case "woman":
                user.setSex((short) 2);
                break;
        }
        switch (userlei){
            case "1":
                user.setType("超级管理员");
                user.setId(1);
                break;
            case "2":
                user.setType("管理员");
                user.setId(2);
                break;
        }
        switch (userStatus){
            case "1":
                user.setStatus((short) 1);
                break;
            case "0":
                user.setStatus((short) 0);
        }
        userServiceImpl.updateUser(user);
        modelAndView.setViewName("userList.jsp");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/userDelete")
    public ModelAndView userView(String account){
        ModelAndView modelAndView = new ModelAndView();
        userServiceImpl.deleteUser(account);
        modelAndView.setViewName("userList.jsp");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/userSelect")
    public ModelAndView userSelect(@RequestParam(name = "selectInfo", required = true) String uid, HttpServletRequest request){
        System.out.println(uid);
        ModelAndView modelAndView = new ModelAndView();
        T_User user = userServiceImpl.getUser(uid);
        System.out.println(user);
        request.getSession().setAttribute("userSelect", user);
        modelAndView.setViewName("userSelect.jsp");
        return modelAndView;
    }
}


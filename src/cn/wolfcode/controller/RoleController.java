package cn.wolfcode.controller;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    UserService userService;



    //回答用户界面请求，返回数据。
    @RequestMapping("/roleList")
    public ModelAndView roleList(){
        ModelAndView modelAndView = new ModelAndView();
        List<T_User> userList=userService.getUserList();
        modelAndView.addObject("roles",userList);
        modelAndView.setViewName("roleList.jsp");
        return modelAndView;
    }


    @RequestMapping("/userView")
    public ModelAndView userView(String ucode){
        ModelAndView modelAndView=new ModelAndView();
        T_User t_user=userService.getUser(ucode);
        modelAndView.addObject("role",t_user);
        modelAndView.setViewName("userView.jsp");
        return modelAndView;

    }


    @RequestMapping("roleSelect")
    public ModelAndView roleSelect(String uname){
        ModelAndView modelAndView=new ModelAndView();
//        Map<String,Object> paramMapper=new HashMap<>();
//        paramMapper.put("uname",uname);
//        T_User t_user=userService.searchUser(paramMapper);

        T_User t_user=userService.searchUser(uname);
        System.out.println(uname);
        System.out.println("查询已启动");
        System.out.println(t_user);
        modelAndView.addObject("role",t_user);
        modelAndView.setViewName("roleSelect.jsp");
        return modelAndView;
    }

//    @RequestMapping("roleAdd")
//    public ModelAndView roleAdd(String ucode,String uname,Integer rid){
//        ModelAndView modelAndView=new ModelAndView();
//        T_User t_user=new T_User();
//        t_user.setRid(rid);
//        t_user.setUcode(ucode);
//        t_user.setUname(uname);
//        userService.addRole(t_user);
//        modelAndView.setViewName("redirect:roleList");
//        return modelAndView;
//    }

    @RequestMapping("roleAdd")
    public ModelAndView roleAdd(String ucode,String uname,Integer rid){
        ModelAndView modelAndView=new ModelAndView();
        T_User t_user=new T_User();
        t_user.setUcode(ucode);
        t_user.setUname(uname);
        t_user.setId(rid);
        userService.addRole(t_user);
        modelAndView.setViewName("redirect:roleList");
        return modelAndView;
    }


    @RequestMapping("roleUpdateAll")
    public ModelAndView roleUpdate(Integer rid, Short ustatus,String ucode){
        ModelAndView modelAndView=new ModelAndView();
        T_User t_user=new T_User();
        t_user.setUcode(ucode);
        t_user.setId(rid);
        t_user.setStatus(ustatus);
        System.out.println("已运行更新");
        System.out.println(rid+"-----"+ustatus);
        userService.updateRoleAll(t_user);
        modelAndView.setViewName("redirect:roleList");
        return modelAndView;

    }

    @RequestMapping("/roleUpdate")
    public ModelAndView roleUpdate(String ucode ){
        ModelAndView modelAndView=new ModelAndView();
        T_User t_user=userService.getUser(ucode);
        modelAndView.addObject("role",t_user);
        modelAndView.setViewName("roleUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping("roleDelete")
    public ModelAndView roleDelete(String ucode){
        ModelAndView modelAndView=new ModelAndView();
        userService.deleteRole(ucode);
        modelAndView.setViewName("redirect:roleList");
        return modelAndView;
    }
}

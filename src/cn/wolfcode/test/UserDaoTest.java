package cn.wolfcode.test;

import cn.wolfcode.controller.LoginController;
import cn.wolfcode.dao.UserDao;
import cn.wolfcode.dao.VideoDao;
import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_Video;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {
    @Autowired
    UserDao userMapper;
    @Autowired
    VideoDao videoMapper;
    @Autowired
    LoginController userController;
    @Test
    public void test1(){
        int select = userMapper.selects();
        System.out.println(select);
    }
    @Test
    public void test_selectUserByCondition(){
        T_User t_user=userMapper.selectUserByCondition("15283995628");
        System.out.println(t_user);
    }
    @Test
    public void test2(){
        T_Video t_video = new T_Video();
        t_video.setVurl("/sss");
        t_video.setVid("v12345664");
        t_video.setVamount(3);
        t_video.setVname("不良人");
        t_video.setVmoney(11);
        t_video.setVpay(0);
        t_video.setVunit("个");
        t_video.setVtype(".mp4");
        System.out.println(t_video);
        //videoMapper.insertVideo(t_video);

    }
}

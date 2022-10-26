package cn.wolfcode.service.imp;

import cn.wolfcode.dao.PriDao;
import cn.wolfcode.dao.UserDao;
import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_priviage;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    //引入dao层
    @Autowired
    UserDao userMapper;
    @Autowired
    PriDao priMapper;

    @Override
    public int getUserCount() {
        return userMapper.selects();
    }

    @Override
    public int updateUsers(String ucode, Short status) {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("ucode",ucode);
        paramMap.put("status",status);
        return userMapper.updateUsers(paramMap);
    }

    @Override
    public List<T_priviage> getUserPri(Integer rid) {
        List<T_priviage> t_priviages = priMapper.selectPriviage(rid);
        for(T_priviage priviage:t_priviages){
            Map<String,Object> paramMap=new HashMap<>();
            paramMap.put("pid",priviage.getPid());
            paramMap.put("rid",rid);
            List<T_priviage> sonPriviager = priMapper.selectSonPriviage(paramMap);
            priviage.setT_priviageList(sonPriviager);
        }
        return t_priviages;
    }

    @Override
    public T_User getUserss(String acount) {
        return userMapper.selectUserByCondition(acount);
    }

    /**
     * 获取用户数量
     * @return
     */
    @Override
    public List<T_User> getUsers() {
        return userMapper.select();
    }

    /**
     * 根据账户或者手机号获取用户
     * @param account
     * @return
     */

    @Override
    public T_User getUser(String account) {
        return userMapper.selectUser(account);
    }

    /**
     * 更新用户账号状态
     * @param account
     */
    @Override
    public void updateStatus(String account) {
        userMapper.updateStatus(account);
    }

    /**
     * 获取用户权限
     * @param rid
     * @return
     */
    @Override
    public List<T_priviage> getPrivilege(Integer rid) {
        //需要查询模块权限和按钮权限
        //首先查询模块权限
        List<T_priviage> privileges = priMapper.selectPriviage(rid);
        //根据模块权限id去查询按钮权限
        for (T_priviage privilege:privileges){
            Map<String, Object> paramMap = new HashMap<>();
            //注意该处的pid作为的是查询条件的p_pid
            paramMap.put("pid", privilege.getPid());
            paramMap.put("rid", rid);
            List<T_priviage> sonPrivilege = priMapper.selectSonPriviage(paramMap);
            //将子级权限赋值给模块权限
            privilege.setT_priviageList(sonPrivilege);
        }
        //返回模块权限
        return privileges;
    }

    @Override
    public void insertUser(T_User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(T_User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(String account) {
        userMapper.deleteUser(account);
    }


    @Override
    public List<T_User> getUserList() {
        return userMapper.selectUserList();

    }

    @Override
    public T_User getUsere(String ucode) {
        T_User t_user=userMapper.selectUser(ucode);
        return t_user;
    }

    @Override
    public T_User searchUser(String uname) {
        T_User t_user=userMapper.searchUser(uname);
        return t_user;
    }

    @Override
    public void addRole(T_User t_user) {
        userMapper.addRole(t_user);

    }

    @Override
    public void updateRoleAll(T_User t_user) {
        userMapper.updateRoleAll(t_user);
    }

    @Override
    public void deleteRole(String ucode) {
        userMapper.deleteRole(ucode);

    }

}

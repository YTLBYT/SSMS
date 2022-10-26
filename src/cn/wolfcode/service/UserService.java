package cn.wolfcode.service;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_priviage;

import java.util.List;

public interface UserService {
    int getUserCount();

    /**
     * 根据账户查询
     * @param acount
     * @return
     */
    T_User getUserss(String acount);
    int updateUsers(String ucode,Short status);
    /**
     * 获取用户的权限信息
     * @param
     * @return
     */
    List<T_priviage> getUserPri(Integer rid);
    //获取用户数
    List<T_User> getUsers();
    //获取用户
    T_User getUser(String account);
    //更新用户账号状态
    void updateStatus(String account);
    //获取用户权限
    List<T_priviage> getPrivilege(Integer rid);
    //插入用户
    void insertUser(T_User user);
    //更新用户
    void updateUser(T_User user);
    //删除用户
    void deleteUser(String account);


    //    获取用户列表
    List<T_User> getUserList();

    //    查询单个用户
    T_User getUsere(String ucode);

    //    查找用户
    T_User searchUser(String uname);
    //    添加角色
    void addRole(T_User t_user);

    //    修改角色/用户
    void updateRoleAll(T_User t_user);

    //    删除用户
    void deleteRole(String ucode);
}

package cn.wolfcode.dao;

import cn.wolfcode.entity.T_User;
import cn.wolfcode.entity.T_priviage;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int selects();
    //查询用户信息根据账号查询
    T_User selectUserByCondition(String str);

    /**
     * 根据用户的ucode更改用户状态
     * String ucode,Short ustatus
     * @param paramMap
     * @return
     */
    int updateUsers(Map<String,Object> paramMap);
    //测试方法


    List<T_User> select();
    //查询用户信息
    T_User selectUser(String str);
    //更新用户状态
    void updateStatus(String str);
    //插入用户
    void insertUser(T_User user);
    //更新用户
    void updateUser(T_User user);
    //删除用户
    void deleteUser(String str);

    List<T_User> selectUserList();

    T_User selectUsere(String ucode);

    T_User searchUser(String uname);

    void addRole(T_User t_user);

    void updateRoleAll(T_User t_user);

    void deleteRole(String ucode);

}

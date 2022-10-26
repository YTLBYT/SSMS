package cn.wolfcode.dao;

import cn.wolfcode.entity.T_priviage;

import java.util.List;
import java.util.Map;

public interface PriDao {
    //查询该用户的模块权限
    List<T_priviage> selectPriviage(Integer rid);
    //模块级权限id查询按钮权限

    /**
     * Integer pid,Integer rid
     * @param paramMap
     * @return
     */
    List<T_priviage> selectSonPriviage(Map<String,Object> paramMap);
}

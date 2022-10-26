package cn.wolfcode.dao;


import cn.wolfcode.entity.PicAuthor;

public interface PicAuthorDao {
    Integer selectAuthor(String name);
    void insertAuthor(PicAuthor author);
}

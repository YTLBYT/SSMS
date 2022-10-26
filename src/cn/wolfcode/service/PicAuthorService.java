package cn.wolfcode.service;

import cn.wolfcode.entity.PicAuthor;

public interface PicAuthorService {



    Integer getPicUid(String name);

    void addAuthor(PicAuthor author);

}

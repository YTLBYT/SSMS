package cn.wolfcode.dao;

import cn.wolfcode.entity.PicShow;
import cn.wolfcode.entity.Picture;

import java.util.List;
import java.util.Map;

public interface PicDao {

    void insertPic(Picture picture);


    void selectPic(String picId);

    List<PicShow> selectAllPic();

    String selectUrl(String picID);


    void deletePic(String picId);

    void updatePic(Picture picture);

    void upPicSta(Map<String,Object> map);


    void upNum(Map map);
}

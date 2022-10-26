package cn.wolfcode.service;

import cn.wolfcode.entity.PicShow;
import cn.wolfcode.entity.Picture;

import java.util.List;

public interface PicService {

    public void addPic(Picture picture);

    public List<PicShow> showPic();

    public String selectUrl(String picId);

    void deletePic(String picId);

    void updatePic(Picture picture);

    void upPicSta(String picId,int picSta);

    void upNum(String picId,int num);



}

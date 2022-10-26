package cn.wolfcode.service.imp;

import cn.wolfcode.dao.PicDao;
import cn.wolfcode.entity.PicShow;
import cn.wolfcode.entity.Picture;
import cn.wolfcode.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PicServiceImpl implements PicService {


    @Autowired
    PicDao picMapper;

    @Override
    public void addPic(Picture picture){
        picMapper.insertPic(picture);
    }

    @Override
    public List<PicShow> showPic() {
        return picMapper.selectAllPic();
    }

    @Override
    public String selectUrl(String picId) {


        return picMapper.selectUrl(picId);
    }

    @Override
    public void deletePic(String picId) {
        picMapper.deletePic(picId);
    }

    @Override
    public void updatePic(Picture picture) {
        picMapper.updatePic(picture);
    }

    @Override
    public void upPicSta(String picId,int picSta) {
        Map<String, Object> map = new HashMap<>();

        map.put("picId",picId);
        map.put("picSta",picSta);

        picMapper.upPicSta(map);
    }

    @Override
    public void upNum(String picId, int num) {
        Map<String, Object> map = new HashMap<>();

        map.put("picId",picId);
        map.put("num",num);

        picMapper.upNum(map);
    }


}

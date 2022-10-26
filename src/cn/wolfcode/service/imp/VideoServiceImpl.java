package cn.wolfcode.service.imp;

import cn.wolfcode.dao.VideoDao;
import cn.wolfcode.entity.T_Video;
import cn.wolfcode.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoMapper;
    @Override
    public List<T_Video> getVideo(Map<String, Object> paramMapper) {
        List<T_Video> t_video = videoMapper.selectVideo(paramMapper);
        return t_video;
    }

    @Override
    public void addVideo(T_Video t_video) {
        videoMapper.insertVideo(t_video);
    }

    @Override
    public void deleteVide(String vid) {
        videoMapper.deleteVideo(vid);
    }

    @Override
    public T_Video updateVideo(String vid) {
        T_Video t_video = videoMapper.updateVideo(vid);
        return t_video;
    }

    @Override
    public void updateVideoInput(T_Video t_video) {
        videoMapper.updateVideoInput(t_video);
    }

    @Override
    public List<T_Video> getVideoList() {
        return videoMapper.selectVideoList();
    }
}

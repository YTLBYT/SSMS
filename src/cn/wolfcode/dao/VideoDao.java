package cn.wolfcode.dao;

import cn.wolfcode.entity.T_Video;

import java.util.List;
import java.util.Map;

public interface VideoDao {
    List<T_Video> selectVideoList();
    List<T_Video> selectVideo(Map<String,Object> paramMap);
    void insertVideo(T_Video t_video);
    void deleteVideo(String vid);
    T_Video updateVideo(String vid);
    void updateVideoInput(T_Video t_video);
}

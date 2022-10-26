package cn.wolfcode.service;

import cn.wolfcode.entity.T_Video;

import java.util.List;
import java.util.Map;

public interface VideoService {
    /**
     * 显示所有的视频
     * @return
     */
    List<T_Video> getVideoList();
    /**
     * 通过编号查询
     * @param paramMapper
     * @return
     */
    List<T_Video> getVideo(Map<String,Object> paramMapper);

    /**
     * 添加
     */
    void addVideo(T_Video t_video);
    /**
     * 删除
     */
    void deleteVide(String vid);

    /**
     * 编辑输入
     * @param vid
     * @return
     */
    T_Video updateVideo(String vid);

    /**
     * 编辑输出
     */
    void updateVideoInput(T_Video t_video);
}

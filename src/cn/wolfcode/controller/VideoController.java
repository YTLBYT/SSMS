package cn.wolfcode.controller;

import cn.wolfcode.entity.T_Video;
import cn.wolfcode.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@MultipartConfig
public class VideoController {
    @Autowired
    VideoService videoService;

    @RequestMapping("/videoList")
    public ModelAndView videoList() {
        ModelAndView modelAndView = new ModelAndView();
        List<T_Video> videoLists = videoService.getVideoList();
        modelAndView.setViewName("videoList.jsp");
        modelAndView.addObject("videos", videoLists);
        return modelAndView;
    }
    @RequestMapping("/videoSelect")
    public ModelAndView videoSelect(String vid, String vclassify, String vstatues) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> paramMapper = new HashMap<>();
        paramMapper.put("vid", vid);
        paramMapper.put("vclassify", vclassify);
        paramMapper.put("vstatues", vstatues);
        List<T_Video> videos = videoService.getVideo(paramMapper);
        modelAndView.setViewName("videoSelect.jsp");
        modelAndView.addObject("videos", videos);
        return modelAndView;
    }

    @RequestMapping("/videoAdd")
    public ModelAndView videoAdd(String vid, String vname, String vunit, Integer vnum, Integer vmoney, MultipartFile myfile, Integer zhifu) {
        ModelAndView modelAndView = new ModelAndView();
        T_Video t_video = new T_Video();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        String originalFilename = myfile.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String vtype = "." + split[1];
        long size = myfile.getSize();
        Double mb=size/Math.pow(10,6);
        double mbs=(double)Math.round(mb*10)/10;
        t_video.setVid(vid);
        t_video.setVamount(vnum);
        t_video.setVname(vname);
        t_video.setVmoney(vmoney);
        t_video.setVpay(zhifu);
        t_video.setVunit(vunit);
        t_video.setVsize(mbs+"MB");
        t_video.setVtype(vtype);
        t_video.setVtime(java.sql.Date.valueOf(format));
        t_video.setVurl(myfile.getOriginalFilename());
        videoService.addVideo(t_video);
        //文件
        try {
            InputStream inputStream = myfile.getInputStream();
            OutputStream outputStream = new FileOutputStream("/Users/wlc/IdeaProjects/ProjectDevelop/web/video/" + myfile.getOriginalFilename());
            //边读边写
            byte[] b = new byte[1024];
            //定义长度
            int len = 0;
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            outputStream.close();
            inputStream.close();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("videoList");
        return modelAndView;
    }

    @RequestMapping("/videoDelete")
    public ModelAndView videoDelete(String vid) {
        ModelAndView modelAndView = new ModelAndView();
        videoService.deleteVide(vid);
        modelAndView.setViewName("redirect:videoList");
        return modelAndView;
    }

    @RequestMapping("/videoUpdate")
    public ModelAndView videoUpdate(String vid, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        T_Video t_video = videoService.updateVideo(vid);
        modelAndView.addObject("video", t_video);
        modelAndView.setViewName("videoUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping("/videoUpdateInput")
    public ModelAndView videoUpdateInput(String vid, String vname, String vsize, String vtype,
                                         String vclassify, Integer vstatues, String vtime, Integer vnumber) {
        ModelAndView modelAndView = new ModelAndView();
        T_Video t_video = new T_Video();
        t_video.setVname(vname);
        t_video.setVclassify(vclassify);
        t_video.setVnumber(vnumber);
        t_video.setVstatues(vstatues);
        t_video.setVid(vid);
        t_video.setVsize(vsize);
        t_video.setVtime(java.sql.Date.valueOf(vtime));
        t_video.setVtype(vtype);
        videoService.updateVideoInput(t_video);
        modelAndView.setViewName("videoList");
        return modelAndView;
    }
    @RequestMapping("/videoDetails")
    public ModelAndView videoDetails(String vid){
        ModelAndView modelAndView = new ModelAndView();
        T_Video t_video = videoService.updateVideo(vid);
        modelAndView.addObject("video",t_video);
        modelAndView.setViewName("videoView.jsp");
        return modelAndView;
    }
    @RequestMapping("/videoDownload")
    public ModelAndView downloadFile(String filename,String vid, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        //定义一个返回值
        Map<String,Object> resultMap=new HashMap<>();
        //设置响应的名称
        response.setHeader("Content-Disposition","filename="+filename);
        //设置文件类型
        response.setHeader("Content-Type","application/mp4");
        //从服务器端磁盘中找到需要的文件
        //在服务器端提供下载的路径
        String dir ="/Users/wlc/IdeaProjects/ProjectDevelop/web/video/";
        //拼接一个需要下载的文件的路径
        String fileurl=dir+filename;
        //创建一个文件对象
        File file = new File(fileurl);
        //判定file是否存在
        if(file.exists()){
            //存在--就下载
            //读取这个文件到内存
            try {
                InputStream input=new FileInputStream(file);
                //创建一个输出流
                try {
                    ServletOutputStream output = response.getOutputStream();
                    //边读边写
                    byte[] b =new byte[1024];
                    int len=0;
                    while ((len=input.read(b))!=-1){
                        output.write(b,0,len);
                    }
                    //关闭流
                    output.flush();
                    output.close();
                    input.close();
                    //设置返回值
                    resultMap.put("code",1000);
                    resultMap.put("msg","下载成功");
                    T_Video t_video = videoService.updateVideo(vid);
                    Integer s = t_video.getVnumber() + 1;
                    t_video.setVnumber(s);
                    videoService.updateVideoInput(t_video);

                } catch (IOException e) {
                    resultMap.put("code",1002);
                    resultMap.put("msg","输出失败");
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                resultMap.put("code",1001);
                resultMap.put("msg","文件不存在");
                e.printStackTrace();
            }
        }
        modelAndView.setViewName("videoList");
        return modelAndView;
    }
}

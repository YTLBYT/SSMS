package cn.wolfcode.controller;


import cn.wolfcode.entity.PicAuthor;
import cn.wolfcode.entity.PicShow;
import cn.wolfcode.entity.PicView;
import cn.wolfcode.entity.Picture;
import cn.wolfcode.service.PicAuthorService;
import cn.wolfcode.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PicController {

    @Autowired
    PicAuthorService picAuthorImpl;
    @Autowired
    PicService picServiceImpl;



    //添加图片
    @RequestMapping("/addpic")
    public String addPic(
            @RequestParam(name = "providerId",required = false) String picId,
            @RequestParam(name = "providerName",required = false) String picName,
            @RequestParam(name = "people",required = false) String name,
            @RequestParam(name = "phone",required = false) String phone,
            @RequestParam(name = "address",required = false) String address,
            MultipartFile fax,
            @RequestParam(name = "describe",required = false) String picDes
            ){

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();



        //根据作者名称查询作者编号,为空则说明为新作者
        Integer picuid = picAuthorImpl.getPicUid(name);

        //picuid为空，作者不存在，添加新作者
        if (picuid==null){
            PicAuthor author = new PicAuthor();
            author.setName(name);
            author.setPhone(phone);
            author.setAddress(address);

            picAuthorImpl.addAuthor(author);
            picuid = picAuthorImpl.getPicUid(name);
        }

        //获取图片后缀,做存储路径与索引
        String picUrl = fax.getOriginalFilename();


        //构建picture
        Picture picture = new Picture();
        picture.setPicId(picId);
        picture.setPicName(picName);
        picture.setPicDes(picDes);
        picture.setPicUrl(picUrl);
        picture.setPicUpTime(new Timestamp(System.currentTimeMillis()));
        picture.setPicSta(0);
        picture.setPicUid(picuid);

        //保存图片至本地
        try {

            String realPath = request.getSession().getServletContext().getRealPath("/img");

            File file = new File(realPath+"/"+picUrl);
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            fax.transferTo(file);

            //成功则添加记录
            picServiceImpl.addPic(picture);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    return "/picture";

    }


    @RequestMapping("/picture")
    public void showPic(){

        //获取request 和 response
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();


        List<PicShow> list = new ArrayList<>();
        list = (List<PicShow>)picServiceImpl.showPic();

        request.getSession().setAttribute("listInfo",list);

        //
        try {
            request.getRequestDispatcher("/picture.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @RequestMapping("/pictureView")
    public void showPicView(String picId){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();


        List<PicShow> list = new ArrayList<>();
        list = (List<PicShow>)picServiceImpl.showPic();

        PicView picView = (PicView) request.getSession().getAttribute("picView");

        //匹配查询图片
        for (PicShow picShow:list){

            if (picShow.getPicId().equals(picId)){

                //构建picview对象
                picView = new PicView();
                picView.setPicId(picId);
                picView.setPicName(picShow.getPicName());
                picView.setPicDes(picShow.getPicDes());
                picView.setStatus(picShow.getStatus());
                picView.setPicUpTime(picShow.getPicUpTime());
                picView.setNum(picShow.getNum());


                //文件路径

                String url = picServiceImpl.selectUrl(picId);
                picView.setPicUrl(url);

                //文件大小及转换
                String realPath = request.getSession().getServletContext().getRealPath("/img");
                File file = new File(realPath+"/"+url);
                long fileS = file.length();

                DecimalFormat df = new DecimalFormat("#.00");

                String fileSizeString = "";

                if (fileS < 1024) {

                    fileSizeString = df.format((double) fileS) + "B";

                } else if (fileS < 1048576) {

                    fileSizeString = df.format((double) fileS / 1024) + "K";

                } else if (fileS < 1073741824) {

                    fileSizeString = df.format((double) fileS / 1048576) + "M";

                } else {

                    fileSizeString = df.format((double) fileS / 1073741824) + "G";

                }



                picView.setPicSize(fileSizeString);
                picView.setPicType(url.split("\\.")[1]);
                picView.setNum(picView.getNum()+1);
                System.out.println(picView.getNum());

                picServiceImpl.upNum(picId,picView.getNum());

                request.getSession().setAttribute("picView",picView);
                break;

            }
        }


        try {
            request.getRequestDispatcher("/pictureView.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





    @RequestMapping("/delete")
    public void deletePic(String picId){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();

        picServiceImpl.deletePic(picId);

        try {
            request.getRequestDispatcher("/picture").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @RequestMapping("/update")
    public String updatePic(
            @RequestParam(name = "providerId",required = true) String picId,
            @RequestParam(name = "providerName",required = false) String picName,
            @RequestParam(name = "people",required = false) String name,
            @RequestParam(name = "phone",required = false) String phone,
            @RequestParam(name = "address",required = false) String address,
            MultipartFile fax,
            @RequestParam(name = "describe",required = false) String picDes){

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();


        System.out.println("进入update");


        Integer picuid = picAuthorImpl.getPicUid(name);

        //picuid为0，作者不存在，添加新作者
        if (picuid==null){
            PicAuthor author = new PicAuthor();
            author.setName(name);
            author.setPhone(phone);
            author.setAddress(address);

            picAuthorImpl.addAuthor(author);
            picuid = picAuthorImpl.getPicUid(name);
        }


        String picUrl = fax.getOriginalFilename();
        System.out.println(picUrl);


        //保存图片至本地
        try {

            String realPath = request.getSession().getServletContext().getRealPath("/img");

            File file = new File(realPath+"/"+picUrl);
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            fax.transferTo(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Picture picture = new Picture();
        picture.setPicId(picId);
        picture.setPicName(picName);
        picture.setPicDes(picDes);
        picture.setPicUrl(picUrl);
        picture.setPicUpTime(new Timestamp(System.currentTimeMillis()));
        picture.setPicSta(0);
        picture.setPicUid(picuid);

        System.out.println(picture);

        picServiceImpl.updatePic(picture);


        return "/picture";

    }


    @RequestMapping("/uppicsta")
    public String upPicSta(String picId,int picSta){

        picServiceImpl.upPicSta(picId,picSta);

        return "/picture";

    }


}

package cn.wolfcode.entity;

import java.sql.Timestamp;

public class PicView {

    String picId;
    String picName;
    String picSize;
    String picType;
    String picDes;
    String status;
    Timestamp picUpTime;

    String picUrl;
    int num;


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicSize() {
        return picSize;
    }

    public void setPicSize(String picSize) {
        this.picSize = picSize;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    public String getPicDes() {
        return picDes;
    }

    public void setPicDes(String picDes) {
        this.picDes = picDes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getPicUpTime() {
        return picUpTime;
    }

    public void setPicUpTime(Timestamp picUpTime) {
        this.picUpTime = picUpTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

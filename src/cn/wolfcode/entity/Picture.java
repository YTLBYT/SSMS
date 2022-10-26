package cn.wolfcode.entity;

import java.sql.Timestamp;

public class Picture {

    private String picId;
    private String picName;
    private String picDes;
    private String picUrl;
    private Timestamp picUpTime;
    private int picSta;
    private int picUid;

    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picId='" + picId + '\'' +
                ", picName='" + picName + '\'' +
                ", picDes='" + picDes + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", picUpTime='" + picUpTime + '\'' +
                ", picSta='" + picSta + '\'' +
                ", picUid=" + picUid +
                '}';
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

    public String getPicDes() {
        return picDes;
    }

    public void setPicDes(String picDes) {
        this.picDes = picDes;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Timestamp getPicUpTime() {
        return picUpTime;
    }

    public void setPicUpTime(Timestamp picUpTime) {
        this.picUpTime = picUpTime;
    }

    public int getPicSta() {
        return picSta;
    }

    public void setPicSta(int picSta) {
        this.picSta = picSta;
    }

    public int getPicUid() {
        return picUid;
    }

    public void setPicUid(int picUid) {
        this.picUid = picUid;
    }
}

package cn.wolfcode.entity;

import java.sql.Timestamp;

public class PicShow {

    private String picId;
    private String picName;
    private String picDes;
    private String status;
    private Timestamp picUpTime;
    private String name;
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    public Timestamp getPicUpTime() {
        return picUpTime;
    }

    public void setPicUpTime(Timestamp picUpTime) {
        this.picUpTime = picUpTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

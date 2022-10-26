package cn.wolfcode.entity;

import java.util.Date;

public class T_Video {
    private String vid;
    private String vname;
    private String vsize;
    private String vtype;
    private String vclassify;
    private Integer vstatues;
    private Date vtime;
    private Integer vnumber;
    private String vunit;
    private Integer vamount;
    private Integer vmoney;
    private Integer vpay;
    private String vurl;

    @Override
    public String toString() {
        return "T_Video{" +
                "vid='" + vid + '\'' +
                ", vname='" + vname + '\'' +
                ", vsize='" + vsize + '\'' +
                ", vtype='" + vtype + '\'' +
                ", vclassify='" + vclassify + '\'' +
                ", vstatues=" + vstatues +
                ", vtime=" + vtime +
                ", vnumber='" + vnumber + '\'' +
                ", vunit='" + vunit + '\'' +
                ", vamount=" + vamount +
                ", vmoney=" + vmoney +
                ", vpay=" + vpay +
                ", vrul='" + vurl + '\'' +
                '}';
    }

    public String getVurl() {

        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVsize() {
        return vsize;
    }

    public void setVsize(String vsize) {
        this.vsize = vsize;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getVclassify() {
        return vclassify;
    }

    public void setVclassify(String vclassify) {
        this.vclassify = vclassify;
    }

    public Integer getVstatues() {
        return vstatues;
    }

    public void setVstatues(Integer vstatues) {
        this.vstatues = vstatues;
    }

    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }

    public Integer getVnumber() {
        return vnumber;
    }

    public void setVnumber(Integer vnumber) {
        this.vnumber = vnumber;
    }

    public String getVunit() {
        return vunit;
    }

    public void setVunit(String vunit) {
        this.vunit = vunit;
    }

    public Integer getVamount() {
        return vamount;
    }

    public void setVamount(Integer vamount) {
        this.vamount = vamount;
    }

    public Integer getVmoney() {
        return vmoney;
    }

    public void setVmoney(Integer vmoney) {
        this.vmoney = vmoney;
    }

    public Integer getVpay() {
        return vpay;
    }

    public void setVpay(Integer vpay) {
        this.vpay = vpay;
    }

}

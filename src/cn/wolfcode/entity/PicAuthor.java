package cn.wolfcode.entity;

public class PicAuthor {

    private int picUid;
    private String name;
    private String phone;
    private String address;

    @Override
    public String toString() {
        return "PicAuthor{" +
                "picUid=" + picUid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getPicUid() {
        return picUid;
    }

    public void setPicUid(int picUid) {
        this.picUid = picUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

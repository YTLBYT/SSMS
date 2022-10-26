package cn.wolfcode.entity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class T_User {
    private Integer id;
    private String ucode;
    private String uname;
    private String uphoto;
    private Short sex;
    private Date birthday;
    private String phone;
    private String type;
    private Short status;
    private String pwd;
    private String address;
    //表示用户对应的权限
    private List<T_priviage> t_priviageList;

    public List<T_priviage> getT_priviageList() {
        return t_priviageList;
    }

    public void setT_priviageList(List<T_priviage> t_priviageList) {
        this.t_priviageList = t_priviageList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphoto() {
        return uphoto;
    }

    public void setUphoto(String uphoto) {
        this.uphoto = uphoto;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "T_User{" +
                "id=" + id +
                ", ucode='" + ucode + '\'' +
                ", uname='" + uname + '\'' +
                ", uphoto='" + uphoto + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                ", t_priviageList=" + t_priviageList +
                '}';
    }
    public int getUserAge() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDayAge = sdf.parse(sdf.format(birthday));
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDayAge)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "日期填写错误！！");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDayAge);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;//当前日期在生日之前，年龄减一
                }
            }else{
                age--;//当前月份在生日之前，年龄减一
            } } return age;
    }
}

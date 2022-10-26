package cn.wolfcode.entity;

import java.sql.Timestamp;

public class T_Log {
    private Integer id;
    private String uid;
    private String ip;
    private Timestamp optime;
    private String operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getOptime() {
        return optime;
    }

    public void setOptime(Timestamp optime) {
        this.optime = optime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "T_LOG{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", ip='" + ip + '\'' +
                ", optime=" + optime +
                ", operation='" + operation + '\'' +
                '}';
    }
}

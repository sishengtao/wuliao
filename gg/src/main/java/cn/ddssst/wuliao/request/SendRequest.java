package cn.ddssst.wuliao.request;

public class SendRequest {

    /* 详细内容*/
    private String first;
    /* 预约号*/
    private String number;
    /* 预约时间*/
    private String time;
    /* 预约地点*/
    private String name;
    /* 备注*/
    private String remark;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

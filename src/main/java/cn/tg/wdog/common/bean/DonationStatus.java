package cn.tg.wdog.common.bean;

public enum DonationStatus {
    DONATION_UNSTART(0, "未启用"),
    DONATION_START(1, "启用");

    DonationStatus(int Code, String msg) {
        this.code = Code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

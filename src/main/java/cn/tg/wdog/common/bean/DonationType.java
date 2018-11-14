package cn.tg.wdog.common.bean;

public enum DonationType {
    DONATION_TYPE(0, "无"),
    DONATION_TYPE_CHANGE_STEP(100, "步数兑换TG"),
    DONATION_ONE_2_ONE(1, "一对一捐助");

    DonationType(int Code, String msg) {
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

    public static String getMsgByType(Integer d) {
        for (DonationType type : DonationType.values()) {
            if (type.code == d) {
                return type.msg;
            }
        }
        return "";
    }
}

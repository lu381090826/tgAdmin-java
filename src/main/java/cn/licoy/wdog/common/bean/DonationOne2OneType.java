package cn.licoy.wdog.common.bean;

public enum DonationOne2OneType {
    DONATION_ONE_2_ONE_CHILD(1, "城乡儿童"),
    DONATION_ONE_2_ONE_TREAT(2, "捐助治病");

    DonationOne2OneType(int Code, String msg) {
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
        for (DonationOne2OneType type : DonationOne2OneType.values()) {
            if (type.code == d) {
                return type.msg;
            }
        }
        return "";
    }
}

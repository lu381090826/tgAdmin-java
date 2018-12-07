package cn.tg.wdog.common.bean;

public enum GoodsType {
    GOODS_TYPE(0, "无"),
    GOODS_TYPE_BOOK(1000001, "书");

    GoodsType(int Code, String msg) {
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
        for (GoodsType type : GoodsType.values()) {
            if (type.code == d) {
                return type.msg;
            }
        }
        return "";
    }
}

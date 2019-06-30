package com.huo.msb.java.hellospringboot.account.resp;

/**
 * 包装返回信息
 *
 * @author huoyun
 * @date 2019/6/30-16:22
 */
public class RespStat {
    private Integer code;
    private String message;
    private Object data;

    public RespStat(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static RespStat build(int i, String msg, Object data) {
        return new RespStat(i, msg, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

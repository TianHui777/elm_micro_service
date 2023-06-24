package com.tianhui.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T result;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}

package com.baidu.ubqa.entity;

import lombok.Data;

@Data
public class Result {
    private Object data;
    private Boolean status;
    private String info;


    public Result success(Object data) {
        this.setStatus(true);
        this.setData(data);
        this.setInfo("");
        return this;
    }

    public Result success() {
        this.setStatus(true);
        this.setInfo("");
        this.setData("");
        return this;
    }


    public Result fail(Object data,String errorMessage) {
        this.setStatus(false);
        this.setData(data);
        this.setInfo(errorMessage);
        return this;
    }

    public Result fail(String errorMessage) {
        this.setStatus(false);
        this.setInfo(errorMessage);
        return this;
    }
}

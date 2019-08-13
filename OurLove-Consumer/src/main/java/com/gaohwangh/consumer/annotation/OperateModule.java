package com.gaohwangh.consumer.annotation;

/**
 * @Author: GH
 * @Date: 2019/8/12 21:26
 * @Version 1.0
 * 操作模块
 */
public enum OperateModule {
    LOGIN("登陆"),
    LOGOUT("退出登陆"),
    DEMAND("需求"),
    ITERATION("迭代");

    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    OperateModule(String model) {
        this.model = model;
    }
}

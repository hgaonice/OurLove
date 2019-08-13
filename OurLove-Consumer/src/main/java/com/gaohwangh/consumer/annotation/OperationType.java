package com.gaohwangh.consumer.annotation;

/**
 * @Author: GH
 * @Date: 2019/8/12 21:07
 * @Version 1.0
 * 操作类型
 */
public enum OperationType {
    QUERY("查询"),
    INSERT("新增"),
    UPDATE("修改"),
    DELETE("删除");

    private String type;

    OperationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

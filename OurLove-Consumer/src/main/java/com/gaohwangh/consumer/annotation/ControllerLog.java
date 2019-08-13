package com.gaohwangh.consumer.annotation;

import java.lang.annotation.*;

/**
 * @Author: GH
 * @Date: 2019/8/12 20:52
 * @Version 1.0
 * controller 日志输出
 * 标注在方法上
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited//可被继承
public @interface ControllerLog {

    /**
     * 相关描述
     * @return
     */
    String desc() default "";

    /**
     * 操作类型
     * @return
     */
    OperationType type() default OperationType.QUERY;

    /**
     * 操作模块
     * @return
     */
    OperateModule model() default OperateModule.DEMAND;

    /**
     * 主键入参参数名称，入参中的哪个参数为主键
     *
     * @return
     */
    String primaryKeyName() default "";

    /**
     * 主键在参数中的顺序，从0开始，默认0
     */
    int primaryKeySort() default 0;

    /**
     * 业务类型
     * @return
     */
    String business() default "";
}

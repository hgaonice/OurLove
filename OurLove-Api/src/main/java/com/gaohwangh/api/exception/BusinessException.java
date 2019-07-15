package com.gaohwangh.api.exception;

import com.gaohwangh.api.utils.BaseUtils;

/**
 * @Author: GH
 * @Date: 2019/7/16 1:50
 * @Version 1.0
 *
 * 异常处理类
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 5333594641625781010L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message,Throwable e){
        super(message, e);
    }

    public BusinessException(Throwable e){
        BaseUtils.loggerError(e);
    }
}

package com.gaohwangh.consumer.annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gaohwangh.api.utils.BaseUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GH
 * @Date: 2019/8/12 21:06
 * @Version 1.0
 * <p>
 * 日志切面
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    /**
     * controller层日志切点
     */
    @Pointcut("@annotation(com.gaohwangh.consumer.annotation.ControllerLog)")
    public void controllerLog() {  }

    /**
     * 环绕通知
     * @param point
     * @return
     * @throws Throwable
     */
    @Around(value = "controllerLog()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //方法的签名
        MethodSignature methodSignature = ((MethodSignature) point.getSignature());

        //切入的目标类
        Object target = point.getTarget();
        RequestMapping annotation = target.getClass().getAnnotation(RequestMapping.class);
        String url = "";
        if (annotation != null && (annotation.value().length > 0)) {
            url = annotation.value()[0];
        }

        //获取相关描述
        String memo = methodSignature.getMethod().getAnnotation(ControllerLog.class).desc();
        log.info("相关描述:" + memo);
        //操作模块
        OperateModule model = methodSignature.getMethod().getAnnotation(ControllerLog.class).model();
        log.info("操作模块:" + model.getModel());
        //操作类型
        OperationType type = methodSignature.getMethod().getAnnotation(ControllerLog.class).type();
        log.info("操作类型:"+type.getType());
        //请求的Url
        String[] val = methodSignature.getMethod().getAnnotation(RequestMapping.class).value();
        log.info("请求路径:" + url + val[0]);

        //************************请求参数打印****************************
        //得到参数名称
        String[] parameterNames = methodSignature.getParameterNames();
        //获取参数
        Object[] args = point.getArgs();
        Map<String, String> paramMap = new HashMap<>();
        for (int i = 0; i < args.length; ++i) {
            Object o = args[i];
            if (o instanceof HttpServletRequest) {
                Enumeration en = request.getParameterNames();
                Map<String, String> map = new HashMap<>();
                while (en.hasMoreElements()) {
                    String name = en.nextElement().toString();
                    String value = request.getParameter(name);
                    map.put(name, value);
                }
                log.info("HttpServletRequest请求参数:" + map);
                continue;
            }
            if (o instanceof Serializable) {
                if (o instanceof String) {
                    paramMap.put(parameterNames[i], JSONObject.toJSONString(o));
                } else if (o instanceof Integer) {
                    paramMap.put(parameterNames[i], JSONObject.toJSONString(o));
                }else {
                    log.info("实体请求参数:" + JSONObject.toJSONString(o));
                }
            }
        }
        if (paramMap.size() > 0) {
            log.info("其他请求参数:" + paramMap.toString());
        }
        //***************************************请求参数打印**********************************

        //TODO  暂时没用
        //获取返回的结果
        Object result = null;
        try {
            result = point.proceed(point.getArgs());
            HashMap resultMap = new HashMap<String, Object>();
            if (result instanceof Map) {
                resultMap = (HashMap) result;
            }

        } catch (Exception e) {
            BaseUtils.loggerError(e);
        }
        return result;

    }



}

package com.gaohwangh.consumer.controller;

import com.gaohwangh.api.model.SysUserModel;
import com.gaohwangh.api.utils.BaseUtils;
import com.gaohwangh.consumer.service.SysUserConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GH
 * @Date: 2019/7/25 23:16
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class SysUserController {
    @Autowired
    private SysUserConsumerService sysUserConsumerService;

    @RequestMapping(value = "sysUserAdd",method = RequestMethod.POST)
    public Map<String, Object> userAdd(@RequestBody SysUserModel userModel) {
        Map<String, Object> resultMap = new HashMap<>(6);

        if (userModel != null) {
            sysUserConsumerService.userAdd(userModel);
            resultMap.put("msg", "success");
        }else {
            resultMap.put("msg", "数据为空!");
        }
        return resultMap;
    }

    /**
     * 发送验证码
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSmsCode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSmsCode(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>(6);
        try {
            resultMap= sysUserConsumerService.getSmsCode(request);
        } catch (Exception e) {
            resultMap.put("msg", BaseUtils.loggerError(e));
        }

        return resultMap;
    }


}

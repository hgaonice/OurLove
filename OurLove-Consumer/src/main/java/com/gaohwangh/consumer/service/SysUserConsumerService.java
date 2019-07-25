package com.gaohwangh.consumer.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.gaohwangh.api.exception.BusinessException;
import com.gaohwangh.api.model.SysUserModel;
import com.gaohwangh.api.utils.CryptographyUtils;
import com.gaohwangh.consumer.client.SysUserConsumerClient;
import com.gaohwangh.consumer.utils.SmsDemoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GH
 * @Date: 2019/7/25 23:15
 * @Version 1.0
 */
@Service
@Slf4j
public class SysUserConsumerService {
    @Resource
    private SysUserConsumerClient sysUserConsumerClient;

    public void userAdd(SysUserModel userModel) {
        log.debug("加密前:" + userModel.getPassword());
        userModel.setPassword(CryptographyUtils.encMd5(userModel.getPassword()));
        log.debug("加密后:" + userModel.getPassword());
        log.debug("消费者的服务端调用!");
        sysUserConsumerClient.userAdd(userModel);
    }


    /**
     * 发送验证码
     *
     * @param request
     * @return
     */
    public Map<String, Object> getSmsCode(HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(6);
        String phone = request.getParameter("phone");
        log.debug("手机号:" + phone);
        if (StringUtils.isNotBlank(phone)) {
            String randNum = SmsDemoUtils.getRandNum();
            log.debug("生成的验证码:" + randNum);
            SendSmsResponse sendSmsResponse = SmsDemoUtils.sendSms(randNum, phone);
            String code = sendSmsResponse.getCode();
            log.debug("是否发送成功:" + code);
            resultMap.put("code", code);
        } else {
            throw new BusinessException("请输入手机号");
        }
        return resultMap;
    }
}

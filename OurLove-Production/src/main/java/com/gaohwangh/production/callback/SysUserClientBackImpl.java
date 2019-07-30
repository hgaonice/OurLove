package com.gaohwangh.production.callback;

import com.alibaba.fastjson.JSONObject;
import com.gaohwangh.api.feignClient.SysUserClient;
import com.gaohwangh.api.model.SysUserModel;
import com.gaohwangh.production.services.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GH
 * @Date: 2019/7/25 23:03
 * @Version 1.0
 */
@RestController
@Slf4j
public class SysUserClientBackImpl implements SysUserClient {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public void userAdd(@RequestBody SysUserModel userModel) {
        log.info("回调Service方法!");
        log.info("userModel[{}]!" + JSONObject.toJSONString(userModel));
        sysUserService.userAdd(userModel);
    }
}

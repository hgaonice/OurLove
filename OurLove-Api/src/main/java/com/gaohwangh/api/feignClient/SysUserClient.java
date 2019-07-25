package com.gaohwangh.api.feignClient;

import com.gaohwangh.api.model.SysUserModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;

/**
 * @Author: GH
 * @Date: 2019/7/25 22:18
 * @Version 1.0
 */
@RequestMapping("/sysUser")
public interface SysUserClient {

    /**
     * 新增
     * @param userModel
     */
    @RequestMapping(value = "userAdd",method = RequestMethod.POST/*,consumes = MediaType.APPLICATION_JSON_VALUE*/)
    void userAdd(@RequestBody SysUserModel userModel);


}

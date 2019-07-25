package com.gaohwangh.production.services;

import com.gaohwangh.api.model.SysUserModel;
import com.gaohwangh.production.dao.SysUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: GH
 * @Date: 2019/7/25 23:10
 * @Version 1.0
 */
@Service
@Slf4j
public class SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    public void userAdd(SysUserModel userModel) {
        log.info("插入数据!");
        sysUserDao.insertSelective(userModel);
    }
}

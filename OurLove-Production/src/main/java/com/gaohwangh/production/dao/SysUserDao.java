package com.gaohwangh.production.dao;

import com.gaohwangh.api.model.SysUserModel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: GH
 * @Date: 2019/7/25 23:04
 * @Version 1.0
 */
@Repository
public interface SysUserDao extends Mapper<SysUserModel> {

}

package com.gaohwangh.production.dao;


import com.gaohwangh.api.model.SysJobModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/8/15 9:26
 */
public interface SysJobDao extends Mapper<SysJobModel> {
    List<Map<String, Object>> selectListBySQL(String sql);
}

package com.gaohwangh.production.dao;

import com.gaohwangh.api.model.PapersModel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: GH
 * @Date: 2019/7/15 23:40
 * @Version 1.0
 */
@Repository
public interface PapersDao extends Mapper<PapersModel> {


}

package com.gaoh.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaohwangh.api.entity.StudentEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoh
 * @since 2019-07-30
 */
public interface StudentMapper extends BaseMapper<StudentEntity> {
    List<Map<String, Object>> selectListBySQL(String sql);
}

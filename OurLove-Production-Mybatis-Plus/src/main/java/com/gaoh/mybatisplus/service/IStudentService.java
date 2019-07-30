package com.gaoh.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gaohwangh.api.entity.StudentEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaoh
 * @since 2019-07-30
 */
public interface IStudentService extends IService<StudentEntity> {

    StudentEntity selectOne(StudentEntity studentEntity);

    List<StudentEntity> selectList(StudentEntity studentEntity);

    void insertStudent(StudentEntity studentEntity);

    List<StudentEntity> selectBySql(StudentEntity studentEntity);
}

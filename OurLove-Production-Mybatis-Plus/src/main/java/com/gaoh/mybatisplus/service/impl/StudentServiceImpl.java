package com.gaoh.mybatisplus.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gaoh.mybatisplus.mapper.StudentMapper;
import com.gaoh.mybatisplus.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaohwangh.api.entity.StudentEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gaoh
 * @since 2019-07-30
 */
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentEntity> implements IStudentService {
    @Resource
    private IStudentService iStudentService;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public StudentEntity selectOne(StudentEntity studentEntity) {
        log.info("studentEntity:" + JSONObject.toJSONString(studentEntity));
       /* Wrapper<StudentEntity> wrapper = new QueryWrapper<>();
        studentMapper.selectOne(wrapper);*/
        studentEntity = iStudentService.getById(studentEntity);
        log.info("查询的studentEntity:" + JSONObject.toJSONString(studentEntity));
        return studentEntity;
    }

    @Override
    public List<StudentEntity> selectList(StudentEntity studentEntity) {
        log.info("参数:" + JSONObject.toJSONString(studentEntity));
        Wrapper<StudentEntity> wr = new QueryWrapper<>();
        List<StudentEntity> studentEntities = studentMapper.selectList(wr);

        log.info("service" + studentEntities.size() + "");
        return studentEntities;
    }

    @Override
    public void insertStudent(StudentEntity studentEntity) {
        log.info("insert===>");
        studentMapper.insert(studentEntity);
        log.info("save===>");
        iStudentService.save(studentEntity);
    }

    @Override
    public List<StudentEntity> selectBySql(StudentEntity studentEntity) {
        List<StudentEntity> list = new ArrayList<>();
        String sql = "SELECT ids,name,age FROM student";

        List<Map<String, Object>> maps = studentMapper.selectListBySQL(sql);

        for (Map<String, Object> map : maps) {
            StudentEntity student = new StudentEntity();
            try {
                BeanUtils.populate(student, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(student);
        }
        return list;

    }

}

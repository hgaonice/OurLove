package com.gaoh.mybatisplus.controller;


import com.gaoh.mybatisplus.service.IStudentService;
import com.gaohwangh.api.entity.StudentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gaoh
 * @since 2019-07-30
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Resource
    private IStudentService iStudentService;

    @RequestMapping(value = "/selectOne")
    public StudentEntity selectOne(@RequestBody StudentEntity studentEntity) {
        log.info("controller");
        studentEntity = iStudentService.selectOne(studentEntity);
        return studentEntity;
    }

    @RequestMapping(value = "/selectList")
    public List<StudentEntity> selectList(@RequestBody StudentEntity studentEntity) {
        List<StudentEntity> studentEntities = iStudentService.selectList(studentEntity);
        log.info("length:" + studentEntities.size());
        return studentEntities;
    }

    @RequestMapping(value = "/insert")
    public Map<String, Object> insertStudent(@RequestBody StudentEntity studentEntity) {
        Map<String, Object> resultMap = new HashMap<>(6);

        iStudentService.insertStudent(studentEntity);

        resultMap.put("data", "插入数据成功!");
        return resultMap;
    }

    @RequestMapping(value = "/selectBySql")
    public Map<String, Object> selectBySql(@RequestBody StudentEntity studentEntity) {
        Map<String, Object> resultMap = new HashMap<>(6);

        List<StudentEntity> list = iStudentService.selectBySql(studentEntity);

        resultMap.put("data", list);
        return resultMap;
    }


}

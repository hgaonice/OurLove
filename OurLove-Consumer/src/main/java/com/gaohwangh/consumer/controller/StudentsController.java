package com.gaohwangh.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.gaohwangh.api.entity.StudentEntity;
import com.gaohwangh.consumer.service.StudentConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/8/1 23:58
 * @Version 1.0
 * MIME type may not contain reserved characters  解决方案 :在RequestMapping中加上 consumes = MediaType.APPLICATION_JSON_VALUE
 */
@RestController
@RequestMapping("/stu")
@Slf4j
public class StudentsController {
    @Resource
    private StudentConsumerService studentConsumerService;

    /**
     * @param studentEntity
     * @return
     */
    @RequestMapping(value = "/selectList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentEntity> selectList(@RequestBody StudentEntity studentEntity) {
        log.info("StudentsController===>selectList");
        log.info(JSON.toJSONString(studentEntity));
        return studentConsumerService.selectList(studentEntity);
    }

    @RequestMapping(value = "/selectStudent", method = RequestMethod.GET)
    public List<StudentEntity> selectStudent() {
        log.info("StudentsController===>selectList");
        StudentEntity studentEntity = new StudentEntity();
        log.info(JSON.toJSONString(studentEntity));
        return studentConsumerService.selectList(studentEntity);
    }
}

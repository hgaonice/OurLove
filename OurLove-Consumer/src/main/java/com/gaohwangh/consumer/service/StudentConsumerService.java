package com.gaohwangh.consumer.service;

import com.gaohwangh.api.entity.StudentEntity;
import com.gaohwangh.consumer.client.StudentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/8/1 23:56
 * @Version 1.0
 */
@Service
@Slf4j
public class StudentConsumerService {
    @Resource
    private StudentFeignClient studentFeignClient;

    public List<StudentEntity> selectList(StudentEntity studentEntity){
        log.info("StudentConsumerService===>selectList");
        return studentFeignClient.selectList(studentEntity);
    }

}

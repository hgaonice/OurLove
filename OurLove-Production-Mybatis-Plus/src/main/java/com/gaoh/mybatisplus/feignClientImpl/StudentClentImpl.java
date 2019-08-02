package com.gaoh.mybatisplus.feignClientImpl;

import com.gaoh.mybatisplus.service.IStudentService;
import com.gaohwangh.api.entity.StudentEntity;
import com.gaohwangh.api.feignClient.StudentClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/8/1 23:51
 * @Version 1.0
 */
@RestController
public class StudentClentImpl implements StudentClient {
    @Resource
    private IStudentService iStudentService;

    @Override
    public List<StudentEntity> selectList(@RequestBody StudentEntity studentEntity) {
        return iStudentService.selectList(studentEntity);
    }
}

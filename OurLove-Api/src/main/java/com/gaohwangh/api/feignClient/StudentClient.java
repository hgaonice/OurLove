package com.gaohwangh.api.feignClient;

import com.gaohwangh.api.entity.StudentEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/8/1 23:48
 * @Version 1.0
 */
@RequestMapping("/student")
public interface StudentClient {

    @RequestMapping(value = "/selectList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<StudentEntity> selectList(@RequestBody StudentEntity studentEntity);
}

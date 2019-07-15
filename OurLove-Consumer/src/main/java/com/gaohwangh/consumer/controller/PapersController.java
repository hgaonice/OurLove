package com.gaohwangh.consumer.controller;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.consumer.service.PapersConsumerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:53
 * @Version 1.0
 */
@Api(value = "/papers", description = "文件相关操作")
@RestController
@RequestMapping("/papers")
public class PapersController {

    @Autowired
    private PapersConsumerService papersConsumerService;

    /**
     * @CrossOrigin(origins = "*")  解决跨域问题  允许所以访问
     * @return
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/selectAll")
    List<PapersModel> getPapers(){
        return papersConsumerService.getPapers();
    }

}

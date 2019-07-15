package com.gaohwangh.production.controller;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.production.services.PapersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:40
 * @Version 1.0
 */
@RestController
public class PapersController {

    @Resource
    private PapersService papersService;

    @RequestMapping("selectAll")
    public List<PapersModel> getPapers() {
        return papersService.getPapers();
    }
}

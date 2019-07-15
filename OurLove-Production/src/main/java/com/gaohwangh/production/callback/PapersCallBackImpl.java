package com.gaohwangh.production.callback;

import com.gaohwangh.api.feignCall.PapersCall;
import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.production.services.PapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:59
 * @Version 1.0
 * 如果传入的参数是一个实体  那么加上@RequestBody
 */

@RestController
public class PapersCallBackImpl implements PapersCall {

    @Autowired
    private PapersService papersService;

    @Override
    public List<PapersModel> getPapers() {
        return papersService.getPapers();
    }
}

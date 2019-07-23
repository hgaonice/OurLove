package com.gaohwangh.production.callback;

import com.gaohwangh.api.feignClient.PapersClient;
import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.production.services.PapersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:59
 * @Version 1.0
 * 如果传入的参数是一个实体  那么加上@RequestBody
 */

@RestController
public class PapersConsumerClientBackImpl implements PapersClient {

    @Resource
    private PapersService papersService;

    @Override
    public List<PapersModel> getPapers() {
        return papersService.getPapers();
    }

    @Override
    public void insert(@RequestBody PapersModel papersModel) {
        try {
            papersService.insert(papersModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PapersModel selectById(Integer id) {
        return papersService.selectById(id);
    }


}

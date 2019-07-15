package com.gaohwangh.consumer.service;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.consumer.client.PapersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 1:05
 * @Version 1.0
 */
@Service
public class PapersConsumerService {
    @Resource
    private PapersClient papersClient;

    /**
     * 查询所以数据
     * @return
     */
    public List<PapersModel> getPapers(){
        return papersClient.getPapers();
    }

}

package com.gaohwangh.consumer.service;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.consumer.client.PapersConsumerClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 1:05
 * @Version 1.0
 */
@Service
public class PapersConsumerService {
    @Resource
    private PapersConsumerClient papersClient;

    /**
     * 查询所以数据
     * @return
     */
    public List<PapersModel> getPapers(){
        return papersClient.getPapers();
    }


    public void insert(PapersModel papersModel) {
        papersClient.insert(papersModel);
    }


    public PapersModel selectById(Integer id) {
        return papersClient.selectById(id);
    }

    public void insertsRequest(HttpServletRequest request) {
        papersClient.insertsRequest(request);
    }
}

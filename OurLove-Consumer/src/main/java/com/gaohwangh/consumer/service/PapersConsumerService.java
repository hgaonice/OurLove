package com.gaohwangh.consumer.service;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.api.utils.BaseUtils;
import com.gaohwangh.consumer.client.PapersConsumerClient;
import com.gaohwangh.consumer.utils.BaseUtilsCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: GH
 * @Date: 2019/7/16 1:05
 * @Version 1.0
 */
@Service
@Slf4j
public class PapersConsumerService {
    @Resource
    private PapersConsumerClient papersClient;

    /**
     * 查询所有数据
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

    public Map<String, Object> uploadFile(MultipartFile[] files, HttpServletRequest request) {
        String localPath = BaseUtils.getLocalPath();

        BaseUtils.loggerDebug("上传的文件路径:" + localPath);

        for (MultipartFile file : files) {
            String name = file.getName();
            String originalFilename = file.getOriginalFilename();
            log.debug(name);
            log.debug(originalFilename);
//            BaseUtilsCustomer.loggerDebug(name);
//            BaseUtilsCustomer.loggerDebug(originalFilename);
        }

        return new HashMap<>(6);
    }
}

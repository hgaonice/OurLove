package com.gaohwangh.production.services;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.api.utils.BaseUtils;
import com.gaohwangh.production.dao.PapersDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:38
 * @Version 1.0
 */
@Service
public class PapersService {
    @Resource
    private PapersDao papersDao;

    public List<PapersModel> getPapers() {
        System.out.println("getPapers  sout");
        BaseUtils.loggerDebug("getPapers 查询所有的!");
        return papersDao.selectAll();
    }


    @Transactional(rollbackFor = Exception.class)
    public void insert(@RequestBody PapersModel papersModel) throws Exception {
        System.out.println("getPapers-sout");
        BaseUtils.loggerDebug("insert");
        papersDao.insertSelective(papersModel);
    }




    public PapersModel selectById(Integer id) {
        if (id != null) {
            PapersModel papersModel = new PapersModel();
            papersModel.setId(id);
            System.out.println("selectById:sout" + id);
            BaseUtils.loggerDebug("selectById:" + id);
            return papersDao.selectByPrimaryKey(papersModel);
        }
        return null;
    }

}

package com.gaohwangh.production.services;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.api.utils.BaseUtils;
import com.gaohwangh.production.dao.PapersDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        return papersDao.selectAll();
    }


    @Transactional(rollbackFor = Exception.class)
    public void insert(@RequestBody PapersModel papersModel) throws Exception {
        BaseUtils.loggerDebug("insert");
        papersDao.insertSelective(papersModel);
    }

    @Transactional
    public void insertsRequest(HttpServletRequest request) {
        PapersModel papersModel = new PapersModel();
        String paper = request.getParameter("obj");
        System.out.println("insertsRequest");
        if (!"".equals(paper)) {
            BaseUtils.serializeArray2Model(papersModel, paper);
            papersDao.insertSelective(papersModel);
        }

    }


    public PapersModel selectById(Integer id) {
        if (id != null) {
            PapersModel papersModel = new PapersModel();
            papersModel.setId(id);
            BaseUtils.loggerDebug("selectById:" + id);
            return papersDao.selectByPrimaryKey(papersModel);
        }
        return null;
    }

}

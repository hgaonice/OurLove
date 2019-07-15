package com.gaohwangh.production.services;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.production.dao.PapersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:38
 * @Version 1.0
 */
@Service
public class PapersService {
    @Autowired
    private PapersDao papersDao;

    public List<PapersModel> getPapers() {
        return papersDao.selectAll();
    }
}

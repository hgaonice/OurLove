//package com.gaohwangh.production.controller;
//
//import com.gaohwangh.api.model.PapersModel;
//import com.gaohwangh.production.services.PapersService;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * @Author: GH
// * @Date: 2019/7/16 0:40
// * @Version 1.0
// */
//@RestController
////@Deprecated
//public class PapersProductController {
//
//    @Resource
//    private PapersService papersService;
//
//    @RequestMapping("/selectAll")
//    public List<PapersModel> getPapers() {
//        return papersService.getPapers();
//    }
//
//    @RequestMapping("/insert")
//    public void insert(@RequestBody PapersModel papersModel) throws Exception {
//        papersService.insert(papersModel);
//    }
//
//    @RequestMapping("/inserts")
//    public void inserts(HttpServletRequest request) {
//        papersService.inserts(request);
//
//    }
//}

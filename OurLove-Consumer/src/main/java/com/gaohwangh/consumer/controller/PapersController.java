package com.gaohwangh.consumer.controller;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.api.utils.BaseUtils;
import com.gaohwangh.consumer.service.PapersConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:53
 * @Version 1.0
 */
@Api(value = "/papers", description = "文件相关操作")
@RestController
//@RequestMapping("/papers")
public class PapersController {

    @Resource
    private PapersConsumerService papersConsumerService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    List<PapersModel> getPapers(){
        return papersConsumerService.getPapers();
    }

    @ApiOperation(value="插入文件信息")
    @ApiImplicitParam(paramType="insert", name = "papers", value = "文件信息", required = true, dataType = "PapersModel")
    @PostMapping(value = "/insert")
    public String insert(@RequestBody PapersModel papersModel) {
        papersConsumerService.insert(papersModel);
        return "success";
    }

    @ApiOperation(value="根据主键Id查询文件信息")
    @ApiImplicitParam(paramType = "query",name="id",value = "主键Id",required = true,dataType = "Integer")
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public PapersModel selectById(@RequestParam("id") Integer id) {
       PapersModel papersModel = papersConsumerService.selectById(id);

       return papersModel;
   }

    @ApiOperation(value="insertsRequest插入数据")
    @ApiImplicitParam(paramType = "query",name="request",value = "请求信息",required = true,dataType = "HttpServletRequest")
    @RequestMapping(value = "insertsRequest", method = RequestMethod.POST)
    public String insertsRequest(HttpServletRequest request) {
        String obj = request.getParameter("obj");
        BaseUtils.loggerDebug(obj);
        papersConsumerService.insertsRequest(request);
        return "success";
    }
}

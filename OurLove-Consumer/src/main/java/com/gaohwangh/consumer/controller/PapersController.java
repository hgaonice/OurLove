package com.gaohwangh.consumer.controller;

import com.gaohwangh.api.model.PapersModel;
import com.gaohwangh.api.utils.BaseUtils;
import com.gaohwangh.consumer.annotation.ControllerLog;
import com.gaohwangh.consumer.service.PapersConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:53
 * @Version 1.0
 */
@Api(value = "/papers", description = "文件相关操作")
@RestController
@Slf4j
public class PapersController {

    @Resource
    private PapersConsumerService papersConsumerService;

    @ControllerLog(desc = "查询所有信息")
    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    List<PapersModel> getPapers(){
        log.info("controller===>selectAll");
        return papersConsumerService.getPapers();
    }

    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    List<PapersModel> getpapers(){
        log.info("controller===>selectAll");
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
    @ControllerLog(desc = "根据主键Id查询文件信息")
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
        log.info(obj);
        BaseUtils.loggerDebug(obj);
        return "success";
    }

    @ApiOperation(value = "文件上传")
    @ApiImplicitParams(
        value = {
                @ApiImplicitParam(paramType = "MultipartFile", name = "files", value = "文件", required = true, dataType = "MultipartFile"),
                @ApiImplicitParam(paramType = "HttpServletRequest", name = "request", value = "附加请求信息", required = true, dataType = "HttpServletRequest"),
        }
    )
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public Map<String, Object> uploadFile(@RequestParam(name = "files", required = true) MultipartFile[] files
            , HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>(6);

        resultMap = papersConsumerService.uploadFile(files, request);

        resultMap.put("data", "message");
        return resultMap;
    }
}

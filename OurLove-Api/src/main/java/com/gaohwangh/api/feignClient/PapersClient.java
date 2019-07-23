package com.gaohwangh.api.feignClient;

import com.gaohwangh.api.model.PapersModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:45
 * @Version 1.0
 */
@RequestMapping("/papers")
public interface PapersClient {

//    @ApiOperation(value = "查询数据")
   /* @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "size", value = "每页显示的数量", required = true, dataType = "int", paramType = "path")
    })*/
    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)//, consumes = MediaType.APPLICATION_JSON_VALUE
    List<PapersModel> getPapers();

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void insert(@RequestBody PapersModel papersModel);

    @RequestMapping(value = "/selectById")
    PapersModel selectById(@RequestParam("id") Integer id);


}

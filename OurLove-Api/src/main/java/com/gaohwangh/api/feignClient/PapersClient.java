package com.gaohwangh.api.feignClient;

import com.gaohwangh.api.model.PapersModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: GH
 * @Date: 2019/7/16 0:45
 * @Version 1.0
 */
@RequestMapping("/papers")
public interface PapersClient {
    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
//, consumes = MediaType.APPLICATION_JSON_VALUE
    List<PapersModel> getPapers();

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    void insert(@RequestBody PapersModel papersModel);

    @RequestMapping(value = "/selectById")
    PapersModel selectById(@RequestParam("id") Integer id);
}

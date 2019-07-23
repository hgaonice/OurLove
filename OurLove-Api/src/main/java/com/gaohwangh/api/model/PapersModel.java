package com.gaohwangh.api.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/7/11 14:15
 * 文件表
 */
@Table(name = "papers")
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class PapersModel implements Serializable {
    @Id
    private Integer id;

    private String objid;

    private String objtype;

    private String filename;

    private String filetype;

    private Integer filesize;

    private String fileurl;

    private String filepath;

    private String suffixname;

    private Date createdate;

    private String reserve1;

    private String reserve2;

    private String reserve3;

   }
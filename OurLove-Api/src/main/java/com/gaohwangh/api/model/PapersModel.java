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
@Data
public class PapersModel implements Serializable {
    @Id
    private Integer ids;
    private String objCode;//文件对象的Id 合同对象的Id或者UUid
    private String objType;//文件对象的类型  经营  外包
    private String filename;//文件名称
    private String filetype;//文件类型(01 图片 02 PDF)
    private Integer filesize;//文件类型(01 图片 02 PDF)
    private String fileurl;//文件路径  相对路径
    private String filepath;//所在文件夹
    private String suffixname;//后缀名 pdf jpg
    private Date createDate;//创建日期
    private String reserve1;//扩展字段1
    private String reserve2;
    private String reserve3;
   }
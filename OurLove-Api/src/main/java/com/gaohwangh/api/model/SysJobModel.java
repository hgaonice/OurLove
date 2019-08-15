package com.gaohwangh.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/8/13 10:10
 *
 * 定时任务
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Table(name = "sys_job")
public class SysJobModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String name;//任务名称
    private String groupNo;//任务分组
    private String status;//任务状态
    private String cron;//规则表达式
    private String springId;//调用类SpringID
    private String className;//调用类
    private String method;//调用类方法
    private String isConcurrent;//是否并发，默认否
    private String isEnable;//是否启用
    private Date startTime;//本次运行时间
    private Date nextFireTime;//下次运行时间
    private String isSys;//是否是系统级(1是 其它否)
    private String memo;//备注
    private String createBy;//创建人
    private Date createDate;//创建时间
    private String updateBy;//修改人
    private Date updateDate;//修改时间
}
package com.gaohwangh.api.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

//@Table(name = "SYS_ROLE")
public class SysRoleModel implements Serializable {
 
    private static final long serialVersionUID = -7742053117819951238L;

//    @Id
    private Integer id; // 角色ID
    private String name; // 角色名称
    private Date validdate; // 有效期
    private String memo; //备注
    private String createUserId; //创建人ID
    private Date createTime; //创建时间
    private String updateUserId; //最后更新人ID
    private Date updateTime; //最后更新时间
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getValiddate() {
        return validdate;
    }
    public void setValiddate(Date validdate) {
        this.validdate = validdate;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getCreateUserId() {
        return createUserId;
    }
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getUpdateUserId() {
        return updateUserId;
    }
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        return "SysRoleModel [id=" + id + ", name=" + name + ", validdate=" + validdate + ", memo=" + memo
                + ", createUserId=" + createUserId + ", createTime=" + createTime + ", updateUserId=" + updateUserId
                + ", updateTime=" + updateTime + "]";
    }
}
package com.gaohwangh.api.model;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

//@Table(name = "SYS_USER_ROLE")
public class SysUserRoleModel implements Serializable {

    private static final long serialVersionUID = -3077671105103596150L;

    private Integer userId; // 用户编号
    private Integer roleId; // 角色编号
    private Date validdate; //有效期
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Date getValiddate() {
        return validdate;
    }
    public void setValiddate(Date validdate) {
        this.validdate = validdate;
    }
    
    @Override
    public String toString() {
        return "SysUserRoleModel [userId=" + userId + ", roleId=" + roleId + ", validdate=" + validdate + "]";
    }
}
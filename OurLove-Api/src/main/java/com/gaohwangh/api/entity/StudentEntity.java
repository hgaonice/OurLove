package com.gaohwangh.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaoh
 * @since 2019-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "student")
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ids", type = IdType.AUTO)
    private Integer ids;

    private String name;

    private String age;

}

package com.ainijar.modules.sys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    private static final long serialVersionUID = 1L;
    /** 乐观锁 */
    private Integer revision ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;
    /** 编号 */
    @TableId(value = "id", type = IdType.UUID)
    private String id ;
    /** 姓名 */
    private String name ;
    /** 密码 */
    private String password ;
    /** 登录名 */
    private String loginName ;
    /** 删除标记 */
    @TableLogic
    private String delFlag ;
    /** 备注 */
    private String remarks ;
}

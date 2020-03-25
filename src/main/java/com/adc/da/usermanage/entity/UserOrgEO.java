package com.adc.da.usermanage.entity;

import org.apache.ibatis.annotations.Mapper;

import com.adc.da.base.entity.BaseEntity;


/**
 * <b>功能：</b>tr_user_org UserOrgEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-22 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class UserOrgEO extends BaseEntity {

    private Long orgId;
    private Long userId;
    private String type;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>orgId -> org_id</li>
     * <li>userId -> user_id</li>
     * <li>type -> type</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "orgId": return "org_id";
            case "userId": return "user_id";
            case "type": return "type";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>org_id -> orgId</li>
     * <li>user_id -> userId</li>
     * <li>type -> type</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "org_id": return "orgId";
            case "user_id": return "userId";
            case "type": return "type";
            default: return null;
        }
    }
    
    /**  **/
    public Long getOrgId() {
        return this.orgId;
    }

    /**  **/
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**  **/
    public Long getUserId() {
        return this.userId;
    }

    /**  **/
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**  **/
    public String getType() {
        return this.type;
    }

    /**  **/
    public void setType(String type) {
        this.type = type;
    }

}

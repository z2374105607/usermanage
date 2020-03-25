package com.adc.da.usermanage.entity;

import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

/**
 * <b>功能：</b>ts_group_org GroupOrgEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-10-22 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
public class GroupOrgEO extends BaseEntity {

    private Long id;
    private String orgName;
    private Integer level;
    private Long parentId;
    private String groupOrgId;
    private String groupOrgParentId;
    private String type;
    private String orgType;
    private String isVirtual;
    private String isParent;
    private String open;
    private String description;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    private Long createdPerson;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    private Long updatedPerson;
    private String delFlag;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>orgName -> org_name</li>
     * <li>level -> level</li>
     * <li>parentId -> parent_id</li>
     * <li>groupOrgId -> group_org_id</li>
     * <li>groupOrgParentId -> group_org_parent_id</li>
     * <li>type -> type</li>
     * <li>orgType -> org_type</li>
     * <li>isVirtual -> is_virtual</li>
     * <li>isParent -> is_parent</li>
     * <li>open -> open</li>
     * <li>description -> description</li>
     * <li>createdAt -> created_at</li>
     * <li>createdPerson -> created_person</li>
     * <li>updatedAt -> updated_at</li>
     * <li>updatedPerson -> updated_person</li>
     * <li>delFlag -> del_flag</li>
     */
    public static String fieldToColumn(String fieldName) {
        if (fieldName == null) return null;
        switch (fieldName) {
            case "id": return "id";
            case "orgName": return "org_name";
            case "level": return "level";
            case "parentId": return "parent_id";
            case "groupOrgId": return "group_org_id";
            case "groupOrgParentId": return "group_org_parent_id";
            case "type": return "type";
            case "orgType": return "org_type";
            case "isVirtual": return "is_virtual";
            case "isParent": return "is_parent";
            case "open": return "open";
            case "description": return "description";
            case "createdAt": return "created_at";
            case "createdPerson": return "created_person";
            case "updatedAt": return "updated_at";
            case "updatedPerson": return "updated_person";
            case "delFlag": return "del_flag";
            default: return null;
        }
    }

    /**
     * 原始数据库列名转换为java字段名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>org_name -> orgName</li>
     * <li>level -> level</li>
     * <li>parent_id -> parentId</li>
     * <li>group_org_id -> groupOrgId</li>
     * <li>group_org_parent_id -> groupOrgParentId</li>
     * <li>type -> type</li>
     * <li>org_type -> orgType</li>
     * <li>is_virtual -> isVirtual</li>
     * <li>is_parent -> isParent</li>
     * <li>open -> open</li>
     * <li>description -> description</li>
     * <li>created_at -> createdAt</li>
     * <li>created_person -> createdPerson</li>
     * <li>updated_at -> updatedAt</li>
     * <li>updated_person -> updatedPerson</li>
     * <li>del_flag -> delFlag</li>
     */
    public static String columnToField(String columnName) {
        if (columnName == null) return null;
        switch (columnName) {
            case "id": return "id";
            case "org_name": return "orgName";
            case "level": return "level";
            case "parent_id": return "parentId";
            case "group_org_id": return "groupOrgId";
            case "group_org_parent_id": return "groupOrgParentId";
            case "type": return "type";
            case "org_type": return "orgType";
            case "is_virtual": return "isVirtual";
            case "is_parent": return "isParent";
            case "open": return "open";
            case "description": return "description";
            case "created_at": return "createdAt";
            case "created_person": return "createdPerson";
            case "updated_at": return "updatedAt";
            case "updated_person": return "updatedPerson";
            case "del_flag": return "delFlag";
            default: return null;
        }
    }
    
    /**  **/
    public Long getId() {
        return this.id;
    }

    /**  **/
    public void setId(Long id) {
        this.id = id;
    }

    /**  **/
    public String getOrgName() {
        return this.orgName;
    }

    /**  **/
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**  **/
    public Integer getLevel() {
        return this.level;
    }

    /**  **/
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**  **/
    public Long getParentId() {
        return this.parentId;
    }

    /**  **/
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**  **/
    public String getGroupOrgId() {
        return this.groupOrgId;
    }

    /**  **/
    public void setGroupOrgId(String groupOrgId) {
        this.groupOrgId = groupOrgId;
    }

    /**  **/
    public String getGroupOrgParentId() {
        return this.groupOrgParentId;
    }

    /**  **/
    public void setGroupOrgParentId(String groupOrgParentId) {
        this.groupOrgParentId = groupOrgParentId;
    }

    /**  **/
    public String getType() {
        return this.type;
    }

    /**  **/
    public void setType(String type) {
        this.type = type;
    }

    /**  **/
    public String getOrgType() {
        return this.orgType;
    }

    /**  **/
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    /**  **/
    public String getIsVirtual() {
        return this.isVirtual;
    }

    /**  **/
    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual;
    }

    /**  **/
    public String getIsParent() {
        return this.isParent;
    }

    /**  **/
    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    /**  **/
    public String getOpen() {
        return this.open;
    }

    /**  **/
    public void setOpen(String open) {
        this.open = open;
    }

    /**  **/
    public String getDescription() {
        return this.description;
    }

    /**  **/
    public void setDescription(String description) {
        this.description = description;
    }

    /**  **/
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /**  **/
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**  **/
    public Long getCreatedPerson() {
        return this.createdPerson;
    }

    /**  **/
    public void setCreatedPerson(Long createdPerson) {
        this.createdPerson = createdPerson;
    }

    /**  **/
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    /**  **/
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**  **/
    public Long getUpdatedPerson() {
        return this.updatedPerson;
    }

    /**  **/
    public void setUpdatedPerson(Long updatedPerson) {
        this.updatedPerson = updatedPerson;
    }

    /**  **/
    public String getDelFlag() {
        return this.delFlag;
    }

    /**  **/
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}

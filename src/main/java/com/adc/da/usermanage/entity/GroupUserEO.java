package com.adc.da.usermanage.entity;



import com.adc.da.base.entity.BaseEntity;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

/**
 * <b>功能：</b>ts_group_user GroupUserEOEntity<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-08-14 <br>
 */
public class GroupUserEO extends BaseEntity {

    private Long id;
    private String userName;
    private String password;
    private String mobilephone;
    private String email;
    private String type;
    private String status;
    private String photo;
    private String realName;
    private String sex;
    private String description;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    private Long createdPerson;
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    private Long updatedPerson;
    private String delFlag;
    public static String STATE_NORMAL= "0";
    public static String STATE_LOCK= "1";
    public static String STATE_ACCOUNTEXPIRED= "2";
    public static String STATE_TOKENEXPIRED= "3";

    // 组织结构名称
    private String orgName;

    /**
     * java字段名转换为原始数据库列名。<b>如果不存在则返回null</b><br>
     * <p>字段列表：</p>
     * <li>id -> id</li>
     * <li>userName -> user_name</li>
     * <li>password -> password</li>
     * <li>mobilephone -> mobilephone</li>
     * <li>email -> email</li>
     * <li>type -> type</li>
     * <li>status -> status</li>
     * <li>photo -> photo</li>
     * <li>realName -> real_name</li>
     * <li>sex -> sex</li>
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
            case "userName": return "user_name";
            case "password": return "password";
            case "mobilephone": return "mobilephone";
            case "email": return "email";
            case "type": return "type";
            case "status": return "status";
            case "photo": return "photo";
            case "realName": return "real_name";
            case "sex": return "sex";
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
     * <li>user_name -> userName</li>
     * <li>password -> password</li>
     * <li>mobilephone -> mobilephone</li>
     * <li>email -> email</li>
     * <li>type -> type</li>
     * <li>status -> status</li>
     * <li>photo -> photo</li>
     * <li>real_name -> realName</li>
     * <li>sex -> sex</li>
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
            case "user_name": return "userName";
            case "password": return "password";
            case "mobilephone": return "mobilephone";
            case "email": return "email";
            case "type": return "type";
            case "status": return "status";
            case "photo": return "photo";
            case "real_name": return "realName";
            case "sex": return "sex";
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
    public String getUserName() {
        return this.userName;
    }

    /**  **/
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**  **/
    public String getPassword() {
        return this.password;
    }

    /**  **/
    public void setPassword(String password) {
        this.password = password;
    }

    /**  **/
    public String getMobilephone() {
        return this.mobilephone;
    }

    /**  **/
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    /**  **/
    public String getEmail() {
        return this.email;
    }

    /**  **/
    public void setEmail(String email) {
        this.email = email;
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
    public String getStatus() {
        return this.status;
    }

    /**  **/
    public void setStatus(String status) {
        this.status = status;
    }

    /**  **/
    public String getPhoto() {
        return this.photo;
    }

    /**  **/
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**  **/
    public String getRealName() {
        return this.realName;
    }

    /**  **/
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**  **/
    public String getSex() {
        return this.sex;
    }

    /**  **/
    public void setSex(String sex) {
        this.sex = sex;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}

package com.adc.da.usermanage.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.usermanage.entity.UserOrgEO;

import java.util.List;
/**
 *
 * <br>
 * <b>功能：</b>tr_user_org UserOrgEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-20 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
//@Mapper
public interface UserOrgEODao extends BaseDao<UserOrgEO> {
    /**
     * 删除用户组织机构
     * @param record
     * @return
     */
    public int deleteByUserId(Long record);

    /**
     * 取得当前用户的组织机构
     * @param record
     * @return
     */
    public List<Long> selectByUserId(Long record);

    /**
     * 根据区分删除用户组织机构
     * @param record
     * @return
     */
    public int deleteByType(String record);

    /**
     * 删除备份的用户组织关系信息
     * @return
     */
    public int deleteUserOrgBakInfo();

    /**
     * 备份用户组织关系信息
     * @return
     */
    public int backupUserOrgInfo();
}

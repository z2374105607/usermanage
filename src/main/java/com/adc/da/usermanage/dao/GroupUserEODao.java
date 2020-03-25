package com.adc.da.usermanage.dao;



import com.adc.da.base.dao.BaseDao;
import com.adc.da.usermanage.entity.GroupUserEO;


/**
 *
 * <br>
 * <b>功能：</b>ts_group_user GroupUserEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-08-14 <br>
 */
//@Mapper
public interface GroupUserEODao  extends BaseDao<GroupUserEO>{
	//public int insertSelective(GroupUserEO groupUserEO);
    /**
     * 根据帐号取得集团人员信息
     * @param record
     * @return
     */
    public GroupUserEO getUserInfoByName(String record);

    /**
     * 获取人员信息
     * @param record
     * @return
     */
    public GroupUserEO getUserInfoById(Long record);

    /**
     * 删除集团用户信息
     * @return
     */
    public int deleteGroupUserInfo();

    /**
     * 删除集团用户的备份信息
     * @return
     */
    public int deleteGroupUserBakInfo();

    /**
     * 备份集团用户信息
     * @return
     */
    public int backupGroupUserInfo();

    /**
     * 取得用户数量
     * @return
     */
    public int getUserCount(GroupUserEO record);
}

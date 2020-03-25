package com.adc.da.usermanage.dao;

import com.adc.da.base.dao.BaseDao;
import com.adc.da.usermanage.entity.GroupOrgEO;

/**
 *
 * <br>
 * <b>功能：</b>ts_group_org GroupOrgEODao<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2018-09-20 <br>
 * <b>版权所有：<b>版权归北京卡达克数据技术中心所有。<br>
 */
// @Mapper
public interface GroupOrgEODao extends BaseDao<GroupOrgEO> {
	public GroupOrgEO selectBygrouporgid(String grouporgid);
	public GroupOrgEO selectBygrouporgpid(String grouporgpid);

	/**
	 * 删除集团组织机构信息
	 * 
	 * @return
	 */
	public int deleteGroupOrgInfo();

	/**
	 * 删除备份集团组织机构信息
	 * 
	 * @return
	 */
	public int deleteGroupOrgBakInfo();

	/**
	 * 备份集团组织机构信息
	 * 
	 * @return
	 */
	public int backupGroupOrgInfo();
}

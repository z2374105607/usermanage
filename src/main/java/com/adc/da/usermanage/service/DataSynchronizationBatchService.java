package com.adc.da.usermanage.service;

import com.adc.da.usermanage.dao.GroupOrgEODao;
import com.adc.da.usermanage.dao.GroupUserEODao;
import com.adc.da.usermanage.dao.UserOrgEODao;
import com.adc.da.usermanage.entity.GroupOrgEO;
import com.adc.da.usermanage.entity.GroupUserEO;
import com.adc.da.usermanage.entity.UserOrgEO;
import com.adc.da.usermanage.util.DataUtil;
import com.adc.da.util.utils.RandomUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by admin on 2018/10/22.
 */
@Service("dataSynchronizationBatchService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class DataSynchronizationBatchService {

	@Autowired
	private GroupOrgEODao groupOrgEODao;

	@Autowired
	private GroupUserEODao groupUserEODao;

	@Autowired
	private UserOrgEODao userOrgEODao;

	@Value("${group.openapi.url.GetUserListByTree}")
	private String groupRootUrlVal;

	public void backupGroupInfo() {
		// 删除备份的集团组织信息
		groupOrgEODao.deleteGroupOrgBakInfo();
		// 备份集团组织信息
		groupOrgEODao.backupGroupOrgInfo();

		// 删除备份的集团用户信息
		groupUserEODao.deleteGroupUserBakInfo();
		// 备份集团用户信息
		groupUserEODao.backupGroupUserInfo();

		// 删除备份的集团用户组织关系
		userOrgEODao.deleteUserOrgBakInfo();
		// 备份集团用户组织关系
		userOrgEODao.backupUserOrgInfo();

	}

	/**
	 * 从集团获取相关信息
	 * 
	 * @return
	 */
	public void dataSynchronization() {
		// 获取集团全量信息
		List<LinkedHashMap<String, Object>> groupRootList = DataUtil.getData(groupRootUrlVal);
		GroupOrgEO[] grouplist = new GroupOrgEO[groupRootList.size()];
		List<GroupOrgEO> groupList = new LinkedList<GroupOrgEO>();
		for (LinkedHashMap<String, Object> linkedHashMap : groupRootList) {
			if ("003200000000000000000000000000".equals(String.valueOf(linkedHashMap.get("id")))) {
				GroupOrgEO groupOrgEO = new GroupOrgEO();
				groupOrgEO = setGroupOrgEO(linkedHashMap, groupOrgEO, Long.valueOf("0"));
				grouplist[0] = groupOrgEO;
				groupRootList.remove(linkedHashMap);
				break;
			}

			/*
			 * if ("" == linkedHashMap.get("userid")) { // 初始化entity GroupOrgEO
			 * groupOrgEO = new GroupOrgEO(); setGroupOrgEO(linkedHashMap,
			 * groupOrgEO, Long.valueOf("0")); //
			 * addGroupUser(String.valueOf(subNode.get("useraccount")), //
			 * parentId); } else { addGroupUser(linkedHashMap); }
			 */
		}
		Iterator<GroupOrgEO> iterator = groupList.iterator();
		int j = 1;
		int num = groupRootList.size();
		for (int i = 0; i < num; i++) {
			if (null == grouplist[i])
				break;
			GroupOrgEO temp = grouplist[i];
			String groupId = temp.getGroupOrgId();
			for (LinkedHashMap<String, Object> linkedHashMap : groupRootList) {
				if (groupId.equals(linkedHashMap.get("pid"))) {
					if ("" == linkedHashMap.get("userid")) {
						GroupOrgEO groupOrgEO = new GroupOrgEO();
						groupOrgEO = setGroupOrgEO(linkedHashMap, groupOrgEO, temp.getId());
						grouplist[j] = groupOrgEO;
						j += 1;
					} else {
						addGroupUser(linkedHashMap, temp.getId());
					}
				}

			}
		}

	}

	/**
	 * 保存组织机构信息
	 * 
	 * @param map
	 * @param groupOrgEO
	 * @param parentId
	 * @return
	 */
	private GroupOrgEO setGroupOrgEO(Map<String, Object> map, GroupOrgEO groupOrgEO, Long parentId) {
		// 定义随机类
		Random random = new Random();
		int pre = random.nextInt(9) + 1;
		// 非集团用户ID生成
		String orgIdEnd = RandomUtils.randomNumberString(14);
		String orgId = pre + orgIdEnd;
		// 组织机构ID
		if ("003200000000000000000000000000".equals(String.valueOf(map.get("id")))) {
			groupOrgEO.setId(Long.valueOf("1"));
		} else {
			groupOrgEO.setId(Long.valueOf(orgId));
		}
		// 组织名称
		groupOrgEO.setOrgName(String.valueOf(map.get("name")));
		// 层级
		groupOrgEO.setLevel(Integer.valueOf(String.valueOf(map.get("nodetype"))));
		// 父节点
		/*
		 * GroupOrgEO temp = groupOrgEODao.selectByPrimaryKey(map.get("pid"));
		 * if (null == temp) { groupOrgEO.setParentId((long) 1); } else
		 */
		// 集团节点ID
		groupOrgEO.setGroupOrgId(String.valueOf(map.get("id")));
		// 集团父节点ID
		groupOrgEO.setGroupOrgParentId(String.valueOf(map.get("pid")));
		GroupOrgEO groupOrgEOpdb = groupOrgEODao.selectBygrouporgid(groupOrgEO.getGroupOrgParentId());
		// 保存集团组织机构
		if (null == groupOrgEOpdb)
			groupOrgEO.setParentId(parentId);
		else
			groupOrgEO.setParentId(groupOrgEOpdb.getId());
		// 组织类型
		groupOrgEO.setType("0");
		// 机构类型
		if (map.get("companytype") == null) {
			groupOrgEO.setOrgType("集团总部");
		} else {
			groupOrgEO.setOrgType(String.valueOf(map.get("companytype")));
		}
		// 虚拟组织
		groupOrgEO.setIsVirtual("0");
		// 是否为父节点
		groupOrgEO.setIsParent("0");
		// 节点开启状态
		groupOrgEO.setOpen("0");
		Date date = new Date();
		// 创建时间
		groupOrgEO.setCreatedAt(date);
		// 创建人
		groupOrgEO.setCreatedPerson(Long.valueOf("10000000000001"));
		// 修改时间
		groupOrgEO.setUpdatedAt(date);
		// 修改人
		groupOrgEO.setUpdatedPerson(Long.valueOf("10000000000001"));
		// 删除标志位
		groupOrgEO.setDelFlag("0");
		GroupOrgEO groupOrgEOdb = groupOrgEODao.selectBygrouporgid(groupOrgEO.getGroupOrgId());
		// 保存集团组织机构
		if (null == groupOrgEOdb)
			groupOrgEODao.insertSelective(groupOrgEO);
		// 返回集团组织机构信息
		return groupOrgEO;
	}

	/**
	 * 添加集团用户信息
	 * 
	 * @param groupUserInfo
	 * @param orgId
	 */
	public void addGroupUser(LinkedHashMap<String, Object> groupUserInfo, Long orgId) {

		// 集团用户表
		GroupUserEO groupUserEO = new GroupUserEO();
		// 定义随机类
		Random random = new Random();
		int pre = random.nextInt(9) + 1;
		// 非集团用户ID生成
		String groupUserIdEnd = RandomUtils.randomNumberString(14);
		String groupUserId = pre + groupUserIdEnd;
		// ID
		groupUserEO.setId(Long.valueOf(groupUserId));
		// 用户名
		groupUserEO.setUserName(String.valueOf(groupUserInfo.get("useraccount")));
		// 密码
		groupUserEO.setPassword("password");
		// 手机号
		groupUserEO.setMobilephone(String.valueOf("123456789"));
		// 邮箱
		if (null != groupUserInfo.get("email")) {
			groupUserEO.setEmail(String.valueOf(groupUserInfo.get("email")));
		}
		// 用户类型
		groupUserEO.setType("0");
		// 用户状
		groupUserEO.setStatus("0");
		// 真实姓名
		groupUserEO.setRealName(String.valueOf(groupUserInfo.get("name")));
		// 性别
		if (null != groupUserInfo.get("sex")) {
			groupUserEO.setSex(String.valueOf(groupUserInfo.get("sex")));
		}
		Date date = new Date();
		// 创建时间
		groupUserEO.setCreatedAt(date);
		// 创建人
		groupUserEO.setCreatedPerson(Long.valueOf("10000000000001"));
		// 修改时间
		groupUserEO.setUpdatedAt(date);
		// 修改人
		groupUserEO.setUpdatedPerson(Long.valueOf("10000000000001"));
		// 删除标志位
		groupUserEO.setDelFlag("0");
		int count = groupUserEODao.getUserCount(groupUserEO);
		if (count == 0) {
			// 保存集团用户信息
			groupUserEODao.insertSelective(groupUserEO);
			// 用户组织结构关系表 \
			UserOrgEO userOrgEO = new UserOrgEO(); // 组织ID
			GroupOrgEO groupOrgEOpdb = groupOrgEODao.selectBygrouporgid(String.valueOf(groupUserInfo.get("pid")));
			if (null == groupOrgEOpdb)
				userOrgEO.setOrgId(orgId); // 用户ID
			else
				userOrgEO.setOrgId(groupOrgEOpdb.getId()); // 用户ID
			userOrgEO.setUserId(Long.valueOf(groupUserId)); // 区分 0:集团 1:自定义
			userOrgEO.setType("0"); // 保存用户组织结构关系
			userOrgEODao.insertSelective(userOrgEO);
		}
	}
}

package com.smartlab.oa.service;

import java.util.List;

import com.smartlab.oa.base.DaoSupport;
import com.smartlab.oa.domain.Privilege;

public interface PrivilegeService  extends DaoSupport<Privilege>{

	
	//查询所有顶级信息
	List<Privilege> findTopList();

}

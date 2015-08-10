package com.smartlab.oa.service;

import java.util.List;

import com.smartlab.oa.base.DaoSupport;
import com.smartlab.oa.domain.Department;

public interface DepartmentService  extends DaoSupport<Department>{

//	List<Department> findAll();
//
//	void delete(Long id);
//
//
//	void save(Department model);
//
//	Department getById(Long id);
//
//	void update(Department department);

	List<Department> findTopList();

	List<Department> findChildren(Long parentId);

}

package com.smartlab.oa.base;

import java.util.List;

//公共的dao
public interface DaoSupport<T> {

	// 保存实体
	void save(T entity);

	// 按id删除
	void delete(Long id);

	// 更新实体
	void update(T entity);

	// 按id查询
	T getById(Long id);

	// 多个id查询(ids)
	List<T> getByIds(Long[] ids);

	// 查询所有
	List<T> findAll();

}

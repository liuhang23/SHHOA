package com.smartlab.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//通用数据服务层实现类
@SuppressWarnings("unchecked")
public class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;
	// 通过泛型获取对象的对象
	private Class<T> clazz;   //指定泛型

	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型  com.smartlab.oa.base.BaseDaoImpl<com.smartlab.oa.domain.User>
		ParameterizedType pt = (ParameterizedType) this.getClass()// this表示当前new的实例
				.getGenericSuperclass(); // 获取当前new的对象的泛型的父类 类型
		// 获取第一个参数类型的真实参数
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		//System.out.println("clazz-->" +clazz);   //com.smartlab.oa.domain.User
	}

	// 获取当前可用的Session,设置为protected给子类提供sessionFactory
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		// Spring做了事务管理
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if(id == null){
			return null;
		}else{
			return (T) getSession().get(clazz, id);
		}
	}

	@Override
	// 通过多个id查询多个用户实体
	public List<T> getByIds(Long[] ids) {
		return getSession().createQuery(// HQL语句查询
				"FROM USER WHERE id IN(:ids)")//
				.setParameter("ids", ids)//
				.list();
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

}

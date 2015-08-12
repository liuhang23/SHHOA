package com.smartlab.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smartlab.oa.service.DepartmentService;
import com.smartlab.oa.service.PrivilegeService;
import com.smartlab.oa.service.RoleService;
import com.smartlab.oa.service.UserService;

public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T> {

	// ===================1.ModelDriven支持============================
	// 使用model，可以减少再次封装参数
	protected T model = null;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public T getModel() {

		return model;
	}

	// ===================2.Service实例的声明============================
	// 获取到RoleService提供的方法
	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;

}

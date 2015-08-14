package com.smartlab.oa.domain;

import java.util.HashSet;
import java.util.Set;

//用户管理
public class User {
	private Long id;
	private Department department; // 所属部门
	private Set<Role> roles = new HashSet<Role>(); // 无序，对应岗位

	private String loginName; // 登陆名
	private String name;// 真实姓名
	private String password;// 密码
	private String gender;// 性别
	private String phoneNumber; // 电话号码
	private String email; // 邮箱
	private String description; // 说明

	/** 判断本用户是否有指定名称的权限 */
	public boolean hasPrivilegeByName(String name) {
		// 超级管理员有所有的权限
		if (isAdmin()) {
			return true;
		}
		// 普通用户判断是否含有这个权限
		for (Role role : roles) {
			for (Privilege privilege : role.getPrivileges()) {
				if (privilege.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/** 判断本用户是否有指定URL的权限  a.equals(b)   a(可能为空的值)  b(一定不为空)  避免空指针异常*/
	public boolean hasPrivilegeByUrl(String privUrl) {
		// 超级管理员有所有的权限
		if (isAdmin()) {
			return true;
		}
		// 普通用户判断是否含有这个权限
		for (Role role : roles) {
			for (Privilege privilege : role.getPrivileges()) {
				if (privUrl.equals(privilege.getUrl())) {
					return true;
				}
			}
		}
		return false;
	}

	/** 判断本用户是否是超级管理员 */
	public boolean isAdmin() {
		return "admin".equals(loginName);
	}
	
	
	
	

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

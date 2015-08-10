package com.smartlab.oa.domain;

import java.util.HashSet;
import java.util.Set;

//部门管理
public class Department {
	private Long id;
	private String name; // 部门名称
	private String description; // 部门描述
	private Set<User> users = new HashSet<User>(); // 存放多个员工
	private Department parent; // 上级部门
	private Set<Department> children = new HashSet<Department>(); // 会对应多个下级部门

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

}

package com.smartlab.oa.domain;

import java.util.HashSet;
import java.util.Set;

//岗位管理
public class Role {
	private Long id;
	private String name; // 岗位名称
	private String description; // 描述
	private Set<User> users = new HashSet<User>();// 对应员工

	private Set<Privilege> privileges = new HashSet<Privilege>();// 设置对应权限

	// gettet/setter
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

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}

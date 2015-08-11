package com.smartlab.oa.domain;

import java.util.HashSet;
import java.util.Set;

//权限实体
public class Privilege {
	private Long id;
	private String name; // 权限名称
	private String url;
	private Set<Role> roles = new HashSet<Role>(); //对应的岗位列表
	private Privilege parent; // 上级权限
	private Set<Privilege> children = new HashSet<Privilege>();// 下级权限

	public Privilege() {

	}

	public Privilege(String name, String url, Privilege parent) {
		this.name = name;
		this.url = url;
		this.parent = parent;
	}

	//
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}

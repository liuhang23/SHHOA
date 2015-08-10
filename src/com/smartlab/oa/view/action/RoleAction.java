package com.smartlab.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smartlab.oa.base.BaseAction;
import com.smartlab.oa.domain.Role;
import com.smartlab.oa.service.RoleService;

//岗位管理请求
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	// 1.列表
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		// 可以将得到的list放入request或值栈中用于页面进行显示 // OGNL将值放入值栈中,在页面进行迭代显示
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}

	// 2.删除
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}

	// 3.添加页面
	public String addUI() throws Exception {
		return "saveUI";
	}

	// 4.添加
	public String add() throws Exception {
		// 封装到对象
//		Role role = new Role();
//		role.setName(model.getName());
//		role.setDescription(model.getDescription());
//		roleService.save(role);
		roleService.save(model);
		return "toList";
	}

	// 5.修改页面
	public String editUI() throws Exception {
		//准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role); //从对象栈中取值
		//this.name = role.getName();
		//this.description = role.getDescription();
		return "saveUI";
	}

	// 6.修改
	public String edit() throws Exception {
		//1.从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		//2.设置要修改的属性
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		//3.更新到数据库
		roleService.update(role);
		return "toList";
	}

}

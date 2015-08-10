package com.smartlab.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.smartlab.oa.base.BaseAction;
import com.smartlab.oa.domain.Department;
import com.smartlab.oa.domain.Role;
import com.smartlab.oa.domain.User;
import com.smartlab.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	// 列表
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	// 删除
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	// 添加页面
	public String addUI() throws Exception {
		// 准备数据,departementList
		List<Department> toList =  departmentService.findTopList();
		List<Department> departmentList =DepartmentUtils.getAllDepartments(toList);
		ActionContext.getContext().put("departmentList", departmentList);
		
		//准备数据,roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}

	// 添加
	public String add() throws Exception {
		//封装到对象中(当model时实体类型时，也可以使用model,但要设置未封装的属性)
		//>>设置所属部门
		
		//>>设置关联的岗位
		
		//>>设置默认密码1234
		
		//保存到数据库中
		userService.save(model);
		return "toList";
	}

	// 编辑页面
	public String editUI() throws Exception {
		return "saveUI";
	}

	// 编辑
	public String edit() throws Exception {
		return "toList";
	}

	// 初始化密码为1234
	public String initPassword() throws Exception {
		return "toList";
	}

}

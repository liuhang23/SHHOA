package com.smartlab.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.smartlab.oa.base.BaseAction;
import com.smartlab.oa.domain.Department;
import com.smartlab.oa.domain.Role;
import com.smartlab.oa.service.DepartmentService;
import com.smartlab.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{

	private static final long serialVersionUID = 1L;
	// 获取服务器传回到parentId
	private Long parentId;

	/** 列表 */
	public String list() throws Exception {
		//List<Department> departmentList = departmentService.findAll();
		List<Department> departmentList = null;
		if(parentId == null){ //初始化显示顶级部门
 			departmentList = departmentService.findTopList();
		}else{ //点击顶级部门显示所属子部门
			departmentList = departmentService.findChildren(parentId);
			//返回上一级(需要的父类)
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList); // 存放在ValueStack的map中
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		// 准备数据，departmentList
		List<Department> toList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(toList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		//封装信息到对象中
		Department parent = departmentService.getById(parentId);
        model.setParent(parent);
        //执行保存方法
		departmentService.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备数据 departmentList
		List<Department> toList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(toList);
		ActionContext.getContext().put("departmentList", departmentList);
		//准备回显数据
		Department department = departmentService.getById(model.getId()); 
		ActionContext.getContext().getValueStack().push(department); // 存放在ValueStack中对象栈顶
		if(department.getParent() != null){
			parentId = department.getParent().getId();
		}
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1.从数据库中取出原对象
		Department department = departmentService.getById(model.getId());
		// 2.设置要修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentService.getById(parentId));//设置所属的上级部门
		// 3.更新到数据库
		departmentService.update(department);
		return "toList";
	}

	//
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}

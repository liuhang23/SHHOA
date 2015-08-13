package com.smartlab.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.smartlab.oa.base.BaseAction;
import com.smartlab.oa.domain.Department;
import com.smartlab.oa.domain.Role;
import com.smartlab.oa.domain.User;
import com.smartlab.oa.service.UserService;
import com.smartlab.oa.util.DepartmentUtils;
import com.smartlab.oa.util.StringUtil;


@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	// 获取页面上传的部门id
	private Long departmentId;
	// 岗位id数组
	private Long[] roleIds;

	// 1.列表
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	// 2.删除
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	// 3.添加页面
	public String addUI() throws Exception {
		// 准备数据,departementList
		List<Department> toList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(toList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据,roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}

	// 4.添加
	public String add() throws Exception {
		// 封装到对象中(当model时实体类型时，也可以使用model,但要设置未封装的属性)
		// >>设置所属部门（获取页面选择的部门id,查询出实体信息）
		model.setDepartment(departmentService.getById(departmentId));
		// >>设置关联的岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList)); // hashSet集合接受另一集合参数
		// >>设置默认密码1234
		String md5Digest = DigestUtils.md5Hex("1234");
		model.setPassword(md5Digest);
		// 保存到数据库中
		userService.save(model);
		return "toList";
	}

	// 5.修改页面
	public String editUI() throws Exception {
		// 准备数据,departementList
		List<Department> toList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(toList);
		ActionContext.getContext().put("departmentList", departmentList);

		// 准备数据,roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		// 准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user); //将user对象放入ValueStack的对象栈中，方便数据显示
		if(user.getDepartment() != null){
			departmentId  =  user.getDepartment().getId();
		}
		if(user.getRoles() != null){
			roleIds = new Long[user.getRoles().size()]; //给数组指定长度
			int index = 0;
			for(Role role : user.getRoles()){
			   roleIds[index++] = role.getId(); //将从页面传回id遍历存放于数组
			}
		}
		return "saveUI";
	}

	// 6.修改
	public String edit() throws Exception {
		//1.从数据库去除原对象
		User user = userService.getById(model.getId());
		//2.设置要修改的属性
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		//>>设置部门属性
		user.setDepartment(departmentService.getById(departmentId));
		//>>设置关联岗位
		List<Role> roleList = roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		//3.更新到数据库
		userService.update(user);
		return "toList";
	}

	// 7.初始化密码为1234
	public String initPassword() throws Exception {
		//1.从数据库中去除原对象
		User user = userService.getById(model.getId());
		//2.设置默认密码为1234（要使用MD5摘要）
		String md5Digest = DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);
		//3.更新到数据库
		userService.update(user);
		return "toList";
	}

	/**登陆页面*/
	public String loginUI() throws Exception{
		return "loginUI";
	}
	
	/**登陆  : 重定向到首页*/
	public String login() throws Exception{
		User user = userService.findByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		if(user == null){
			addFieldError("login", "登录名或密码错误");
			return "loginUI";
		}else{ 
			//用户登陆
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}
	}
	
	/**注销*/
	public String logout() throws Exception{
		//将user对象从值栈中移除
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
	
	
	
	// -------
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

}

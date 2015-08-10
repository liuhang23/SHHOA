package com.smartlab.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.smartlab.oa.domain.Department;

public class DepartmentUtils {

	/**
	 * 
	 * 遍历部门树，把所有的部门遍历出来放到同一个集合中返回，并且其中所有的部门的名称都修改了，以表示层次<BR>
	 * 方法名：getAllDepartments<BR>
	 * 创建人：航大 <BR>
	 * 时间：2015年8月9日-上午10:42:13 <BR>
	 * 
	 * @param toList
	 * @return List<Department><BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static List<Department> getAllDepartments(List<Department> toList) {
		List<Department> list= new ArrayList<Department>();
		walkDepartmentTreeList(toList,"┣",list);
		return list;
	}

	
	//遍历部门树
	private static void walkDepartmentTreeList(Collection<Department> toList,String prefix,List<Department> list) {
		for(Department top : toList){
			//顶点
			Department copy = new Department(); //使用副本，因为源对象在Session中
			copy.setId(top.getId()); 
			copy.setName( prefix + top.getName());
			list.add(copy); //把副本添加到同一个集合中
			//子树
			walkDepartmentTreeList(top.getChildren(),"　" +prefix,list); //使用全角的空格
		}
		
	}
	
	

}

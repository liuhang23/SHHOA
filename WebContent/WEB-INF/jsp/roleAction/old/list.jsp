<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri ="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>岗位管理---列表</title>
</head>
<body>
		
		<s:iterator value="#roleList">
	     	<!--ognl表达式  -->
			<s:property value="id"  />
			<s:property value="name"  />
			<s:property value="description"  />
			<s:a action = "role_delete?id=%{id}"   onclick ="return confirm('确定删除吗?')">删除</s:a>
			<s:a action="role_editUI?id=%{id}">修改</s:a></br>
		</s:iterator>
		
		<br/>
		<s:a action="role_addUI">跳转到添加页面</s:a>
		
		
</body>
</html>
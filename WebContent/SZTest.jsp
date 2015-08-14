<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>树状图测试</title>
<!--1.导入js与css文件 -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/file.css" />
<script type="text/javascript"  src="${pageContext.request.contextPath}/script/jquery.js"></script>
<!--导入树状结构js  -->
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>

</head>
<body>
    <!--2.使用ul展示数据  -->
	<ul id="tree">
		<li>系统管理（1）
			<ul>
				<li>部门管理（2）</li>
				<li>岗位管理（2）
					<ul>
						<li>岗位删除（3）</li>
						<li>岗位添加（3）</li>
					</ul>
				</li>
				<li><input type="checkbox">用户管理（2）</li>
			</ul>
		</li>
		<li>审批流转（1）</li>
	</ul>
<!--3.显示树状结构  -->
<script type="text/javascript">
   $("#tree").treeview();
</script>
</body>
</html>

<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>导航菜单</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
<script type="text/javascript">
	function menuClick( menu){
		$(menu).next().toggle();  /*next() 找到当前(div)紧跟的同胞元素ul(二级菜单) */		
	}
</script>
</head>

<body style="margin: 0">
	<div id="Menu">

		<ul id="MenuUl">
			<!-- 显示一级菜单  程序启动就加载缓存 -->
		 <s:iterator value="#application.topPrivilegeList">
		  <s:if test="#session.user.hasPrivilegeByName(name)">
			<li class="level1">
				<div onClick="menuClick(this)" class="level1Style">
					<img src="style/images/MenuIcon/${id}.gif" class="Icon" />
					${name}
				</div>
				
				<ul  class="MenuLevel2"  >
					<!--显示二级菜单 -->
					<s:iterator value="children">
					  <s:if test="#session.user.hasPrivilegeByName(name)">
						<li class="level2">
							<div class="level2Style">
								<img src="style/images/MenuIcon/menu_arrow_single.gif" /> 
								<a target="right" href="${pageContext.request.contextPath}${url}.action"> ${name}</a>
							</div>
						</li>
					  </s:if>
					</s:iterator>
				</ul>
			</li>
		   </s:if>
		  </s:iterator>
		</ul>
	
	</div>

</body>
</html>
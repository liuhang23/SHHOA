package com.smartlab.oa.util;

import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.smartlab.oa.domain.Privilege;
import com.smartlab.oa.service.PrivilegeService;

//容器启动就加载执行   （会产生懒加载异常）
public class InitListener implements ServletContextListener {

	// 初始化数据
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//获取容器与相关的Service对象   从容器对象中取数据，使用Spring创建的容器对象
		//WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()) 可以获取Spring创建的容器对象
		//保证使用容器中同一个对象，按照指定key去获取 （与Struts2使用同一个）
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		PrivilegeService privilegeService = (PrivilegeService)ac.getBean("privilegeServiceImpl");

		// 准备数据 topPrivilegeList
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		sce.getServletContext().setAttribute("topPrivilegeList",topPrivilegeList);
		//产生懒加载异常，主要是未加载相关联的对象信息，session已经关闭。  可以关闭懒加载特性
		System.out.println("-------->已准备数据<-------------");
	}

	// 销毁
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}

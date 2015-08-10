package com.smartlab.oa.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartlab.oa.domain.User;

@Service("testService")
public class TestService {  //改了字段，类名（类的结构） 需要重新发布    只改变方法内容不需要重新发布

	//注入bean
	@Resource
	private SessionFactory SessionFactory;

	@Transactional
	public void saveTwoUsers() {
		Session session = SessionFactory.getCurrentSession(); // 获得已经管理的好session

		session.save(new User());
		//int a = 1 / 0; // 这行会抛出异常
		session.save(new User());
	}

}

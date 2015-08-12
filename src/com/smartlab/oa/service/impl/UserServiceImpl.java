package com.smartlab.oa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.components.Password;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartlab.oa.base.DaoSupportImpl;
import com.smartlab.oa.domain.User;
import com.smartlab.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

	//用户登陆
	@Override
	public User findByLoginNameAndPassword(String loginName, String password) {
		//使用密码的MD5摘要进行对象
		String md5Digest = DigestUtils.md5Hex(password) ;
		return (User)getSession().createQuery(//
				"FROM User u WHERE u.loginName = ? AND u.password = ? ")//
				.setParameter(0, loginName)//
				.setParameter(1,md5Digest)//
				.uniqueResult();
	}

}

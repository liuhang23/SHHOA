package com.smartlab.oa.service;

import com.smartlab.oa.base.DaoSupport;
import com.smartlab.oa.domain.User;

public interface UserService extends DaoSupport<User>{

	/**
	 * 根据登录名和密码查询用户
	 * 方法名：findByLoginNameAndPassword<BR>
	 * 创建人：航大 <BR>
	 * 时间：2015年8月12日-上午9:54:27 <BR>
	 * @param loginName
	 * @param passwrod
	 * @return User<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	User findByLoginNameAndPassword(String loginName, String password);

}

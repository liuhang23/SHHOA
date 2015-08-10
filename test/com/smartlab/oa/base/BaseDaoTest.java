package com.smartlab.oa.base;

import org.junit.Test;

import com.smartlab.oa.dao.RoleDao;
import com.smartlab.oa.dao.UserDao;
import com.smartlab.oa.dao.impl.RoleDaoImpl;
import com.smartlab.oa.dao.impl.UserDaoImpl;

public class BaseDaoTest {

	@Test
	public void testSave() {
		UserDao userDao = new UserDaoImpl();
		RoleDao roleDao = new RoleDaoImpl();

	}

}

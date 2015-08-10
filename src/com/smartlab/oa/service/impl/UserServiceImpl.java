package com.smartlab.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartlab.oa.base.DaoSupportImpl;
import com.smartlab.oa.domain.User;
import com.smartlab.oa.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

}

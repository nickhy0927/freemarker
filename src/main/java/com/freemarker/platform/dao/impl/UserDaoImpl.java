package com.freemarker.platform.dao.impl;


import org.springframework.stereotype.Service;

import com.freemarker.mongo.orm.dao.impl.AbstractRepository;
import com.freemarker.platform.dao.UserDao;
import com.freemarker.platform.entity.User;

@Service
public class UserDaoImpl extends AbstractRepository<User> implements UserDao{
	
}

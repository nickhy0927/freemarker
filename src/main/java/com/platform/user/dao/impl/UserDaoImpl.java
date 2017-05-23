package com.platform.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.freemarker.mongo.orm.dao.impl.AbstractRepository;
import com.platform.user.dao.UserDao;
import com.platform.user.entity.User;

@Repository
public class UserDaoImpl extends AbstractRepository<User> implements UserDao{
	
}

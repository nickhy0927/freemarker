package com.mongo.orm.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongo.orm.dao.BaseRepository;
import com.mongo.orm.factory.MongoTemplateSingleton;

public abstract class AbstractRepository<T> implements BaseRepository<T> {
	
	public MongoTemplate mongoTemplate;
	
	public AbstractRepository(){
		System.out.println(MongoTemplateSingleton.instance);
		mongoTemplate = MongoTemplateSingleton.instance.getMongoTemplate();
	}
	
	@Override
	public void insert(T t) {
		this.mongoTemplate.insert(t);
	}

	@Override
	public T findOne(String id) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public List<T> findByRegex(String regex) {
		return null;
	}

	@Override
	public void removeOne(String id) {
	}

	@Override
	public void removeAll() {
		
	}

	@Override
	public void findAndModify(String id) {
		
	}

}

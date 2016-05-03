package com.mongo.orm.factory;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongo.spring.SpringContextHolder;

public class MongoTemplateSingleton {
	
	private MongoTemplateSingleton(){}
	
	private MongoTemplate mongoTemplate ;
	
	public static MongoTemplateSingleton instance = null;
	
	static {
		if (instance == null) {
			instance = new MongoTemplateSingleton();
			instance.init();
		}
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	
	public MongoTemplate init(){
		mongoTemplate = SpringContextHolder.getBean("mongoTemplate");
		return mongoTemplate;
	}
	
}

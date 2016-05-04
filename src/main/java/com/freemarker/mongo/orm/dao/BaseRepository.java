package com.freemarker.mongo.orm.dao;

import java.util.List;

public interface BaseRepository<T> {
	/**
	 * 
	 * <b>function:</b>添加对象
	 * 
	 * @author yuanhuang
	 * @createDate 2012-12-12 11:41:30
	 */
	public void insert(T t);

	/**
	 * 
	 * <b>function:</b>根据ID查找对象
	 * 
	 * @author yuanhuang
	 * @createDate 2012-12-12 11:41:41
	 */
	public T findOne(String id);

	/**
	 * 
	 * <b>function:</b>查询所有
	 * 
	 * @author yuanhuang
	 * @createDate 2012-12-12 16:26:06
	 */
	public List<T> findAll();

	public List<T> findByRegex(String regex);

	/**
	 * 
	 * <b>function:</b>删除指定的ID对象
	 * 
	 * @author yuanhuang
	 * @createDate 2012-12-12 16:26:16
	 */
	public void removeOne(String id);

	/**
	 * 
	 * <b>function:</b>删除所有
	 * 
	 * @author yuanhuang
	 * @createDate 2012-12-12 16:25:40
	 */
	public void removeAll();

	/**
	 * 通过ID找到并修改 <b>function:</b>
	 * 
	 * @author yuanhuang
	 * @createDate 2012-12-12 16:25:51
	 */
	public void findAndModify(String id);
}

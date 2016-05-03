package com.freemarker;

import java.util.List;

/**
 * 分页 
 * Created by huangyuan on 16-4-28.
 */
public class Pager<E> {
	/**
	 * 当前页码
	 */
	private int currentPage = 1;

	/**
	 * 每页显示多少个
	 */
	private final static int pageSize = 10;

	/**
	 * 总记录数
	 */
	private int totalCount;

	/**
	 * 多少页
	 */
	private int totalPage;

	private List<E> content;

	public Pager(int currentPage, List<E> content, int totalCount) {
		this.currentPage = currentPage < 0 ? 1 : currentPage;
		this.content = content;
		this.totalCount = totalCount < 0 ? 0 : totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		this.totalPage = this.totalCount % Pager.pageSize;
		if (this.totalPage != 0) {
			this.totalPage = this.totalPage + (this.totalCount / Pager.pageSize);
		} else
			this.totalPage = (this.totalCount / Pager.pageSize);
		return this.totalPage;
	}

	public List<E> getContent() {
		return content;
	}

	public void setContent(List<E> content) {
		this.content = content;
	}
}

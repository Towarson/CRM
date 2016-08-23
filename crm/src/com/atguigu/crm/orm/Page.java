package com.atguigu.crm.orm;

import java.util.List;

public class Page<T> {
	//当前页码
	private int pageNo;
	
	//每页显示的条目数
	private int pageSize = 4;
	
	//查询出来的总记录数
	private long totalRecordNo;
	
	//封装的内容信息
	private List<T> pageList;
	
	//总页数
	private int totalPage;
	
	public Page() {
		super();
	}
	
	public Page(long totalRecordNo,String pageNoStr) {
		
		//一.计算总页数
		this.totalRecordNo = totalRecordNo;
		this.totalPage = (int)((this.totalRecordNo + this.pageSize - 1) / this.pageSize);
		
		//二.纠正pageNo(有效范围是 1~totalPageNo)
		//1.给pageNo设置默认值
		
		this.pageNo = 1;
		
		try {
			this.pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {}
		
		if(this.pageNo > this.totalPage) {
			this.pageNo = this.totalPage;
		}
		
		if(this.pageNo < 1) {
			this.pageNo = 1;
		}

	}
	
	//获取上一页
	public int getPre() {
		return this.pageNo-1;
	}
	//判断是否有上一页
	public boolean isHasPre() {
		return this.pageNo > 1;
	}
	
	//获取下一页
	public int getNext() {
		return this.pageNo+1;
	}
	//判断是否有下一页
	public boolean isHasNext() {
		return this.pageNo < this.totalPage;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalRecordNo() {
		return totalRecordNo;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalRecordNo=" + totalRecordNo + ", pageList=" + pageList
				+ ", totalPage=" + totalPage + "]";
	}
}

/**
 *@time 2011-3-22
 *@author soledad pisces
 *@fileName Pagination.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.util.List;

import com.hanphon.recruit.domain.ShowStudentDomain;

/**
 * @author soledad pisces
 * 
 */
public interface Pagination {
	public boolean isFirst();

	public boolean isLast();

	public boolean hasNext();

	public boolean hasPrevious();

	public int getMaxElements();

	public int getMaxPages();

	public int getNext();

	public int getPrevious();

	public int getPageSize();

	public int getPageNumber();

	public List<ShowStudentDomain> getList();

	public void setPageSize(int pageSize);

	public void setPageNumber(int pageNumber);
}

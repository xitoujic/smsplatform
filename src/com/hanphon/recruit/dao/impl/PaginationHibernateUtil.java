/**
 *@time 2011-3-22
 *@author soledad pisces
 *@fileName PaginationHibernateUtil.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hanphon.recruit.domain.ShowStudentDomain;

/**
 * @author soledad pisces
 * 
 */
public class PaginationHibernateUtil implements Pagination {
	private int pageSize = 20;
	private int pageNumber = 1;
	private int maxPages;
	private List<ShowStudentDomain> list = null;
	private int maxElements;
	private String userCategory;
	private String onStatus;

	public PaginationHibernateUtil(int pageSize, int pageNumber,
			String userCategory, String onStatus) {
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.userCategory = userCategory;
		this.onStatus = onStatus;
		init1();
	}

	public PaginationHibernateUtil(int pageSize, int pageNumber, String onStatus) {
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.onStatus = onStatus;
		init2();
	}

	@SuppressWarnings("unchecked")
	private void init1() {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session
					.createQuery("select count(userId) from ShowStudentDomain where userCategory = ? and onStatus = ? and isStudent = 'Y'");
			query.setString(0, this.userCategory);
			query.setString(1, this.onStatus);

			Long values = (Long) query.uniqueResult();
			this.maxElements = values.intValue();

			if (this.pageSize != 0) {
				if (this.maxElements % this.pageSize == 0) {
					this.maxPages = this.maxElements / this.pageSize;
				} else {
					this.maxPages = this.maxElements / this.pageSize + 1;
				}
			}

			query = session
					.createQuery("from ShowStudentDomain where userCategory = ? and onStatus = ? and isStudent = 'Y'");
			query.setString(0, this.userCategory);
			query.setString(1, this.onStatus);
			query.setFirstResult((this.pageNumber - 1) * this.pageSize);
			query.setMaxResults(this.pageSize);

			if (list != null) {
				list.clear();
			}

			this.list = query.list();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	private void init2() {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session
					.createQuery("select count(userId) from ShowStudentDomain where onStatus = ? and isStudent = 'Y'");

			query.setString(0, this.onStatus);

			Long values = (Long) query.uniqueResult();
			this.maxElements = values.intValue();

			if (this.pageSize != 0) {
				if (this.maxElements % this.pageSize == 0) {
					this.maxPages = this.maxElements / this.pageSize;
				} else {
					this.maxPages = this.maxElements / this.pageSize + 1;
				}
			}

			query = session
					.createQuery("from ShowStudentDomain where onStatus = ? and isStudent = 'Y'");
			query.setString(0, this.onStatus);
			query.setFirstResult((this.pageNumber - 1) * this.pageSize);
			query.setMaxResults(this.pageSize);

			if (list != null) {
				list.clear();
			}

			this.list = query.list();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.close();
		}
	}

	public List<ShowStudentDomain> getList() {
		return list;
	}

	public int getMaxElements() {
		return this.maxElements;
	}

	public int getMaxPages() {
		return this.maxPages;
	}

	public int getNext() {
		if (this.pageNumber >= maxPages) {
			return this.pageNumber;
		}
		return this.pageNumber + 1;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public int getPrevious() {
		if (this.pageNumber == 1) {
			return 1;
		}
		return this.pageNumber - 1;
	}

	public boolean hasNext() {
		return (this.pageNumber < maxPages);
	}

	public boolean hasPrevious() {
		return (this.pageNumber > 1);
	}

	public boolean isFirst() {
		return (this.pageNumber == 1);
	}

	public boolean isLast() {
		return (this.pageNumber == maxPages);
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}

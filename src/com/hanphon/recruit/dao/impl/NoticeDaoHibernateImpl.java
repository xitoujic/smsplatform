/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName NoticeDaoHibernateImpl.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hanphon.recruit.dao.NoticeDao;
import com.hanphon.recruit.domain.NoticeDomain;

/**
 * @author soledad pisces
 * 
 */
public class NoticeDaoHibernateImpl extends
		GenericDaoHibernateImpl<NoticeDomain, Integer> implements NoticeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hanphon.recruit.dao.NoticeDao#getAll(java.util.Date)
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public List<NoticeDomain> getAll() {
		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(NoticeDomain.class);
			Date nowTime = new Date();
			int year = nowTime.getYear() - 2;
			nowTime.setYear(year);
			criteria.add(Restrictions.gt("time", nowTime));
			List<NoticeDomain> list = (List<NoticeDomain>) criteria.list();
			
			ComparatorNoticeSort comparator = new ComparatorNoticeSort();
			Collections.sort(list, comparator);
			
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}

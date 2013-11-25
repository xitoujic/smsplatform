/**
 *@time 2011-4-23
 *@author soledad pisces
 *@fileName ScoreDaoHibernateImple.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.util.List;

import com.hanphon.recruit.dao.ScoreDao;
import com.hanphon.recruit.domain.ScoreDomain;

/**
 * @author soledad pisces
 *
 */
public class ScoreDaoHibernateImple extends
GenericDaoHibernateImpl<ScoreDomain, Integer> implements ScoreDao {

	/* (non-Javadoc)
	 * @see com.hanphon.recruit.dao.ScoreDao#getAll()
	 */
	public List<ScoreDomain> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

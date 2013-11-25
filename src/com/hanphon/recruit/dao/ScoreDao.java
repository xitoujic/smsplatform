/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName NoticeDao.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao;

import java.util.List;

import com.hanphon.recruit.domain.ScoreDomain;

/**
 * @author soledad pisces
 *
 */
public interface ScoreDao extends GenericDao<ScoreDomain, Integer> {
	public List<ScoreDomain> getAll ();
}

/**
 *@time 2011-3-18
 *@author soledad pisces
 *@fileName StudentMessageDao.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao;

import java.util.List;

import com.hanphon.recruit.domain.NoticeDomain;
import com.hanphon.recruit.domain.StudentDomain;

/**
 * @author soledad pisces
 *
 */
public interface StudentMessageDao extends GenericDao<StudentDomain, String> {
	public List<NoticeDomain> getAll ();
	public Boolean setOnStatus(String id,String status);
	public String getOnStatus(String id);
	public String getIdByName(String name);
}

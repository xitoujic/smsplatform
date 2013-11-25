/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName RegisterMessageDao.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao;

import java.io.Serializable;

/**
 * @author soledad pisces
 * 
 */
public interface RegisterMessageDao<T, PK extends Serializable> extends
		GenericDao<T, PK> {
	public Boolean save(T entity);
	public String[] findByEmail(PK email);
}

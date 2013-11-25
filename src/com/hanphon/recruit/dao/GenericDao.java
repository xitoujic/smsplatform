/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName Dao.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao;

import java.io.Serializable;

/**
 * @author soledad pisces
 *
 */
public interface GenericDao<T,PK extends Serializable> {
	public T findById(PK id);
	public Boolean save(T entity);
	public Boolean update(T entity);
	public Boolean delete(T entity);
}

/**
 *@time 2011-4-20
 *@author soledad pisces
 *@fileName ComparatorNoticeSort.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.util.Comparator;

import com.hanphon.recruit.domain.NoticeDomain;

/**
 * @author soledad pisces
 *
 */
public class ComparatorNoticeSort implements Comparator<NoticeDomain> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(NoticeDomain o1, NoticeDomain o2) {
		return o2.getTime().compareTo(o1.getTime());
	}

}

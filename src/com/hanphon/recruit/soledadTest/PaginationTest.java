/**
 *@time 2011-3-22
 *@author soledad pisces
 *@fileName PaginationTest.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.soledadTest;

import java.util.List;

import com.hanphon.recruit.dao.impl.PaginationHibernateUtil;
import com.hanphon.recruit.domain.ShowStudentDomain;

/**
 * @author soledad pisces
 * 
 */
public class PaginationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PaginationHibernateUtil pageUtil = new PaginationHibernateUtil(30, 1,"普通",
				"1");
		List<ShowStudentDomain> list = (List<ShowStudentDomain>) pageUtil
				.getList();

		for (ShowStudentDomain domain : list) {
			System.out.println(domain.getUserName());
		}
	}

}

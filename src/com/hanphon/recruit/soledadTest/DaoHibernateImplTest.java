/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName DaoHibernateImplTest.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.soledadTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.hibernate.sql.Insert;

import com.hanphon.recruit.dao.NoticeDao;
import com.hanphon.recruit.dao.RegisterMessageDao;
import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.NoticeDaoHibernateImpl;
import com.hanphon.recruit.dao.impl.RegisterMessageDaoHibernateImpl;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.NoticeDomain;
import com.hanphon.recruit.domain.RegisterMessageDomain;
import com.hanphon.recruit.domain.StudentDomain;

/**
 * @author soledad pisces
 * 
 */
@SuppressWarnings("unused")
public class DaoHibernateImplTest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		save();
		// findByEmail();
		// getAll();
		// Insert();
		// setOnStatus();
		// getOnStatus();
	}

	private static void Insert() {
		NoticeDomain entity = new NoticeDomain();
		entity.setContent("欢迎各位同学登陆本系统，现在您可以进行各项操作了");
		entity.setNdtitle("欢迎");
		entity.setTime(new Date());
		NoticeDao dao = new NoticeDaoHibernateImpl();
		dao.save(entity);
	}

	private static void save() throws UnsupportedEncodingException {
		StudentMessageDao dao = new StudentMessageDaoHibernateImpl();
		StudentDomain entity = new StudentDomain();

		System.out.println("kk");
		
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
			entity.setUserEmail("username"+i);
			entity.setOnStatus("1");
			entity.setIsStudent("Y");
			entity.setUserCategory("普通");
			entity.setUserName("username"+i);
			entity.setUserAddress("userAddress"+i);
			entity.setUserSex("男");
			entity.setUserNation("汉族");
			entity.setUserBirthday("20100320");
			dao.save(entity);
		}
		System.out.println("ok");
	}

	private static void findByEmail() {
		RegisterMessageDao<RegisterMessageDomain, String> dao = new RegisterMessageDaoHibernateImpl();
		String[] retVal = dao.findByEmail("jiangguojian1990@qq.com");

		if (retVal == null) {
			System.out.println("-----------null------------");
		}

		System.out.println(retVal[0] + "----" + retVal[1]);
	}

	private static void getAll() {
		NoticeDao dao = new NoticeDaoHibernateImpl();
		List<NoticeDomain> list = dao.getAll();

		for (NoticeDomain domain : list) {
			System.out.println(domain.getNdtitle() + "---" + domain.getTime()
					+ "--" + domain.getContent());
		}

	}

	private static void setOnStatus() {
		StudentMessageDao dao = new StudentMessageDaoHibernateImpl();
		dao.setOnStatus("402881882eb99c5d012eb99c676f0001", "3");
	}

	private static void getOnStatus() {
		StudentMessageDao dao = new StudentMessageDaoHibernateImpl();
		System.out.println(dao.getOnStatus("402881882eb99c5d012eb99c676f0001"));
	}

}

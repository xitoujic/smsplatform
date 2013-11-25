/**
 *@time 2011-4-23
 *@author soledad pisces
 *@fileName SaveScoreAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hanphon.recruit.dao.ScoreDao;
import com.hanphon.recruit.dao.impl.ScoreDaoHibernateImple;
import com.hanphon.recruit.domain.ScoreDomain;

/**
 * @author soledad pisces
 *
 */
public class SaveScoreAction {
	private String message;
	private ScoreDomain domain;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ScoreDomain getDomain() {
		return domain;
	}

	public void setDomain(ScoreDomain domain) {
		this.domain = domain;
	}

	public void saveScoreDomain() throws IOException{
		ScoreDao dao = new ScoreDaoHibernateImple();
		if(domain!=null) {
			boolean flag = dao.update(domain);
			if(flag == true) {
				this.message = "<script>SUCCESS</script>";
			} else {
				this.message = "<script>ERROR</script>";
			}
		} else {
			this.message = "<script>ERROR</script>";
		}
		sendMsg(this.message);
	}
	
	public void sendMsg(String content) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().println(content);
	}
}

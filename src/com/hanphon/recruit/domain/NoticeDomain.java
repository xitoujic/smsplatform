/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName NoticeDomain.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.domain;

import java.util.Date;

/**
 * @author soledad pisces
 * 
 */
public class NoticeDomain {
	private int ndid;
	private String ndtitle;
	private String content;
	private Date time;

	public int getNdid() {
		return ndid;
	}

	public void setNdid(int ndid) {
		this.ndid = ndid;
	}

	public String getNdtitle() {
		return ndtitle;
	}

	public void setNdtitle(String ndtitle) {
		this.ndtitle = ndtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}

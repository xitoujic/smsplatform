/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName StudentDomain.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.domain;


/**
 * @author soledad pisces
 * 
 */
public class StudentScoreDomain {
	private String userId;// 主键
	private Integer chineseScore;
	private Integer mathScore;
	private Integer englishScore;
	private Integer physicsScore;
	private Integer chemistryScore;
	private Integer historyScore;
	private Integer politicsScore;
	private Integer sumScore;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getChineseScore() {
		return chineseScore;
	}

	public void setChineseScore(Integer chineseScore) {
		this.chineseScore = chineseScore;
	}

	public Integer getMathScore() {
		return mathScore;
	}

	public void setMathScore(Integer mathScore) {
		this.mathScore = mathScore;
	}

	public Integer getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(Integer englishScore) {
		this.englishScore = englishScore;
	}

	public Integer getPhysicsScore() {
		return physicsScore;
	}

	public void setPhysicsScore(Integer physicsScore) {
		this.physicsScore = physicsScore;
	}

	public Integer getChemistryScore() {
		return chemistryScore;
	}

	public void setChemistryScore(Integer chemistryScore) {
		this.chemistryScore = chemistryScore;
	}

	public Integer getHistoryScore() {
		return historyScore;
	}

	public void setHistoryScore(Integer historyScore) {
		this.historyScore = historyScore;
	}

	public Integer getPoliticsScore() {
		return politicsScore;
	}

	public void setPoliticsScore(Integer politicsScore) {
		this.politicsScore = politicsScore;
	}

	public Integer getSumScore() {
		return sumScore;
	}

	public void setSumScore(Integer sumScore) {
		this.sumScore = sumScore;
	}

}

/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName StudentDomain.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.domain;

import java.io.File;
import java.util.Date;

/**
 * @author soledad pisces
 * 
 */
public class StudentDomain {
	private String userId;// 主键
	private String isStudent;
	private String userEmail;
	/*
	 * 
	 * 1:表示注册状态 2:表示登陆过 3：提交基本信息 4：已经下载申请表，等待考核 5：考核通过，等待考试 6：已经录取
	 */
	private String onStatus;// 用户进行填表的状态
	private String userPassword;
	private File userPhoto;// 照片

	private String userCategory;// 选报类型
	private String userName;
	private String userSex;
	private String userBirthday;
	private String userNation;// 民族
	private String userRdcard;// 身份证
	private String userPolStatus;// 政治面貌
	private String userAddress;
	private String userPostalCode;
	private String linkMan;
	private String linkPhoneNum;

	// 考试成绩
	private String fatherName;
	private String fatherEducation;
	private String fatherWorkUnit;
	private String fatherWrkPosition;
	private String fatherCareer;
	private String fatherPhoneNum;
	private String motherName;
	private String motherEducation;
	private String motherWorkUnit;
	private String motherWorkPosition;
	private String motherCareer;
	private String motherPhoneNum;

	// 中学地址类
	private String juniorSchoolName;
	private String juniorSchoolAddress;
	private String juniorSchoolPostalCode;
	private String juniorSchoolLinkman;
	private String juniorSchoolLinkPhoneNum;
	private String juniorSchoolFax;

	// 成绩
	// 初二上
	private String testName1;
	private Integer junior2PreChinese;
	private Integer junior2PreMath;
	private Integer junior2PreEnglish;
	private Integer junior2PreHpy;
	private Integer junior2PreChem;
	private Integer junior2PrePoli;
	private Integer junior2PreHistory;
	// 初二下
	private String testName2;
	private Integer junior2NextChinese;
	private Integer junior2NextMath;
	private Integer junior2NextEnglish;
	private Integer junior2NextHpy;
	private Integer junior2NextChem;
	private Integer junior2NextPoli;
	private Integer junior2NextHistory;
	// 初三上
	private String testName3;
	private Integer junior3PreChinese;
	private Integer junior3PreMath;
	private Integer junior3PreEnglish;
	private Integer junior3PreHpy;
	private Integer junior3PreChem;
	private Integer junior3PrePoli;
	private Integer junior3PreHistory;
	// 初三下期中
	private String testName4;
	private Integer junior3NextMidChinese;
	private Integer junior3NextMidMath;
	private Integer junior3NextMidEnglish;
	private Integer junior3NextMidHpy;
	private Integer junior3NextMidChem;
	private Integer junior3NextMidPoli;
	private Integer junior3NextMidHistory;
	// 初三一模
	private String testName5;
	private Integer junior3Next1stShamChinese;
	private Integer junior3Next1stShamMath;
	private Integer junior3Next1stShamEnglish;
	private Integer junior3Next1stShamHpy;
	private Integer junior3Next1stShamChem;
	private Integer junior3Next1stShamPoli;
	private Integer junior3Next1stShamHistory;

	// 初中业余爱好
	private String competitionTimeAdr;
	private String competitionName;
	private String competitionDegree;
	private String competitionResult;
	private String userHobby;
	private String userActTime;
	private String userActPosition;
	private String userActContent;
	private Date registerTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getOnStatus() {
		return onStatus;
	}

	public void setOnStatus(String onStatus) {
		this.onStatus = onStatus;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserNation() {
		return userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

	public String getUserRdcard() {
		return userRdcard;
	}

	public void setUserRdcard(String userRdcard) {
		this.userRdcard = userRdcard;
	}

	public String getUserPolStatus() {
		return userPolStatus;
	}

	public void setUserPolStatus(String userPolStatus) {
		this.userPolStatus = userPolStatus;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPostalCode() {
		return userPostalCode;
	}

	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkPhoneNum() {
		return linkPhoneNum;
	}

	public void setLinkPhoneNum(String linkPhoneNum) {
		this.linkPhoneNum = linkPhoneNum;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherEducation() {
		return fatherEducation;
	}

	public void setFatherEducation(String fatherEducation) {
		this.fatherEducation = fatherEducation;
	}

	public String getFatherWorkUnit() {
		return fatherWorkUnit;
	}

	public void setFatherWorkUnit(String fatherWorkUnit) {
		this.fatherWorkUnit = fatherWorkUnit;
	}

	public String getFatherWrkPosition() {
		return fatherWrkPosition;
	}

	public void setFatherWrkPosition(String fatherWrkPosition) {
		this.fatherWrkPosition = fatherWrkPosition;
	}

	public String getFatherCareer() {
		return fatherCareer;
	}

	public void setFatherCareer(String fatherCareer) {
		this.fatherCareer = fatherCareer;
	}

	public String getFatherPhoneNum() {
		return fatherPhoneNum;
	}

	public void setFatherPhoneNum(String fatherPhoneNum) {
		this.fatherPhoneNum = fatherPhoneNum;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherEducation() {
		return motherEducation;
	}

	public void setMotherEducation(String motherEducation) {
		this.motherEducation = motherEducation;
	}

	public String getMotherWorkUnit() {
		return motherWorkUnit;
	}

	public void setMotherWorkUnit(String motherWorkUnit) {
		this.motherWorkUnit = motherWorkUnit;
	}

	public String getMotherWorkPosition() {
		return motherWorkPosition;
	}

	public void setMotherWorkPosition(String motherWorkPosition) {
		this.motherWorkPosition = motherWorkPosition;
	}

	public String getMotherCareer() {
		return motherCareer;
	}

	public void setMotherCareer(String motherCareer) {
		this.motherCareer = motherCareer;
	}

	public String getMotherPhoneNum() {
		return motherPhoneNum;
	}

	public void setMotherPhoneNum(String motherPhoneNum) {
		this.motherPhoneNum = motherPhoneNum;
	}

	public String getJuniorSchoolAddress() {
		return juniorSchoolAddress;
	}

	public void setJuniorSchoolAddress(String juniorSchoolAddress) {
		this.juniorSchoolAddress = juniorSchoolAddress;
	}

	public String getJuniorSchoolPostalCode() {
		return juniorSchoolPostalCode;
	}

	public void setJuniorSchoolPostalCode(String juniorSchoolPostalCode) {
		this.juniorSchoolPostalCode = juniorSchoolPostalCode;
	}

	public String getJuniorSchoolLinkman() {
		return juniorSchoolLinkman;
	}

	public void setJuniorSchoolLinkman(String juniorSchoolLinkman) {
		this.juniorSchoolLinkman = juniorSchoolLinkman;
	}

	public String getJuniorSchoolLinkPhoneNum() {
		return juniorSchoolLinkPhoneNum;
	}

	public void setJuniorSchoolLinkPhoneNum(String juniorSchoolLinkPhoneNum) {
		this.juniorSchoolLinkPhoneNum = juniorSchoolLinkPhoneNum;
	}

	public String getJuniorSchoolFax() {
		return juniorSchoolFax;
	}

	public void setJuniorSchoolFax(String juniorSchoolFax) {
		this.juniorSchoolFax = juniorSchoolFax;
	}

	public Integer getJunior2PreChinese() {
		return junior2PreChinese;
	}

	public void setJunior2PreChinese(Integer junior2PreChinese) {
		this.junior2PreChinese = junior2PreChinese;
	}

	public Integer getJunior2PreMath() {
		return junior2PreMath;
	}

	public void setJunior2PreMath(Integer junior2PreMath) {
		this.junior2PreMath = junior2PreMath;
	}

	public Integer getJunior2PreEnglish() {
		return junior2PreEnglish;
	}

	public void setJunior2PreEnglish(Integer junior2PreEnglish) {
		this.junior2PreEnglish = junior2PreEnglish;
	}

	public Integer getJunior2PreHpy() {
		return junior2PreHpy;
	}

	public void setJunior2PreHpy(Integer junior2PreHpy) {
		this.junior2PreHpy = junior2PreHpy;
	}

	public Integer getJunior2PreChem() {
		return junior2PreChem;
	}

	public void setJunior2PreChem(Integer junior2PreChem) {
		this.junior2PreChem = junior2PreChem;
	}

	public Integer getJunior2PrePoli() {
		return junior2PrePoli;
	}

	public void setJunior2PrePoli(Integer junior2PrePoli) {
		this.junior2PrePoli = junior2PrePoli;
	}

	public Integer getJunior2PreHistory() {
		return junior2PreHistory;
	}

	public void setJunior2PreHistory(Integer junior2PreHistory) {
		this.junior2PreHistory = junior2PreHistory;
	}

	public Integer getJunior2NextChinese() {
		return junior2NextChinese;
	}

	public void setJunior2NextChinese(Integer junior2NextChinese) {
		this.junior2NextChinese = junior2NextChinese;
	}

	public Integer getJunior2NextMath() {
		return junior2NextMath;
	}

	public void setJunior2NextMath(Integer junior2NextMath) {
		this.junior2NextMath = junior2NextMath;
	}

	public Integer getJunior2NextEnglish() {
		return junior2NextEnglish;
	}

	public void setJunior2NextEnglish(Integer junior2NextEnglish) {
		this.junior2NextEnglish = junior2NextEnglish;
	}

	public Integer getJunior2NextHpy() {
		return junior2NextHpy;
	}

	public void setJunior2NextHpy(Integer junior2NextHpy) {
		this.junior2NextHpy = junior2NextHpy;
	}

	public Integer getJunior2NextChem() {
		return junior2NextChem;
	}

	public void setJunior2NextChem(Integer junior2NextChem) {
		this.junior2NextChem = junior2NextChem;
	}

	public Integer getJunior2NextPoli() {
		return junior2NextPoli;
	}

	public void setJunior2NextPoli(Integer junior2NextPoli) {
		this.junior2NextPoli = junior2NextPoli;
	}

	public Integer getJunior2NextHistory() {
		return junior2NextHistory;
	}

	public void setJunior2NextHistory(Integer junior2NextHistory) {
		this.junior2NextHistory = junior2NextHistory;
	}

	public Integer getJunior3PreChinese() {
		return junior3PreChinese;
	}

	public void setJunior3PreChinese(Integer junior3PreChinese) {
		this.junior3PreChinese = junior3PreChinese;
	}

	public Integer getJunior3PreMath() {
		return junior3PreMath;
	}

	public void setJunior3PreMath(Integer junior3PreMath) {
		this.junior3PreMath = junior3PreMath;
	}

	public Integer getJunior3PreEnglish() {
		return junior3PreEnglish;
	}

	public void setJunior3PreEnglish(Integer junior3PreEnglish) {
		this.junior3PreEnglish = junior3PreEnglish;
	}

	public Integer getJunior3PreHpy() {
		return junior3PreHpy;
	}

	public void setJunior3PreHpy(Integer junior3PreHpy) {
		this.junior3PreHpy = junior3PreHpy;
	}

	public Integer getJunior3PreChem() {
		return junior3PreChem;
	}

	public void setJunior3PreChem(Integer junior3PreChem) {
		this.junior3PreChem = junior3PreChem;
	}

	public Integer getJunior3PrePoli() {
		return junior3PrePoli;
	}

	public void setJunior3PrePoli(Integer junior3PrePoli) {
		this.junior3PrePoli = junior3PrePoli;
	}

	public Integer getJunior3PreHistory() {
		return junior3PreHistory;
	}

	public void setJunior3PreHistory(Integer junior3PreHistory) {
		this.junior3PreHistory = junior3PreHistory;
	}

	public Integer getJunior3NextMidChinese() {
		return junior3NextMidChinese;
	}

	public void setJunior3NextMidChinese(Integer junior3NextMidChinese) {
		this.junior3NextMidChinese = junior3NextMidChinese;
	}

	public Integer getJunior3NextMidMath() {
		return junior3NextMidMath;
	}

	public void setJunior3NextMidMath(Integer junior3NextMidMath) {
		this.junior3NextMidMath = junior3NextMidMath;
	}

	public Integer getJunior3NextMidEnglish() {
		return junior3NextMidEnglish;
	}

	public void setJunior3NextMidEnglish(Integer junior3NextMidEnglish) {
		this.junior3NextMidEnglish = junior3NextMidEnglish;
	}

	public Integer getJunior3NextMidHpy() {
		return junior3NextMidHpy;
	}

	public void setJunior3NextMidHpy(Integer junior3NextMidHpy) {
		this.junior3NextMidHpy = junior3NextMidHpy;
	}

	public Integer getJunior3NextMidChem() {
		return junior3NextMidChem;
	}

	public void setJunior3NextMidChem(Integer junior3NextMidChem) {
		this.junior3NextMidChem = junior3NextMidChem;
	}

	public Integer getJunior3NextMidPoli() {
		return junior3NextMidPoli;
	}

	public void setJunior3NextMidPoli(Integer junior3NextMidPoli) {
		this.junior3NextMidPoli = junior3NextMidPoli;
	}

	public Integer getJunior3NextMidHistory() {
		return junior3NextMidHistory;
	}

	public void setJunior3NextMidHistory(Integer junior3NextMidHistory) {
		this.junior3NextMidHistory = junior3NextMidHistory;
	}

	public Integer getJunior3Next1stShamChinese() {
		return junior3Next1stShamChinese;
	}

	public void setJunior3Next1stShamChinese(Integer junior3Next1stShamChinese) {
		this.junior3Next1stShamChinese = junior3Next1stShamChinese;
	}

	public Integer getJunior3Next1stShamMath() {
		return junior3Next1stShamMath;
	}

	public void setJunior3Next1stShamMath(Integer junior3Next1stShamMath) {
		this.junior3Next1stShamMath = junior3Next1stShamMath;
	}

	public Integer getJunior3Next1stShamEnglish() {
		return junior3Next1stShamEnglish;
	}

	public void setJunior3Next1stShamEnglish(Integer junior3Next1stShamEnglish) {
		this.junior3Next1stShamEnglish = junior3Next1stShamEnglish;
	}

	public Integer getJunior3Next1stShamHpy() {
		return junior3Next1stShamHpy;
	}

	public void setJunior3Next1stShamHpy(Integer junior3Next1stShamHpy) {
		this.junior3Next1stShamHpy = junior3Next1stShamHpy;
	}

	public Integer getJunior3Next1stShamChem() {
		return junior3Next1stShamChem;
	}

	public void setJunior3Next1stShamChem(Integer junior3Next1stShamChem) {
		this.junior3Next1stShamChem = junior3Next1stShamChem;
	}

	public Integer getJunior3Next1stShamPoli() {
		return junior3Next1stShamPoli;
	}

	public void setJunior3Next1stShamPoli(Integer junior3Next1stShamPoli) {
		this.junior3Next1stShamPoli = junior3Next1stShamPoli;
	}

	public Integer getJunior3Next1stShamHistory() {
		return junior3Next1stShamHistory;
	}

	public void setJunior3Next1stShamHistory(Integer junior3Next1stShamHistory) {
		this.junior3Next1stShamHistory = junior3Next1stShamHistory;
	}

	public String getCompetitionTimeAdr() {
		return competitionTimeAdr;
	}

	public void setCompetitionTimeAdr(String competitionTimeAdr) {
		this.competitionTimeAdr = competitionTimeAdr;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getCompetitionDegree() {
		return competitionDegree;
	}

	public void setCompetitionDegree(String competitionDegree) {
		this.competitionDegree = competitionDegree;
	}

	public String getCompetitionResult() {
		return competitionResult;
	}

	public void setCompetitionResult(String competitionResult) {
		this.competitionResult = competitionResult;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getUserActTime() {
		return userActTime;
	}

	public void setUserActTime(String userActTime) {
		this.userActTime = userActTime;
	}

	public String getUserActPosition() {
		return userActPosition;
	}

	public void setUserActPosition(String userActPosition) {
		this.userActPosition = userActPosition;
	}

	public String getUserActContent() {
		return userActContent;
	}

	public void setUserActContent(String userActContent) {
		this.userActContent = userActContent;
	}

	public File getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(File userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(String isStudent) {
		this.isStudent = isStudent;
	}

	public String getJuniorSchoolName() {
		return juniorSchoolName;
	}

	public void setJuniorSchoolName(String juniorSchoolName) {
		this.juniorSchoolName = juniorSchoolName;
	}

	public String getTestName1() {
		return testName1;
	}

	public void setTestName1(String testName1) {
		this.testName1 = testName1;
	}

	public String getTestName2() {
		return testName2;
	}

	public void setTestName2(String testName2) {
		this.testName2 = testName2;
	}

	public String getTestName3() {
		return testName3;
	}

	public void setTestName3(String testName3) {
		this.testName3 = testName3;
	}

	public String getTestName4() {
		return testName4;
	}

	public void setTestName4(String testName4) {
		this.testName4 = testName4;
	}

	public String getTestName5() {
		return testName5;
	}

	public void setTestName5(String testName5) {
		this.testName5 = testName5;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

}

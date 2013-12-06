package smsplatform.dao;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TBdMessagesendgroup entity. @author MyEclipse Persistence Tools
 */

public class TBdMessagesendgroup implements java.io.Serializable {

	// Fields

	private Long FSendGroupId;
	private TBdUser TBdUser;
	private String FGroupType;
	private String FSubmitType;
	private String FGroupSendStatus;
	private Long FGroupPhoneNum;
	private String FGroupContent;
	private Timestamp FGroupSendTime;
	private String FGroupPhones;
	private Set TBdMessagesends = new HashSet(0);

	// Constructors

	/** default constructor */
	public TBdMessagesendgroup() {
	}

	/** minimal constructor */
	public TBdMessagesendgroup(TBdUser TBdUser, String FGroupType) {
		this.TBdUser = TBdUser;
		this.FGroupType = FGroupType;
	}

	/** full constructor */
	public TBdMessagesendgroup(TBdUser TBdUser, String FGroupType,
			String FSubmitType, String FGroupSendStatus, Long FGroupPhoneNum,
			String FGroupContent, Timestamp FGroupSendTime,
			String FGroupPhones, Set TBdMessagesends) {
		this.TBdUser = TBdUser;
		this.FGroupType = FGroupType;
		this.FSubmitType = FSubmitType;
		this.FGroupSendStatus = FGroupSendStatus;
		this.FGroupPhoneNum = FGroupPhoneNum;
		this.FGroupContent = FGroupContent;
		this.FGroupSendTime = FGroupSendTime;
		this.FGroupPhones = FGroupPhones;
		this.TBdMessagesends = TBdMessagesends;
	}

	// Property accessors

	public Long getFSendGroupId() {
		return this.FSendGroupId;
	}

	public void setFSendGroupId(Long FSendGroupId) {
		this.FSendGroupId = FSendGroupId;
	}

	public TBdUser getTBdUser() {
		return this.TBdUser;
	}

	public void setTBdUser(TBdUser TBdUser) {
		this.TBdUser = TBdUser;
	}

	public String getFGroupType() {
		return this.FGroupType;
	}

	public void setFGroupType(String FGroupType) {
		this.FGroupType = FGroupType;
	}

	public String getFSubmitType() {
		return this.FSubmitType;
	}

	public void setFSubmitType(String FSubmitType) {
		this.FSubmitType = FSubmitType;
	}

	public String getFGroupSendStatus() {
		return this.FGroupSendStatus;
	}

	public void setFGroupSendStatus(String FGroupSendStatus) {
		this.FGroupSendStatus = FGroupSendStatus;
	}

	public Long getFGroupPhoneNum() {
		return this.FGroupPhoneNum;
	}

	public void setFGroupPhoneNum(Long FGroupPhoneNum) {
		this.FGroupPhoneNum = FGroupPhoneNum;
	}

	public String getFGroupContent() {
		return this.FGroupContent;
	}

	public void setFGroupContent(String FGroupContent) {
		this.FGroupContent = FGroupContent;
	}

	public Timestamp getFGroupSendTime() {
		return this.FGroupSendTime;
	}

	public void setFGroupSendTime(Timestamp FGroupSendTime) {
		this.FGroupSendTime = FGroupSendTime;
	}

	public String getFGroupPhones() {
		return this.FGroupPhones;
	}

	public void setFGroupPhones(String FGroupPhones) {
		this.FGroupPhones = FGroupPhones;
	}

	public Set getTBdMessagesends() {
		return this.TBdMessagesends;
	}

	public void setTBdMessagesends(Set TBdMessagesends) {
		this.TBdMessagesends = TBdMessagesends;
	}

}
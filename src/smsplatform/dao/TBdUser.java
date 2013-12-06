package smsplatform.dao;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;



/**
 * TBdUser entity. @author MyEclipse Persistence Tools
 */

public class TBdUser   implements Cloneable ,java.io.Serializable {

	// Fields

	private Long FUserId;
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	private String FUserName;
	private String FUserFullName;
	private String FPassword;
	private String FPhoneNumber;
	private String FSex;
	private String FRole;
	private String FCompanyType;
	private String FCheckType;
	private String FSignature;
	private String FSignatureFlag;
	private String FUrgent;
	private String FUpdateStatus;
	private String FRight;
	private Integer FDeductScale;
	private String FEmail;
	private Long FMessageNumber;
	private Double FMoney;
	private Timestamp FUpdateTime;
	private Set TBdMessagesendgroups = new HashSet(0);
	private Set TBdRechargeandconsumptions = new HashSet(0);
	private Set TBdLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TBdUser() {
	}

	/** minimal constructor */
	public TBdUser(String FUserName, String FPassword, String FRole) {
		this.FUserName = FUserName;
		this.FPassword = FPassword;
		this.FRole = FRole;
	}

	/** full constructor */
	public TBdUser(String FUserName, String FUserFullName, String FPassword,
			String FPhoneNumber, String FSex, String FRole,
			String FCompanyType, String FCheckType, String FSignature,
			String FSignatureFlag, String FUrgent, String FUpdateStatus,
			String FRight, Integer FDeductScale, String FEmail,
			Long FMessageNumber, Double FMoney, Timestamp FUpdateTime,
			Set TBdMessagesendgroups, Set TBdRechargeandconsumptions,
			Set TBdLogs) {
		this.FUserName = FUserName;
		this.FUserFullName = FUserFullName;
		this.FPassword = FPassword;
		this.FPhoneNumber = FPhoneNumber;
		this.FSex = FSex;
		this.FRole = FRole;
		this.FCompanyType = FCompanyType;
		this.FCheckType = FCheckType;
		this.FSignature = FSignature;
		this.FSignatureFlag = FSignatureFlag;
		this.FUrgent = FUrgent;
		this.FUpdateStatus = FUpdateStatus;
		this.FRight = FRight;
		this.FDeductScale = FDeductScale;
		this.FEmail = FEmail;
		this.FMessageNumber = FMessageNumber;
		this.FMoney = FMoney;
		this.FUpdateTime = FUpdateTime;
		this.TBdMessagesendgroups = TBdMessagesendgroups;
		this.TBdRechargeandconsumptions = TBdRechargeandconsumptions;
		this.TBdLogs = TBdLogs;
	}

	// Property accessors

	public Long getFUserId() {
		return this.FUserId;
	}

	public void setFUserId(Long FUserId) {
		this.FUserId = FUserId;
	}

	public String getFUserName() {
		return this.FUserName;
	}

	public void setFUserName(String FUserName) {
		this.FUserName = FUserName;
	}

	public String getFUserFullName() {
		return this.FUserFullName;
	}

	public void setFUserFullName(String FUserFullName) {
		this.FUserFullName = FUserFullName;
	}

	public String getFPassword() {
		return this.FPassword;
	}

	public void setFPassword(String FPassword) {
		this.FPassword = FPassword;
	}

	public String getFPhoneNumber() {
		return this.FPhoneNumber;
	}

	public void setFPhoneNumber(String FPhoneNumber) {
		this.FPhoneNumber = FPhoneNumber;
	}

	public String getFSex() {
		return this.FSex;
	}

	public void setFSex(String FSex) {
		this.FSex = FSex;
	}

	public String getFRole() {
		return this.FRole;
	}

	public void setFRole(String FRole) {
		this.FRole = FRole;
	}

	public String getFCompanyType() {
		return this.FCompanyType;
	}

	public void setFCompanyType(String FCompanyType) {
		this.FCompanyType = FCompanyType;
	}

	public String getFCheckType() {
		return this.FCheckType;
	}

	public void setFCheckType(String FCheckType) {
		this.FCheckType = FCheckType;
	}

	public String getFSignature() {
		return this.FSignature;
	}

	public void setFSignature(String FSignature) {
		this.FSignature = FSignature;
	}

	public String getFSignatureFlag() {
		return this.FSignatureFlag;
	}

	public void setFSignatureFlag(String FSignatureFlag) {
		this.FSignatureFlag = FSignatureFlag;
	}

	public String getFUrgent() {
		return this.FUrgent;
	}

	public void setFUrgent(String FUrgent) {
		this.FUrgent = FUrgent;
	}

	public String getFUpdateStatus() {
		return this.FUpdateStatus;
	}

	public void setFUpdateStatus(String FUpdateStatus) {
		this.FUpdateStatus = FUpdateStatus;
	}

	public String getFRight() {
		return this.FRight;
	}

	public void setFRight(String FRight) {
		this.FRight = FRight;
	}

	public Integer getFDeductScale() {
		return this.FDeductScale;
	}

	public void setFDeductScale(Integer FDeductScale) {
		this.FDeductScale = FDeductScale;
	}

	public String getFEmail() {
		return this.FEmail;
	}

	public void setFEmail(String FEmail) {
		this.FEmail = FEmail;
	}

	public Long getFMessageNumber() {
		return this.FMessageNumber;
	}

	public void setFMessageNumber(Long FMessageNumber) {
		this.FMessageNumber = FMessageNumber;
	}

	public Double getFMoney() {
		return this.FMoney;
	}

	public void setFMoney(Double FMoney) {
		this.FMoney = FMoney;
	}

	public Timestamp getFUpdateTime() {
		return this.FUpdateTime;
	}

	public void setFUpdateTime(Timestamp FUpdateTime) {
		this.FUpdateTime = FUpdateTime;
	}

	public Set getTBdMessagesendgroups() {
		return this.TBdMessagesendgroups;
	}

	public void setTBdMessagesendgroups(Set TBdMessagesendgroups) {
		this.TBdMessagesendgroups = TBdMessagesendgroups;
	}

	public Set getTBdRechargeandconsumptions() {
		return this.TBdRechargeandconsumptions;
	}

	public void setTBdRechargeandconsumptions(Set TBdRechargeandconsumptions) {
		this.TBdRechargeandconsumptions = TBdRechargeandconsumptions;
	}

	public Set getTBdLogs() {
		return this.TBdLogs;
	}

	public void setTBdLogs(Set TBdLogs) {
		this.TBdLogs = TBdLogs;
	}

}
package smsplatform.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * TBdUser entity. @author MyEclipse Persistence Tools
 */

public class TBdUser implements java.io.Serializable {

	// Fields

	private Long FUserId;
	private String FUserName;
	private String FUserFullName;
	private String FPassword;
	private String FPhoneNumber;
	private Boolean FSex;
	private String FRole;
	private String FCompanyType;
	private Boolean FCheckType;
	private String FSignature;
	private String FSignatureFlag;
	private Boolean FUrgent;
	private Boolean FUpdateStatus;
	private Boolean FRight;
	private Integer FDeductScale;
	private String FEmail;
	private Set TBdMessagesendgroups = new HashSet(0);
	private Set TBdMessagenumbers = new HashSet(0);
	private Set TBdRechargeandconsumptions = new HashSet(0);

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
			String FPhoneNumber, Boolean FSex, String FRole,
			String FCompanyType, Boolean FCheckType, String FSignature,
			String FSignatureFlag, Boolean FUrgent, Boolean FUpdateStatus,
			Boolean FRight, Integer FDeductScale, String FEmail,
			Set TBdMessagesendgroups, Set TBdMessagenumbers,
			Set TBdRechargeandconsumptions) {
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
		this.TBdMessagesendgroups = TBdMessagesendgroups;
		this.TBdMessagenumbers = TBdMessagenumbers;
		this.TBdRechargeandconsumptions = TBdRechargeandconsumptions;
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

	public Boolean getFSex() {
		return this.FSex;
	}

	public void setFSex(Boolean FSex) {
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

	public Boolean getFCheckType() {
		return this.FCheckType;
	}

	public void setFCheckType(Boolean FCheckType) {
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

	public Boolean getFUrgent() {
		return this.FUrgent;
	}

	public void setFUrgent(Boolean FUrgent) {
		this.FUrgent = FUrgent;
	}

	public Boolean getFUpdateStatus() {
		return this.FUpdateStatus;
	}

	public void setFUpdateStatus(Boolean FUpdateStatus) {
		this.FUpdateStatus = FUpdateStatus;
	}

	public Boolean getFRight() {
		return this.FRight;
	}

	public void setFRight(Boolean FRight) {
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

	public Set getTBdMessagesendgroups() {
		return this.TBdMessagesendgroups;
	}

	public void setTBdMessagesendgroups(Set TBdMessagesendgroups) {
		this.TBdMessagesendgroups = TBdMessagesendgroups;
	}

	public Set getTBdMessagenumbers() {
		return this.TBdMessagenumbers;
	}

	public void setTBdMessagenumbers(Set TBdMessagenumbers) {
		this.TBdMessagenumbers = TBdMessagenumbers;
	}

	public Set getTBdRechargeandconsumptions() {
		return this.TBdRechargeandconsumptions;
	}

	public void setTBdRechargeandconsumptions(Set TBdRechargeandconsumptions) {
		this.TBdRechargeandconsumptions = TBdRechargeandconsumptions;
	}

}
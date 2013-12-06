package smsplatform.dao;

import java.sql.Timestamp;

/**
 * TBdRechargeandconsumption entity. @author MyEclipse Persistence Tools
 */

public class TBdRechargeandconsumption implements java.io.Serializable {

	// Fields

	private Long FRcgAndCuptId;
	private TBdUser TBdUser;
	private Double FBeforeRechargeMoney;
	private Double FRechargeMoney;
	private Double FAfterRechargeMoney;
	private Long FBeforeRechargeNum;
	private Long FRechargeNum;
	private Long FAfterRechargeNum;
	private Double FBeforeConsumpteMoney;
	private Double FConsumpteMoney;
	private Double FAfterConsumpteMoney;
	private Long FBeforeConsumpteNum;
	private Long FConsumpteNum;
	private Long FAfterConsumpteNum;
	private Timestamp FOperateTime;
	private String FOperateType;

	// Constructors

	/** default constructor */
	public TBdRechargeandconsumption() {
	}

	/** minimal constructor */
	public TBdRechargeandconsumption(TBdUser TBdUser, Timestamp FOperateTime,
			String FOperateType) {
		this.TBdUser = TBdUser;
		this.FOperateTime = FOperateTime;
		this.FOperateType = FOperateType;
	}

	/** full constructor */
	public TBdRechargeandconsumption(TBdUser TBdUser,
			Double FBeforeRechargeMoney, Double FRechargeMoney,
			Double FAfterRechargeMoney, Long FBeforeRechargeNum,
			Long FRechargeNum, Long FAfterRechargeNum,
			Double FBeforeConsumpteMoney, Double FConsumpteMoney,
			Double FAfterConsumpteMoney, Long FBeforeConsumpteNum,
			Long FConsumpteNum, Long FAfterConsumpteNum,
			Timestamp FOperateTime, String FOperateType) {
		this.TBdUser = TBdUser;
		this.FBeforeRechargeMoney = FBeforeRechargeMoney;
		this.FRechargeMoney = FRechargeMoney;
		this.FAfterRechargeMoney = FAfterRechargeMoney;
		this.FBeforeRechargeNum = FBeforeRechargeNum;
		this.FRechargeNum = FRechargeNum;
		this.FAfterRechargeNum = FAfterRechargeNum;
		this.FBeforeConsumpteMoney = FBeforeConsumpteMoney;
		this.FConsumpteMoney = FConsumpteMoney;
		this.FAfterConsumpteMoney = FAfterConsumpteMoney;
		this.FBeforeConsumpteNum = FBeforeConsumpteNum;
		this.FConsumpteNum = FConsumpteNum;
		this.FAfterConsumpteNum = FAfterConsumpteNum;
		this.FOperateTime = FOperateTime;
		this.FOperateType = FOperateType;
	}

	// Property accessors

	public Long getFRcgAndCuptId() {
		return this.FRcgAndCuptId;
	}

	public void setFRcgAndCuptId(Long FRcgAndCuptId) {
		this.FRcgAndCuptId = FRcgAndCuptId;
	}

	public TBdUser getTBdUser() {
		return this.TBdUser;
	}

	public void setTBdUser(TBdUser TBdUser) {
		this.TBdUser = TBdUser;
	}

	public Double getFBeforeRechargeMoney() {
		return this.FBeforeRechargeMoney;
	}

	public void setFBeforeRechargeMoney(Double FBeforeRechargeMoney) {
		this.FBeforeRechargeMoney = FBeforeRechargeMoney;
	}

	public Double getFRechargeMoney() {
		return this.FRechargeMoney;
	}

	public void setFRechargeMoney(Double FRechargeMoney) {
		this.FRechargeMoney = FRechargeMoney;
	}

	public Double getFAfterRechargeMoney() {
		return this.FAfterRechargeMoney;
	}

	public void setFAfterRechargeMoney(Double FAfterRechargeMoney) {
		this.FAfterRechargeMoney = FAfterRechargeMoney;
	}

	public Long getFBeforeRechargeNum() {
		return this.FBeforeRechargeNum;
	}

	public void setFBeforeRechargeNum(Long FBeforeRechargeNum) {
		this.FBeforeRechargeNum = FBeforeRechargeNum;
	}

	public Long getFRechargeNum() {
		return this.FRechargeNum;
	}

	public void setFRechargeNum(Long FRechargeNum) {
		this.FRechargeNum = FRechargeNum;
	}

	public Long getFAfterRechargeNum() {
		return this.FAfterRechargeNum;
	}

	public void setFAfterRechargeNum(Long FAfterRechargeNum) {
		this.FAfterRechargeNum = FAfterRechargeNum;
	}

	public Double getFBeforeConsumpteMoney() {
		return this.FBeforeConsumpteMoney;
	}

	public void setFBeforeConsumpteMoney(Double FBeforeConsumpteMoney) {
		this.FBeforeConsumpteMoney = FBeforeConsumpteMoney;
	}

	public Double getFConsumpteMoney() {
		return this.FConsumpteMoney;
	}

	public void setFConsumpteMoney(Double FConsumpteMoney) {
		this.FConsumpteMoney = FConsumpteMoney;
	}

	public Double getFAfterConsumpteMoney() {
		return this.FAfterConsumpteMoney;
	}

	public void setFAfterConsumpteMoney(Double FAfterConsumpteMoney) {
		this.FAfterConsumpteMoney = FAfterConsumpteMoney;
	}

	public Long getFBeforeConsumpteNum() {
		return this.FBeforeConsumpteNum;
	}

	public void setFBeforeConsumpteNum(Long FBeforeConsumpteNum) {
		this.FBeforeConsumpteNum = FBeforeConsumpteNum;
	}

	public Long getFConsumpteNum() {
		return this.FConsumpteNum;
	}

	public void setFConsumpteNum(Long FConsumpteNum) {
		this.FConsumpteNum = FConsumpteNum;
	}

	public Long getFAfterConsumpteNum() {
		return this.FAfterConsumpteNum;
	}

	public void setFAfterConsumpteNum(Long FAfterConsumpteNum) {
		this.FAfterConsumpteNum = FAfterConsumpteNum;
	}

	public Timestamp getFOperateTime() {
		return this.FOperateTime;
	}

	public void setFOperateTime(Timestamp FOperateTime) {
		this.FOperateTime = FOperateTime;
	}

	public String getFOperateType() {
		return this.FOperateType;
	}

	public void setFOperateType(String FOperateType) {
		this.FOperateType = FOperateType;
	}

}
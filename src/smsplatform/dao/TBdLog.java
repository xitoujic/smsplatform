package smsplatform.dao;

import java.sql.Timestamp;

/**
 * TBdLog entity. @author MyEclipse Persistence Tools
 */

public class TBdLog implements java.io.Serializable {

	// Fields

	private Long FLogId;
	private TBdUser TBdUser;
	private String FBefor;
	private String FOperate;
	private String FAfter;
	private Timestamp FTime;

	// Constructors

	/** default constructor */
	public TBdLog() {
	}

	/** minimal constructor */
	public TBdLog(TBdUser TBdUser, Timestamp FTime) {
		this.TBdUser = TBdUser;
		this.FTime = FTime;
	}

	/** full constructor */
	public TBdLog(TBdUser TBdUser, String FBefor, String FOperate,
			String FAfter, Timestamp FTime) {
		this.TBdUser = TBdUser;
		this.FBefor = FBefor;
		this.FOperate = FOperate;
		this.FAfter = FAfter;
		this.FTime = FTime;
	}

	// Property accessors

	public Long getFLogId() {
		return this.FLogId;
	}

	public void setFLogId(Long FLogId) {
		this.FLogId = FLogId;
	}

	public TBdUser getTBdUser() {
		return this.TBdUser;
	}

	public void setTBdUser(TBdUser TBdUser) {
		this.TBdUser = TBdUser;
	}

	public String getFBefor() {
		return this.FBefor;
	}

	public void setFBefor(String FBefor) {
		this.FBefor = FBefor;
	}

	public String getFOperate() {
		return this.FOperate;
	}

	public void setFOperate(String FOperate) {
		this.FOperate = FOperate;
	}

	public String getFAfter() {
		return this.FAfter;
	}

	public void setFAfter(String FAfter) {
		this.FAfter = FAfter;
	}

	public Timestamp getFTime() {
		return this.FTime;
	}

	public void setFTime(Timestamp FTime) {
		this.FTime = FTime;
	}

}
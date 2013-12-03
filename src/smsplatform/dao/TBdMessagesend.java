package smsplatform.dao;

import java.sql.Timestamp;


/**
 * TBdMessagesend entity. @author MyEclipse Persistence Tools
 */

public class TBdMessagesend  implements java.io.Serializable {


    // Fields    

     private Long FMessageId;
     private TBdMessagesendgroup TBdMessagesendgroup;
     private String FSendNumber;
     private Boolean FSendStatus;
     private Boolean FSendCostStatus;
     private Boolean FMessageStatus;
     private String FOperator;
     private String FNumberArea;
     private Timestamp FSendTime;


    // Constructors

    /** default constructor */
    public TBdMessagesend() {
    }

	/** minimal constructor */
    public TBdMessagesend(Long FMessageId, TBdMessagesendgroup TBdMessagesendgroup, String FSendNumber, Timestamp FSendTime) {
        this.FMessageId = FMessageId;
        this.TBdMessagesendgroup = TBdMessagesendgroup;
        this.FSendNumber = FSendNumber;
        this.FSendTime = FSendTime;
    }
    
    /** full constructor */
    public TBdMessagesend(Long FMessageId, TBdMessagesendgroup TBdMessagesendgroup, String FSendNumber, Boolean FSendStatus, Boolean FSendCostStatus, Boolean FMessageStatus, String FOperator, String FNumberArea, Timestamp FSendTime) {
        this.FMessageId = FMessageId;
        this.TBdMessagesendgroup = TBdMessagesendgroup;
        this.FSendNumber = FSendNumber;
        this.FSendStatus = FSendStatus;
        this.FSendCostStatus = FSendCostStatus;
        this.FMessageStatus = FMessageStatus;
        this.FOperator = FOperator;
        this.FNumberArea = FNumberArea;
        this.FSendTime = FSendTime;
    }

   
    // Property accessors

    public Long getFMessageId() {
        return this.FMessageId;
    }
    
    public void setFMessageId(Long FMessageId) {
        this.FMessageId = FMessageId;
    }

    public TBdMessagesendgroup getTBdMessagesendgroup() {
        return this.TBdMessagesendgroup;
    }
    
    public void setTBdMessagesendgroup(TBdMessagesendgroup TBdMessagesendgroup) {
        this.TBdMessagesendgroup = TBdMessagesendgroup;
    }

    public String getFSendNumber() {
        return this.FSendNumber;
    }
    
    public void setFSendNumber(String FSendNumber) {
        this.FSendNumber = FSendNumber;
    }

    public Boolean getFSendStatus() {
        return this.FSendStatus;
    }
    
    public void setFSendStatus(Boolean FSendStatus) {
        this.FSendStatus = FSendStatus;
    }

    public Boolean getFSendCostStatus() {
        return this.FSendCostStatus;
    }
    
    public void setFSendCostStatus(Boolean FSendCostStatus) {
        this.FSendCostStatus = FSendCostStatus;
    }

    public Boolean getFMessageStatus() {
        return this.FMessageStatus;
    }
    
    public void setFMessageStatus(Boolean FMessageStatus) {
        this.FMessageStatus = FMessageStatus;
    }

    public String getFOperator() {
        return this.FOperator;
    }
    
    public void setFOperator(String FOperator) {
        this.FOperator = FOperator;
    }

    public String getFNumberArea() {
        return this.FNumberArea;
    }
    
    public void setFNumberArea(String FNumberArea) {
        this.FNumberArea = FNumberArea;
    }

    public Timestamp getFSendTime() {
        return this.FSendTime;
    }
    
    public void setFSendTime(Timestamp FSendTime) {
        this.FSendTime = FSendTime;
    }
   








}
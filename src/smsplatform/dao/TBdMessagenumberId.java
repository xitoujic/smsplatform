package smsplatform.dao;

import java.sql.Timestamp;


/**
 * TBdMessagenumberId entity. @author MyEclipse Persistence Tools
 */

public class TBdMessagenumberId  implements java.io.Serializable {


    // Fields    

     private Long FUserId;
     private Long FMessageNumber;
     private Double FMoney;
     private Timestamp FUpdateTime;


    // Constructors

    /** default constructor */
    public TBdMessagenumberId() {
    }

    
    /** full constructor */
    public TBdMessagenumberId(Long FUserId, Long FMessageNumber, Double FMoney, Timestamp FUpdateTime) {
        this.FUserId = FUserId;
        this.FMessageNumber = FMessageNumber;
        this.FMoney = FMoney;
        this.FUpdateTime = FUpdateTime;
    }

   
    // Property accessors

    public Long getFUserId() {
        return this.FUserId;
    }
    
    public void setFUserId(Long FUserId) {
        this.FUserId = FUserId;
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
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TBdMessagenumberId) ) return false;
		 TBdMessagenumberId castOther = ( TBdMessagenumberId ) other; 
         
		 return ( (this.getFUserId()==castOther.getFUserId()) || ( this.getFUserId()!=null && castOther.getFUserId()!=null && this.getFUserId().equals(castOther.getFUserId()) ) )
 && ( (this.getFMessageNumber()==castOther.getFMessageNumber()) || ( this.getFMessageNumber()!=null && castOther.getFMessageNumber()!=null && this.getFMessageNumber().equals(castOther.getFMessageNumber()) ) )
 && ( (this.getFMoney()==castOther.getFMoney()) || ( this.getFMoney()!=null && castOther.getFMoney()!=null && this.getFMoney().equals(castOther.getFMoney()) ) )
 && ( (this.getFUpdateTime()==castOther.getFUpdateTime()) || ( this.getFUpdateTime()!=null && castOther.getFUpdateTime()!=null && this.getFUpdateTime().equals(castOther.getFUpdateTime()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFUserId() == null ? 0 : this.getFUserId().hashCode() );
         result = 37 * result + ( getFMessageNumber() == null ? 0 : this.getFMessageNumber().hashCode() );
         result = 37 * result + ( getFMoney() == null ? 0 : this.getFMoney().hashCode() );
         result = 37 * result + ( getFUpdateTime() == null ? 0 : this.getFUpdateTime().hashCode() );
         return result;
   }   





}
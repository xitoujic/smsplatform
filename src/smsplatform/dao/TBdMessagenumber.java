package smsplatform.dao;



/**
 * TBdMessagenumber entity. @author MyEclipse Persistence Tools
 */

public class TBdMessagenumber  implements java.io.Serializable {


    // Fields    

     private TBdMessagenumberId id;
     private TBdUser TBdUser;


    // Constructors

    /** default constructor */
    public TBdMessagenumber() {
    }

    
    /** full constructor */
    public TBdMessagenumber(TBdMessagenumberId id, TBdUser TBdUser) {
        this.id = id;
        this.TBdUser = TBdUser;
    }

   
    // Property accessors

    public TBdMessagenumberId getId() {
        return this.id;
    }
    
    public void setId(TBdMessagenumberId id) {
        this.id = id;
    }

    public TBdUser getTBdUser() {
        return this.TBdUser;
    }
    
    public void setTBdUser(TBdUser TBdUser) {
        this.TBdUser = TBdUser;
    }
   








}
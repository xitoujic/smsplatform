package smsplatform.dao;



/**
 * UserDomain entity. @author MyEclipse Persistence Tools
 */

public class UserDomain  implements java.io.Serializable {


    // Fields    

     private Integer usrId;
     private String userName;
     private String email;
     private String password;
     private String type;


    // Constructors

    /** default constructor */
    public UserDomain() {
    }

    
    /** full constructor */
    public UserDomain(String userName, String email, String password, String type) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.type = type;
    }

   
    // Property accessors

    public Integer getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
   








}
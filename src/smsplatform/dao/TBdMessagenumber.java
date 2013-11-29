package smsplatform.dao;

/**
 * TBdMessagenumber entity. @author MyEclipse Persistence Tools
 */

public class TBdMessagenumber implements java.io.Serializable {

	// Fields

	private TBdMessagenumberId id;

	// Constructors

	/** default constructor */
	public TBdMessagenumber() {
	}

	/** full constructor */
	public TBdMessagenumber(TBdMessagenumberId id) {
		this.id = id;
	}

	// Property accessors

	public TBdMessagenumberId getId() {
		return this.id;
	}

	public void setId(TBdMessagenumberId id) {
		this.id = id;
	}

}
package org.sss.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table
@Component

public class Catagory {
	
	
	private String CID;
	private String CNAME;
	private String CTYPE;
	
	@Id
	@Column(name= "CID")
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCNAME() {
		return CNAME;
	}
	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}
	public String getCTYPE() {
		return CTYPE;
	}
	public void setCTYPE(String cTYPE) {
		CTYPE = cTYPE;
	}
	
	

}

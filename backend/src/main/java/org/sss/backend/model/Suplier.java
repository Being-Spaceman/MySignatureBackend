package org.sss.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "SUPPLIER")
@Component
public class Suplier {

	@Id
	@Column(name= "SID")
	
	private int SID;
	private String SNAME;
	private String SADRESS;
	public int getSID() {
		return SID;
	}
	public void setSID(int id) {
		SID = id;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public String getSADRESS() {
		return SADRESS;
	}
	public void setSADRESS(String sADRESS) {
		SADRESS = sADRESS;
	}
	

}

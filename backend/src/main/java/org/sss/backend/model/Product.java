package org.sss.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "PRODUCT")
@Component
public class Product {

	@Id
	@Column(name="PID")
	private String  PID; 	  	  	  
	private String PNAME;
	private int PQUANTITY;
	private double PPRICE;
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public String getPNAME() {
		return PNAME;
	}
	public void setPNAME(String pNAME) {
		PNAME = pNAME;
	}
	public int getPQUANTITY() {
		return PQUANTITY;
	}
	public void setPQUANTITY(int pQUANTITY) {
		PQUANTITY = pQUANTITY;
	}
	public double getPPRICE() {
		return PPRICE;
	}
	public void setPPRICE(double pPRICE) {
		PPRICE = pPRICE;
	}
	
	
}
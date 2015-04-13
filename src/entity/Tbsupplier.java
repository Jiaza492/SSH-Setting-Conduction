package entity;

import java.util.Set;

/**
 * Tbsupplier entity. @author MyEclipse Persistence Tools
 */

public class Tbsupplier implements java.io.Serializable {

	// Fields

	private int supplierid;
	private String suppliername;
	private String supplierdiscribe;
	private String contact;
	private String telephone;
	private String address;
	private Set<Tbbill> bills;

	// Constructors

	// Property accessors
	
	

	public int getSupplierid() {
		return this.supplierid;
	}

	public Set<Tbbill> getBills() {
		return bills;
	}

	public void setBills(Set<Tbbill> bills) {
		this.bills = bills;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public String getSuppliername() {
		return this.suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public String getSupplierdiscribe() {
		return this.supplierdiscribe;
	}

	public void setSupplierdiscribe(String supplierdiscribe) {
		this.supplierdiscribe = supplierdiscribe;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
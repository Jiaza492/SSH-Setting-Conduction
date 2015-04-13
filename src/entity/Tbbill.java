package entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Tbbill entity. @author MyEclipse Persistence Tools
 */

public class Tbbill implements java.io.Serializable {

	// Fields

	private int billid;
	private Tbsupplier supplier;
	private int commnum;
	private double money;
	private String pay;
	private String commdiscribe;
	private Date time;
	private String commname;
	private String billnum;
	private String communit;

	// Constructors

	// Property accessors

	
	
	public int getBillid() {
		return this.billid;
	}

	public Tbsupplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Tbsupplier supplier) {
		this.supplier = supplier;
	}

	public void setBillid(int billid) {
		this.billid = billid;
	}

	public int getCommnum() {
		return this.commnum;
	}

	public void setCommnum(int commnum) {
		this.commnum = commnum;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getPay() {
		return this.pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getCommdiscribe() {
		return this.commdiscribe;
	}

	public void setCommdiscribe(String commdiscribe) {
		this.commdiscribe = commdiscribe;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCommname() {
		return this.commname;
	}

	public void setCommname(String commname) {
		this.commname = commname;
	}

	public String getBillnum() {
		return this.billnum;
	}

	public void setBillnum(String billnum) {
		this.billnum = billnum;
	}

	public String getCommunit() {
		return this.communit;
	}

	public void setCommunit(String communit) {
		this.communit = communit;
	}

}
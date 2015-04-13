package entity;

/**
 * Tbuser entity. @author MyEclipse Persistence Tools
 */

public class Tbuser implements java.io.Serializable {

	// Fields

	private int userid;
	private String username;
	private String gender;
	private int age;
	private String userphone;
	private String useraddress;
	private String authentity;
	private String password;

	// Constructors

	/** default constructor */

	// Property accessors

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserphone() {
		return this.userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUseraddress() {
		return this.useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getAuthentity() {
		return this.authentity;
	}

	public void setAuthentity(String authentity) {
		this.authentity = authentity;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
package model;

import java.io.Serializable;

public class Account implements Serializable {
	private String id;
	private String pass;
	private String name1;
	private String name2;
	private String email;
	private int postnum;
	private String address1;
	private String address2;
	private String address3;
	private String address4;


	private int telnum;
	private boolean admin;

	public Account(String id, String email,int telnum, String address1, String address2, String address3,String address4) {
		super();
		this.id = id;
		this.email = email;
		this.telnum = telnum;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
	}
	public Account(String id, String email, int postnum, String address1, String address2, String address3, String address4,
			int telnum) {
		super();
		this.id = id;
		this.email = email;
		this.postnum = postnum;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.telnum = telnum;
	}


	public Account(String id, String pass, String name1, String name2, String email, int postnum, String address1,
			String address2, String address3, String address4, int telnum, boolean admin) {
		super();
		this.id = id;
		this.pass = pass;
		this.name1 = name1;
		this.name2 = name2;
		this.email = email;
		this.postnum = postnum;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.telnum = telnum;
		this.admin = admin;
	}

	public Account() {
	}

	public Account(String id, String pass, boolean admin) {
		this.id = id;
		this.pass = pass;
		this.admin = admin;
	}

	public Account(String id, String pass, String name1, String name2, String email, int postnum,
			String address1, String address2, String address3, int telnum, boolean admin) {
		super();
		this.id = id;
		this.pass = pass;
		this.name1 = name1;
		this.name2 = name2;
		this.email = email;
		this.postnum = postnum;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.telnum = telnum;
		this.admin = admin;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPostnum() {
		return postnum;
	}

	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public int getTelnum() {
		return telnum;
	}

	public void setTelnum(int telnum) {
		this.telnum = telnum;
	}
}

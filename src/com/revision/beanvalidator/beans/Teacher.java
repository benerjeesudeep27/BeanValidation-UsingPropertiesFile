package com.revision.beanvalidator.beans;

public class Teacher {
	private String name;
	private int staffId;
	private String qualification;
	private String phoneno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", staffId=" + staffId + ", qualification=" + qualification + ", phoneno="
				+ phoneno + "]";
	}
}

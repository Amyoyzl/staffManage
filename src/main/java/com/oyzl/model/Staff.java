package com.oyzl.model;

public class Staff {
	
	private int id;
	private String name;
	private String job;
	private String phone;
	private String email;
	private Dept dept;
	
	public Staff() {
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", job=" + job + "]";
	}

}

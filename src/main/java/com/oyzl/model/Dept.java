package com.oyzl.model;

import java.util.ArrayList;
import java.util.List;

public class Dept {
	
	int id;
	String title;
	String loc;
	
	List<Staff> staffList = new ArrayList<>();
	public Dept() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Staff> getStaffList() {
		return staffList;
	}
	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

}

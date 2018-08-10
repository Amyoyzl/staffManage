package com.oyzl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyzl.mapper.DeptMapper;
import com.oyzl.mapper.StaffMapper;
import com.oyzl.model.Dept;
import com.oyzl.model.Staff;



/**
 * 业务逻辑：依赖数据访问操作，自动注入
 * @author Amy_oyzl
 *
 * date 2018年6月9日
 */
@Service
public class HrService {
	
	@Autowired
	DeptMapper deptMapper;
	
	@Autowired
	StaffMapper staffMapper;
	
	// 分页查询----------------
	public List<Staff> loadStaffPage(int limit, int offset) {
		return staffMapper.loadByPage(limit,offset);
	}
	
	public int getPage(int limit) {
		int count = staffMapper.getCount();
		return (int) Math.ceil(count/limit);
	}
	// -------------------------
	
	public Dept loadDept(int id) {
		return deptMapper.load(id);
	}
	
	public List<Dept> deptList() {
		return deptMapper.list();
	}
	
	public void addDept(Dept dept) {
		deptMapper.add(dept);
	}
	
	public void removeDept(int id) {
		deptMapper.delete(id);
	}
	
	public void updateDept(Dept dept) {
		deptMapper.update(dept);
	}
	
	/**
	 * 业务逻辑只是简单调用了数据操作
	 * @return
	 */
	public List<Staff> listStaff(){
		return staffMapper.findAll();
	}
	
	public void removeStaff(int id) {
		staffMapper.remove(id);
	}
	
	public void createStaff(Staff s) {
		staffMapper.create(s);
	}
	
	
	public Staff loadStaff(int id) {
		return staffMapper.load(id);
	}
	

	
	public void addStaff(Staff s) {
		staffMapper.add(s);
	}
	
	public void updateStaff(Staff s) {
		staffMapper.update(s);
	}

	public List<Dept> loadInfo() {
		return deptMapper.loadInfo();
	}


	/**
	 * 复杂的，需要多个映射，或者执行多个操作
	 * @param from
	 * @param to
	 * @param n
	 */
//	@Transactional
//	public void transfer(Staff from, Staff to, int n) {
//		// 往交易记录中添加一条数据
//		staffMapper.update(from);
//		staffMapper.update(to);
//		
//	}
	
}

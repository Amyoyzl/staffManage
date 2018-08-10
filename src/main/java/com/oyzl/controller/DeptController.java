package com.oyzl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oyzl.model.Dept;
import com.oyzl.service.HrService;



@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	HrService hrService;
	
	/**
	 * 查找指定Id的部门及员工
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Dept load(@PathVariable int id) {
		return hrService.loadDept(id);
	}
	
//	@GetMapping(
//			value="",
//			consumes = "application/json",  // 从浏览器地址栏禁止访问数据
//			produces="application/json"
//			)
	/**
	 * 查询所有部门信息
	 * @return
	 */
	@GetMapping
	public List<Dept> list(){
		return hrService.deptList();
	}
	
	@GetMapping("/info")
	public List<Dept> info(){
		return hrService.loadInfo();
	}
	
	@PostMapping
	@ResponseBody
	public String add(Dept dept) {
		hrService.addDept(dept);
		return "{msg: 'ok'}";
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		hrService.removeDept(id);
		return "{msg: id}";
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public String update(@PathVariable int id,Dept dept) {
		hrService.updateDept(dept);
		return "{msg: 'ok'}";
	}

}

package com.oyzl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oyzl.model.Staff;
import com.oyzl.service.HrService;

/**
 * 控制器依赖业务逻辑
 * 
 * @author Amy_oyzl
 *
 * date 2018年6月9日
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	HrService hrService;

	@GetMapping
	@ResponseBody   //返回JSON对象
	public List<Staff> list(){
		return hrService.listStaff();
	}
	
	@GetMapping("/page")
	@ResponseBody
	public List<Staff> staffPage(@RequestParam(name="l") int limit, 
			@RequestParam(name="o") int offset){
		return hrService.loadStaffPage(limit,offset);
	}
	
	@GetMapping("/getpage")
	@ResponseBody
	public Integer getPages(@RequestParam(name="l") int limit) {
		return hrService.getPage(limit);
	}
	
	@PostMapping
	@ResponseBody
	public String create(Staff staff) {
		System.out.println("post staff name: " + staff.getName());
		System.out.println("post staff job: " + staff.getJob());
		System.out.println("post staff email: " + staff.getEmail());
		hrService.addStaff(staff);
//		return "redirect:";
		//返回状态码
		return "{msg: 'ok'}";
	}
	
	@PostMapping("/add")
	//@ResponseBody
	public String add(Staff staff) {
		hrService.createStaff(staff);
		return "{msg: 'ok'}";
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String remove(@PathVariable int id) {
		hrService.removeStaff(id);
		return "{msg: id}";
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public String update(@PathVariable int id, Staff s) {
		hrService.updateStaff(s);
		System.out.println(s);
		return "{msg: ok}";
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Staff load(@PathVariable int id) {
		return hrService.loadStaff(id);
	}

}

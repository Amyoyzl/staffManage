package com.oyzl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.oyzl.model.Dept;
import com.oyzl.model.Staff;


@Mapper
public interface DeptMapper {
	
	/**
	 * 查一个部门的信息
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from dept where dept_id=#{id}")
	@Results(value= {
			@Result(column="dept_id", property="id"),
			@Result(column="dept_title", property="title"),
			@Result(column="dept_loc", property="loc"),
			@Result(
					property="staffList",
					javaType=List.class,
					column="dept_id",
					many=@Many(select="findStaffByDept")
					)
	})
	Dept load(int id);
	
	@Select("select * from staff where dept=#{id}")
	List<Staff> findStaffByDept(int id);
	
	/**
	 * 查询部门的所有信息
	 * @return
	 */
	@Select("select * from dept")
	@Results(value= {
			@Result(column="dept_id", property="id"),
			@Result(column="dept_title", property="title"),
			@Result(column="dept_loc", property="loc"),
			@Result(
					property="staffList",
					javaType=List.class,
					column="dept_id",
					many=@Many(select="findStaffByDept")
					)
	})
	List<Dept> list();
	
	@Select("select dept_id,dept_title,dept_loc from dept")
	@Results(value= {
			@Result(column="dept_id", property="id"),
			@Result(column="dept_title", property="title"),
			@Result(column="dept_loc", property="loc")
	})
	List<Dept> loadInfo();
	
	/**
	 * 添加部门
	 * @param dept
	 */
	@Insert("insert into dept(dept_title,dept_loc) values(#{title},#{loc})")
	void add(Dept dept);
	
	/**
	 * 修改
	 * @param dept
	 */
	@Update("update dept set dept_title=#{title},dept_loc=#{loc} where dept_id=#{id}")
	void update(Dept dept);
	
	@Delete("delete from dept where dept_id=#{id}")
	void delete(int id);

}

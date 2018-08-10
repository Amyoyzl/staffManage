package com.oyzl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.oyzl.model.Dept;
import com.oyzl.model.Staff;


@Mapper
public interface StaffMapper {
	// id,name,job,email,phone
	@Select("select * from staff")
	List<Staff> findAll();
	
	@Insert("insert into staff(name,job,email,phone,dept) values(#{name},#{job},#{email},#{phone},#{dept.id})")
	void create(Staff s);
	
	@Insert("insert into staff(name,job,email,phone) values(#{name},#{job},#{email},#{phone})")
	void add(Staff s);
	
	@Delete("delete from staff where id=#{id}")
	void remove(int id);
	
	@Select("select * from staff where id=#{id}")
	@Results(value= {
			@Result(property="id", column="id"),
			@Result(property="name", column="name"),
			@Result(property="job", column="job"),
			@Result(property="phone", column="phone"),
			@Result(property="email", column="email"),
			@Result(
					property="dept", 
					column="dept",
					javaType=Dept.class,
					one=@One(select="loadDeptById", fetchType=FetchType.DEFAULT))
	})
	Staff load(int id);
	
	@Select("select * from staff limit #{limit} offset #{offset}")
	@Results(value= {
			@Result(
					property="dept", 
					column="dept",
					javaType=Dept.class,
					one=@One(select="loadDeptById", fetchType=FetchType.DEFAULT))
	})
	List<Staff> loadByPage(@Param("limit") int limit,@Param("offset") int offset);
	
	@Select("select count(id) from staff")
	int getCount();
	
	@Select("select * from dept where dept_id=#{id}")
	@Results(value= {
			@Result(column="dept_id", property="id"),
			@Result(column="dept_title", property="title"),
			@Result(column="dept_loc", property="loc")
	})
	Dept loadDeptById(int id);
	
	@Update("update staff set job=#{job},phone=#{phone},email=#{email} where id=#{id}")
	void update(Staff s);
	
}

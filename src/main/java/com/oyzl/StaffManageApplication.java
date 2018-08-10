package com.oyzl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.oyzl.mapper")
@SpringBootApplication
public class StaffManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManageApplication.class, args);
	}
}

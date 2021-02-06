package com.myproject.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
	}

	// TODO: implement Exception Handler,
	//		show current logged user account into the header,
	//		add header and maybe footer in fragments,
	//		add error messages handling for login page,
	//		add pagination,
	//		add filters,
	//		fix error message appearance when passwords don't match
}

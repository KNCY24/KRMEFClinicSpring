package com.ISIS.KRMEFClinicSpring;

import com.ISIS.KRMEFClinicSpring.Model.User;
import com.ISIS.KRMEFClinicSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class KrmefClinicSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(KrmefClinicSpringApplication.class, args);
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(KrmefClinicSpringApplication.class);
	}
}

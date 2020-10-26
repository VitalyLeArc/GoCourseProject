package com;

import com.domain.parts.CarBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class GoCourseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoCourseProjectApplication.class, args);
	}

}

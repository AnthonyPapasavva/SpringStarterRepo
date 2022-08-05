package com.qa.starterproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StarterProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StarterProjectApplication.class, args);
//		System.out.println(context.getBean(String.class));

		System.out.println(context.getBean("greeting"));
		System.out.println(context.getBean("farewell"));
		System.out.println(context.getBean("serverTime"));

//		Object byName = context.getBean("serverTime");
//		String byType = context.getBean(String.class);
//		String byBoth = context.getBean("serverTime", String.class);
//
//		System.out.println(byName);
//		System.out.println(byType);
//		System.out.println(byBoth);

		// What is the point of the code from lines 18-24? (From QA Community tutorial)
	}

}

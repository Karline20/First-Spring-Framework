package com.legaspi.learnspringframework.example.a0;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//Usually this classes should be a different file, but as of now to make it simple

//Your business class
@Component
class BusinessClass{
	
	
	Dependency1 dependency1;
	
	Dependency2 dependency2;
	
	
	@Autowired
	public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
			super();
			System.out.println("Constructor Injection - setDependency1");
			this.dependency1 = dependency1;
			System.out.println("Constructor Injection - setDependency2");
			this.dependency2 = dependency2;
		}



//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}



	public String toString() {
		return "Using "+ dependency1 + " and "+ dependency2;
	}
}

//Dependency 1
@Component
class Dependency1{
	
}

//Dependency 2
@Component
class Dependency2{
	
}



@Configuration
@ComponentScan
public class SimpleContextSpringLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = 
			new AnnotationConfigApplicationContext
				(SimpleContextSpringLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessClass.class));
		}
		
	}

}

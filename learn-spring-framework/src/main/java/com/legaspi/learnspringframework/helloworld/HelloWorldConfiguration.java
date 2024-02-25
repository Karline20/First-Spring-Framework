package com.legaspi.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity in creating java beans
//Public accessor methods, constructor
//Equals, hashcode and toString are automatically created.
//Released in JDK 16
record Person (String name, int age, Address address) {
	
}

//Address - firstline & city

record Address(String firstline, String city) {
	
}

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Marx";
	}
	
	@Bean
	public int age() {
		return 24;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Karlen", 25, new Address("Brgy. Hard coded", "Hard coded City"));
		
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address3()); //name, age, address
		
		return person;
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address2) {//name,age,address2 - for address
		var person = new Person(name, age, address2); //name, age, address
		
		return person;
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) {//name,age,address2 - for address
		var person = new Person(name, age, address); //name, age, address
		
		return person;
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {//name,age,address2 - for address
		var person = new Person(name, age, address); //name, age, address
		
		return person;
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address2() {
		var address2 = new Address("Brgy. NBBS Proper", "Navotas City");
		
		return address2;
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address3 = new Address("Barangay 09, Tumalistis Boao", "Catbalogan City");
		
		return address3;
	}



}

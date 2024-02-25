package com.legaspi.learnspringframework.example.c1;

import org.springframework.stereotype.Component;

@Component
public interface DataService {
	
	int[] retrieveData();
	
}

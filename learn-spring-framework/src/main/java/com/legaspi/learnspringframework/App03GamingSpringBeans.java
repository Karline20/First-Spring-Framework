package com.legaspi.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.legaspi.learnspringframework.game.GameRunner;
import com.legaspi.learnspringframework.game.GamingConsole;
import com.legaspi.learnspringframework.game.MarioGame;
import com.legaspi.learnspringframework.game.PacmanGame;
import com.legaspi.learnspringframework.game.SuperContraGame;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		try(var context = 
			new AnnotationConfigApplicationContext
				(GamingConfiguration.class)){
			
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}
		
	}

}

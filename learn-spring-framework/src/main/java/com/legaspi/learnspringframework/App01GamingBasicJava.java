package com.legaspi.learnspringframework;

import com.legaspi.learnspringframework.game.GameRunner;
import com.legaspi.learnspringframework.game.MarioGame;
import com.legaspi.learnspringframework.game.PacmanGame;
import com.legaspi.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		
		var game = new PacmanGame();	//1: Object creation
		
		var gameRunner = new GameRunner(game);		
		//2: Object creation + wiring of Dependencies
		//Game or GamingConsole is a Dependency of GameRunner class
		
		gameRunner.run();

	}

}

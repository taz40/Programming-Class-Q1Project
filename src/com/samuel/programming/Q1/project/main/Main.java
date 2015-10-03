package com.samuel.programming.Q1.project.main;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.Scenes.LostMenu;
import com.samuel.programming.Q1.project.Scenes.MainMenu;
import com.samuel.programming.Q1.project.Scenes.PauseMenu;
import com.samuel.programming.Q1.project.Utils.Timer;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.LightsOut;

public class Main extends LightsOut {
	
	static int width = Reference.width;
	static int height = Reference.height;
	public static Timer timer = new Timer();
	public static GameScene game = new GameScene(width, height, "Level1");
	LostMenu lostMenu = new LostMenu();
	MainMenu mainMenu = new MainMenu();
	PauseMenu pauseMenu = new PauseMenu();
	
	public static void main(String[] args){
		new Main().init();
	}

	protected void init() {
		createDisplay(Reference.projectName + " v. " + Reference.version, width, height);
		start();
	}

	protected void render() {
		screen.clear(0xffc7c7c7);
		if(PlayerValues.Menu == 1){
			game.render(screen);
		}else if(PlayerValues.Menu == 2){
			lostMenu.render(screen);
		}else if(PlayerValues.Menu == 0){
			mainMenu.render(screen);
		}else if(PlayerValues.Menu == 3){
			game.render(screen);
			pauseMenu.render(screen);
		}
		show();
		timer.render();
	}

	protected void update() {
		if(PlayerValues.Menu == 1){
			game.update();
			if(PlayerValues.lives <= 0){
				PlayerValues.Menu = 2;
				Reference.fixedTime = Reference.fixedTimeConstant;
			}
		}else if(PlayerValues.Menu == 2){
			lostMenu.update();
		}else if(PlayerValues.Menu == 0){
			mainMenu.update();
		}else if(PlayerValues.Menu == 3){
			pauseMenu.update();
		}
		timer.update();
	}

}

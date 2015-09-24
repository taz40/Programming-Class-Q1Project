package com.samuel.programming.Q1.project.main;

import io.brace.lightsoutgaming.engine.LightsOut;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.Utils.Timer;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;

public class Main extends LightsOut {
	
	int width = Reference.width;
	int height = Reference.height;
	public static Timer timer = new Timer();
	GameScene game = new GameScene(width, height, "Level1");
	
	public static void main(String[] args){
		new Main().init();
	}

	protected void init() {
		createDisplay(Reference.projectName + " v. " + Reference.version, width, height);
		start();
		PlayerValues.Money = Reference.StartingCash;
	}

	protected void render() {
		screen.clear(0xffc7c7c7);
		game.render(screen);
		show();
		timer.render();
	}

	protected void update() {
		game.update();
		timer.update();
	}

}

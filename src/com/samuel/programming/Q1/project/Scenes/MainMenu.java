package com.samuel.programming.Q1.project.Scenes;

import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.Quit;
import com.samuel.programming.Q1.project.Entities.Button.StandardMode;
import com.samuel.programming.Q1.project.Entities.Button.SurvivalMode;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.graphics.Screen;

public class MainMenu extends Scene {
	
	Button standardMode, survivalMode, quit;
	
	public MainMenu(){
		standardMode = new StandardMode((Reference.width)/2-Reference.tileSize, 200);
		survivalMode = new SurvivalMode((Reference.width)/2-Reference.tileSize, 300);
		quit = new Quit((Reference.width)/2-Reference.tileSize, 400);
	}

	@Override
	public void render(Screen s) {
		standardMode.render(s);
		survivalMode.render(s);
		quit.render(s);
	}

	@Override
	public void update() {
		standardMode.update();
		survivalMode.update();
		quit.update();
	}

}

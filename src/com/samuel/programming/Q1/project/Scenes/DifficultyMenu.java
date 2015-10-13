package com.samuel.programming.Q1.project.Scenes;

import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.QuitToMain;
import com.samuel.programming.Q1.project.Entities.Button.StandardMode;
import com.samuel.programming.Q1.project.Entities.Button.SurvivalMode;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.graphics.Screen;

public class DifficultyMenu extends Scene {
	Button standardMode, survivalMode, back;
	
	public DifficultyMenu(){
		standardMode = new StandardMode((Reference.width)/2-Reference.tileSize, 200);
		survivalMode = new SurvivalMode((Reference.width)/2-Reference.tileSize, 300);
		back = new QuitToMain((Reference.width)/2-Reference.tileSize, 400);
	}

	@Override
	public void render(Screen s) {
		standardMode.render(s);
		survivalMode.render(s);
		back.render(s);
	}

	@Override
	public void update() {
		standardMode.update();
		survivalMode.update();
		back.update();
	}

}

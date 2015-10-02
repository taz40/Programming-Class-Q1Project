package com.samuel.programming.Q1.project.Scenes;

import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.Entities.Button.Button;

public class MainMenu extends Scene {
	
	Button standardMode, survivalMode, backToMain;

	@Override
	public void render(Screen s) {
		standardMode.render(s);
		survivalMode.render(s);
		backToMain.render(s);
	}

	@Override
	public void update() {
		standardMode.update();
		survivalMode.update();
		backToMain.update();
	}

}

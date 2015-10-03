package com.samuel.programming.Q1.project.Scenes;

import com.samuel.programming.Q1.project.Entities.Button.BackToMainMenu;
import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.Retry;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.graphics.Screen;

public class LostMenu extends Scene {
	
	Button retry = new Retry((Reference.width)/2-Reference.tileSize, 300);
	Button back = new BackToMainMenu((Reference.width)/2-Reference.tileSize, 400);

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		retry.render(s);
		back.render(s);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		retry.update();
		back.update();
	}

}

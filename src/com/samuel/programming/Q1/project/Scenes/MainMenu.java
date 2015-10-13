package com.samuel.programming.Q1.project.Scenes;

import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.Multi;
import com.samuel.programming.Q1.project.Entities.Button.Quit;
import com.samuel.programming.Q1.project.Entities.Button.Single;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.graphics.Screen;

public class MainMenu extends Scene {
	
	Button single, multi, quit;
	
	public MainMenu(){
		single = new Single((Reference.width)/2-Reference.tileSize, 200);
		multi = new Multi((Reference.width)/2-Reference.tileSize, 300);
		quit = new Quit((Reference.width)/2-Reference.tileSize, 400);
	}

	@Override
	public void render(Screen s) {
		single.render(s);
		multi.render(s);
		quit.render(s);
	}

	@Override
	public void update() {
		single.update();
		multi.update();
		quit.update();
	}

}

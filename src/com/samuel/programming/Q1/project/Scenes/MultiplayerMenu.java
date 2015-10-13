package com.samuel.programming.Q1.project.Scenes;

import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.Host;
import com.samuel.programming.Q1.project.Entities.Button.Join;
import com.samuel.programming.Q1.project.Entities.Button.QuitToMain;
import com.samuel.programming.Q1.project.references.Reference;

public class MultiplayerMenu extends Scene {

	Button host, join, back;
	
	public MultiplayerMenu(){
		host = new Host((Reference.width)/2-Reference.tileSize, 200);
		join = new Join((Reference.width)/2-Reference.tileSize, 300);
		back = new QuitToMain((Reference.width)/2-Reference.tileSize, 400);
	}

	@Override
	public void render(Screen s) {
		host.render(s);
		join.render(s);
		back.render(s);
	}

	@Override
	public void update() {
		host.update();
		join.update();
		back.update();
	}

}

package com.samuel.programming.Q1.project.Scenes;

import java.awt.event.KeyEvent;

import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.QuitToMain;
import com.samuel.programming.Q1.project.Entities.Button.Resume;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Keyboard;

public class PauseMenu extends Scene {
	
	Button backToGame = new Resume((Reference.width)/2-Reference.tileSize, 200);
	Button quit = new QuitToMain((Reference.width)/2-Reference.tileSize, 300);

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		backToGame.render(s);
		quit.render(s);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		backToGame.update();
		quit.update();
		if(Keyboard.getKey(KeyEvent.VK_ESCAPE)){
			PlayerValues.Menu = 1;
			Keyboard.keys[KeyEvent.VK_ESCAPE] = false;
		}
	}

}

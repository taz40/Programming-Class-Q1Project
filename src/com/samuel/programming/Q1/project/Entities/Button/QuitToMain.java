package com.samuel.programming.Q1.project.Entities.Button;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Mouse;

public class QuitToMain extends Button {

	public QuitToMain(int x, int y) {
		super(x, y, Textures.UI.back);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraw(Screen s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseEnter() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.backH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.back;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		PlayerValues.Menu = 0;
		Mouse.button = 0;
		Main.game = new GameScene(Reference.width, Reference.height, "Level1");
		Reference.fixedTime = Reference.fixedTimeConstant;
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

}

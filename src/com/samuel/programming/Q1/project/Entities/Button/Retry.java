package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Retry extends Button {

	public Retry(int x, int y) {
		super(x, y, Textures.UI.retry);
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
		sprite = Textures.UI.retryH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.retry;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		Main.game = new GameScene(Reference.width, Reference.height, "Level1");
		PlayerValues.Menu = 1;
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub

	}

}

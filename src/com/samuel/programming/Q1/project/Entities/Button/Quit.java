package com.samuel.programming.Q1.project.Entities.Button;

import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;

public class Quit extends Button {

	public Quit(int x, int y) {
		super(x, y, Textures.UI.quit);
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
		sprite = Textures.UI.quitH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.quit;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub

	}

}

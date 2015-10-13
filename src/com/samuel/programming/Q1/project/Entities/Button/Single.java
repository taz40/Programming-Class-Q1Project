package com.samuel.programming.Q1.project.Entities.Button;

import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.input.Mouse;

public class Single extends Button {

	public Single(int x, int y) {
		super(x, y, Textures.UI.single);
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
		sprite = Textures.UI.singleH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.single;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		PlayerValues.players = 1;
		PlayerValues.Menu = 4;
		Mouse.button = 0;
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

}

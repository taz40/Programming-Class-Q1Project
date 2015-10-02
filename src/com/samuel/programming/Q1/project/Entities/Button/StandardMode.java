package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Textures;

public class StandardMode extends Button {

	public StandardMode(int x, int y) {
		super(x, y, Textures.UI.easy);
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
		sprite = Textures.UI.easyH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.easy;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		PlayerValues.Menu = 1;
		PlayerValues.mode = 0;
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

}

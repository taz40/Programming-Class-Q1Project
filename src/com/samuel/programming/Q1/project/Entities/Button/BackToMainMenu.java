package com.samuel.programming.Q1.project.Entities.Button;

import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.graphics.Screen;

public class BackToMainMenu extends Button {

	public BackToMainMenu(int x, int y) {
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
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

}

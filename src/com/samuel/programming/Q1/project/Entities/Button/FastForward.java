package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class FastForward extends Button {

	public FastForward(int x, int y) {
		super(x, y, Textures.UI.ff);
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
		sprite = Textures.UI.ffH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.ff;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		if(Reference.fixedTime == Reference.fixedTimeConstant){
			Reference.fixedTime = Reference.fastTime;
		}else{
			Reference.fixedTime = Reference.fixedTimeConstant;
		}
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

}

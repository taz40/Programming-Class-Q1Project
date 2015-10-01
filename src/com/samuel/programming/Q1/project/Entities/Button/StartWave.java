package com.samuel.programming.Q1.project.Entities.Button;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;

public class StartWave extends Button {

	public StartWave(int x, int y) {
		super(x, y, Textures.UI.startWave);
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
		sprite = Textures.UI.startWaveH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.startWave;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		GameScene.inWave = true;
		GameScene.fastForward.mouseDown = true;
		GameScene.startWave.setActive(false);
		GameScene.fastForward.setActive(true);
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

}

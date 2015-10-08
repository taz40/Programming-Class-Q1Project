package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.Textures;

public class TargetFirst extends Button {
	
	Sprite notSelectedSprite = Textures.UI.first;
	int myMode = 0;
	static Sprite down = Textures.UI.firstH;
	static Sprite up = Textures.UI.first;

	public TargetFirst(int x, int y) {
		super(x, y, down);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		if(GameScene.selected != null && GameScene.selected.targetMode == myMode){
			sprite = down;
		}else{
			sprite = notSelectedSprite;
		}
	}

	@Override
	public void onDraw(Screen s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseEnter() {
		// TODO Auto-generated method stub
		notSelectedSprite = down;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		notSelectedSprite = up;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		GameScene.selected.targetMode = myMode;
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub

	}

}

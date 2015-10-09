package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Upgrade extends Button {
	
	

	public Upgrade(int x, int y) {
		super(x, y, Textures.UI.upgrade);
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
		sprite = Textures.UI.upgradeH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.upgrade;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		if(PlayerValues.Money >= GameScene.selected.upgradeCost){
			PlayerValues.Money -= GameScene.selected.upgradeCost;
			GameScene.selected.cost += Reference.sellPercent*GameScene.selected.upgradeCost;
			GameScene.selected.upgrade();
		}
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub

	}

}

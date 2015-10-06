package com.samuel.programming.Q1.project.Entities.Button;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;
import com.samuel.programming.Q1.project.references.Turrets;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;

public class SellTurret extends Button {

	public SellTurret(int x, int y) {
		super(x, y, Textures.UI.sell);
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
		sprite = Textures.UI.sellH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.sell;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		PlayerValues.Money += GameScene.selected.cost*Reference.sellPercent;
		Turrets.takenTiles[GameScene.selected.x/Reference.tileSize][GameScene.selected.y/Reference.tileSize] = false;
		GameScene.entities.remove(GameScene.selected);
		GameScene.selected = null;
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub

	}

}

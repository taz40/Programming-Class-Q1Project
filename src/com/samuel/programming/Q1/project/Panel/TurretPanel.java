package com.samuel.programming.Q1.project.Panel;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Mouse;

import java.awt.Color;
import java.awt.Font;

import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Entities.TurretBasic;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;
import com.samuel.programming.Q1.project.references.Turrets;

public class TurretPanel extends Panel {
	
	TurretBasic displayTB = new TurretBasic(Reference.width-190, 50);
	Turret selected = null;
	boolean click = false;

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Mouse.button == 1 && !click){
			click = true;
			if(Mouse.clickX >= displayTB.x && Mouse.clickX <= displayTB.x + Reference.tileSize && Mouse.clickY >= displayTB.y && Mouse.clickY <= displayTB.y + Reference.tileSize){
				selected = (Turret) displayTB.clone();
			}else if(Mouse.clickX <= Reference.width-200 && selected != null){
				int mx = ((Mouse.mouseX)/Reference.tileSize)*Reference.tileSize;
				int my = (Mouse.mouseY/Reference.tileSize) * Reference.tileSize;
				if(GameScene.l.sprites[mx/Reference.tileSize][my/Reference.tileSize] == Textures.Void && PlayerValues.Money >= Turrets.basic.cost){
					GameScene.entities.add((Entity) selected.clone());
					PlayerValues.Money -= Turrets.basic.cost;
				}
			}else{
				selected = null;
			}
		}else if(Mouse.button == 0){
			click = false;
		}
		
		if(selected != null){
			selected.x = ((Mouse.mouseX)/Reference.tileSize)*Reference.tileSize;
			selected.y = (Mouse.mouseY/Reference.tileSize) * Reference.tileSize;
		}
		
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(Reference.width-200, 0, Textures.Panels.Turret.bg, false);
		s.renderString(Reference.width-125, 30, "Money: $"+PlayerValues.Money, Color.WHITE, new Font("comic sans ms", Font.PLAIN, 20), false);
		s.renderString(Reference.width-125, 0, "Lives: "+PlayerValues.lives, Color.WHITE, new Font("comic sans ms", Font.PLAIN, 20), false);
		s.renderString(Reference.width-190, 100, "$"+Turrets.basic.cost, Color.WHITE, new Font("comic sans ms", Font.PLAIN, 20), false);
		displayTB.render(s);
		if(selected != null){
			selected.render(s);
		}
	}

}

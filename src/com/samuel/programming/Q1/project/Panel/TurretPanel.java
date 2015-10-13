package com.samuel.programming.Q1.project.Panel;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
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
	
	TurretBasic displayTB = new TurretBasic(Reference.width-190, 70);
	public Turret selected = null;
	boolean click = false;

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Mouse.button == 1 && !click){
			click = true;
			if(Mouse.clickX >= displayTB.x && Mouse.clickX <= displayTB.x + Reference.tileSize && Mouse.clickY >= displayTB.y && Mouse.clickY <= displayTB.y + Reference.tileSize){
				selected = (Turret) displayTB.clone();
			}else if(Mouse.clickX <= Reference.width-240 && selected != null){
				int mx = ((Mouse.mouseX)/Reference.tileSize)*Reference.tileSize;
				int my = (Mouse.mouseY/Reference.tileSize) * Reference.tileSize;
				if(GameScene.l.sprites[mx/Reference.tileSize][my/Reference.tileSize] == Textures.Void && PlayerValues.Money >= Turrets.basic.cost && (!Turrets.takenTiles[mx/Reference.tileSize][my/Reference.tileSize])){
					if(PlayerValues.players == 1)
						GameScene.entities.add((Entity) selected.clone());
					else{
						NetworkUtils.createObject(TurretBasic.class, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
					}
					PlayerValues.Money -= Turrets.basic.cost;
					Turrets.takenTiles[mx/Reference.tileSize][my/Reference.tileSize] = true;
				}else if(Turrets.takenTiles[mx/Reference.tileSize][my/Reference.tileSize]){
					System.out.println("Taken!");
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
		s.renderSprite(Reference.width-240, 0, Textures.Panels.Turret.bg, false);
		s.renderString(Reference.width-230, 30, "Money: $"+PlayerValues.Money, Color.WHITE, Reference.Fonts.ComicSans, false);
		s.renderString(Reference.width-230, 0, "Lives: "+PlayerValues.lives, Color.WHITE, Reference.Fonts.ComicSans, false);
		s.renderString(Reference.width-190, 120, "$"+Turrets.basic.cost, Color.WHITE, Reference.Fonts.ComicSans, false);
		displayTB.render(s);
		if(selected != null){
			selected.render(s);
		}
	}

}

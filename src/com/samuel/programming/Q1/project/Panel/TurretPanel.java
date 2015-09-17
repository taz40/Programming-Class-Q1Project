package com.samuel.programming.Q1.project.Panel;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Mouse;

import com.samuel.programming.Q1.project.Entities.TurretBasic;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;
import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Scenes.GameScene;

public class TurretPanel extends Panel {
	
	TurretBasic displayTB = new TurretBasic(Reference.width-190, 10);
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
				int mx = (Mouse.mouseX-Reference.tileSize/2);
				int my = (Mouse.mouseY-Reference.tileSize/2);
				if(GameScene.l.sprites[mx/Reference.tileSize][my/Reference.tileSize] == Textures.Void && GameScene.l.sprites[(mx+Reference.tileSize)/Reference.tileSize][my/Reference.tileSize] == Textures.Void && GameScene.l.sprites[(mx+Reference.tileSize)/Reference.tileSize][(my+Reference.tileSize)/Reference.tileSize] == Textures.Void && GameScene.l.sprites[mx/Reference.tileSize][(my+Reference.tileSize)/Reference.tileSize] == Textures.Void)
					GameScene.entities.add((Entity) selected.clone());
			}else{
				selected = null;
			}
		}else if(Mouse.button == 0){
			click = false;
		}
		
		if(selected != null){
			selected.x = Mouse.mouseX-Reference.tileSize/2;
			selected.y = Mouse.mouseY-Reference.tileSize/2;
		}
		
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(Reference.width-200, 0, Textures.Panels.Turret.bg, false);
		displayTB.render(s);
		if(selected != null){
			selected.render(s);
		}
	}

}

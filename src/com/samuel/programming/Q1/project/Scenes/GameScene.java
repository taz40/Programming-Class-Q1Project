package com.samuel.programming.Q1.project.Scenes;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Mouse;

import java.awt.Color;
import java.util.ArrayList;

import com.samuel.programming.Q1.project.Entities.Ghost;
import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Entities.TurretBasic;
import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.Reference;

public class GameScene extends Scene {
	
	int width, height;
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	Level l;
	Turret selected;
	
	public GameScene(int width, int height, String levelName){
		this.width = width;
		this.height = height;
		entities.add(new TurretBasic((width/2)-3*8, (height/2)-3*8));
		l = new Level("/Levels/"+levelName);
		entities.add(new Ghost(l.spawnX, l.spawnY, l));

	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		l.render(s);
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
		for(Entity e : entityTmp){
			e.render(s);
		}
		if(selected != null){
			selected.selectedRender(s);
		}
		s.renderString(10, 10, Main.timer.fps + " fps, " + Main.timer.ups + " ups", Color.black, false);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
		for(Entity e : entityTmp){
			e.update();
		}
		if(selected != null){
			selected.selectedUpdate();
		}
		if(Mouse.button == 1){
			Mouse.button = 0;
			selected = null;
			for(Entity e : entities){
				if(e instanceof Turret && Mouse.clickX >= e.x && Mouse.clickX <= e.x+Reference.tileSize && Mouse.clickY >= e.y && Mouse.clickY <= e.y+Reference.tileSize){
					selected = (Turret) e;
					break;
				}
			}
		}
	}

}

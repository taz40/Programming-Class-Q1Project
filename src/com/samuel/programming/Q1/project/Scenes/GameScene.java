package com.samuel.programming.Q1.project.Scenes;

import java.awt.Color;
import java.util.ArrayList;

import com.samuel.programming.Q1.project.Entities.Ghost;
import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.Utils.Timer;
import com.samuel.programming.Q1.project.main.Main;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class GameScene extends Scene {
	
	int width, height;
	Turret t;
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	Level l;
	
	public GameScene(int width, int height, String levelName){
		this.width = width;
		this.height = height;
		t = new Turret((width/2)-3*8, (height/2)-3*8);
		l = new Level("/Levels/"+levelName);
		entities.add(new Ghost(l.spawnX, l.spawnY, l));
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		l.render(s);
		t.render(s);
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
		for(Entity e : entityTmp){
			e.render(s);
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
		t.update();
	}

}

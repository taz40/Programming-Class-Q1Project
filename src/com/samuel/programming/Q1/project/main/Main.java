package com.samuel.programming.Q1.project.main;

import java.awt.Color;
import java.util.ArrayList;

import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.Utils.Timer;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.LightsOut;

public class Main extends LightsOut {
	
	int width = 900;
	int height = (int) (width * Reference.aspectRatio);
	Turret t = new Turret((width/2)-3*8, (height/2)-3*8);
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	Timer timer = new Timer();
	Level l = new Level("/Levels/Level1.png");
	
	public static void main(String[] args){
		new Main().init();
	}

	protected void init() {
		createDisplay(Reference.projectName + " v. " + Reference.version, width, height);
		start();
	}

	protected void render() {
		screen.clear(0xffc7c7c7);
		l.render(screen);
		t.render(screen);
		for(Entity e : entities){
			e.render(screen);
		}
		screen.renderString(10, 10, timer.fps + " fps, " + timer.ups + " ups", Color.black, false);
		show();
		timer.render();
	}

	protected void update() {
		for(Entity e : entities){
			e.update();
		}
		t.update();
		timer.update();
	}

}

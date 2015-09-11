package com.samuel.programming.Q1.project.main;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.LightsOut;

import java.util.ArrayList;

import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.references.Reference;

public class Main extends LightsOut {
	
	float aspectRatio = 9f/16f;
	int width = 900;
	int height = (int) (width * aspectRatio);
	Turret t = new Turret();
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public static void main(String[] args){
		new Main().init();
	}

	protected void init() {
		createDisplay(Reference.projectName + " v. " + Reference.version, width, height);
		start();
	}

	protected void render() {
		screen.clear(0xffc7c7c7);
		t.render(screen);
		for(Entity e : entities){
			e.render(screen);
		}
		show();
	}

	protected void update() {
		for(Entity e : entities){
			e.update();
		}
		t.update();
	}

}

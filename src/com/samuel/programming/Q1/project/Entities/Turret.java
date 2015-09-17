package com.samuel.programming.Q1.project.Entities;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.input.Mouse;

import com.samuel.programming.Q1.project.Entities.Projectiles.Bullet;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.Textures;

public abstract class Turret extends Entity {
	
	int range;
	
	public Turret(int x, int y, int range){
		this.x = x;
		this.y = y;
		this.range = range;
	}
	
	public double distance(Entity e){
		return Math.sqrt(Math.abs(e.y - y)*Math.abs(e.y - y) + Math.abs(e.x - x)*Math.abs(e.x - x));
	}

	public abstract void update();

	public abstract void render(Screen s);
	
	public abstract void Shoot();
	
	public abstract void selectedRender(Screen s);
	
	public abstract void selectedUpdate();
	
	public abstract Object clone();

}

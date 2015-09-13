package com.samuel.programming.Q1.project.Entities.Projectiles;

import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class Bullet extends Entity {
	
	float mx, my;
	float angle;
	float x, y;
	
	public Bullet(int x, int y, float mx, float my, float angle){
		this.x = x;
		this.y = y;
		this.mx = mx;
		this.my = my;
		this.angle = angle;
	}

	public void update() {
		// TODO Auto-generated method stub
		x += mx*(1f/60f);
		y += my*(1f/60f);
	}

	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite((int)x, (int)y, Textures.Entities.Projectiles.bullet.rotate(angle), true);
	}

}
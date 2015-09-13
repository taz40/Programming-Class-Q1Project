package com.samuel.programming.Q1.project.Entities;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.input.Mouse;

import com.samuel.programming.Q1.project.Entities.Projectiles.Bullet;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.Textures;

public class Turret extends Entity {
	
	float speed = 100.0f;
	
	public Turret(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void update() {
		// TODO Auto-generated method stub
		if(Mouse.button == 1){
			Mouse.button = 0;
			Shoot();
		}
	}

	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(x, y, Textures.Entities.Turret.base, true);
		Sprite turretRot = Textures.Entities.Turret.turret.rotate(Math.toDegrees(Math.atan2(y-Mouse.mouseY, x-Mouse.mouseX))+180);
		s.renderSprite(x,y,turretRot,true);
	}
	
	public void Shoot(){
		double angle = Math.atan2(y-Mouse.mouseY, x-Mouse.mouseX)+Math.PI;
		Main.entities.add(new Bullet(x,y,speed * (float)Math.cos(angle),speed*(float)Math.sin(angle),(float)Math.toDegrees(angle)));
	}

}

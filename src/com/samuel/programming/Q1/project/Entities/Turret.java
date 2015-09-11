package com.samuel.programming.Q1.project.Entities;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.input.Mouse;

import com.samuel.programming.Q1.project.Entities.Projectiles.Bullet;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.Textures;

public class Turret extends Entity {
	
	float speed = 10.0f;

	public void update() {
		// TODO Auto-generated method stub
		if(Mouse.button == 1){
			Mouse.button = 0;
			Shoot();
		}
	}

	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(10, 10, Textures.Entities.Turret.base, true);
		Sprite turretRot = Textures.Entities.Turret.turret.rotate(Math.toDegrees(Math.atan2(10-Mouse.mouseY, 10-Mouse.mouseX))+180);
		s.renderSprite(10,10,turretRot,true);
	}
	
	public void Shoot(){
		System.out.println("Bang");
		double angle = Math.atan2(10-Mouse.mouseY, 10-Mouse.mouseX)+Math.PI;
		Main.entities.add(new Bullet(10,10,speed * (float)Math.cos(angle),speed*(float)Math.sin(angle),(float)Math.toDegrees(angle)));
	}

}

package com.samuel.programming.Q1.project.Entities.Projectiles;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.samuel.programming.Q1.project.Entities.Ghost;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Bullet extends Entity {
	
	float mx, my;
	float angle;
	float x, y;
	float timer = 0;
	float lifeTime = 10;
	int dmg;
	
	public Bullet(int x, int y, float mx, float my, float angle, float dmg){
		this.x = x;
		this.y = y;
		this.mx = mx;
		this.my = my;
		this.angle = angle;
		this.dmg = (int)dmg;
	}

	public void update() {
		// TODO Auto-generated method stub
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)GameScene.entities.clone();
		for(Entity e : entityTmp){
			if(e instanceof Ghost){
				Rectangle rect = new Rectangle((int)x, (int)y, Reference.tileSize, Reference.tileSize);
				Rectangle rect2 = new Rectangle((int)e.x, (int)e.y, Reference.tileSize, Reference.tileSize);
				if(rect.intersects(rect2)){
					((Ghost) e).doDmg(dmg);
					GameScene.entities.remove(this);
				}
			}
		}
		if(timer >= lifeTime){
			GameScene.entities.remove(this);
		}else{
			timer += Reference.fixedTime;
		}
		x += mx*Reference.fixedTime;
		y += my*Reference.fixedTime;
	}

	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite((int)x, (int)y, Textures.Entities.Projectiles.bullet.rotate(angle), true);
	}

}

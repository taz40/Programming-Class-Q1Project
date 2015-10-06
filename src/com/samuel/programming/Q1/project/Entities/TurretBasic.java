package com.samuel.programming.Q1.project.Entities;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;

import com.samuel.programming.Q1.project.Entities.Projectiles.Bullet;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;
import com.samuel.programming.Q1.project.references.Turrets;

public class TurretBasic extends Turret {

	float speed = 200.0f;
	double angle = 0;
	float coolDown = 1;
	float timer = 0;
	
	public TurretBasic(int x, int y){
		super(x, y, Turrets.basic.range*Reference.tileSize, Turrets.basic.dmg);
		cost += Turrets.basic.cost;
	}

	public void update() {
		// TODO Auto-generated method stub
		Ghost target = null;
		for(Entity e : GameScene.entities){
			if(e instanceof Ghost){
				if((target == null || ((Ghost)e).tilesTraveled > target.tilesTraveled) && distance(e) <= range)
					target = (Ghost)e;
			}
		}
		if(target != null){
			angle = Math.atan2((y+8*3)-(target.y+8*3), (x+8*3)-(target.x+8*3))+Math.PI;
		}
		if(timer <= 0){
			if(target != null){
				Shoot();
				timer = coolDown;
			}
		}else{
			timer -= Reference.fixedTime;
		}
	}

	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(x, y, Textures.Entities.Turret.base, true);
		Sprite turretRot = Textures.Entities.Turret.turret.rotate(Math.toDegrees(angle));
		s.renderSprite(x,y,turretRot,true);
	}
	
	public void Shoot(){
		GameScene.entities.add(new Bullet(x,y,speed * (float)Math.cos(angle),speed*(float)Math.sin(angle),(float)Math.toDegrees(angle), dmg));
	}

	@Override
	public void selectedRender(Screen s) {
		
	}

	@Override
	public void selectedUpdate() {
		
	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return new TurretBasic(x, y);
	}
}

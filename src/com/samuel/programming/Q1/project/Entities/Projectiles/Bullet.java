package com.samuel.programming.Q1.project.Entities.Projectiles;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.samuel.programming.Q1.project.Entities.Ghost;
import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Bullet extends Networked {
	
	public float mx, my;
	public float angle;
	public float x, y;
	float timer = 0;
	float lifeTime = 10;
	public int dmg;
	public Turret srcTurret;
	public boolean hit;
	public boolean dead;
	
	public Bullet(int x, int y, float mx, float my, float angle, float dmg, Turret src){
		this.x = x;
		this.y = y;
		this.mx = mx;
		this.my = my;
		this.angle = angle;
		this.dmg = (int)dmg;
		srcTurret = src;
	}
	
	public Bullet(){
		this(-100,-100,0,0,0,0,null);
	}

	public void update() {
		// TODO Auto-generated method stub
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)GameScene.entities.clone();
		for(Entity e : entityTmp){
			if(e instanceof Ghost){
				Rectangle rect = new Rectangle((int)x, (int)y, Reference.tileSize, Reference.tileSize);
				Rectangle rect2 = new Rectangle((int)e.x, (int)e.y, Reference.tileSize, Reference.tileSize);
				if(rect.intersects(rect2)){
					((Ghost) e).doDmg(dmg, srcTurret);
					GameScene.entities.remove(this);
				}
			}
		}
		if(timer >= lifeTime){
			if(PlayerValues.players == 1){
				GameScene.entities.remove(this);
			}else{
				NetworkUtils.removeObject(this, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
			}
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

	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		return new String[]{x+"", y+"", angle+"", dmg+""};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		try{
			x = Float.parseFloat(data[0]);
			y = Float.parseFloat(data[1]);
			angle = Float.parseFloat(data[2]);
			dmg = Integer.parseInt(data[3]);
		}catch(Exception e){
			
		}
	}

}

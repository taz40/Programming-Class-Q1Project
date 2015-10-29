package com.samuel.programming.Q1.project.Entities;

import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

import java.util.Random;

import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.Utils.MultiplayerDataSync;
import com.samuel.programming.Q1.project.references.Enemies;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Ghost extends Networked {
	
	public int tilesTraveled = 0;
	
	Level l;
	int tileX, tileY;
	public float speed = Enemies.Ghost.speed;
	float x, y;
	float nextX, nextY;
	public int health;
	public Turret lastTurret;
	public boolean dead = false;
	
	boolean passable[][];
	
	public Ghost(){
		this(GameScene.l.spawnX, GameScene.l.spawnY, GameScene.l,Enemies.Ghost.health + ((GameScene.levelCount-1)*Enemies.Ghost.healthMod) + new Random().nextInt(21)-10);
	}
	
	public Ghost(int x, int y, Level l, int health){
		tileX = x;
		tileY = y;
		this.x = x*3*16;
		this.y = y*3*16;
		this.l = l;
		this.health = health;
		passable = new boolean[l.width][l.height];
		nextX = (tileX*3*16);
		nextY = (tileY*3*16);
		for(int mx = 0; mx < l.width; mx++){
			for(int my = 0; my < l.height; my++){
				passable[mx][my] = l.sprites[mx][my] != Textures.Void;
			}
		}
	}
	
	public void doDmg(int amount, Turret t){
		health -= amount;
		lastTurret = t;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Math.abs(x-nextX) <= 5f && Math.abs(y-nextY) <= 5f){
			if(tileX < l.width-1 && passable[tileX+1][tileY]){
				passable[tileX][tileY] = false;
				tileX++;
				tilesTraveled++;
			}else if(tileX > 0 && passable[tileX-1][tileY]){
				passable[tileX][tileY] = false;
				tileX--;
				tilesTraveled++;
			}else if(tileY < l.height-1 && passable[tileX][tileY+1]){
				passable[tileX][tileY] = false;
				tileY++;
				tilesTraveled++;
			}else if(tileY > 0 && passable[tileX][tileY-1]){
				passable[tileX][tileY] = false;
				tileY--;
				tilesTraveled++;
			}
			nextX = (tileX*3*16);
			nextY = (tileY*3*16);
		}
		
		if(x > nextX){
			x -= speed*Reference.fixedTime;
		}
		if(x < nextX){
			x += speed*Reference.fixedTime;
		}
		if(y > nextY){
			y -= speed*Reference.fixedTime;
		}
		if(y < nextY){
			y += speed*Reference.fixedTime;
		}
		super.x = (int)x;
		super.y = (int)y;
		if(!dead){
			if(health <= 0){
				GameScene.enemiesLiving--;
				destroy();
				PlayerValues.Money += Enemies.Ghost.money;
				if(PlayerValues.players == 2)
					MultiplayerDataSync.moneydiff += Enemies.Ghost.money;
				if(lastTurret != null && PlayerValues.players == 1)
					lastTurret.killAmount++;
			}
			if(Math.abs((x/Reference.tileSize) - l.endX) <= .5 && Math.abs((y/Reference.tileSize) - l.endY) <= .5){
				GameScene.enemiesLiving--;
				destroy();
				PlayerValues.lives--;
			}
		}else{
			destroy();
		}
	}
	
	public void destroy(){
		dead = true;
		if(PlayerValues.players == 1){
			GameScene.entities.remove(this);
		}else{
			NetworkUtils.removeObject(this, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
		}
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite((int)x, (int)y, Textures.Enemies.ghost, true);
	}

	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		return new String[]{x+"", y+"", health+"", tilesTraveled+""};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		x = Float.parseFloat(data[0]);
		y = Float.parseFloat(data[1]);
		super.x = (int)x;
		super.y = (int)y;
		health = Integer.parseInt(data[2]);
		tilesTraveled = Integer.parseInt(data[3]);
	}

}

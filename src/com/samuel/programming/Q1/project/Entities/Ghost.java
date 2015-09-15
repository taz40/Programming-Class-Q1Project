package com.samuel.programming.Q1.project.Entities;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.references.Textures;

public class Ghost extends Entity {
	
	Level l;
	int tileX, tileY;
	float speed = 50;
	float x, y;
	float nextX, nextY;
	
	boolean passable[][];
	
	public Ghost(int x, int y, Level l){
		tileX = x;
		tileY = y;
		this.x = x*3*16;
		this.y = y*3*16;
		this.l = l;
		passable = new boolean[l.width][l.height];
		nextX = (tileX*3*16);
		nextY = (tileY*3*16);
		for(int mx = 0; mx < l.width; mx++){
			for(int my = 0; my < l.height; my++){
				passable[mx][my] = l.sprites[mx][my] != Textures.Void;
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Math.abs(x-nextX) <= 1f && Math.abs(y-nextY) <= 1f){
			if(tileX < l.width-1 && passable[tileX+1][tileY]){
				passable[tileX][tileY] = false;
				tileX++;
			}else if(tileX > 0 && passable[tileX-1][tileY]){
				passable[tileX][tileY] = false;
				tileX--;
			}else if(tileY < l.height-1 && passable[tileX][tileY+1]){
				passable[tileX][tileY] = false;
				tileY++;
			}else if(tileY > 0 && passable[tileX][tileY-1]){
				passable[tileX][tileY] = false;
				tileY--;
			}
			nextX = (tileX*3*16);
			nextY = (tileY*3*16);
		}
		
		if(x > nextX){
			x -= speed*(1f/60f);
		}
		if(x < nextX){
			x += speed*(1f/60f);
		}
		if(y > nextY){
			y -= speed*(1f/60f);
		}
		if(y < nextY){
			y += speed*(1f/60f);
		}
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite((int)x, (int)y, Textures.Enemies.ghost, true);
	}

}

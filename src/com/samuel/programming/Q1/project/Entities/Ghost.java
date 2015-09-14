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
	
	boolean passable[][];
	
	public Ghost(int x, int y, Level l){
		tileX = x;
		tileY = y;
		this.x = x*3*16;
		this.y = y*3*16;
		this.l = l;
		passable = new boolean[l.width][l.height];
		for(int mx = 0; mx < l.width; mx++){
			for(int my = 0; my < l.height; my++){
				passable[mx][my] = l.sprites[mx][my] != Textures.Void;
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(tileX < l.width-1 && passable[tileX+1][tileY]){
			x += speed*(1f/60f);
		}
		if(tileX > 0 && passable[tileX-1][tileY]){
			x -= speed*(1f/60f);
		}
		if(tileY < l.height-1 && passable[tileX][tileY+1]){
			y += speed*(1f/60f);
		}
		if(tileY > 0 && passable[tileX][tileY-1]){
			y -= speed*(1f/60f);
		}
		passable[tileX][tileY] = false;
		tileX = Math.round(((x+3*8)/(3f*16f)));
		tileY = Math.round(((y+3*8)/(3f*16f)));
		System.out.println(tileX + ", " + tileY);
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite((int)x, (int)y, Textures.Enemies.ghost, true);
	}

}

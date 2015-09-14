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
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(tileX < l.width-1 && l.sprites[tileX+1][tileY] != Textures.Void){
			x += speed*(1f/60f);
		}
		if(tileX > 0 && l.sprites[tileX-1][tileY] != Textures.Void){
			x -= speed*(1f/60f);
		}
		if(tileY < l.height-1 && l.sprites[tileX][tileY+1] != Textures.Void){
			y += speed*(1f/60f);
		}
		if(tileY > 0 && l.sprites[tileX][tileY-1] != Textures.Void){
			y -= speed*(1f/60f);
		}
		tileX = (int) (x/3f/16f);
		tileY = (int) (y/3f/16f);
		System.out.println(tileX + ", " + tileY);
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite((int)x, (int)y, Textures.Enemies.ghost, true);
	}

}

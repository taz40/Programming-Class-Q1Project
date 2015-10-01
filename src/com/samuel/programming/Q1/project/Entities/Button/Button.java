package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.input.Mouse;

public abstract class Button extends Entity {
	
	protected boolean mouseIn = false, mouseDown = false;
	protected int x, y, width, height;
	
	protected Sprite sprite;
	
	protected boolean active = true;
	
	public void setActive(boolean active){
		this.active = active;
	}
	
	public Button(int x, int y, Sprite s){
		this.x = x;
		this.y = y;
		this.sprite = s;
		this.width = s.width;
		this.height = s.height;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(active){
			if(mouseIn){
				int mx = Mouse.mouseX;
				int my = Mouse.mouseY;
				if(mx < x || mx > x+width || my < y || my > y+height){
					mouseIn = false;
					onMouseExit();
				}
			}else{
				int mx = Mouse.mouseX;
				int my = Mouse.mouseY;
				if(mx >= x && mx <= x+width && my >= y && my <= y+height){
					mouseIn = true;
					onMouseEnter();
				}
			}
			
			if(mouseDown){
				int mx = Mouse.mouseX;
				int my = Mouse.mouseY;
				if(Mouse.button != 1){
					mouseDown = false;
					onMouseUp();
				}
			}else{
				int mx = Mouse.mouseX;
				int my = Mouse.mouseY;
				if(Mouse.button == 1 && mouseIn){
					mouseDown = true;
					onMouseDown();
				}
			}
			
			onUpdate();
		}
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		if(active){
			s.renderSprite(x, y, sprite, false);
			onDraw(s);
		}
	}
	
	public abstract void onUpdate();
	public abstract void onDraw(Screen s);
	
	public abstract void onMouseEnter();
	public abstract void onMouseExit();
	public abstract void onMouseDown();
	public abstract void onMouseUp();
	

}

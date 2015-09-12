package com.samuel.programming.Q1.project.Utils;

public class Timer {
	
	public int fps;
	public int ups;
	
	int frames;
	int updates;
	
	long renderTimer = 0;
	long updateTimer = 0;
	
	long lastRender = 0;
	long lastUpdate = 0;
	
	public Timer(){
		lastRender = System.currentTimeMillis();
		lastUpdate = System.currentTimeMillis();
	}
	
	public void render(){
		frames++;
		long now = System.currentTimeMillis();
		if(renderTimer >= 1000){
			renderTimer = 0;
			fps = frames;
			frames = 0;
		}else{
			renderTimer += now - lastRender;
		}
		lastRender = now;
	}
	
	public void update(){
		updates++;
		long now = System.currentTimeMillis();
		if(updateTimer >= 1000){
			updateTimer = 0;
			ups = updates;
			updates = 0;
		}else{
			updateTimer += now - lastUpdate;
		}
		lastUpdate = now;
	}
}

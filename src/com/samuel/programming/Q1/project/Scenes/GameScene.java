package com.samuel.programming.Q1.project.Scenes;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Mouse;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import com.samuel.programming.Q1.project.Entities.Ghost;
import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Entities.TurretBasic;
import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.Panel.Panel;
import com.samuel.programming.Q1.project.Panel.TurretPanel;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.Reference;

public class GameScene extends Scene {
	
	int width, height;
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Level l;
	Turret selected;
	Panel turretPanel = new TurretPanel();
	boolean click = false;
	int waveCount = 0;
	int enemyCount = 0;
	int waves = 3;
	int eperwave = 5;
	float waveTimer = 0;
	float timeBetweenWaves = 5;
	float timeBetweenLevels = 10;
	float levelTimer = 0;
	float timeBetweenSpawns = .5f;
	float spawnTimer = 0;
	
	public GameScene(int width, int height, String levelName){
		this.width = width;
		this.height = height;
		entities.add(new TurretBasic((width/2)-3*8, (height/2)-3*8));
		l = new Level("/Levels/"+levelName);

	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		l.render(s);
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
		for(Entity e : entityTmp){
			e.render(s);
		}
		if(selected != null){
			selected.selectedRender(s);
		}
		turretPanel.render(s);
		s.renderString(10, 10, Main.timer.fps + " fps, " + Main.timer.ups + " ups", Color.black, false);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(levelTimer <= 0){
			if(waveCount < waves && waveTimer <= 0){
				if(spawnTimer <= 0 && enemyCount < eperwave){
					entities.add(new Ghost(l.spawnX, l.spawnY, l, 20));
					spawnTimer = timeBetweenSpawns;
					enemyCount ++;
				}else if(spawnTimer > 0){
					spawnTimer -= Reference.fixedTime;
				}
				if(enemyCount >= eperwave){
					waveCount ++;
					enemyCount = 0;
					waveTimer = timeBetweenWaves;
				}
			}else if(waveTimer > 0){
				waveTimer -= Reference.fixedTime;
			}
			if(waveCount >= waves){
				waves = 0;
				levelTimer = timeBetweenLevels;
			}
		}else{
			levelTimer -= Reference.fixedTime;
			if(levelTimer <= 0){
				if(eperwave == 15){
					eperwave = 5;
					waves++;
				}else{
					eperwave += 5;
				}
			}
		}
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
		for(Entity e : entityTmp){
			e.update();
		}
		if(selected != null){
			selected.selectedUpdate();
		}
		if(Mouse.button == 1 && !click){
			click = true;
			selected = null;
			for(Entity e : entities){
				if(e instanceof Turret && Mouse.clickX >= e.x && Mouse.clickX <= e.x+Reference.tileSize && Mouse.clickY >= e.y && Mouse.clickY <= e.y+Reference.tileSize){
					selected = (Turret) e;
					break;
				}
			}
		}else if(Mouse.button == 0){
			click = false;
		}
		turretPanel.update();
	}

}

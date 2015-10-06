package com.samuel.programming.Q1.project.Scenes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import com.samuel.programming.Q1.project.Entities.Ghost;
import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.FastForward;
import com.samuel.programming.Q1.project.Entities.Button.StartWave;
import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.Panel.TurretInfoPanel;
import com.samuel.programming.Q1.project.Panel.TurretPanel;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.Enemies;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Keyboard;
import io.brace.lightsoutgaming.engine.input.Mouse;

public class GameScene extends Scene {
	
	static int width;
	static int height;
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Level l;
	Turret selected;
	TurretPanel turretPanel = new TurretPanel();
	boolean click = false;
	public static int levelCount = 0;
	int waveCount = 0;
	int enemyCount = 0;
	public static int waves = 3;
	public static int eperwave = 5;
	public static boolean inWave = false;
	//boolean ff = false;
	float timeBetweenWaves = 2;
	float waveTimer = 0;
	float timeBetweenSpawns = .5f;
	float spawnTimer = 0;
	boolean clicked = false;
	public static int enemiesLiving = 0;
	public static Button startWave;
	public static Button fastForward;
	TurretInfoPanel info = new TurretInfoPanel();
	
	public GameScene(int width, int height, String levelName){
		this.width = width;
		this.height = height;
		l = new Level("/Levels/"+levelName);
		PlayerValues.Money = Reference.StartingCash;
		PlayerValues.lives = Reference.startingLives;
		entities = new ArrayList<Entity>();
		startWave = new StartWave(width - 190, height -100);
		fastForward = new FastForward(width - 190, height - 100);
		fastForward.setActive(false);
		entities.add(fastForward);
		entities.add(startWave);
		inWave = false;
		enemiesLiving = 0;
		levelCount = 0;
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		l.render(s);
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
		turretPanel.render(s);
		for(Entity e : entityTmp){
			e.render(s);
		}
		s.renderString(10, 10, Main.timer.fps + " fps, " + Main.timer.ups + " ups", Color.black, false);
		if(selected != null){
			selected.selectedRender(s);
			info.render(s);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Keyboard.getKey(KeyEvent.VK_ESCAPE)){
			PlayerValues.Menu = 3;
			Keyboard.keys[KeyEvent.VK_ESCAPE] = false;
		}
		if(PlayerValues.mode == 0){
			if(inWave){
				if(waveCount < waves && waveTimer <= 0){
					if(spawnTimer <= 0 && enemyCount < eperwave){
						Ghost lastEnemy = new Ghost(l.spawnX, l.spawnY, l,Enemies.Ghost.health + ((levelCount-1)*Enemies.Ghost.healthMod) + new Random().nextInt(21)-10);
						entities.add(lastEnemy);
						enemiesLiving++;
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
					if(enemiesLiving <= 0){
						waveCount = 0;
						enemiesLiving = 0;
						Reference.fixedTime = Reference.fixedTimeConstant;
						inWave = false;
						fastForward.setActive(false);
						startWave.setActive(true);
					}
				}
			}
		}else if(PlayerValues.mode == 1 && inWave){
			if(spawnTimer <= 0){
				Ghost lastEnemy = new Ghost(l.spawnX, l.spawnY, l,Enemies.Ghost.health + ((enemyCount/20)*Enemies.Ghost.healthMod) + new Random().nextInt(21)-10);
				entities.add(lastEnemy);
				enemiesLiving++;
				spawnTimer = timeBetweenSpawns;
				enemyCount ++;
			}else if(spawnTimer > 0){
				spawnTimer -= Reference.fixedTime;
			}
		}
		ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
		for(Entity e : entityTmp){
			e.update();
		}
		if(selected != null){
			selected.selectedUpdate();
			info.update();
		}
		if(Mouse.button == 1 && !click && turretPanel.selected == null){
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
		System.out.println(entities.size());
	}

}

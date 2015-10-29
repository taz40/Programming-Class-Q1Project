package com.samuel.programming.Q1.project.Scenes;

import io.brace.lightsoutgaming.engine.Entity;
import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Keyboard;
import io.brace.lightsoutgaming.engine.input.Mouse;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import com.samuel.programming.Q1.project.Entities.Ghost;
import com.samuel.programming.Q1.project.Entities.Turret;
import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.FastForward;
import com.samuel.programming.Q1.project.Entities.Button.StartWave;
import com.samuel.programming.Q1.project.Entities.Projectiles.Bullet;
import com.samuel.programming.Q1.project.Level.Level;
import com.samuel.programming.Q1.project.Panel.TurretInfoPanel;
import com.samuel.programming.Q1.project.Panel.TurretPanel;
import com.samuel.programming.Q1.project.Utils.MultiplayerDataSync;
import com.samuel.programming.Q1.project.Utils.MultiplayerDataSyncClient;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Turrets;

public class GameScene extends Scene {
	
	static int width;
	static int height;
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	public static Level l;
	public static Turret selected;
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
		PlayerValues.Money = Reference.StartingCash;
		if(PlayerValues.mode == 1)
			PlayerValues.Money *= 2;
		if(PlayerValues.players == 1){
			l = new Level("/Levels/"+levelName);
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
			Turrets.takenTiles = new boolean[100][100];
		}else{
			if(PlayerValues.host){
				NetworkUtils.createObject(Level.class, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
				NetworkUtils.createObject(MultiplayerDataSync.class, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
			}else{
				NetworkUtils.createObject(MultiplayerDataSyncClient.class, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
			}
		}
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		if(PlayerValues.players == 1){
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
		}else{
			if(selected != null){
				selected.selectedRender(s);
				info.render(s);
			}
			try{
				
				ArrayList<Networked> entities = new ArrayList<Networked>();
				
				if(PlayerValues.host){
					entities.addAll(NetworkUtils.myObjects);
					entities.addAll(NetworkUtils.networkObjects);
				}else{
					entities.addAll(NetworkUtils.networkObjects);
					entities.addAll(NetworkUtils.myObjects);
				}
				
				for(Entity e : entities){
					e.render(s);
				}
			}catch(ConcurrentModificationException e){
				
			}
			if(selected != null){
				selected.selectedRender(s);
				info.render(s);
			}
			turretPanel.render(s);
			startWave.render(s);
			fastForward.render(s);
			s.renderString(10, 10, Main.timer.fps + " fps, " + Main.timer.ups + " ups", Color.black, false);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Keyboard.getKey(KeyEvent.VK_ESCAPE)){
			PlayerValues.Menu = 3;
			Keyboard.keys[KeyEvent.VK_ESCAPE] = false;
		}
		if(PlayerValues.players == 2 && PlayerValues.host){
			ArrayList<Networked> entities = new ArrayList<Networked>();
			entities.addAll(NetworkUtils.myObjects);
			entities.addAll(NetworkUtils.networkObjects);
			for(Networked b1 : entities){
				if(b1 instanceof Bullet){
					Bullet b = (Bullet)b1;
					for(Networked e : entities){
						if(e instanceof Ghost){
							Rectangle rect = new Rectangle((int)b.x, (int)b.y, Reference.tileSize, Reference.tileSize);
							Rectangle rect2 = new Rectangle((int)e.x, (int)e.y, Reference.tileSize, Reference.tileSize);
							if(rect.intersects(rect2) && !b.dead){
								((Ghost) e).doDmg(b.dmg, b.srcTurret);
								NetworkUtils.removeObject(b, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
								b.dead = true;
							}
						}
					}
				}
			}
		}
		if(PlayerValues.mode == 0 && PlayerValues.host){
			if(inWave){
				if(waveCount < waves && waveTimer <= 0){
					if(spawnTimer <= 0 && enemyCount < eperwave){
						Ghost lastEnemy = new Ghost();
						if(PlayerValues.players == 1)
							entities.add(lastEnemy);
						else
							NetworkUtils.createObject(Ghost.class, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
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
						PlayerValues.Money += Reference.moneyPerRound;
						if(PlayerValues.players == 2){
							MultiplayerDataSync.inWave = false;
							MultiplayerDataSync.ff = false;
							MultiplayerDataSync.moneydiff += Reference.moneyPerRound;
						}
					}
				}
			}
		}else if(PlayerValues.mode == 1 && inWave && PlayerValues.host){
			if(spawnTimer <= 0){
				Ghost lastEnemy = new Ghost();
				if(PlayerValues.players == 1)
					entities.add(lastEnemy);
				else
					NetworkUtils.createObject(Ghost.class, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
				enemiesLiving++;
				spawnTimer = timeBetweenSpawns;
				enemyCount ++;
			}else if(spawnTimer > 0){
				spawnTimer -= Reference.fixedTime;
			}
		}
		if(PlayerValues.players == 1){
			ArrayList<Entity> entityTmp = (ArrayList<Entity>)entities.clone();
			for(Entity e : entityTmp){
				e.update();
			}
		}else{
			ArrayList<Networked> entityTmp = (ArrayList<Networked>)NetworkUtils.myObjects.clone();
			try{
				for(Networked e : entityTmp){
					e.update();
					NetworkUtils.sendObject(e, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
				}
				startWave.update();
				fastForward.update();
				if(MultiplayerDataSync.ff){
					Reference.fixedTime = Reference.fastTime;
				}else{
					Reference.fixedTime = Reference.fixedTimeConstant;
				}
				inWave = MultiplayerDataSync.inWave;
				if(inWave){
					fastForward.setActive(true);
					startWave.setActive(false);
				}else{
					fastForward.setActive(false);
					startWave.setActive(true);
				}
				
				ArrayList<Networked> entities = new ArrayList<Networked>();
				entities.addAll(NetworkUtils.myObjects);
				entities.addAll(NetworkUtils.networkObjects);
				for(Networked b1 : entities){
					if(b1 instanceof Bullet){
						Bullet b = (Bullet)b1;
						for(Networked e : entities){
							if(e instanceof Ghost){
								Rectangle rect = new Rectangle((int)b.x, (int)b.y, Reference.tileSize, Reference.tileSize);
								Rectangle rect2 = new Rectangle((int)e.x, (int)e.y, Reference.tileSize, Reference.tileSize);
								if(rect.intersects(rect2) && b.srcTurret != null && !b.hit && ((Ghost)e).health <= b.dmg){
									b.srcTurret.killAmount++;
									b.hit = true;
								}
							}
						}
					}
				}
			}catch(Exception e){
				
			}
		}
		if(selected != null){
			selected.selectedUpdate();
			info.update();
		}
		if(Mouse.button == 1 && !click && turretPanel.selected == null && (selected == null || Mouse.mouseY <= Reference.height - 96)){
			click = true;
			selected = null;
			
			if(PlayerValues.players == 1){
			
				for(Entity e : entities){
					if(e instanceof Turret && Mouse.clickX >= e.x && Mouse.clickX <= e.x+Reference.tileSize && Mouse.clickY >= e.y && Mouse.clickY <= e.y+Reference.tileSize){
						selected = (Turret) e;
						break;
					}
				}
			
			}else{
				for(Entity e : NetworkUtils.myObjects){
					if(e instanceof Turret && Mouse.clickX >= e.x && Mouse.clickX <= e.x+Reference.tileSize && Mouse.clickY >= e.y && Mouse.clickY <= e.y+Reference.tileSize){
						selected = (Turret) e;
						break;
					}
				}
				
				for(Entity e : NetworkUtils.networkObjects){
					if(e instanceof Turret && Mouse.clickX >= e.x && Mouse.clickX <= e.x+Reference.tileSize && Mouse.clickY >= e.y && Mouse.clickY <= e.y+Reference.tileSize){
						selected = (Turret) e;
						break;
					}
				}
			}
			
		}else if(Mouse.button == 0){
			click = false;
		}
		turretPanel.update();
	}

}

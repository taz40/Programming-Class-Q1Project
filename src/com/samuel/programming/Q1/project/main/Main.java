package com.samuel.programming.Q1.project.main;

import io.brace.lightsoutgaming.engine.LightsOut;
import io.brace.lightsoutgaming.engine.input.Mouse;

import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.Quit;
import com.samuel.programming.Q1.project.Entities.Button.Retry;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.Utils.Timer;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Main extends LightsOut {
	
	static int width = Reference.width;
	static int height = Reference.height;
	public static Timer timer = new Timer();
	public static GameScene game = new GameScene(width, height, "Level1");
	public static boolean lost = false, won = false;
	Button retry = new Retry((width)/2-Reference.tileSize, 300);
	Button quit = new Quit((width)/2-Reference.tileSize, 400);
	
	public static void main(String[] args){
		new Main().init();
	}

	protected void init() {
		createDisplay(Reference.projectName + " v. " + Reference.version, width, height);
		start();
	}

	protected void render() {
		screen.clear(0xffc7c7c7);
		if(!lost && !won){
			game.render(screen);
		}else if(lost){
			retry.render(screen);
			quit.render(screen);
		}
		show();
		timer.render();
	}

	protected void update() {
		if(!lost && !won){
			game.update();
			if(PlayerValues.lives <= 0){
				lose();
			}
		}else if(lost){
			retry.update();
			quit.update();
		}
		timer.update();
	}
	
	public void lose(){
		lost = true;
	}

}

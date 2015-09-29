package com.samuel.programming.Q1.project.main;

import io.brace.lightsoutgaming.engine.LightsOut;
import io.brace.lightsoutgaming.engine.input.Mouse;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.Utils.Timer;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Main extends LightsOut {
	
	int width = Reference.width;
	int height = Reference.height;
	public static Timer timer = new Timer();
	GameScene game = new GameScene(width, height, "Level1");
	boolean lost = false, won = false;
	
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
			screen.renderSprite((width)/2-Reference.tileSize, 300, Textures.UI.retry, false);
			screen.renderSprite((width)/2-Reference.tileSize, 400, Textures.UI.quit, false);
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
			if(Mouse.button == 1){
				Mouse.button = 0;
				int mx = Mouse.clickX;
				int my = Mouse.clickY;
				if(mx >= (width)/2-Reference.tileSize && mx <= width-190+(Reference.tileSize*2)){
					if(my >= 300 && my <= 300+(Reference.tileSize)){
						//Retry
						lost = false;
						game = new GameScene(width, height, "Level1");
					}
					if(my >= 400 && my <= 400+(Reference.tileSize)){
						//Quit
						System.exit(0);
						
					}
				}
			}
		}
		timer.update();
	}
	
	public void lose(){
		lost = true;
	}

}

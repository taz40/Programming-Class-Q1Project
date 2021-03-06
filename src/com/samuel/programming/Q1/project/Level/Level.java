 package com.samuel.programming.Q1.project.Level;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.samuel.programming.Q1.project.references.Textures;

public class Level extends Networked{
	
	String path;
	public Sprite[][] sprites;
	public int width, height;
	public int spawnX, spawnY, endX, endY;
	public boolean loaded = false;
	
	public Level(String path){
		this.path = path;
		loadLevel();
	}
	
	public Level(){
		path = "/Levels/Level1";
		loadLevel();
	}
	
	public void loadLevel(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path+".png"));
			width = image.getWidth();
			height = image.getHeight();
			sprites = new Sprite[image.getWidth()][image.getHeight()];
			int[] mapPixels = new int[image.getWidth()*image.getHeight()];
			image.getRGB(0, 0, width, height, mapPixels, 0, width);
			for(int x = 0; x < image.getWidth(); x++){
				for(int y = 0; y < image.getHeight(); y++){
					if(mapPixels[x+y*image.getHeight()] == 0xffffff00){
						Sprite s = Textures.Terrain.roadStraightV;
						if(x > 0 && mapPixels[(x-1)+y*height] == 0xffffff00)
							s = Textures.Terrain.roadStraightH;
						if(x < width-1 && mapPixels[(x+1)+y*height] == 0xffffff00)
							s = Textures.Terrain.roadStraightH;
						if(x < width-1 && y < height-1){
							if(mapPixels[(x+1)+y*height] == 0xffffff00 && mapPixels[(x)+(y+1)*height] == 0xffffff00)
								s = Textures.Terrain.roadCornerDR;
						}
						if(x > 0 && y < height-1){
							if(mapPixels[(x-1)+y*height] == 0xffffff00 && mapPixels[(x)+(y+1)*height] == 0xffffff00)
								s = Textures.Terrain.roadCornerDL;
						}
						if(x > 0 && y > 0){
							if(mapPixels[(x-1)+y*height] == 0xffffff00 && mapPixels[(x)+(y-1)*height] == 0xffffff00)
								s = Textures.Terrain.roadCornerUL;
						}
						
						if(x < width-1 && y > 0){
							if(mapPixels[(x+1)+y*height] == 0xffffff00 && mapPixels[(x)+(y-1)*height] == 0xffffff00)
								s = Textures.Terrain.roadCornerUR;
						}
						sprites[x][y] = s;
					}else{
						sprites[x][y] = Textures.Void;
					}
				}
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(SpriteSheet.class.getResource(path+".lvl").openStream()));
			spawnX = Integer.parseInt(reader.readLine());
			spawnY = Integer.parseInt(reader.readLine());
			endX = Integer.parseInt(reader.readLine());
			endY = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public void render(Screen s){
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				s.renderSprite(x*16*3, y*16*3, sprites[x][y], true);
			}
		}
	}

	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		return new String[] {path};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		if(path != data[0]){
			path = data[0];
			loadLevel();
			loaded = true;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

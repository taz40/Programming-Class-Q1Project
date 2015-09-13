package com.samuel.programming.Q1.project.Level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.graphics.SpriteSheet;

public class Level {
	
	String path;
	Sprite[][] sprites;
	int width, height;
	
	public Level(String path){
		this.path = path;
		loadLevel();
	}
	
	public void loadLevel(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render(Screen s){
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				s.renderSprite(x*16*3, y*16*3, sprites[x][y], true);
			}
		}
	}

}
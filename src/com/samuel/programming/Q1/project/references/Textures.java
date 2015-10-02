package com.samuel.programming.Q1.project.references;

import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.graphics.SpriteSheet;

public class Textures {
	
	public static Sprite Void = new Sprite(1,1);
	
	static{
		Void.pixels[0] = 0xffff00ff;
	}
	public static class SpriteSheets{
		public static SpriteSheet turret = new SpriteSheet("/Textures/Turret.png");
		public static SpriteSheet terrain = new SpriteSheet("/Textures/Terrain.png");
		public static SpriteSheet enemies = new SpriteSheet("/Textures/Enemies.png");
		public static SpriteSheet UI = new SpriteSheet("/Textures/UI.png");
	}
	
	public static class Entities{
		public static class Turret{
			public static Sprite base = new Sprite(0,0,3,16,16,Textures.SpriteSheets.turret);
			public static Sprite turret = new Sprite(1,0,3,16,16,Textures.SpriteSheets.turret);
		}
		public static class Projectiles{
			public static Sprite bullet = new Sprite(0,1,3,16,16,Textures.SpriteSheets.turret);
		}
	}
	
	public static class Terrain{
		public static Sprite roadStraightV = new Sprite(0,0,3,16,16,Textures.SpriteSheets.terrain);
		public static Sprite roadStraightH = new Sprite(1,0,3,16,16,Textures.SpriteSheets.terrain);
		public static Sprite roadCornerDR = new Sprite(2,0,3,16,16,Textures.SpriteSheets.terrain);
		public static Sprite roadCornerDL = new Sprite(3,0,3,16,16,Textures.SpriteSheets.terrain);
		public static Sprite roadCornerUL = new Sprite(4,0,3,16,16,Textures.SpriteSheets.terrain);
		public static Sprite roadCornerUR = new Sprite(5,0,3,16,16,Textures.SpriteSheets.terrain);
	}
	
	public static class Enemies{
		public static Sprite ghost = new Sprite(0,0,3,16,16,Textures.SpriteSheets.enemies);
	}
	
	public static class Panels{
		public static class Turret{
			public static Sprite bg = new Sprite(200, Reference.height);
			private static int bgcolor = 0xff0000ff;
			
			static{
				for(int i = 0; i < bg.pixels.length; i++){
					bg.pixels[i] = bgcolor;
				}
			}
			
		}
	}
	
	public static class UI{
		public static Sprite startWave = new Sprite(0,0,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite ff = new Sprite(1,0,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite retry = new Sprite(2,0,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite quit = new Sprite(3,0,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite easy = new Sprite(0,2,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite hard = new Sprite(1,2,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite back = new Sprite(2,2,3,32,16,Textures.SpriteSheets.UI);

		
		public static Sprite startWaveH = new Sprite(0,1,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite ffH = new Sprite(1,1,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite retryH = new Sprite(2,1,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite quitH = new Sprite(3,1,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite easyH = new Sprite(0,3,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite hardH = new Sprite(1,3,3,32,16,Textures.SpriteSheets.UI);
		public static Sprite backH = new Sprite(2,3,3,32,16,Textures.SpriteSheets.UI);
		
		
	}

}

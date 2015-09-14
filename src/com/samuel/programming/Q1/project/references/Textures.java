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
		public static SpriteSheet enemies = new SpriteSheet("/Textures/enemies.png");
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

}

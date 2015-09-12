package com.samuel.programming.Q1.project.references;

import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.graphics.SpriteSheet;

public class Textures {
	
	public static class SpriteSheets{
		public static SpriteSheet sheet = new SpriteSheet("/Turret.png");
	}
	
	public static class Entities{
		public static class Turret{
			public static Sprite base = new Sprite(0,0,3,16,16,Textures.SpriteSheets.sheet);
			public static Sprite turret = new Sprite(1,0,3,16,16,Textures.SpriteSheets.sheet);
		}
		public static class Projectiles{
			public static Sprite bullet = new Sprite(0,1,3,16,16,Textures.SpriteSheets.sheet);
		}
	}

}

package com.samuel.programming.Q1.project.references;

public class Turrets {
	
	public static boolean[][] takenTiles = new boolean[100][100];
	
	public static class basic{
		public static float range = 3;
		public static int cost = 100;
		public static int dmg = 10;
		public static float upgradeRangeMod = .25f;
		public static float upgradeDmgMod = 5;
		public static float startingUpgradeCost = 50;
		public static float upgradeCostMod = .75f;
	}

}

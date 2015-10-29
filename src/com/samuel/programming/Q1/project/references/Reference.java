package com.samuel.programming.Q1.project.references;

import java.awt.Font;

public class Reference {
	
	public static String projectName = "Q1 Project";
	public static String version = "1.0 Beta";
	public static float aspectRatio = 1f/(16f/9f);
	public static final float fixedTimeConstant = (1f/60f);
	public static float fixedTime = fixedTimeConstant;
	public static float fastTime = fixedTimeConstant*3;
	public static int tileSize = 3*16;
	public static int width = 912;
	public static int height = (int) (width * Reference.aspectRatio);
	public static final int StartingCash = 150;
	public static final int startingLives = 100;
	public static final int moneyPerRound = 100;
	public static final float sellPercent = .65f;
	public static final int port = 32;
	public static class Fonts{
		public static final Font ComicSans = new Font("comic sans ms", Font.PLAIN, 20);
	}

}

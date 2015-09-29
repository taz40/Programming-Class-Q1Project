package com.samuel.programming.Q1.project.references;

public class Reference {
	
	public static String projectName = "Q1 Project";
	public static String version = "1.0 Alpha";
	public static float aspectRatio = 1f/(16f/9f);
	public static final float fixedTimeConstant = (1f/60f);
	public static float fixedTime = fixedTimeConstant;
	public static float fastTime = fixedTimeConstant*3;
	public static int tileSize = 3*16;
	public static int width = 900;
	public static int height = (int) (width * Reference.aspectRatio);
	public static final int StartingCash = 300;
	public static final int startingLives = 100;

}

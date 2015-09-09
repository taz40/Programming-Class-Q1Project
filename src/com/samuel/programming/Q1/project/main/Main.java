package com.samuel.programming.Q1.project.main;

import io.brace.lightsoutgaming.engine.LightsOut;

import com.samuel.programming.Q1.project.references.Reference;

public class Main extends LightsOut {
	
	float aspectRatio = 9f/16f;
	int width = 900;
	int height = (int) (width * aspectRatio);
	
	public static void main(String[] args){
		new Main().init();
	}

	protected void init() {
		createDisplay(Reference.projectName + " v. " + Reference.version, width, height);
		start();
	}

	protected void render() {
		screen.clear();
		
		show();
	}

	protected void update() {
		
	}

}

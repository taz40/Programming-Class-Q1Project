package com.samuel.programming.Q1.project.Utils;

import com.samuel.programming.Q1.project.references.PlayerValues;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class MultiplayerDataSync extends Networked {
	
	public static boolean inWave = false;
	public static boolean ff = false;
	
	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		return new String[]{inWave+"", ff+"", PlayerValues.lives+"", PlayerValues.Money+""};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		inWave = Boolean.parseBoolean(data[0]);
		ff = Boolean.parseBoolean(data[1]);
		PlayerValues.lives = Integer.parseInt(data[2]);
		PlayerValues.Money = Integer.parseInt(data[3]);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		
	}

}

package com.samuel.programming.Q1.project.Utils;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class MultiplayerDataSync extends Networked {
	
	public static boolean inWave = false;
	public static boolean ff = false;
	
	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		return new String[]{inWave+"", ff+""};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		
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

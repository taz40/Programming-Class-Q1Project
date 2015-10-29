package com.samuel.programming.Q1.project.Utils;

import com.samuel.programming.Q1.project.references.PlayerValues;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class MultiplayerDataSyncClient extends Networked {
	
	public static int moneydiff = 0;

	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		int Money = moneydiff;
		moneydiff = 0;
		return new String[]{Money+""};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		//PlayerValues.Money += Integer.parseInt(data[0]);
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

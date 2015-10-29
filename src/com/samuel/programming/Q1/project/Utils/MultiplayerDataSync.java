package com.samuel.programming.Q1.project.Utils;

import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.Reference;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class MultiplayerDataSync extends Networked {
	
	public static boolean inWave = false;
	public static boolean ff = false;
	public static int moneydiff = 0;
	boolean modeBonus = false;
	
	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		int Money = moneydiff;
		moneydiff = 0;
		return new String[]{inWave+"", ff+"", PlayerValues.lives+"", Money+"", PlayerValues.mode+""};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		inWave = Boolean.parseBoolean(data[0]);
		ff = Boolean.parseBoolean(data[1]);
		PlayerValues.lives = Integer.parseInt(data[2]);
		PlayerValues.Money += Integer.parseInt(data[3]);
		int mode = Integer.parseInt(data[4]);
		if(mode == 1 && !modeBonus){
			modeBonus = true;
			PlayerValues.Money = Reference.StartingCash*2;
		}
		
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

package com.samuel.programming.Q1.project.references;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class PlayerValuesSync extends Networked {

	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		String[] result = {PlayerValues.mode+""};
		return result;
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		PlayerValues.mode = Integer.parseInt(data[0]);
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

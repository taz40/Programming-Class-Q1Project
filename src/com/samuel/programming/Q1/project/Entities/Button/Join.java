package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.input.Mouse;

import javax.swing.JOptionPane;

import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.PlayerValuesSync;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class Join extends Button {

	public Join(int x, int y) {
		super(x, y, Textures.UI.join);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDraw(Screen s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseEnter() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.joinH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.join;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		String s = (String)JOptionPane.showInputDialog(
                null,
                "IP Address:",
                "Connect",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");
		PlayerValues.socket = NetworkUtils.NetInit();
		PlayerValues.id = NetworkUtils.connect("localhost", Reference.port, "User 1", Reference.projectName+" "+Reference.version, PlayerValues.socket, PlayerValues.main);
		if(PlayerValues.id != -1){
			PlayerValues.Menu = 1;
			Mouse.button = 0;
		}
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub

	}

}

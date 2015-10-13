package com.samuel.programming.Q1.project.Entities.Button;

import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
import io.brace.lightsoutgaming.engine.Network.Server;
import io.brace.lightsoutgaming.engine.graphics.Screen;

import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.main.Main;
import com.samuel.programming.Q1.project.references.PlayerValues;
import com.samuel.programming.Q1.project.references.PlayerValuesSync;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class StandardMode extends Button {

	public StandardMode(int x, int y) {
		super(x, y, Textures.UI.easy);
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
		sprite = Textures.UI.easyH;
	}

	@Override
	public void onMouseExit() {
		// TODO Auto-generated method stub
		sprite = Textures.UI.easy;
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		if(PlayerValues.players == 2){
			Server s = new Server(false, Reference.port, Reference.projectName+" "+Reference.version);
			PlayerValues.socket = NetworkUtils.NetInit();
			PlayerValues.id = NetworkUtils.connect("localhost", Reference.port, "User 1", Reference.projectName+" "+Reference.version, PlayerValues.socket, PlayerValues.main);
			NetworkUtils.createObject(PlayerValuesSync.class, NetworkUtils.serverIP, Reference.port, PlayerValues.socket);
		}
		PlayerValues.Menu = 1;
		PlayerValues.mode = 0;
		PlayerValues.host = true;
		Main.game = new GameScene(Reference.width, Reference.height, "Level1");
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

}

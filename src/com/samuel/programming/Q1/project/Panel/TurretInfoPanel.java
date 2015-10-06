package com.samuel.programming.Q1.project.Panel;

import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

import io.brace.lightsoutgaming.engine.graphics.Screen;

public class TurretInfoPanel extends Panel {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(0, Reference.height - 96, Textures.Panels.Info.bg, false);
	}

}

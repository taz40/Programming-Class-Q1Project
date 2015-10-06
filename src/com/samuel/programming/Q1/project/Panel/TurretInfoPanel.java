package com.samuel.programming.Q1.project.Panel;

import io.brace.lightsoutgaming.engine.graphics.Screen;

import java.awt.Color;

import com.samuel.programming.Q1.project.Entities.Button.Button;
import com.samuel.programming.Q1.project.Entities.Button.SellTurret;
import com.samuel.programming.Q1.project.Entities.Button.TargetClose;
import com.samuel.programming.Q1.project.Entities.Button.TargetFirst;
import com.samuel.programming.Q1.project.Entities.Button.TargetLast;
import com.samuel.programming.Q1.project.Entities.Button.TargetStrong;
import com.samuel.programming.Q1.project.Scenes.GameScene;
import com.samuel.programming.Q1.project.references.Reference;
import com.samuel.programming.Q1.project.references.Textures;

public class TurretInfoPanel extends Panel {
	
	Button sell = new SellTurret(120, Reference.height-86);
	Button first = new TargetFirst(220, Reference.height-86);
	Button last = new TargetLast(257, Reference.height-86);
	Button close = new TargetClose(295, Reference.height-86);
	Button strong = new TargetStrong(333, Reference.height-86);

	@Override
	public void update() {
		// TODO Auto-generated method stub
		sell.update();
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(0, Reference.height - 96, Textures.Panels.Info.bg, false);
		s.renderString(0, Reference.height - 86, "Range: "+(GameScene.selected.range/Reference.tileSize), Color.WHITE, Reference.Fonts.ComicSans, false);
		s.renderString(0, Reference.height - 61, "Dmg: "+GameScene.selected.dmg, Color.WHITE, Reference.Fonts.ComicSans, false);
		sell.render(s);
		first.render(s);
		last.render(s);
		close.render(s);
		strong.render(s);
		s.renderString(120, Reference.height-40, "$"+(int)(GameScene.selected.cost*Reference.sellPercent), Color.white, Reference.Fonts.ComicSans, false);
	}

}

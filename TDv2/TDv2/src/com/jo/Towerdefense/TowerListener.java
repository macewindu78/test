package com.jo.Towerdefense;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jo.Towerdefense.Screens.GameScreen;

@SuppressWarnings("unused")
public class TowerListener extends InputListener {
	Image im;
	
	public TowerListener(Image im) {
		this.im = im;
	}
	
	
	public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
		System.out.println("T1");
		System.out.println(im.getX());
		System.out.println(im.getY());
		GameScreen.createTower(im.getX(),im.getY());
		return true;
	}
}

package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Blocks extends Actor {
	public static final float SIZE = 1f;
	
	Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();
	
	public Blocks(Vector2 pos){
		this.position = pos;
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
		
	}
	
}

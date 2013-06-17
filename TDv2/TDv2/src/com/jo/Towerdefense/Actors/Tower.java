package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jo.Towerdefense.Screens.GameScreen;

@SuppressWarnings("unused")
public class Tower extends Image {
	public static final float SIZE = 32f;
	public static int shootingRange = 6;
	Rectangle range;
	int towerDamage = 10;
	boolean shooting;
	public Creeps ShotCreep=null;
	ShapeRenderer debugRenderer;
	
	public Tower(float x, float y, Texture tower){
		super(tower);
		
		this.setHeight(SIZE);
		this.setWidth(SIZE);
		this.setPosition(x,y);
		range = new Rectangle(this.getX()+SIZE/2-(shootingRange*SIZE)/2,this.getY()+SIZE/2-(shootingRange*SIZE)/2,shootingRange*SIZE+1,shootingRange*SIZE+1);
		debugRenderer = new ShapeRenderer();
		
	}
	
	 
		int ReloadTime = 70, WaitingFire=0;
		public void physics(){
			if(WaitingFire>= ReloadTime){

				if(!shooting){
					for (int i=0; i< GameScreen.Wave.size(); i++){
						if(Intersector.intersectRectangles(GameScreen.Wave.get(i).Rect, range)){
							GameScreen.Wave.get(i).DamageCreep(towerDamage);
							GameScreen.createBullet(this.getX(),this.getY(),GameScreen.Wave.get(i));
							ShotCreep = GameScreen.Wave.get(i);
							shooting = true;
							break;
							}
						}
					
				}
					
								
				if(ShotCreep!=null){
					
					if(Intersector.intersectRectangles(ShotCreep.Rect,range)){
						ShotCreep.DamageCreep(towerDamage);
						GameScreen.createBullet(this.getX(),this.getY(),ShotCreep);
						
						if(ShotCreep.CreepHealth<= 0){
							ShotCreep.deleteCreep(ShotCreep);
							shooting = false;
							for(int i= 0 ; i< GameScreen.Towers.size();i++){
								if(GameScreen.Towers.get(i).ShotCreep == this.ShotCreep){
									GameScreen.Towers.get(i).ShotCreep =null;
								}
							}
							ShotCreep=null;
							
						}
					}else{ShotCreep=null;}
				}
				else{
					shooting = false;
				}
			

				WaitingFire = 0;
			}else{
				WaitingFire++;
			}
	
		}
		
		public void draw(SpriteBatch batch, float parentAlpha) {
			super.draw(batch, parentAlpha);
	    	
	  /*  	debugRenderer.begin(ShapeType.Rectangle);
	   		debugRenderer.setColor(new Color(1, 0, 0, 1));
	    	debugRenderer.rect(range.x, range.y, range.width, range.height);
	    	debugRenderer.end();*/
		}
	}
	
	


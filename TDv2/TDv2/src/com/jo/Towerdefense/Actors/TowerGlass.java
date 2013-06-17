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

public class TowerGlass extends Image {
	private static final float SIZE = 32f;
	private static int shootingRange = 6;
	private Rectangle range;
	private int towerDamage = 30;
	private boolean shooting;
	public Creeps ShotCreep=null;
	private ShapeRenderer debugRenderer;
	
	public TowerGlass(float x, float y, Texture tower){
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
							System.out.println("HAHAHAHAHA " + i);
							GameScreen.Wave.get(i).DamageCreep(towerDamage);
							GameScreen.createBulletGlass(this.getX(),this.getY(),GameScreen.Wave.get(i));
							ShotCreep = GameScreen.Wave.get(i);
							shooting = true;
							break;
							}
						}
					
				}
				
				
				
				if(ShotCreep!=null){
					System.out.println(ShotCreep);
					if(Intersector.intersectRectangles(ShotCreep.Rect,range)){
						ShotCreep.DamageCreep(towerDamage);
						GameScreen.createBulletGlass(this.getX(),this.getY(),ShotCreep);
						
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
	    	
	    	/*debugRenderer.begin(ShapeType.Rectangle);
	   		debugRenderer.setColor(new Color(1, 0, 0, 1));
	    	debugRenderer.rect(range.x, range.y, range.width, range.height);
	    	debugRenderer.end();*/
		}
	}
	
	


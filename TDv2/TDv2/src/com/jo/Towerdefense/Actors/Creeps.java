package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jo.Towerdefense.Assets;
import com.jo.Towerdefense.Screens.GameScreen;


@SuppressWarnings("unused")
public class Creeps extends Image {
	
	public static final float SIZE = 32f; //size of the creep
	public boolean inGame = false;
	private int left =0,right = 1, upward =2, downward=3;
	private int direction = right;
	private boolean hasright = false;
	private boolean hasleft = false;
	private boolean hasupward = false;
	private boolean hasdownward = false;
	public Rectangle Rect;
	int CreepHealth;
	ShapeRenderer debugRenderer;

	public Creeps(int Health){
		super(Assets.Creep1Texture);
		this.setHeight(SIZE);
		this.setWidth(SIZE);
		this.setPosition(0*SIZE,2*SIZE);
		setVisible(true);
		
		CreepHealth = Health;

		Rect = new Rectangle(0*SIZE,2*SIZE,SIZE+3,SIZE+3);
		debugRenderer = new ShapeRenderer();
	}
	
	
	public int walkspeed = 1, WaintingWalk = 0;
	public void physics(){
		if(WaintingWalk >= walkspeed){
			
			if(this.direction == right){
				this.setPosition(this.getX()+1,this.getY());
				this.hasright = true;
			}else if (this.direction == left){
				this.setPosition(this.getX()-1,this.getY());
				this.hasleft = true;
			}else if (this.direction == upward){
				this.setPosition(this.getX(),this.getY()+1);
				this.hasupward = true;
			}else if(this.direction == downward){
				this.setPosition(this.getX(),this.getY()-1);
				this.hasdownward = true;
			}
			
			
			if(hasleft){
				if(!hasleft){
					try{
						if(Map.map1int[(int) (this.getY()/SIZE)][(int) (this.getX()/SIZE)+1]!= 0){
							this.direction = right;
						}
						if(Map.map1int[(int) (this.getY()/SIZE)][(int) (this.getX()/SIZE)+1]== 2){
							deleteCreep(this);
							looseHealth();
						}
					}catch(Exception e){}
				}
				
				if(!hasright){
					try{
						if(Map.map1int[(int) (this.getY()/SIZE)][(int)(this.getX()/SIZE)+1]!= 0){
							this.direction = left;
						}
					}catch(Exception e){}
				}
				
				if(!hasdownward){
					try{
						if(Map.map1int[(int) (this.getY()/SIZE)+1][(int) (this.getX()/SIZE)+1]!= 0){
							this.direction = upward;
						}
					}catch(Exception e){}
				}
			}
			
			else{
				if(!hasleft){
					try{
						if(Map.map1int[(int) (this.getY()/SIZE)][(int) (this.getX()/SIZE)+1]!= 0){
							this.direction = right;
						}
						if(Map.map1int[(int) (this.getY()/SIZE)][(int) (this.getX()/SIZE)+1]== 2){
							deleteCreep(this);
							looseHealth();
						}
					}catch(Exception e){}
				}
				
				if(!hasright){
					try{
						if(Map.map1int[(int) (this.getY()/SIZE)][(int)(this.getX()/SIZE)-1]!= 0){
							this.direction = left;
						}
					}catch(Exception e){}
				}
				
				if(!hasdownward){
					try{
						if(Map.map1int[(int) (this.getY()/SIZE)+1][(int) (this.getX()/SIZE)]!= 0){
							this.direction = upward;
						}
					}catch(Exception e){}
				}
				
				
	/*			if(!hasupward){
					try{
						if(Map.map1int[ (int) (this.getY()/SIZE)-1][(int) (this.getX()/SIZE)]!= 0){
							this.direction = downward;
						}
					}catch(Exception e){}
				}*/
		
			}
			this.hasright = false;
			this.hasleft = false;
			this.hasupward = false;
			this.hasdownward = false;
			
			
			Rect.setX(this.getX()-1);
			Rect.setY(this.getY()-2);
			WaintingWalk = 0;
		}
		else{
			WaintingWalk++;
		}
	}
/*	public void SpawnCreep(){
		this.getX()/32 = 0*SIZE; 
		this.position.y = 2*SIZE;
		inGame = true;
	}*/
	Creeps LocalCreep = null;
	public void deleteCreep(Creeps creep){
		this.remove();
		GameScreen.Wave.remove(creep);
		if(LocalCreep!= creep & creep!=null){
			GameScreen.Coins += 1;
			LocalCreep = creep;
		}
	}
	
	public void looseHealth(){
		GameScreen.Health--;
		if(GameScreen.Health <=0){
			GameScreen.getInstance().ChangeGO();
		}
	}
	
	public void DamageCreep(int damage){
		CreepHealth -= damage;
	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
    	/*
    	debugRenderer.begin(ShapeType.Rectangle);
   		debugRenderer.setColor(new Color(1, 0, 0, 1));
    	debugRenderer.rect(Rect.x, Rect.y, Rect.width, Rect.height);
    	debugRenderer.end();*/
	}
	
}

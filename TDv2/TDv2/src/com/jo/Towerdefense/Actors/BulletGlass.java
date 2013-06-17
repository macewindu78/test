package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jo.Towerdefense.Assets;
import com.jo.Towerdefense.Screens.GameScreen;

public class BulletGlass extends Image{
	
	public int SIZE = 6;
	Creeps targetcreep;
	float targetX, targetY;
	float BulletPosX, BulletPosY;
	float VectorX,VectorY;
	Rectangle RectBullet;
	
	ShapeRenderer debugRenderer;
	
	public BulletGlass(float x, float y, Creeps creep){
		super(Assets.BulletGlass);
		this.setHeight(SIZE);
		this.setWidth(SIZE);
		this.setPosition(x+32/2,y+32);
		this.targetcreep = creep;
		RectBullet= new Rectangle(x +32/2 - SIZE,y +32 - SIZE,SIZE*3,SIZE*3);
		debugRenderer = new ShapeRenderer();
	}
	
	
	public void physics(){
		targetX = targetcreep.getX()+Creeps.SIZE/2;
		targetY = targetcreep.getY()+Creeps.SIZE/2;
		
		BulletPosX = this.getX();
		BulletPosY = this.getY();
		
		VectorX = targetX - BulletPosX;
		VectorY = targetY - BulletPosY;
		
		if(Intersector.overlapRectangles(RectBullet,targetcreep.Rect)){
			RemoveBullet();
			//System.out.println("hit target");
		}
		else{
			this.setX(BulletPosX + 2*VectorX/(Math.abs(VectorX)+Math.abs(VectorY)));
			this.setY(BulletPosY + 2*VectorY/(Math.abs(VectorX)+Math.abs(VectorY)));
			RectBullet.setX(this.getX()-SIZE);
			RectBullet.setY(this.getY()-SIZE);
		}
	}
	
	public void RemoveBullet(){
		this.remove();
		GameScreen.bulletGlass.remove(this);
	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
    	
    	/*debugRenderer.begin(ShapeType.Rectangle);
   		debugRenderer.setColor(new Color(1, 0, 0, 1));
    	debugRenderer.rect(RectBullet.x, RectBullet.y, RectBullet.width, RectBullet.height);
    	debugRenderer.end();*/
	}
	
}

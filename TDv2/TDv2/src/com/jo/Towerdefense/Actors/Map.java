package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jo.Towerdefense.Assets;
import com.jo.Towerdefense.TowerListener;
import com.jo.Towerdefense.Screens.GameScreen;


public class Map extends Group {
	int MapHeight =15;
	int MapWidth = 20;
	public float SIZE = 32f;

	boolean hastower;
	
	public static int[][] map1int = new int[][]{
	
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1,1,1,1,1,4,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0},
			{0,0,0,6,1,1,1,1,1,1,1,1,5,0,0,0,0,0,0,0},
			{0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,7,1,1,1,1,1,1,1,1,1,1,1,1,1,4,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0},
			{0,0,0,0,0,0,6,1,1,1,1,1,1,1,1,1,1,5,0,0},
			{0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,7,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			
	};
	
	
	
    public Map() {
    	
    	for(int i=0;i<MapHeight;i++){
    		for(int j =0; j<MapWidth;j++){
    			Vector2 position = new Vector2(j, i);
    			
    			Image Block;
    			
    			if(map1int[i][j]==0){
    				Block = new Image(Assets.grassTexture);
        			Block.addListener(new TowerListener(Block));
    			}
    			else if(map1int[i][j]==1){
    				Block = new Image(Assets.horizontalRoadTexture);
    			}
    			else if(map1int[i][j]==2){
    				Block = new Image(Assets.finishTexture);  				
    			}
    			else if(map1int[i][j]==3){
    				Block = new Image(Assets.verticalRoadTexture);
    			}
    			else if(map1int[i][j]==4){
    				Block = new Image(Assets.roadTopLeftTexture);
    			}
    			else if(map1int[i][j]==5){
    				Block = new Image(Assets.roadBottomLeftTexture);
    			}
    			else if(map1int[i][j]==6){
    				Block = new Image(Assets.roadTopRightTexture);
    			}
    			else if(map1int[i][j]==7){
    				Block = new Image(Assets.roadBottomRightTexture);
    			}
    			else{
    				Block = new Image(Assets.grassTexture);
    			}
    			
    			
    			Block.setPosition(position.x*SIZE, position.y*SIZE);
    			Block.setWidth(SIZE);
    			Block.setHeight(SIZE);
    			this.addActor(Block);
    		
    		}
    	}
	}
    
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	}
	
}

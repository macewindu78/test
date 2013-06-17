package com.jo.Towerdefense.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.jo.Towerdefense.TowerDefense;
import com.jo.Towerdefense.Actors.Menu;



@SuppressWarnings("unused")

public class MenuScreen implements Screen{
	
	
	Stage stage;
	Menu menu;
	protected final TowerDefense game;
	private static MenuScreen instance;



	 
	    public MenuScreen(TowerDefense game ){
	       
	    		this.game = game;
	    		instance = this;
	        
	    }
	 
	    @Override
	    public void resize(int width,int height ){
	    		    	
	    	stage = new Stage(800,480,true);
	    	menu = new Menu();
		    	
	    	Gdx.input.setInputProcessor(stage);
	    	stage.addActor(menu);
	    

	    }

		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			
			stage.draw();
			
			
		}

		@Override
		public void show() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resume() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}
		
		public void changeScreen(){
			
			game.setScreen( new GameScreen( game ) );
			
		}
		
		public void changeScreenOption(){
			
			game.setScreen( new OptionScreen( game ) );
			
		}

		public static MenuScreen getInstance() {
			return instance;
		}
	}
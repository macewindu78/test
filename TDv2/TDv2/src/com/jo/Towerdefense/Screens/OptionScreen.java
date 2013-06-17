package com.jo.Towerdefense.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jo.Towerdefense.TowerDefense;
import com.jo.Towerdefense.Actors.Menu;
import com.jo.Towerdefense.Actors.Option;

public class OptionScreen implements Screen {

	
	Stage stage;
	Option option;
	protected final TowerDefense game;
	private static OptionScreen instance;



	 
	    public OptionScreen(TowerDefense game ){
	       
	    		this.game = game;
	    		instance = this;
	        
	    }
	 
	    @Override
	    public void resize(int width,int height ){
	    		    	
	    	stage = new Stage(800,480,true);
	    	option = new Option();
		    	
	    	Gdx.input.setInputProcessor(stage);
	    	stage.addActor(option);
	    

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
		
		public void ChangeScreenMenu(){
			
			game.setScreen( new MenuScreen( game ) );
			
		}

		public static OptionScreen getInstance() {
			return instance;
		}
}

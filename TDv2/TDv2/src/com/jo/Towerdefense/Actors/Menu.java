package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.InputProcessor;
import com.jo.Towerdefense.Screens.MenuScreen;



@SuppressWarnings("unused")



public class Menu extends Group {
	
	 Game game;
	 private static final float BUTTON_WIDTH = 100f;
	 private static final float BUTTON_HEIGHT = 60f;
	 private static final float BUTTON_SPACING = 100f;
	 private static final float width = 800f;
	 private final float buttonX = ( width - BUTTON_WIDTH ) / 2;

	 BitmapFont font;
	
	public Menu(){
				
		font = new BitmapFont();
		
		//Background
        Image Background = new Image(new Texture(Gdx.files.internal("data/Imgs/fondshop.png")));
        Background.setX(0);
        Background.setY(0);
        Background.setWidth(800);
        Background.setHeight(480);
        addActor(Background);
 
        // button "start game"
        Image startButton = new Image(new Texture(Gdx.files.internal("data/Imgs/play-01.png")));
        startButton.setX(buttonX);
        startButton.setY(BUTTON_HEIGHT + 3*BUTTON_SPACING );
        startButton.setWidth(BUTTON_WIDTH);
        startButton.setHeight(BUTTON_HEIGHT);
        
        
        startButton.addListener( new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
            	System.out.println("mouahhhh");
            	MenuScreen.getInstance().changeScreen();
            	return true;
            }
           
            } );
        addActor( startButton );
        
        // button "options"
        Image optionsButton = new Image(new Texture(Gdx.files.internal("data/Imgs/options-01.png")));
        optionsButton.setX(buttonX);
        optionsButton.setY(BUTTON_HEIGHT + 2*BUTTON_SPACING );
        optionsButton.setWidth(BUTTON_WIDTH);
        optionsButton.setHeight(BUTTON_HEIGHT);
       
        optionsButton.addListener( new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
            	
            	MenuScreen.getInstance().changeScreenOption();
            	return true;
            }
        } );
        addActor( optionsButton );
 
        // button "quit"
        Image quitButton = new Image(new Texture(Gdx.files.internal("data/Imgs/quit-01.png")));
        quitButton.setX(buttonX);
        quitButton.setY(BUTTON_HEIGHT + BUTTON_SPACING );
        quitButton.setWidth(BUTTON_WIDTH);
        quitButton.setHeight(BUTTON_HEIGHT);
		
        quitButton.addListener( new InputListener() {
	        public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
	        	Gdx.app.exit();
	            	return true;
	        }
	    } );
        
        addActor( quitButton );
	}
	
	public void draw(SpriteBatch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		
		//font.draw(batch,"Jouer!", buttonX+30, 3*BUTTON_SPACING+BUTTON_HEIGHT+35);
		//font.draw(batch,"Options", buttonX+30, 2*BUTTON_SPACING+BUTTON_HEIGHT+35);
		//font.draw(batch,"Quitter", buttonX+30, BUTTON_SPACING+BUTTON_HEIGHT+35);
	}
	
}	
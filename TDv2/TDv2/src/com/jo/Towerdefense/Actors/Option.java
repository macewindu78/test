package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jo.Towerdefense.Assets;
import com.jo.Towerdefense.Screens.GameScreen;
import com.jo.Towerdefense.Screens.OptionScreen;

public class Option extends Group {
	
	
	
	BitmapFont font;
	
	
	public Option(){
		
		font = new BitmapFont();
		
		//Background
        Image Background = new Image(new Texture(Gdx.files.internal("data/Imgs/fondshop.png")));
        Background.setX(0);
        Background.setY(0);
        Background.setWidth(800);
        Background.setHeight(480);
        addActor(Background);
        
        //MenuButton
		Image MenuBut = new Image(Assets.Menu);
		MenuBut.setPosition(50,100);
		MenuBut.setHeight(50);
		MenuBut.setWidth(100);
		MenuBut.addListener(MenuButlistener);
		addActor(MenuBut);
        
        
        
        
	}
	
	public void draw(SpriteBatch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		
		font.draw(batch,"Game Design by : Zagar Laetitia and John Joke", 300, 350);
		font.draw(batch,"Graphics Design : Douat Anne", 300,300);
	}
	
	InputListener MenuButlistener = new InputListener(){
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
			System.out.println("Menu");
			OptionScreen.getInstance().ChangeScreenMenu();
			return true;
		}
	};

}

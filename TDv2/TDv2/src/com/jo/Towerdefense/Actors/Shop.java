package com.jo.Towerdefense.Actors;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.jo.Towerdefense.Assets;
import com.jo.Towerdefense.Screens.GameScreen;

@SuppressWarnings("unused")
public class Shop extends Group{
	
	BitmapFont font = new BitmapFont();
	int HeightTower = 55; 
	int WidthTower = 55;
	int ButtonHeight = 50;
	int ButtonWidth = 100;
	public static boolean Tower1Pressed = false;
	public static boolean Tower2Pressed = false;
	public static boolean Tower3Pressed = false;
	public static boolean Tower4Pressed = false;
	
	public Shop(){
		Image ShopBack = new Image(Assets.ShopBackgroundTexture);
		ShopBack.setPosition(640, 0);
		ShopBack.setHeight(480);
		ShopBack.setWidth(160);
		addActor(ShopBack);
		
		
		Image Tower1Button = new Image(Assets.Tower1Texture);
		Tower1Button.setPosition(656,31 );
		Tower1Button.setWidth(WidthTower);
		Tower1Button.setHeight(HeightTower);
		Tower1Button.addListener(Tower1Buttonlistener);
		addActor(Tower1Button);

		Image Tower2Button = new Image(Assets.Tower2Texture);
		Tower2Button.setPosition(726,31 );
		Tower2Button.setWidth(WidthTower);
		Tower2Button.setHeight(HeightTower);
		Tower2Button.addListener(Tower2Buttonlistener);
		addActor(Tower2Button);
		
		Image Tower3Button = new Image(Assets.Tower3Texture);
		Tower3Button.setPosition(656, 100);
		Tower3Button.setWidth(WidthTower);
		Tower3Button.setHeight(HeightTower);
		Tower3Button.addListener(Tower3Buttonlistener);
		addActor(Tower3Button);
		
		Image Tower4Button = new Image(Assets.Tower4Texture);
		Tower4Button.setPosition(726, 100);
		Tower4Button.setWidth(WidthTower);
		Tower4Button.setHeight(HeightTower);
		Tower4Button.addListener(Tower4Buttonlistener);
		addActor(Tower4Button);
		
		Image NextWave = new Image(Assets.nextWaveTexture);
		NextWave.setPosition(670,350);
		NextWave.setHeight(ButtonHeight);
		NextWave.setWidth(ButtonWidth);
		NextWave.addListener(NextWavelistener);
		addActor(NextWave);
		
		Image MenuBut = new Image(Assets.Menu);
		MenuBut.setPosition(670,410);
		MenuBut.setHeight(ButtonHeight);
		MenuBut.setWidth(ButtonWidth);
		MenuBut.addListener(MenuButlistener);
		addActor(MenuBut);
		
		Image Health = new Image(Assets.Health);
		Health.setPosition(665,270);
		Health.setHeight(HeightTower*2/3);
		Health.setWidth(WidthTower*2/3);
		addActor(Health);
		
		Image Coins = new Image(Assets.Coins);
		Coins.setPosition(665,200);
		Coins.setHeight(HeightTower*2/3);
		Coins.setWidth(WidthTower*2/3);
		Coins.addListener(NextWavelistener);
		addActor(Coins);

	}
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		font.draw(batch,""+GameScreen.Health,730,300);
		font.draw(batch,""+GameScreen.Coins,730,220);
	}
	
	InputListener NextWavelistener = new InputListener(){
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
			System.out.println("NextWave");
			GameScreen.SpawnCreep = true;
			return true;
		}
	};
	
	InputListener MenuButlistener = new InputListener(){
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
			System.out.println("Menu");
			GameScreen.getInstance().ChangeScreenMenu();
			return true;
		}
	};
	
	InputListener Tower1Buttonlistener = new InputListener(){
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
			System.out.println("T1");
			Tower1Pressed=true;
			Tower2Pressed=false;
			Tower3Pressed=false;
			Tower4Pressed=false;
			return true;
		}
	};
	
	InputListener Tower2Buttonlistener = new InputListener(){
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
			System.out.println("T2");
			Tower1Pressed=false;
			Tower2Pressed=true;
			Tower3Pressed=false;
			Tower4Pressed=false;
			return true;
		}
	};
	
	InputListener Tower3Buttonlistener = new InputListener(){
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
			System.out.println("T3");
			Tower1Pressed=false;
			Tower2Pressed=false;
			Tower3Pressed=true;
			Tower4Pressed=false;
			return true;
		}
	};
	
	InputListener Tower4Buttonlistener = new InputListener(){
		public boolean touchDown(InputEvent event, float x, float y,int pointer, int button){
			System.out.println("T4");
			Tower1Pressed=false;
			Tower2Pressed=false;
			Tower3Pressed=false;
			Tower4Pressed=true;
			return true;
		}
	};
	
}

package com.jo.Towerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

@SuppressWarnings("unused")
public class Assets {
	public static Texture verticalRoadTexture;
	public static Texture horizontalRoadTexture;
	public static Texture roadTopRightTexture;
	public static Texture roadTopLeftTexture;
	public static Texture roadBottomRightTexture;
	public static Texture roadBottomLeftTexture;
	public static Texture grassTexture;
	public static Texture Creep1Texture;
	public static Texture Tower1Texture;
	public static Texture Tower2Texture;
	public static Texture Tower3Texture;
	public static Texture Tower4Texture;
	public static Texture ShopBackgroundTexture;
	public static Texture SplashScreen;
	public static Texture finishTexture;
	public static Texture nextWaveTexture;
	public static Texture Bullet;
	public static Texture BulletFire;
	public static Texture BulletGlass;
	public static Texture BulletBlack;
	public static Texture Health;
	public static Texture Coins;
	public static Texture Menu;

	public static void load () {
		
		SplashScreen = new Texture(Gdx.files.internal("data/Imgs/Background.png"));
		verticalRoadTexture = new Texture(Gdx.files.internal("data/Imgs/routev.png"));
		horizontalRoadTexture = new Texture(Gdx.files.internal("data/Imgs/routehorizontale.png"));
		roadTopRightTexture = new Texture(Gdx.files.internal("data/Imgs/hautDroite.png"));
		roadTopLeftTexture = new Texture(Gdx.files.internal("data/Imgs/gaucheHaut.png"));
		roadBottomRightTexture = new Texture(Gdx.files.internal("data/Imgs/basDroite.png"));
		roadBottomLeftTexture = new Texture(Gdx.files.internal("data/Imgs/gaucheBas.png"));
		grassTexture = new Texture(Gdx.files.internal("data/Imgs/herbe.png"));
		Creep1Texture = new Texture(Gdx.files.internal("data/Imgs/creep01.png"));
		finishTexture = new Texture(Gdx.files.internal("data/Imgs/arrivee.png"));
		Tower1Texture = new Texture(Gdx.files.internal("data/Imgs/chatofleche.png"));
		Tower2Texture = new Texture(Gdx.files.internal("data/Imgs/chatofroid.png"));
		Tower3Texture = new Texture(Gdx.files.internal("data/Imgs/chatofeu.png"));
		Tower4Texture = new Texture(Gdx.files.internal("data/Imgs/chatobombe.png"));
		ShopBackgroundTexture = new Texture(Gdx.files.internal("data/Imgs/fondshop.png"));
		nextWaveTexture = new Texture(Gdx.files.internal("data/Imgs/next.png"));
		Bullet = new Texture(Gdx.files.internal("data/Imgs/boulejaune-01.png"));
		BulletGlass = new Texture(Gdx.files.internal("data/Imgs/boulebleue-01.png"));
		BulletFire = new Texture(Gdx.files.internal("data/Imgs/boulerouge-01.png"));
		BulletBlack = new Texture(Gdx.files.internal("data/Imgs/boulenoire-01.png"));
		Coins = new Texture(Gdx.files.internal("data/Imgs/argent.png"));
		Health = new Texture(Gdx.files.internal("data/Imgs/coeur-01.png"));
		Menu = new Texture(Gdx.files.internal("data/Imgs/menu.png"));
		
	}
}

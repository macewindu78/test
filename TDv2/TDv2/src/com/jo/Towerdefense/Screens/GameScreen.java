package com.jo.Towerdefense.Screens;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.jo.Towerdefense.Assets;
import com.jo.Towerdefense.TowerDefense;
import com.jo.Towerdefense.Actors.Bullet;
import com.jo.Towerdefense.Actors.BulletBlack;
import com.jo.Towerdefense.Actors.BulletFire;
import com.jo.Towerdefense.Actors.BulletGlass;
import com.jo.Towerdefense.Actors.Creeps;
import com.jo.Towerdefense.Actors.Map;
import com.jo.Towerdefense.Actors.Shop;
import com.jo.Towerdefense.Actors.Tower;
import com.jo.Towerdefense.Actors.TowerBullet;
import com.jo.Towerdefense.Actors.TowerFire;
import com.jo.Towerdefense.Actors.TowerGlass;

@SuppressWarnings("unused")

public class GameScreen implements Screen {

	TowerDefense game;
	static Stage stage;
	static Stage staticStage;
	public static GameScreen instance;
	public static boolean SpawnCreep;
	
	Map map;
	Shop shop;
	
	static int IdCreep=0;
	
	public static int Health;
	public static int Coins;
	
	enum GameState {
		Play, Pause
	}
	
	GameState gameState = GameState.Play;
	
	//Tableau d'acteurs
	public static ArrayList<Creeps> Wave;
	public static ArrayList<Tower> Towers;
	public static ArrayList<TowerGlass> TowersGlass;
	public static ArrayList<TowerFire> TowersFire;
	public static ArrayList<TowerBullet> TowersBullet;
	public static ArrayList<Bullet> bullet;
	public static ArrayList<BulletFire> bulletFire;
	public static ArrayList<BulletGlass> bulletGlass;
	public static ArrayList<BulletBlack> bulletBlack;

	public GameScreen(TowerDefense game) {
		this.game = game;
		instance = this;
		this.Health = 20;
		this.Coins = 50;
		this.TotalWaveSize = 1;
		this.CreepHealth = 100;
		
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
	    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
	    
	    nextWave();
	    
	    for(int i=0; i<Wave.size();i++){
	    	Wave.get(i).physics();
	    }
	    
	    if(Wave.size()!=0){
		    for(int i=0; i<Towers.size();i++){
		    	Towers.get(i).physics();
		    }
		    for(int i=0; i<TowersGlass.size();i++){
		    	TowersGlass.get(i).physics();
		    }
		    for(int i=0; i<TowersFire.size();i++){
		    	TowersFire.get(i).physics();
		    }
		    for(int i=0; i<TowersBullet.size();i++){
		    	TowersBullet.get(i).physics();
		    }
		 
	    }else{
		    for(int i=0; i<Towers.size();i++){
		    	Towers.get(i).ShotCreep=null;
		    }
		    for(int i=0; i<TowersGlass.size();i++){
		    	TowersGlass.get(i).ShotCreep = null;
		    }
		    for(int i=0; i<TowersFire.size();i++){
		    	TowersFire.get(i).ShotCreep = null;
		    }
		    for(int i=0; i<TowersBullet.size();i++){
		    	TowersBullet.get(i).ShotCreep = null;
		    }
	    }
	    
	    for(int i =0;i<bullet.size();i++){
	    	bullet.get(i).physics();
	    }
	    
	    for(int i=0;i<bulletFire.size();i++){
	    	bulletFire.get(i).physics();
	    }
	    for(int i =0;i<bulletBlack.size();i++){
	    	bulletBlack.get(i).physics();
	    }
	    for(int i =0;i<bulletGlass.size();i++){
	    	bulletGlass.get(i).physics();
	    }
	    
        staticStage.draw();
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		staticStage = new Stage(650,480,true);
		stage = new Stage(800 ,480 ,true);
		
		Wave = new ArrayList<Creeps>();
		Towers = new ArrayList<Tower>();
		TowersGlass = new ArrayList<TowerGlass>();
		TowersFire = new ArrayList<TowerFire>();
		TowersBullet = new ArrayList<TowerBullet>();
		map = new Map();
		shop = new Shop();
		bullet = new ArrayList<Bullet>();
		bulletFire = new ArrayList<BulletFire>();
		bulletGlass = new ArrayList<BulletGlass>();
		bulletBlack = new ArrayList<BulletBlack>();
		
		Gdx.input.setInputProcessor(stage);
		
		stage.addActor(shop);
		stage.addActor(map);
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
	
	
	/**
	 * Spawning creeps
	 */
	static int TotalWaveSize = 1;
	int CurrentWaveSize = 0;
	int SpawnTime = 50;
	int SpawnWait = 0;
	int CreepHealth = 100;
	public void nextWave(){
		if(SpawnCreep){
			if(CurrentWaveSize < TotalWaveSize){
				if(SpawnWait>=SpawnTime){
					Wave.add(new Creeps(CreepHealth));
					stage.addActor(Wave.get(Wave.size()-1));
					CurrentWaveSize++;
					SpawnWait=0;
				}
				else{SpawnWait++;}
			}
			else{
				SpawnCreep=false;
				CurrentWaveSize = 0;
				TotalWaveSize = (int) ((TotalWaveSize+1)*1.3);
				CreepHealth = (int) (CreepHealth *1.10);
				
			}
		}
	}
	
	
	
	
	/**
	 * creating towers
	 * @param x : x pos of the tower
	 * @param y : y pos of the tower
	 */
	public static void createTower(float x, float y){
		
		
		if(Coins>=10){
			if(Shop.Tower1Pressed){
				Towers.add(new Tower(x,y,Assets.Tower1Texture));
				stage.addActor(Towers.get(Towers.size()-1));
				Coins -=10;
			}
		}
		
		if (Coins>=50){
			if(Shop.Tower2Pressed){
				TowersGlass.add(new TowerGlass(x,y,Assets.Tower2Texture));
				stage.addActor(TowersGlass.get(TowersGlass.size()-1));
				Coins -=50;
			}
			else if(Shop.Tower3Pressed){
				TowersFire.add(new TowerFire(x,y,Assets.Tower3Texture));
				stage.addActor(TowersFire.get(TowersFire.size()-1));
				Coins -=50;
			}
		}	
		
		if(Coins>100){
			if(Shop.Tower4Pressed){
				TowersBullet.add(new TowerBullet(x,y,Assets.Tower4Texture));
				stage.addActor(TowersBullet.get(TowersBullet.size()-1));
				Coins -=100;
			}
		}
	}
	
	public static void createBullet(float x, float y, Creeps creep){
		bullet.add(new Bullet(x,y,creep));
		stage.addActor(bullet.get(bullet.size()-1));
	}
	
	public static void createBulletFire(float x, float y, Creeps creep){
		bulletFire.add(new BulletFire(x,y,creep));
		stage.addActor(bulletFire.get(bulletFire.size()-1));
	}
	
	public static void createBulletGlass(float x, float y, Creeps creep){
		bulletGlass.add(new BulletGlass(x,y,creep));
		stage.addActor(bulletGlass.get(bulletGlass.size()-1));
	}
	
	public static void createBulletBlack(float x, float y, Creeps creep){
		bulletBlack.add(new BulletBlack(x,y,creep));
		stage.addActor(bulletBlack.get(bulletBlack.size()-1));
	}	
	
	public static GameScreen getInstance(){
		return instance;
	}
	
	public void ChangeScreenMenu(){
		game.setScreen(new MenuScreen(game));
	}


	public void ChangeGO() {
		game.setScreen(new GameOverScreen(game));
	}

}

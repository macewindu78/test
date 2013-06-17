package com.jo.Towerdefense.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jo.Towerdefense.TowerDefense;



public class SplashScreen implements Screen {

	
	protected final TowerDefense game;
    protected final BitmapFont font;
    protected final SpriteBatch batch;
    protected final Stage stage; //new stage for actors to play on
    private Texture splashTexture;
    private TextureRegion splashTextureRegion;
        
    public SplashScreen(TowerDefense game) {
    	this.game = game;
        this.font = new BitmapFont();
        this.batch = new SpriteBatch();
        this.stage = new Stage( 0, 0, true );
    }
 
    
    public void show()
    {
       
      
        splashTexture = new Texture( "data/Imgs/splash.png" );
        splashTexture.setFilter( TextureFilter.Linear, TextureFilter.Linear );

        //Dimensions of the texture region 512*301
       splashTextureRegion = new TextureRegion( splashTexture, 0, 0, 512, 512 );

    }
 
    public void render(float delta ){
     

        batch.begin();
        batch.draw( splashTextureRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
        batch.end();
    }
    
 
    public void resize(int width,int height ){
      

   }

	public void dispose() {
		 
	     splashTexture.dispose();
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
}
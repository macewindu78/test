package com.jo.Towerdefense;

import com.badlogic.gdx.Game;
import com.jo.Towerdefense.Screens.GameScreen;
import com.jo.Towerdefense.Screens.MenuScreen;
import com.jo.Towerdefense.Screens.SplashScreen;

public class TowerDefense extends Game {

	@Override
	public void create() {
	// TODO Auto-generated method stub
	Assets.load();
	setScreen(new MenuScreen(this));
	}

}


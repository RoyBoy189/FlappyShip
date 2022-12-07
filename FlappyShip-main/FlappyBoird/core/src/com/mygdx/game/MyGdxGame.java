package com.mygdx.game;

import com.States.GameState;
import com.States.Menu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	//public static final int width = 800;
	//public static final int height = 600;
	private GameState gm;
	private SpriteBatch batch;
	//public static final String title = "FlappyShip";

	//Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gm = new GameState();
		ScreenUtils.clear(1, 0, 0, 1);
		gm.push(new Menu(gm));
		//img = new Texture("Bird.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gm.update(Gdx.graphics.getDeltaTime());
		gm.render(batch);
		// batch.begin();
		// batch.draw(img, 0, 0);
		// batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}

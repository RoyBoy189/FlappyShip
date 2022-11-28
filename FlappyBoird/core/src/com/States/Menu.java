package com.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends State {
    private Texture background;
    private Texture PlayButton;
   
    public Menu(GameState gm) {
        super(gm); //we use super to allow us to switch game states. I don't like it either.
        background = new Texture("background.png");
        PlayButton = new Texture("PlayButton.png");
    }

    @Override
    public void handleinput() {
        // TODO Auto-generated method stub
       if(Gdx.input.justTouched()) {
        gam.set(GameState.get(0), new PlayState(gam));
        dispose();
       }
    }

    @Override
    public void update(float dt) {
        // TODO Auto-generated method stub
        handleinput();
    }

    @Override
    public void render(SpriteBatch ab) {
        // TODO Auto-generated method stub
        ab.begin();
        ab.draw(background, 0, 0, 800, 600);
        ab.draw(PlayButton, (700 / 2) - (PlayButton.getWidth() / 2), 500 / 2, 128, 128);
        ab.end();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        background.dispose();
        PlayButton.dispose();
    }
    
}

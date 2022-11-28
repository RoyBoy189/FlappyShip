package com.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State {
private Texture bird;
    protected PlayState(GameState gam) {
        super(gam);
        bird = new Texture("Bird.png");
        cam.setToOrtho( false, 800 / 2, 600 /2);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void handleinput() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(float dt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(SpriteBatch ab) {
        // TODO Auto-generated method stub
        ab.setProjectionMatrix(cam.combined);
        ab.begin();
        ab.draw(bird, 50, 50, 64, 64);
        ab.end();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }
    
}
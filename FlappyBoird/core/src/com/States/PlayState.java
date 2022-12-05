package com.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sprites.player;
import com.sprites.tude;

public class PlayState extends State {
private player bird;
private Texture bg;
private tude tude;
    protected PlayState(GameState gam) {
        super(gam);
        cam.setToOrtho( false, 1600 / 2, 1200 /2);
        //TODO Auto-generated constructor stub
         bg = new Texture("backgroung.png"); //draws the background
        bird = new player(100, 600); //we use the player script to allow the player to move
        tude = new tude(100);
    }

    @Override
    protected void handleinput() {
        // TODO Auto-generated method stub
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bird.jump();
        }
        
    }

    @Override
    public void update(float dt) {
        // TODO Auto-generated method stub
        handleinput();
        bird.update(dt);
        
    }

    @Override
    public void render(SpriteBatch ab) {
        // TODO Auto-generated method stub
        ab.setProjectionMatrix(cam.combined);
        ab.begin();
       
        ab.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0); //this shifts our background since the camera is following the player.
        ab.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        ab.draw(tude.getTopTude(), tude.getPostoptude().x, tude.getPostoptude().y);
        ab.draw(tude.getMiddletude(), tude.getPosmiddletude().x, tude.getPosmiddletude().y);
        ab.draw(tude.getBottomtude(), tude.getPosBottube().x, tude.getPosBottube().y);
        ab.end();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }
    
}
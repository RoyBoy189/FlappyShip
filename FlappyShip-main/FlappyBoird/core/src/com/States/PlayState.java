package com.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sprites.Ghost;
import com.sprites.player;
import com.sprites.tude;

public class PlayState extends State {
private static final int distance = 100;
private static final int amount = 4; //amount of tudes
private player bird;
private Texture bg;
private Texture ghost;

//private tude tude;
private DSArraylist<Ghost> ghosts;
private DSArraylist<tude> tubes;


    protected PlayState(GameState gam) {
        
        super(gam);
        cam.setToOrtho( false, 1600 / 2, 1200 /2);
        //TODO Auto-generated constructor stub
        //bird.setGundirection(cam);
         bg = new Texture("backgroung.png"); //draws the background
         bird = new player(250, 600); //we use the player script to allow the player to move
        //tude = new tude(100);
        tubes = new DSArraylist<tude>();
        for (int i = 1; i <= amount; i++) { // for loop for adding tubes to the array
            tubes.add(new tude(i * (distance + tude.width)));
            }      
            ghosts = new DSArraylist<Ghost>();
            for(int a = 1; a < 2; a++) {
                ghosts.add(new Ghost(a * (distance + Ghost.width)));
            }
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
        // if(Gdx.input.justTouched()) {
        //     bird.shootgun(dt);
        // }
        cam.position.x = bird.getPosition().x + 160;
        for(Ghost ghost: ghosts) {
            ghost.shoot();
            ghost.timer(dt, ghost.getPostopGhost().x + ((ghost.width + distance) * 2));
            if(cam.position.x - (cam.viewportWidth / 2) > ghost.getPostopGhost().x + ghost.getTopGhost().getWidth()) {
                ghost.repostition(ghost.getPostopGhost().x + ((ghost.width + distance) * 2));
                ghost.setBotbulletpos(ghost.getPostopGhost());
        }
        }
        for(tude tube : tubes) {
            if(cam.position.x - (cam.viewportWidth / 2) > tube.getPostoptude().x + tube.getTopTude().getWidth()) {
                tube.repostition(tube.getPostoptude().x + ((tube.width + distance) * amount));
            }
            if(cam.position.x - (cam.viewportWidth / 2) > tube.getPosBottube().x + tube.getBottomtude().getWidth()) {
                tube.repostition(tube.getPosBottube().x + ((tube.width + distance) * amount));
            }
            cam.update();
        }
    }
          

    @Override
    public void render(SpriteBatch ab) {
        // TODO Auto-generated method stub
        ab.setProjectionMatrix(cam.combined);
        ab.begin();
       
        ab.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0); //this shifts our background since the camera is following the player.
        ab.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
       // ab.draw(tude.getTopTude(), tude.getPostoptude().x, tude.getPostoptude().y);
        //ab.draw(tude.getBottomtude(), tude.getPosBottube().x, tude.getPosBottube().y);
        for(Ghost ghost : ghosts) {
            ab.draw(ghost.getTopGhost(), ghost.getPostopGhost().x,ghost.getPostopGhost().y);
            ab.draw(ghost.getBullet(), ghost.getBulletpos().x, ghost.getBulletpos().y);
            ab.draw(ghost.getBullet(), ghost.getBotbulletpos().x, ghost.getBotbulletpos().y);
        }
        for (tude tube : tubes) {
            ab.draw(tube.getTopTude(), tube.getPostoptude().x, tube.getPostoptude().y);
            ab.draw(tube.getBottomtude(), tube.getPosBottube().x, tube.getPosBottube().y);
}
        ab.end();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }
}
    
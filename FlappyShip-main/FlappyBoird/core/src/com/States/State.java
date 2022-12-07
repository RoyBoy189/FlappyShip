package com.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
     protected OrthographicCamera cam; //camera
     protected Vector3 mouse; //out controller for the menu and shoot mechanic
     protected GameState gam;

     protected State(GameState gam2) {
         this.gam = gam2;
         cam = new OrthographicCamera();
         mouse = new Vector3();
     }

     protected abstract void handleinput();
     public abstract void update(float dt);
     public abstract void render(SpriteBatch ab);
     public abstract void dispose();
}

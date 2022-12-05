package com.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class player {
    private static int gravity = -15;
    private Vector3 position; // holds x and y position
    private Vector3 velocity;

    private Texture bird;

    public player(int x, int y) {
        position = new Vector3(x, y , 0);
        velocity = new Vector3(0,0,0);
        bird = new Texture("Bird.png");
    }
    public void update(float dt) {
        //sets up gravity for the ship-thing
        velocity.add(0,gravity,0);
        velocity.scl(dt);
        position.add(0,velocity.y,0);

        velocity.scl(1/dt);
    }
    public static int getGravity() {
        return gravity;
    }
    public Vector3 getPosition() {
        return position;
    }
    public Vector3 getVelocity() {
        return velocity;
    }
    public Texture getBird() {
        return bird;
    }
    public void jump() {
        velocity.y = 250;
    }
    //we use getters to access the info we need to draw the bird sprite and use it to move around and stuff.
}

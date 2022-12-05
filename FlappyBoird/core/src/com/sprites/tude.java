package com.sprites;
import java.util.Random;

import javax.management.loading.PrivateClassLoader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class tude {
    private Texture topTude, bottomtude, middletude;
    private static Vector2 postoptude; //Bottom tude
    private Vector2 posmiddletude;
    private Vector2 posBottube;
    private Random rand;

    public tude(float x) {
       final int fluct = 130;
        final int TudeGap = 0;
        final int lowopening = 120;
        topTude = new Texture("bob.png");
        middletude = new Texture("sipkemiddle.png"); //spelling mistake
        bottomtude = new Texture("spikebottom.png");
        rand = new Random();
        postoptude = new Vector2(x + 50, rand.nextInt(fluct) + TudeGap + lowopening);
        posmiddletude = new Vector2(x + 50,postoptude.y + TudeGap - middletude.getHeight());
        posBottube = new Vector2(x + 50,posmiddletude.y - TudeGap - bottomtude.getHeight());
    }

    public Texture getTopTude() {
        return topTude;
    }

    public Texture getBottomtude() {
        return bottomtude;
    }

    public Texture getMiddletude() {
        return middletude;
    }

    public static Vector2 getPostoptude() {
        return postoptude;
    }

    public Vector2 getPosmiddletude() {
        return posmiddletude;
    }

    public Vector2 getPosBottube() {
        return posBottube;
    }

    public Random getRand() {
        return rand;
    }
    
}

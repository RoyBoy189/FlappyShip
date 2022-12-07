package com.sprites;

import java.util.Random;

import javax.management.loading.PrivateClassLoader;

import com.States.DSArraylist;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter.Distance;
import com.badlogic.gdx.math.Vector2;

public class tude {
    private Texture topTude, bottomtude;
    private  Vector2 postoptude;
    private Vector2 posBottube;
    private Random rand;
    private static final int fluct = 130;
    private int TudeGap;
    public int lowopening;
    public static int width;

    public tude(float x) {
         TudeGap = 150; // the gap between the top and bottom pipe
         lowopening = 110; //
        topTude = new Texture("topSpike.png");
        // middletude = new Texture("sipkemiddle.png"); //spelling mistake
        bottomtude = new Texture("spikebottom.png");
        rand = new Random();
        width = topTude.getWidth();
        posBottube = new Vector2(x + 120, rand.nextInt(fluct));
        postoptude = new Vector2(x + 120, posBottube.y + bottomtude.getHeight() + TudeGap - 50);
    }

    public void repostition(float x) {
        postoptude.set(x + 75, rand.nextInt(fluct) + 200);
        posBottube.set(x + 75, postoptude.y + TudeGap - bottomtude.getHeight() - 247);
    }
   

    // adds a certain amount of tudes
    public Texture getTopTude() {
        return topTude;
    }

    public Texture getBottomtude() {
        return bottomtude;
    }

    public Vector2 getPostoptude() {
        return postoptude;
    }

    public Vector2 getPosBottube() {
        return posBottube;
    }

    public Random getRand() {
        return rand;
    }

    public void setTopTude(Texture topTude) {
        this.topTude = topTude;
    }

    public void setBottomtude(Texture bottomtude) {
        this.bottomtude = bottomtude;
    }

}

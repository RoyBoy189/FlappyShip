package com.sprites;

import java.util.Random;

import javax.management.loading.PrivateClassLoader;

import com.States.DSArraylist;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ai.steer.Steerable;
import com.badlogic.gdx.ai.utils.Location;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter.Distance;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Ghost implements Steerable<Vector2> {
    private Texture topGhost, bottomGhost;
    private  Vector2 postopGhost;
    private Vector2 posBotGhost;
    private Random rand;
    private static final int fluct = 130;
    private int GhostGap;
    public int lowopening;
    public static int width;
    private Texture bullet;
    private Vector2 bulletpos;
    private Vector2 botbulletpos;
    private int movementSpeed;
    private Vector2 directionbot;
    private Vector2 directiontop;


    public Ghost(float x) {
        GhostGap = 150; // the gap between the top and bottom ghost
        lowopening = 120; //
        bullet = new Texture("Bird.png");
        topGhost = new Texture("Bird.png");
        // middletude = new Texture("sipkemiddle.png"); //spelling mistake
        bottomGhost = new Texture("Bird.png");
        rand = new Random();
        width = topGhost.getWidth();
        posBotGhost = new Vector2(x + 120, rand.nextInt(fluct));
        postopGhost = new Vector2(x + 113, posBotGhost.y + bottomGhost.getHeight() + GhostGap - 50); 
        bulletpos = new Vector2(postopGhost);
        botbulletpos = new Vector2(posBotGhost);
        movementSpeed = 1;
        directionbot = new Vector2(0,0);
        directiontop = new Vector2(0,0);
    }

    public void repostition(float x) {
        postopGhost.set(x + 75, rand.nextInt(fluct) + 200);
        posBotGhost.set(x + 75, postopGhost.y + GhostGap - bottomGhost.getHeight() - 247);
    }
    public void timer(float dt, float x) {
        int ticker = 0;
        ticker += dt;
        if(ticker > 2) {
            bulletpos.set(bulletpos);
            botbulletpos.set(botbulletpos);
        }
    }
    public void shoot(){
        setBulletpos(postopGhost);   
        setBotbulletpos(posBotGhost);   
        directionbot.x = (player.getPosition().x + 40) - (botbulletpos.x + 40);
        directiontop.x = (player.getPosition().x + 40) - (bulletpos.x + 40);
        directionbot.y = (player.getPosition().y + 40) - (botbulletpos.y + 40);
        directiontop.y = (player.getPosition().y + 40) - (bulletpos.y + 40);
        directionbot.nor();
        directiontop.nor();
        botbulletpos.x += (directionbot.x * movementSpeed);
        botbulletpos. y += (directionbot.y * movementSpeed);
        bulletpos.x += (directiontop.x * movementSpeed);
        bulletpos. y += (directiontop.y * movementSpeed);
    }

    public Texture getTopGhost() {
        return topGhost;
    }

    public Texture getBottomGhost() {
        return bottomGhost;
    }

    public Vector2 getPostopGhost() {
        return postopGhost;
    }

    public Vector2 getPosBotGhost() {
        return posBotGhost;
    }

    public Random getRand() {
        return rand;
    }

    public void setBulletpos(Vector2 bulletpos) {
        this.bulletpos = bulletpos;
    }

    public void setTopGhost(Texture topGhost) {
        this.topGhost = topGhost;
    }

    public void setBullet(Texture bullet) {
        this.bullet = bullet;
    }

    public void setBotbulletpos(Vector2 botbulletpos) {
        this.botbulletpos = botbulletpos;
    }

    public static int getFluct() {
        return fluct;
    }

    public int getGhostGap() {
        return GhostGap;
    }

    public int getLowopening() {
        return lowopening;
    }

    public static int getWidth() {
        return width;
    }

    public Texture getBullet() {
        return bullet;
    }

    public Vector2 getBulletpos() {
        return bulletpos;
    }

    public Vector2 getBotbulletpos() {
        return botbulletpos;
    }

    @Override
    public Vector2 getPosition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float getOrientation() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setOrientation(float orientation) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float vectorToAngle(Vector2 vector) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Vector2 angleToVector(Vector2 outVector, float angle) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Location<Vector2> newLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float getZeroLinearSpeedThreshold() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setZeroLinearSpeedThreshold(float value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float getMaxLinearSpeed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxLinearSpeed(float maxLinearSpeed) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float getMaxLinearAcceleration() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxLinearAcceleration(float maxLinearAcceleration) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float getMaxAngularSpeed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxAngularSpeed(float maxAngularSpeed) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float getMaxAngularAcceleration() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxAngularAcceleration(float maxAngularAcceleration) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Vector2 getLinearVelocity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float getAngularVelocity() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getBoundingRadius() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isTagged() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setTagged(boolean tagged) {
        // TODO Auto-generated method stub
        
    }

    // adds a certain amount of tudes
    

}

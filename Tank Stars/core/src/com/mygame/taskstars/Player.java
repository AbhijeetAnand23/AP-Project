package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image {
    Vector2 position, size;
    Texture player;
    float fuel = 20;
    float health = 100;
    float angle;
    float velocity;

    public Player(String file, Vector2 position, Vector2 size){
        player = new Texture(file);
        this.position = position;
        this.size = size;
    }
    public void draw(SpriteBatch batch){
        batch.draw(player, position.x, position.y, size.x, size.y);
    }

    public Vector2 getPosition() {
        return position;
    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }
    public float getFuel(){
        return this.fuel;
    }
    public void setFuel(float fuel){
        this.fuel = fuel;
    }
    public float getHealth(){
        return this.health;
    }
    public void setHealth(float health){
        this.fuel = health;
    }
    public void dispose(){
        player.dispose();
    }
}

package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image {
    Vector2 position, size;
    Texture player;
    Texture fuel_box;
    Texture fuel_bar;
    Texture health_box;
    Texture health_bar;
    float fuel = 200;
    float health = 100;
    double angle = 30;
    double velocity = 155;

    public Player(String file, Vector2 position, Vector2 size, String file1, String file2, String file3, String file4){
        fuel_box  = new Texture(file2);
        fuel_bar  = new Texture(file1);
//        heart = new Texture(file5);
        health_bar = new Texture(file3);
        health_box = new Texture(file4);
        player = new Texture(file);
        this.position = position;
        this.size = size;
    }
    public void draw(SpriteBatch batch){
        batch.draw(player, position.x, position.y, size.x, size.y);
    }
    public void draw_Fuel1(SpriteBatch batch, float x){
        batch.draw(fuel_box, 30, 40, 200, 50);
        batch.draw(fuel_bar, 30, 40, x, 50);
    }
    public void fuelDispose(){
        fuel_box.dispose();
        fuel_bar.dispose();
    }
    public void draw_Fuel2(SpriteBatch batch, float x){
        batch.draw(fuel_box, 1650, 40, 200, 50);
        batch.draw(fuel_bar, 1650, 40, x, 50);
    }
    public void draw_healthBar1(SpriteBatch batch, float x){
        batch.draw(health_box, 500, 800, 300, 75);
        batch.draw(health_bar, 500, 800, 150, 75);
    }
    public void draw_healthBar2(SpriteBatch batch, float x){
        batch.draw(health_box, 1090, 800, 300, 75);
        batch.draw(health_bar, 1090, 800, 150, 75);
    }
    public double attack1(){
        double range;
        double a = Math.toRadians(angle);
        double sin = Math.sin(2*a);
        range = (velocity*velocity*sin) / (2*9.8);
        double fall_position = position.x + range;
        return fall_position;
    }
    public double attack2(){
        double range;
        double a = Math.toRadians(angle);
        double sin = Math.sin(2*a);
        range = (velocity*velocity*sin) / (2*9.8);
        double fall_position = position.x - range;
        return fall_position;
    }
    public void setAngle(double angle){
        this.angle = angle;
    }
    public double getAngle(){
        return this.angle;
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

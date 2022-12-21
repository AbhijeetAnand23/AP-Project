package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class NewGame implements Screen {
    private TankStars game;
    private SpriteBatch batch;
    private Texture background;
    private Texture terrain;
    private Texture health;
    private Texture menuIcon;
    private Rectangle menuBox;
    private Vector3 menuTouch;
    private Player player1;
    private Player player2;
    private Tank1 tank1;
    private Tank2 tank2;
    private int flag = 0;

    public NewGame(TankStars game){
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("GameBackground.png");
        terrain = new Texture("Terrain.png");
        health = new Texture("Health.png");
        menuIcon = new Texture("MenuIcon.png");
        player1 = new Player("tank1.png",new Vector2(370, 340),new Vector2(170,170),"Fuel Bar.png", "Fuel_BG.png","Health_Bar.png", "Health_box.png");
        tank1 = Tank1.getTank1();
        player2 = new Player("Tank2 Reversed.png", new Vector2(1475, 336),new Vector2(170,170),"Fuel Bar.png", "Fuel_BG.png","Health_Bar.png", "Health_box.png");
        tank2 = Tank2.getTank2(new Vector2(1475, 336));
        menuBox = new Rectangle(63,820,60,70);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.begin();
        game.batch.draw(background, 0,0,1900, 915);
        game.batch.draw(terrain,0,-150,1920,1080);
        game.batch.draw(menuIcon, 0,790,188, 138);

        if (Gdx.input.justTouched()) {
            menuTouch = new Vector3();
            menuTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(menuBox.contains(menuTouch.x, menuTouch.y)) {
                game.setScreen(new InGameMenu(game));
                dispose();
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            float x = player1.getX()+2;
            float y = player1.getY();
            float fuel = player1.getFuel()-1;
            if(fuel>=0) {
                player1.dispose();
                player1 = new Player("tank1.png", new Vector2(x, y), new Vector2(170, 170), "Fuel Bar.png", "Fuel_BG.png","Health_Bar.png", "Health_box.png");
                player1.setFuel(fuel);
                player1.draw(game.batch);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            float x = player1.getX()-2;
            float y = player1.getY();
            float fuel = player1.getFuel()-1;
            if(fuel>=0) {
                player1.dispose();
                player1 = new Player("tank1.png", new Vector2(x, y), new Vector2(170, 170), "Fuel Bar.png", "Fuel_BG.png","Health_Bar.png", "Health_box.png");
                player1.setFuel(fuel);
                player1.draw(game.batch);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            float x = player2.getX()+2;
            float y = player2.getY();
            float fuel = player2.getFuel()-1;
            if(fuel>=0) {
                player2.dispose();
                player2 = new Player("Tank2 Reversed.png", new Vector2(x, y), new Vector2(170, 170), "Fuel Bar.png", "Fuel_BG.png","Health_Bar.png", "Health_box.png");
                player2.setFuel(fuel);
                player2.draw(game.batch);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            float x = player2.getX()-2;
            float y = player2.getY();
            float fuel = player2.getFuel() - 1;
            if(fuel>=0) {
                player2.dispose();
                player2.fuelDispose();
                player2 = new Player("Tank2 Reversed.png", new Vector2(x, y), new Vector2(170, 170), "Fuel Bar.png", "Fuel_BG.png","Health_Bar.png", "Health_box.png");
                player2.setFuel(fuel);
                player2.draw(game.batch);
            }
        }
        if(flag == 0){
            if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                double fall_x = player1.attack1();
                System.out.println("1 attacked at " + fall_x);
                flag = 1;
                player1.setAngle(30);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
                double angle = player1.getAngle() + 10;
                System.out.printf("Angle++");
                player1.setAngle(angle);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
                double angle = player1.getAngle() - 10;
                System.out.printf("Angle--");
                player1.setAngle(angle);
            }
        }
        else if(flag == 1){
            if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                double fall_x = player2.attack2();
                System.out.println("2 attacked at " + fall_x);
                flag = 0;
                player2.setAngle(30);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                double angle = player2.getAngle() + 10;
                System.out.printf("Angle++");
                player2.setAngle(angle);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                double angle = player2.getAngle() - 10;
                System.out.printf("Angle--");
                player2.setAngle(angle);
            }
        }
        player1.draw(game.batch);
        player2.draw(game.batch);
        player1.draw_Fuel1(game.batch,player1.getFuel());
        player2.draw_Fuel2(game.batch, player2.getFuel());
        player1.draw_healthBar1(game.batch, 50);
        player2.draw_healthBar2(game.batch, 50);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        terrain.dispose();
        health.dispose();
        menuIcon.dispose();
//        tank1.dispose();
//        tank2.dispose();
    }
}

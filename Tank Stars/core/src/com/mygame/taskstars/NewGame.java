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
//    private Texture tank1;
//    private Texture tank2;
    private Rectangle menuBox;
    private Vector3 menuTouch;
    private Player player1;
    private Player player2;

    public NewGame(TankStars game){
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("GameBackground.png");
        terrain = new Texture("Terrain.png");
        health = new Texture("Health.png");
        menuIcon = new Texture("MenuIcon.png");
//        tank1 = new Texture("Tank1.png");
        player1 = new Player("tank1.png",new Vector2(370, 340),new Vector2(170,170));
        player2 = new Player("Tank2 Reversed.png", new Vector2(1475, 336),new Vector2(170,170));
//        tank2 = new Texture("Tank2 Reversed.png");
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
        game.batch.draw(health, -400,720,2798, 256);
        game.batch.draw(menuIcon, 0,790,188, 138);

//        game.batch.draw(tank1,370,340,170,170);
//        game.batch.draw(tank2, 1475,336,170,170);


        if (Gdx.input.justTouched()) {
            menuTouch = new Vector3();
            menuTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(menuBox.contains(menuTouch.x, menuTouch.y)) {
                game.setScreen(new InGameMenu(game));
                dispose();
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            float x = player1.getX()+2;
            float y = player1.getY();
            float fuel = player1.getFuel()-1;
            player1.dispose();
            player1 = new Player("tank1.png",new Vector2(x, y),new Vector2(170,170));
            player1.setFuel(fuel);
            player1.draw(game.batch);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            float x = player1.getX()-2;
            float y = player1.getY();
            float fuel = player1.getFuel()-1;
            player1.dispose();
            player1 = new Player("tank1.png",new Vector2(x, y),new Vector2(170,170));
            player1.setFuel(fuel);
            player1.draw(game.batch);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            float x = player2.getX()+2;
            float y = player2.getY();
            float fuel = player2.getFuel();
            player2.dispose();
            player2 = new Player("Tank2 Reversed.png",new Vector2(x, y),new Vector2(170,170));
            player2.setFuel(fuel);
            player2.draw(game.batch);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            float x = player2.getX()-2;
            float y = player2.getY();
            float fuel = player2.getFuel();
            player2.dispose();
            player2 = new Player("Tank2 Reversed.png",new Vector2(x, y),new Vector2(170,170));
            player2.setFuel(fuel);
            player2.draw(game.batch);
        }
        player1.draw(game.batch);
        player2.draw(game.batch);
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

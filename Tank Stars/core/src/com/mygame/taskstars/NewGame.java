package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class NewGame implements Screen {
    TankStars game;
    SpriteBatch batch;
    Texture background;
    Texture terrain;
    Texture health;
    Texture menuIcon;
    Texture tank1;
    Texture tank2;
    Rectangle menuBox;
    Vector3 menuTouch;
    public NewGame(TankStars game){
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("GameBackground.png");
        terrain = new Texture("Terrain.png");
        health = new Texture("Health.png");
        menuIcon = new Texture("MenuIcon.png");
        tank1 = new Texture("Tank1.png");
        tank2 = new Texture("Tank2 Reversed.png");
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
        game.batch.draw(terrain,0,-100,1920,1080);
        game.batch.draw(health, -400,720,2798, 256);
        game.batch.draw(menuIcon, 0,790,188, 138);
        game.batch.draw(tank1,370,381,170,170);
        game.batch.draw(tank2, 1475,505,170,170);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            menuTouch = new Vector3();
            menuTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(menuBox.contains(menuTouch.x, menuTouch.y)) {
                game.setScreen(new InGameMenu(game));
                dispose();
            }
        }
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
        tank1.dispose();
        tank2.dispose();
    }
}

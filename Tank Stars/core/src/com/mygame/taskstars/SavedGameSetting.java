package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.awt.*;

public class SavedGameSetting implements Screen {
    TankStars game;
    SpriteBatch batch;
    Texture background;
    Rectangle close;
    Vector3 closeTouch;

    public SavedGameSetting(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("MainMenuSetting.png");
        close = new Rectangle(805,719,40,40);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, 315,90, 591, 700);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            closeTouch = new Vector3();
            closeTouch.set(Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(close.contains(closeTouch.x, closeTouch.y)) {
                game.setScreen(new SavedGame(game));
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

    }
}

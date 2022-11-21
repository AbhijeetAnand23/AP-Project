package com.mygame.taskstars;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    TankStars game;
    SpriteBatch batch;
    Texture background;
    Texture loading;

    public MainMenuScreen(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture("Background.png");
        loading = new Texture("Loading.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.begin();
        game.batch.draw(background, 0,0, 1900, 915);
        game.batch.draw(loading, 450, -175, 1000, 462);
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
        loading.dispose();
    }
}
